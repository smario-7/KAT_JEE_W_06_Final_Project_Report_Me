package pl.coderslab.model;

import javax.persistence.*;

@Entity
@Table(name= "prediction_report")
public class PredictionReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Report report;
    private int contract;
    private int annex;
    private int businessToBusiness;;
    private int heandset;
    private int play360;
    private int television;
    private int upSaleOnTheSameDay;
    private int teleSales;
    private int displayProtection;;
    private int accessories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
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
