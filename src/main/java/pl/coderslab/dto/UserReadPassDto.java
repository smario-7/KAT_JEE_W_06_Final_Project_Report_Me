package pl.coderslab.dto;

public class UserReadPassDto {
    private final Long id;
    private final Long shopId;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;

    public UserReadPassDto(Long id, Long shopId, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.shopId = shopId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }
}
