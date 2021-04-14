package beans;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User userId;
    @ManyToOne
    private Shop shopId;
    private int contract;
    private int annex;
    private int businessToBusiness;
    private int heandset;
    private int play360;
    private int television;
    private int upSaleOnTheSameDay;
    private int teleSales;
    private int displayProtection;
    private int accessories;
    private LocalDateTime createdTime;
    private LocalDateTime updateTime;

    @PrePersist
    public void createdTime () {
        this.createdTime = LocalDateTime.now();
    }
    @PreUpdate
    public void updateTime () {
        this.updateTime = LocalDateTime.now();
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Shop getShopId() {
        return shopId;
    }

    public void setShopId(Shop shopId) {
        this.shopId = shopId;
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
