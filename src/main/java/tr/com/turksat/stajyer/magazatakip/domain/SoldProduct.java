package tr.com.turksat.stajyer.magazatakip.domain;
import java.time.LocalDateTime;
import java.util.Date;


public class SoldProduct {

    private Long id;
    private Date soldDate;
    private Long customerAccountId;
    private Date createDate;
    private Long createUserId;
    private Long productId;

    //genelde default bu boş constructor u oluşturmayı alışkanlık haline getir.
    public SoldProduct() { }

    public SoldProduct(Long id, Date soldDate, Long customerAccountId, Date createDate, Long createUserId, Long productId) {
        this.id = id;
        this.soldDate = soldDate;
        this.customerAccountId = customerAccountId;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.productId = productId;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public Date getSoldDate() {return soldDate;}
    public void setSoldDate(Date soldDate) {this.soldDate = soldDate;}

    public Long getCustomerAccountId() {return customerAccountId;}
    public void setCustomerAccountId(Long customerAccountId) {this.customerAccountId = customerAccountId;}

    public Date getCreateDate() {return createDate;}
    public void setCreateDate(Date createDate) {this.createDate = createDate;}

    public Long getCreateUserId() {return createUserId;}
    public void setCreateUserId(Long createUserId) {this.createUserId = createUserId;}

    public Long getProductId() {return productId;}
    public void setProductId(Long productId) {this.productId = productId;}

    @Override
    public String toString() {
        return "SoldProduct{" +
                "id=" + id +
                ", soldDate=" + soldDate +
                ", customerAccountId=" + customerAccountId +
                ", createDate=" + createDate +
                ", createUserId=" + createUserId +
                ", productId=" + productId +
                '}';
    }
}
