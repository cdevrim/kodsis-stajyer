package tr.com.turksat.stajyer.magazatakip.domain;

import java.util.Date;
import java.time.LocalDateTime;

public class ProductDescription {
    private Long id;
    private String productDescriptionName;
    private Date createDate;
    private Long createUserId;
    private Long productTypeId;


    public ProductDescription() {

    }

    public ProductDescription(Long id, String productDescriptionName, Date createDate, Long createUserId, Long productTypeId) {
        this.id = id;
        this.productDescriptionName = productDescriptionName;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.productTypeId = productTypeId;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getProductDescriptionName() {return productDescriptionName;}
    public void setProductDescriptionName(String productDescriptionName) {this.productDescriptionName = productDescriptionName;}

    public Date getCreateDate() {return createDate;}
    public void setCreateDate(Date createDate) {this.createDate = createDate;}

    public Long getCreateUserId() {return createUserId;}
    public void setCreateUserId(Long createUserId) {this.createUserId = createUserId;}

    public Long getProductTypeId() {return productTypeId;}
    public void setProductTypeId(Long productTypeId) {this.productTypeId = productTypeId;}

    @Override
    public String toString() {
        return "ProductDescription{" +
                "id=" + id +
                ", productDescriptionName='" + productDescriptionName + '\'' +
                ", createDate=" + createDate +
                ", createUserId=" + createUserId +
                ", productTypeId=" + productTypeId +
                '}';
    }
}
