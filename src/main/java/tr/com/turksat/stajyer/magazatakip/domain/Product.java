package tr.com.turksat.stajyer.magazatakip.domain;
import java.math.BigDecimal;
import java.util.Date;
import java.time.LocalDateTime;

public class Product {

    private Long id;
    private String product_name;
    private BigDecimal price;
    private  Date create_date;
    private Long create_user_id;
    private Date product_date;
    private Long product_description_id;


    public Product(Long id, String product_name, BigDecimal price, Date create_date, Long create_user_id, Date product_date, Long product_description_id) {
        this.id = id;
        this.product_name = product_name;
        this.price = price;
        this.create_date = create_date;
        this.create_user_id = create_user_id;
        this.product_date = product_date;
        this.product_description_id = product_description_id;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getProduct_name() {return product_name;}
    public void setProduct_name(String product_name) {this.product_name = product_name;}

    public BigDecimal getPrice() {return price;}
    public void setPrice(BigDecimal price) {this.price = price;}


    public Date getCreate_date() {return create_date;}
    public void setCreate_date(Date create_date) {this.create_date = create_date;}


    public Long getCreate_user_id() {return create_user_id;}
    public void setCreate_user_id(Long create_user_id) {this.create_user_id = create_user_id;}

    public Date getProduct_date() {return product_date;}
    public void setProduct_date(Date product_date) {this.product_date = product_date;}

    public Long getProduct_description_id() {return product_description_id;}
    public void setProduct_description_id(Long product_description_id) {this.product_description_id = product_description_id;}

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", product_name='" + product_name + '\'' +
                ", price=" + price +
                ", create_date=" + create_date +
                ", create_user_id=" + create_user_id +
                ", product_date=" + product_date +
                ", product_description_id=" + product_description_id +
                '}';
    }
}
