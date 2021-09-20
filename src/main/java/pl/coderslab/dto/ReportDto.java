package pl.coderslab.dto;

import javax.validation.constraints.Digits;

public class ReportDto {
    @Digits(integer = 2, fraction = 0)
    private int contract;
    @Digits(integer = 2, fraction = 0)
    private int annex;
    @Digits(integer = 2, fraction = 0)
    private int businessToBusiness;
    @Digits(integer = 2, fraction = 0)
    private int handset;
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

    public ReportDto(@Digits(integer = 2, fraction = 0) int contract, @Digits(integer = 2, fraction = 0) int annex,
                     @Digits(integer = 2, fraction = 0) int businessToBusiness, @Digits(integer = 2, fraction = 0) int handset,
                     @Digits(integer = 2, fraction = 0) int play360, @Digits(integer = 2, fraction = 0) int television,
                     @Digits(integer = 2, fraction = 0) int upSaleOnTheSameDay, @Digits(integer = 2, fraction = 0) int teleSales,
                     @Digits(integer = 2, fraction = 0) int displayProtection,
                     @Digits(integer = 2, fraction = 0) int accessories) {
        this.contract = contract;
        this.annex = annex;
        this.businessToBusiness = businessToBusiness;
        this.handset = handset;
        this.play360 = play360;
        this.television = television;
        this.upSaleOnTheSameDay = upSaleOnTheSameDay;
        this.teleSales = teleSales;
        this.displayProtection = displayProtection;
        this.accessories = accessories;
    }

    public ReportDto() {
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

    public int getHandset() {
        return handset;
    }

    public void setHandset(int heandset) {
        this.handset = handset;
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
