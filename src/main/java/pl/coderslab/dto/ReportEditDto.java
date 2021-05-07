package pl.coderslab.dto;

import javax.validation.constraints.Digits;

public class ReportEditDto {
    private Long id;
    @Digits(integer = 2, fraction = 0)
    private int contract;
    @Digits(integer = 2, fraction = 0)
    private int annex;
    @Digits(integer = 2, fraction = 0)
    private int businessToBusiness;
    @Digits(integer = 2, fraction = 0)
    private int heandset;
    @Digits(integer = 2, fraction = 0)
    private int play360;
    @Digits(integer = 2, fraction = 0)
    private int television;
    @Digits(integer = 2, fraction = 0)
    private int upSaleOnTheSameDay;
    @Digits(integer = 2, fraction = 0)
    private int teleSales;
    @Digits(integer = 2, fraction = 0)
    private int displayProtection;
    @Digits(integer = 2, fraction = 0)
    private int accessories;

    public ReportEditDto(Long id, int contract, int annex, int businessToBusiness, int heandset, int play360, int television, int upSaleOnTheSameDay, int teleSales, int displayProtection, int accessories) {
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
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getContract() {
        return contract;
    }

    public void setContract(int contract) {
        this.contract = contract;
    }

    public int getAnnex() {
        return annex;
    }

    public void setAnnex(int annex) {
        this.annex = annex;
    }

    public int getBusinessToBusiness() {
        return businessToBusiness;
    }

    public void setBusinessToBusiness(int businessToBusiness) {
        this.businessToBusiness = businessToBusiness;
    }

    public int getHeandset() {
        return heandset;
    }

    public void setHeandset(int heandset) {
        this.heandset = heandset;
    }

    public int getPlay360() {
        return play360;
    }

    public void setPlay360(int play360) {
        this.play360 = play360;
    }

    public int getTelevision() {
        return television;
    }

    public void setTelevision(int television) {
        this.television = television;
    }

    public int getUpSaleOnTheSameDay() {
        return upSaleOnTheSameDay;
    }

    public void setUpSaleOnTheSameDay(int upSaleOnTheSameDay) {
        this.upSaleOnTheSameDay = upSaleOnTheSameDay;
    }

    public int getTeleSales() {
        return teleSales;
    }

    public void setTeleSales(int teleSales) {
        this.teleSales = teleSales;
    }

    public int getDisplayProtection() {
        return displayProtection;
    }

    public void setDisplayProtection(int displayProtection) {
        this.displayProtection = displayProtection;
    }

    public int getAccessories() {
        return accessories;
    }

    public void setAccessories(int accessories) {
        this.accessories = accessories;
    }
}
