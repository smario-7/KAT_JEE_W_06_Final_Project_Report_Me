package dto;

import beans.Shop;
import beans.User;

public class ReportReadDto {
    private final User userId;
    private final Shop shopId;
    private final int contract;
    private final int annex;
    private final int businessToBusiness;
    private final int heandset;
    private final int play360;
    private final int television;
    private final int upSaleOnTheSameDay;
    private final int teleSales;
    private final int displayProtection;
    private final int accessories;

    public ReportReadDto(User userId, Shop shopId, int contract, int annex, int businessToBusiness,
                         int heandset, int play360, int television, int upSaleOnTheSameDay, int teleSales,
                         int displayProtection, int accessories) {
        this.userId = userId;
        this.shopId = shopId;
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
    }

    public User getUserId() {
        return userId;
    }

    public Shop getShopId() {
        return shopId;
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

    @Override
    public String toString() {
        return "ReportReadDto{" +
                "userId=" + userId +
                ", shopId=" + shopId +
                ", contract=" + contract +
                ", annex=" + annex +
                ", businessToBusiness=" + businessToBusiness +
                ", heandset=" + heandset +
                ", play360=" + play360 +
                ", television=" + television +
                ", upSaleOnTheSameDay=" + upSaleOnTheSameDay +
                ", teleSales=" + teleSales +
                ", displayProtection=" + displayProtection +
                ", accessories=" + accessories +
                '}';
    }
}
