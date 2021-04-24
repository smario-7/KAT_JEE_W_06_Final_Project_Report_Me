package pl.coderslab.service;

import pl.coderslab.dto.UserDto;
import pl.coderslab.dto.UserReadDto;

import java.util.List;

public interface UserServiceInt {
    void add(UserDto userDto);
    List<UserReadDto> findAll();
}
