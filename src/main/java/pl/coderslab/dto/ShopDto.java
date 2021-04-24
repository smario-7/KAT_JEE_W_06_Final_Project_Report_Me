package pl.coderslab.dto;

import javax.validation.constraints.NotEmpty;

public class ShopDto {

    private Long id;
    @NotEmpty
    private String shopName;

    public ShopDto(@NotEmpty String shopName) {
        this.shopName = shopName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
