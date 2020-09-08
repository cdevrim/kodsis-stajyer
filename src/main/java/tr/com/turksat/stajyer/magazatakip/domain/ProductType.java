package tr.com.turksat.stajyer.magazatakip.domain;
import java.util.Date;
import javax.ejb.Local;
import java.time.LocalDateTime;

public class ProductType {

    private Long id;
    private Date create_date;
    private Long create_user_id;
    private String product_type_name;

    public ProductType(Long id, Date create_date, Long create_user_id, String product_type_name) {
        this.id = id;
        this.create_date = create_date;
        this.create_user_id = create_user_id;
        this.product_type_name = product_type_name;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public Date getCreate_date() {return create_date;}
    public void setCreate_date(Date create_date) {this.create_date = create_date; }

    public Long getCreate_user_id() {return create_user_id;}
    public void setCreate_user_id(Long create_user_id) {this.create_user_id = create_user_id;}

    public String getProduct_type_name() {return product_type_name;}
    public void setProduct_type_name(String product_type_name) {this.product_type_name = product_type_name;}

    @Override
    public String toString() {
        return "ProductType{" +
                "id=" + id +
                ", create_date=" + create_date +
                ", create_user_id=" + create_user_id +
                ", product_type_name='" + product_type_name + '\'' +
                '}';
    }
}
