package pl.coderslab.service;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.coderslab.beans.User;
import pl.coderslab.dto.UserDto;
import pl.coderslab.dto.UserReadDto;
import pl.coderslab.dto.UserReadPassDto;
import pl.coderslab.repository.ShopRepository;
import pl.coderslab.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final ShopRepository shopRepository;

    public UserServiceImp(UserRepository userRepository, ShopRepository shopRepository) {
        this.userRepository = userRepository;
        this.shopRepository = shopRepository;
    }

    public void add(UserDto userDto) {
        User newUser = new User();
        newUser.setShop(shopRepository.findById(userDto.getShopId()).orElseThrow(EntityNotFoundException::new));
        newUser.setFirstName(userDto.getFirstName());
        newUser.setLastName(userDto.getLastName());
        newUser.setEmail(userDto.getEmail());
        newUser.setPassword("none");
        userRepository.save(newUser);
    }

    public void update(UserReadDto userReadDto){
        User newUser = userRepository.findById(userReadDto.getId()).orElseThrow(EntityNotFoundException::new);
        newUser.setId(userReadDto.getId());
        newUser.setShop(shopRepository.findById(userReadDto.getShopId()).orElseThrow(EntityNotFoundException::new));
        newUser.setFirstName(userReadDto.getFirstName());
        newUser.setLastName(userReadDto.getLastName());
        newUser.setEmail(userReadDto.getEmail());
        newUser.setPassword("none");
        userRepository.save(newUser);
    }

    public List<UserReadDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserReadDto(user.getId(), user.getShop().getId(), user.getFirstName(), user.getLastName(), user.getEmail()))
                .collect(Collectors.toList());
    }

    public UserReadDto findById (Long id){
        User user = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return new UserReadDto(user.getId(),user.getShop().getId(),user.getFirstName(),user.getLastName(),user.getEmail());
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    };

    public UserReadPassDto findByEmail(String email){
        User user = userRepository.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException(email);
        }
        return new ModelMapper().map(user, UserReadPassDto.class);
    }

    @Override
    public UserDetails loadUserByUsername(String email){
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Nie mamy takiego maila w bazie " + email);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),new ArrayList<>());
    }
//    public Collection<? extends GrantedAuthority> mapRoles(Collection<Role> roles)

}
