package tr.com.turksat.stajyer.magazatakip.domain;
import java.util.Date;
import javax.ejb.Local;
import java.time.LocalDateTime;

public class ProductType {

    private Long id;
    private Date createDate;
    private Long createUserId;
    private String productTypeName;


    public ProductType() {


    }

    public ProductType(Long id, Date createDate, Long createUserId, String productTypeName) {
        this.id = id;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.productTypeName = productTypeName;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public Date getCreateDate() {return createDate;}
    public void setCreateDate(Date createDate) {this.createDate = createDate;}

    public Long getCreateUserId() {return createUserId;}
    public void setCreateUserId(Long createUserId) {this.createUserId = createUserId;}

    public String getProductTypeName() {return productTypeName;}
    public void setProductTypeName(String productTypeName) {this.productTypeName = productTypeName;}

    @Override
    public String toString() {
        return "ProductType{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", createUserId=" + createUserId +
                ", productTypeName='" + productTypeName + '\'' +
                '}';
    }
}
