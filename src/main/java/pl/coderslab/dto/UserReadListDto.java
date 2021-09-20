package pl.coderslab.dto;

import pl.coderslab.model.Role;

import java.util.Set;

public class UserReadListDto {
    private final Long id;
    private final String shop;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Set<Role> role;


    public UserReadListDto(Long id, String firstName, String lastName, String email, String shop, Set<Role> role) {
        this.id = id;
        this.shop = shop;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getShop() {
        return shop;
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
