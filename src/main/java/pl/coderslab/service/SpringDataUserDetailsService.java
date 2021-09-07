package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.coderslab.model.ReportUser;

import javax.persistence.EntityExistsException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class SpringDataUserDetailsService implements UserDetailsService {
    private UserService userService;

    @Autowired
    public void setUserRepository(UserService userService) {this.userService = userService;}

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        ReportUser reportUser = Optional.ofNullable(userService.findByEmail(email)).orElseThrow(EntityExistsException::new);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        reportUser.getRoles().forEach(r ->
                grantedAuthorities.add(new SimpleGrantedAuthority(r.getName())));

        return new CurrentUser(reportUser.getEmail(), reportUser.getPassword(), grantedAuthorities, reportUser);
    }
}
