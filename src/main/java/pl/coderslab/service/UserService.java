package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.beans.User;
import pl.coderslab.dto.UserDto;
import pl.coderslab.dto.UserReadDto;
import pl.coderslab.repository.ShopRepository;
import pl.coderslab.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserServiceInt {
    private final UserRepository userRepository;
    private final ShopRepository shopRepository;

    public UserService(UserRepository userRepository, ShopRepository shopRepository) {
        this.userRepository = userRepository;
        this.shopRepository = shopRepository;
    }

    public void add(UserDto userDto) {
        User newUser = new User();
        newUser.setShop(shopRepository.findById(userDto.getShopId()).orElseThrow(EntityNotFoundException::new));
        newUser.setFirstName(userDto.getFirstName());
        newUser.setLastName(userDto.getLastName());
        newUser.setEmial(userDto.getEmail());
        userRepository.save(newUser);
    }

    public List<UserReadDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserReadDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmial()))
                .collect(Collectors.toList());

    }

}
