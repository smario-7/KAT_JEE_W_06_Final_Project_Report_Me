package pl.coderslab.dto;

import pl.coderslab.model.Shop;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserAddDto {

    @NotBlank (message = "puste pole")
    private String firstName;
    @NotBlank (message = "puste pole")
    private String lastName;
    @NotNull
    private Shop shop;
    @Email (message = "błędny format")
    @NotBlank (message = "puste pole")
    private String email;
    @Size(min = 6, message = "za krótkie min. 6 znaków")
    @NotBlank(message = "puste pole")
    private String password;
    @NotBlank
    private String passwordRepeat;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
