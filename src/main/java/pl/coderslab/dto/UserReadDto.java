package pl.coderslab.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserReadDto {
    @NotNull
    private final Long shopId;
    @NotEmpty
    private final String firstName;
    @NotEmpty
    private final String lastName;
    @Email
    private final String email;


    public UserReadDto(@NotNull Long shopId, @NotEmpty String firstName, @NotEmpty String lastName, @Email String email) {
        this.shopId = shopId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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
}
