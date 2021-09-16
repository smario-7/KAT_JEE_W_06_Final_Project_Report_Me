package pl.coderslab.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.coderslab.dto.UserAddDto;
import pl.coderslab.dto.UserReadDto;
import pl.coderslab.model.ReportUser;

import java.util.List;

public interface UserService extends UserDetailsService {
    void add(UserAddDto userAddDto);
    List<UserReadDto> findAll();
    void delete(Long id);
    UserReadDto findById(Long id);
    void update(UserReadDto userReadDto);
    ReportUser findByEmail(String email);
    boolean passwordConfirm(UserAddDto userAddDto);
    boolean userExist(UserAddDto userAddDto);
}
