package pl.coderslab.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ReportReadDto {
    private final Long id;
    @NotNull
    private final String userName;
    @NotNull
    private final String shopName;
    @Digits(integer = 2, fraction = 0)
    private final int contract;
    @Digits(integer = 2, fraction = 0)
    private final int annex;
    @Digits(integer = 2, fraction = 0)
    private final int businessToBusiness;
    @Digits(integer = 2, fraction = 0)
    private final int heandset;
    @Digits(integer = 2, fraction = 0)
    private final int play360;
    @Digits(integer = 2, fraction = 0)
    private final int television;
    @Digits(integer = 2, fraction = 0)
    private final int upSaleOnTheSameDay;
    @Digits(integer = 2, fraction = 0)
    private final int teleSales;
    @Digits(integer = 2, fraction = 0)
    private final int displayProtection;
    @Digits(integer = 2, fraction = 0)
    private final int accessories;

    private final LocalDate createdData;

    public ReportReadDto(Long id, String userName, String shopName, int contract, int annex, int businessToBusiness,
                         int heandset, int play360, int television, int upSaleOnTheSameDay, int teleSales,
                         int displayProtection, int accessories, LocalDate createdData) {
        this.id = id;
        this.userName = userName;
        this.shopName = shopName;
        this.contract = contract;
        this.annex = annex;
        this.businessToBusiness = businessToBusiness;
        this.heandset = heandset;
        this.play360 = play360;
        this.television = television;
        this.upSaleOnTheSameDay = upSaleOnTheSameDay;
        this.teleSales = teleSales;
        this.displayProtection = displayProtection;
        this.accessories = accessories;
        this.createdData = createdData;
    }

    public Long getId() {
        return id;
    }
    public String getUserName() {
        return userName;
    }

    public String getShopName() {
        return shopName;
    }

    public int getContract() {
        return contract;
    }

    public int getAnnex() {
        return annex;
    }

    public int getBusinessToBusiness() {
        return businessToBusiness;
    }

    public int getHeandset() {
        return heandset;
    }

    public int getPlay360() {
        return play360;
    }

    public int getTelevision() {
        return television;
    }

    public int getUpSaleOnTheSameDay() {
        return upSaleOnTheSameDay;
    }

    public int getTeleSales() {
        return teleSales;
    }

    public int getDisplayProtection() {
        return displayProtection;
    }

    public int getAccessories() {
        return accessories;
    }

    public LocalDate getCreatedData() {
        return createdData;
    }

    @Override
    public String toString() {
        return "Raport: { " +
                "Użytkownik :  "  + userName +
                ", Sklep : " + shopName +
                ", contract : " + contract +
                ", annex : " + annex +
                ", businessToBusiness : " + businessToBusiness +
                ", heandset : " + heandset +
                ", play360 : " + play360 +
                ", television : " + television +
                ", upSaleOnTheSameDay : " + upSaleOnTheSameDay +
                ", teleSales : " + teleSales +
                ", displayProtection : " + displayProtection +
                ", accessories : " + accessories +
                '}';
    }
}
