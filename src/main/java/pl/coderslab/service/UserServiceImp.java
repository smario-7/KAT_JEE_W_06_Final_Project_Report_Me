package pl.coderslab.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.dto.UserAddDto;
import pl.coderslab.dto.UserEditRoleDto;
import pl.coderslab.dto.UserReadDto;
import pl.coderslab.dto.UserReadListDto;
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
        Role roles = roleRepository.findByName("Nowy");
        newReportUser.addRole(roles);
        userRepository.save(newReportUser);
    }

    public void update(UserEditRoleDto userEditRoleDto) {
        ReportUser newReportUser = userRepository.findById(userEditRoleDto.getId()).orElseThrow(EntityNotFoundException::new);
        newReportUser.setShop(shopRepository.findById(userEditRoleDto.getShop().getId()).orElseThrow(EntityNotFoundException::new));
        newReportUser.setRoles(userEditRoleDto.getRoles());
        userRepository.save(newReportUser);
    }

    public List<UserReadDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(reportUser -> new UserReadDto(reportUser.getId(), reportUser.getShop().getId(), reportUser.getFirstName(), reportUser.getLastName(), reportUser.getEmail(), reportUser.getRoles()))
                .collect(Collectors.toList());
    }

    public UserEditRoleDto findById(Long id) {
        ReportUser reportUser = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return new UserEditRoleDto(reportUser.getId(), reportUser.getShop(), reportUser.getFirstName(), reportUser.getLastName(), reportUser.getEmail(), reportUser.isEnabled(), reportUser.getRoles());
    }

    public List<UserReadListDto> findAllSortedByShop() {
        return userRepository.findAllByOrderByShop()
                .stream()
                .map(reportUser -> new UserReadListDto(reportUser.getId(), reportUser.getFirstName(), reportUser.getLastName(),
                        reportUser.getEmail(), reportUser.getShop().getShopName(), reportUser.getRoles()))
                .collect(Collectors.toList());
    }
    public List<Role> findRoleList(){
        return roleRepository.findAll();

    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    ;

    public boolean passwordConfirm(UserAddDto userAddDto) {
        return userAddDto.getPassword().equals(userAddDto.getPasswordRepeat());
    }

    public boolean userExist(UserAddDto userAddDto) {
        return userRepository.existsByEmail(userAddDto.getEmail());
    }


    @Override
    public UserDetails loadUserByUsername(String email) {
        ReportUser reportUser = userRepository.findByEmail(email);
        if (reportUser == null) {
            throw new UsernameNotFoundException("Nie mamy takiego maila w bazie " + email);
        }
        return new org.springframework.security.core.userdetails.User(reportUser.getEmail(), reportUser.getPassword(), new ArrayList<>());
    }
//    public Collection<? extends GrantedAuthority> mapRoles(Collection<Role> roles)

}
