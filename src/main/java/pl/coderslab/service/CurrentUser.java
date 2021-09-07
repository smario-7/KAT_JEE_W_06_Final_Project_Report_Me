package pl.coderslab.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import pl.coderslab.model.ReportUser;

import java.util.Collection;

public class CurrentUser extends User {
    private final ReportUser reportUser;

    public CurrentUser(String email, String password, Collection<? extends GrantedAuthority> authorities,
                       ReportUser reportUser) {
        super(email, password, authorities);
        this.reportUser = reportUser;
    }
    public ReportUser getUser() {return reportUser;};

}
