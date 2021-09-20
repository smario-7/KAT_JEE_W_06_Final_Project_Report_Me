package pl.coderslab.beans;

import javax.persistence.*;

@Entity
@Table(name= "prediction_report")
public class PredictionReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Report report;
    private int contractPrediction;
    private int annexPrediction;
    private int businessToBusinessPrediction;;
    private int heandsetPrediction;;
    private int play360Prediction;;
    private int televisionPrediction;;
    private int upSaleOnTheSameDayPrediction;;
    private int teleSalesPrediction;;
    private int displayProtectionPrediction;;
    private int accessoriesPrediction;

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

    public int getContractPrediction() {
        return contractPrediction;
    }

    public void setContractPrediction(int contractPrediction) {
        this.contractPrediction = contractPrediction;
    }

    public int getAnnexPrediction() {
        return annexPrediction;
    }

    public void setAnnexPrediction(int annexPrediction) {
        this.annexPrediction = annexPrediction;
    }

    public int getBusinessToBusinessPrediction() {
        return businessToBusinessPrediction;
    }

    public void setBusinessToBusinessPrediction(int businessToBusinessPrediction) {
        this.businessToBusinessPrediction = businessToBusinessPrediction;
    }

    public int getHeandsetPrediction() {
        return heandsetPrediction;
    }

    public void setHeandsetPrediction(int heandsetPrediction) {
        this.heandsetPrediction = heandsetPrediction;
    }

    public int getPlay360Prediction() {
        return play360Prediction;
    }

    public void setPlay360Prediction(int play360Prediction) {
        this.play360Prediction = play360Prediction;
    }

    public int getTelevisionPrediction() {
        return televisionPrediction;
    }

    public void setTelevisionPrediction(int televisionPrediction) {
        this.televisionPrediction = televisionPrediction;
    }

    public int getUpSaleOnTheSameDayPrediction() {
        return upSaleOnTheSameDayPrediction;
    }

    public void setUpSaleOnTheSameDayPrediction(int upSaleOnTheSameDayPrediction) {
        this.upSaleOnTheSameDayPrediction = upSaleOnTheSameDayPrediction;
    }

    public int getTeleSalesPrediction() {
        return teleSalesPrediction;
    }

    public void setTeleSalesPrediction(int teleSalesPrediction) {
        this.teleSalesPrediction = teleSalesPrediction;
    }

    public int getDisplayProtectionPrediction() {
        return displayProtectionPrediction;
    }

    public void setDisplayProtectionPrediction(int displayProtectionPrediction) {
        this.displayProtectionPrediction = displayProtectionPrediction;
    }

    public int getAccessoriesPrediction() {
        return accessoriesPrediction;
    }

    public void setAccessoriesPrediction(int accessoriesPrediction) {
        this.accessoriesPrediction = accessoriesPrediction;
    }
}
