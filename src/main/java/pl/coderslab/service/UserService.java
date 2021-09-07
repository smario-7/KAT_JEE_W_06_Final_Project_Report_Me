package pl.coderslab.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.coderslab.dto.UserDto;
import pl.coderslab.dto.UserReadDto;
import pl.coderslab.dto.UserReadPassDto;
import pl.coderslab.model.ReportUser;

import java.util.List;

public interface UserService extends UserDetailsService {
    void add(UserDto userDto);
    List<UserReadDto> findAll();
    void delete(Long id);
    UserReadDto findById(Long id);
    void update(UserReadDto userReadDto);
    ReportUser findByEmail(String email);
}
