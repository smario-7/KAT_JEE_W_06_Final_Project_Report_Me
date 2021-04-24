package pl.coderslab.dto;

import javax.validation.constraints.Digits;
import java.time.LocalDateTime;

public class ReportEditDto {
    private final Long id;
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
    private LocalDateTime createdTime;
    private final LocalDateTime updateTime;

    public ReportEditDto(Long id, int contract, int annex, int businessToBusiness, int heandset, int play360,
                         int television, int upSaleOnTheSameDay, int teleSales, int displayProtection, int accessories,
                         LocalDateTime createdTime, LocalDateTime updateTime) {
        this.id = id;
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
        this.createdTime = createdTime;
        this.updateTime = updateTime;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public Long getId() {
        return id;
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

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    @Override
    public String toString() {
        return "ReportEditDto{" +
                "id=" + id +
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
                ", createdTime=" + createdTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
