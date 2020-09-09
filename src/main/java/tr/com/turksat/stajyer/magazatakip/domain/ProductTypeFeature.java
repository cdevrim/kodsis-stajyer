package tr.com.turksat.stajyer.magazatakip.domain;
import java.util.Date;
import javax.ejb.Local;
import java.time.LocalDateTime;

public class ProductTypeFeature {

    private Long id;
    private String value;
    private Date createDate;
    private Long createUserId;
    private Long productTypeId;
    private Long featureId;


    public ProductTypeFeature() {
    }

    public ProductTypeFeature(Long id, String value, Date createDate, Long createUserId, Long productTypeId, Long featureId) {
        this.id = id;
        this.value = value;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.productTypeId = productTypeId;
        this.featureId = featureId;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getValue() {return value;}
    public void setValue(String value) {this.value = value;}

    public Date getCreateDate() {return createDate;}
    public void setCreateDate(Date createDate) {this.createDate = createDate;}

    public Long getCreateUserId() {return createUserId;}
    public void setCreateUserId(Long createUserId) {this.createUserId = createUserId;}

    public Long getProductTypeId() {return productTypeId;}
    public void setProductTypeId(Long productTypeId) {this.productTypeId = productTypeId;}

    public Long getFeatureId() {return featureId;}
    public void setFeatureId(Long featureId) {this.featureId = featureId;}

    @Override
    public String toString() {
        return "ProductTypeFeature{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", createDate=" + createDate +
                ", createUserId=" + createUserId +
                ", productTypeId=" + productTypeId +
                ", featureId=" + featureId +
                '}';
    }
}
