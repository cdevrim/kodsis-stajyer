package tr.com.turksat.stajyer.magazatakip.domain;
import java.time.LocalDateTime;
import java.util.Date;


public class SoldProduct {

    private Long id;
    private Date sold_date;
    private Long customer_account_id;
    private Date create_date;
    private Long create_user_id;
    private Long product_id;

    public SoldProduct(Long id, Date sold_date, Long customer_account_id, Date create_date, Long create_user_id, Long product_id) {
        this.id = id;
        this.sold_date = sold_date;
        this.customer_account_id = customer_account_id;
        this.create_date = create_date;
        this.create_user_id = create_user_id;
        this.product_id = product_id;
    }

    public SoldProduct(Long id) {
        this.id = id;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public Date getSold_date() {return sold_date;}
    public void setSold_date(Date sold_date) {this.sold_date = sold_date;}

    public Long getCustomer_account_id() {return customer_account_id;}
    public void setCustomer_account_id(Long customer_account_id) {this.customer_account_id = customer_account_id;}

    public Date getCreate_date() {return create_date;}
    public void setCreate_date(Date create_date) {this.create_date = create_date;}

    public Long getCreate_user_id() {return create_user_id;}
    public void setCreate_user_id(Long create_user_id) {this.create_user_id = create_user_id;}

    public Long getProduct_id() {return product_id;}
    public void setProduct_id(Long product_id) {this.product_id = product_id;}

    @Override
    public String toString() {
        return "SoldProduct{" +
                "id=" + id +
                ", sold_date=" + sold_date +
                ", customer_account_id=" + customer_account_id +
                ", create_date=" + create_date +
                ", create_user_id=" + create_user_id +
                ", product_id=" + product_id +
                '}';
    }
}
