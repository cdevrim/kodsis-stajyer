package tr.com.turksat.stajyer.magazatakip.domain;

import java.util.Date;
import java.time.LocalDateTime;

public class CustomerAccount {
    private Long id;
    private Long customerId;
    private Date createDate;
    private Long createUserId;
    private String billingAddress;

    public CustomerAccount() {
    }

    public CustomerAccount(Long id, Long customerId, Date createDate, Long createUserId, String billingAddress) {
        this.id = id;
        this.customerId = customerId;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.billingAddress = billingAddress;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public Long getCustomerId() {return customerId;}
    public void setCustomerId(Long customerId) {this.customerId = customerId;}

    public Date getCreateDate() {return createDate;}
    public void setCreateDate(Date createDate) {this.createDate = createDate;}

    public Long getCreateUserId() {return createUserId;}
    public void setCreateUserId(Long createUserId) {this.createUserId = createUserId;}

    public String getBillingAddress() {return billingAddress;}
    public void setBillingAddress(String billingAddress) {this.billingAddress = billingAddress;}

    @Override
    public String toString() {
        return "CustomerAccount{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", createDate=" + createDate +
                ", createUserId=" + createUserId +
                ", billingAddress='" + billingAddress + '\'' +
                '}';
    }
}
