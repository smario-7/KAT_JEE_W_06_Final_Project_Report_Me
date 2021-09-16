package pl.coderslab.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.dto.UserAddDto;
import pl.coderslab.dto.UserReadDto;
import pl.coderslab.model.ReportUser;
import pl.coderslab.model.Role;
import pl.coderslab.repository.RoleRepository;
import pl.coderslab.repository.ShopRepository;
import pl.coderslab.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final ShopRepository shopRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImp(UserRepository userRepository, ShopRepository shopRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.shopRepository = shopRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ReportUser findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void add(UserAddDto userAddDto) {
        ReportUser newReportUser = new ReportUser();
        newReportUser.setShop(shopRepository.findById(userAddDto.getShop().getId()).orElseThrow(EntityNotFoundException::new));
        newReportUser.setFirstName(userAddDto.getFirstName());
        newReportUser.setLastName(userAddDto.getLastName());
        newReportUser.setEmail(userAddDto.getEmail());
        newReportUser.setPassword(passwordEncoder.encode(userAddDto.getPassword()));
        newReportUser.enable();
        Role roles = roleRepository.findByName("ROLE_USER");
        newReportUser.addRole(roles);
        userRepository.save(newReportUser);
    }

    public void update(UserReadDto userReadDto){
        ReportUser newReportUser = userRepository.findById(userReadDto.getId()).orElseThrow(EntityNotFoundException::new);
        newReportUser.setId(userReadDto.getId());
        newReportUser.setShop(shopRepository.findById(userReadDto.getShopId()).orElseThrow(EntityNotFoundException::new));
        newReportUser.setFirstName(userReadDto.getFirstName());
        newReportUser.setLastName(userReadDto.getLastName());
        newReportUser.setEmail(userReadDto.getEmail());
        newReportUser.setPassword("none");
        userRepository.save(newReportUser);
    }

    public List<UserReadDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(reportUser -> new UserReadDto(reportUser.getId(), reportUser.getShop().getId(), reportUser.getFirstName(), reportUser.getLastName(), reportUser.getEmail()))
                .collect(Collectors.toList());
    }

    public UserReadDto findById (Long id){
        ReportUser reportUser = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return new UserReadDto(reportUser.getId(), reportUser.getShop().getId(), reportUser.getFirstName(), reportUser.getLastName(), reportUser.getEmail());
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    };

    public boolean passwordConfirm(UserAddDto userAddDto){
        return userAddDto.getPassword().equals(userAddDto.getPasswordRepeat());
    }

    public boolean userExist (UserAddDto userAddDto){
        return userRepository.existsByEmail(userAddDto.getEmail());
    }

//    public UserReadPassDto findByEmail(String email){
//        ReportUser reportUser = userRepository.findByEmail(email);
//        if (reportUser == null){
//            throw new UsernameNotFoundException(email);
//        }
//        return new ModelMapper().map(reportUser, UserReadPassDto.class);
//    }

    @Override
    public UserDetails loadUserByUsername(String email){
        ReportUser reportUser = userRepository.findByEmail(email);
        if (reportUser == null) {
            throw new UsernameNotFoundException("Nie mamy takiego maila w bazie " + email);
        }
        return new org.springframework.security.core.userdetails.User(reportUser.getEmail(), reportUser.getPassword(),new ArrayList<>());
    }
//    public Collection<? extends GrantedAuthority> mapRoles(Collection<Role> roles)

}
