package pl.coderslab.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.coderslab.dto.UserAddDto;
import pl.coderslab.dto.UserEditRoleDto;
import pl.coderslab.dto.UserReadDto;
import pl.coderslab.dto.UserReadListDto;
import pl.coderslab.model.ReportUser;
import pl.coderslab.model.Role;

import java.util.List;

public interface UserService extends UserDetailsService {
    void add(UserAddDto userAddDto);
    List<UserReadDto> findAll();
    void delete(Long id);
    UserEditRoleDto findById(Long id);
    void update(UserEditRoleDto userEditRoleDto);
    ReportUser findByEmail(String email);
    boolean passwordConfirm(UserAddDto userAddDto);
    boolean userExist(UserAddDto userAddDto);
    List<UserReadListDto> findAllSortedByShop();
    List<Role> findRoleList();
}
