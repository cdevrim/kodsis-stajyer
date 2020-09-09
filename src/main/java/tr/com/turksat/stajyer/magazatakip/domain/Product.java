package tr.com.turksat.stajyer.magazatakip.domain;
import java.math.BigDecimal;
import java.util.Date;
import java.time.LocalDateTime;

public class Product {

    private Long id;
    private String productName;
    private BigDecimal price;
    private  Date createDate;
    private Long createUserId;
    private Date productDate;
    private Long productDescriptionId;

    public Product() {
    }

    public Product(Long id, String productName, BigDecimal price, Date createDate, Long createUserId, Date productDate, Long productDescriptionId) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.productDate = productDate;
        this.productDescriptionId = productDescriptionId;
    }


    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getProductName() {return productName;}
    public void setProductName(String productName) {this.productName = productName;}

    public BigDecimal getPrice() {return price;}
    public void setPrice(BigDecimal price) {this.price = price;}

    public Date getCreateDate() {return createDate;}
    public void setCreateDate(Date createDate) {this.createDate = createDate;}

    public Long getCreateUserId() {return createUserId;}
    public void setCreateUserId(Long createUserId) {this.createUserId = createUserId;}

    public Date getProductDate() {return productDate;}
    public void setProductDate(Date productDate) {this.productDate = productDate;}

    public Long getProductDescriptionId() {return productDescriptionId;}
    public void setProductDescriptionId(Long productDescriptionId) {this.productDescriptionId = productDescriptionId;}

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", createDate=" + createDate +
                ", createUserId=" + createUserId +
                ", productDate=" + productDate +
                ", productDescriptionId=" + productDescriptionId +
                '}';
    }
}
