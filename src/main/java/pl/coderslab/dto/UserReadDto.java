package pl.coderslab.dto;

import pl.coderslab.model.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class UserReadDto {
    private final Long id;
    @NotNull
    private final Long shopId;
    @NotEmpty
    private final String firstName;
    @NotEmpty
    private final String lastName;
    @Email
    private final String email;

    private final Set<Role> role;


    public UserReadDto(Long id, Long shopId, String firstName, String lastName, String email, Set<Role> role) {
        this.id = id;
        this.shopId = shopId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public Long getShopId() {
        return shopId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Set<Role> getRole() {
        return role;
    }
}
