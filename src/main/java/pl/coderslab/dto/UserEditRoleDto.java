package pl.coderslab.dto;

import pl.coderslab.model.Role;
import pl.coderslab.model.Shop;

import java.util.HashSet;
import java.util.Set;

public class UserEditRoleDto {
    private Long id;
    private Shop shop;
    private String firstName;
    private String lastName;
    private String email;
    private boolean enabled;
    private Set<Role> roles = new HashSet<>();

    public UserEditRoleDto(Long id, Shop shop, String firstName, String lastName, String email, boolean enabled, Set<Role> roles) {
        this.id = id;
        this.shop = shop;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.enabled = enabled;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
