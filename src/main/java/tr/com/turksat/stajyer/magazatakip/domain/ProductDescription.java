package tr.com.turksat.stajyer.magazatakip.domain;

import java.util.Date;
import java.time.LocalDateTime;

public class ProductDescription {
    private Long id;
    private String product_description_name;
    private Date create_date;
    private Long create_user_id;
    private Long product_type_id;

    public ProductDescription(Long id, String product_description_name, Date create_date, Long create_user_id, Long product_type_id) {
        this.id = id;
        this.product_description_name = product_description_name;
        this.create_date = create_date;
        this.create_user_id = create_user_id;
        this.product_type_id = product_type_id;
    }

    public Long getId() {return id; }
    public void setId(Long id) {this.id = id;}

    public String getProduct_description_name() {return product_description_name;}
    public void setProduct_description_name(String product_description_name) {this.product_description_name = product_description_name;}

    public Date getCreate_date() {return create_date;}
    public void setCreate_date(Date create_date) {this.create_date = create_date;}

    public Long getCreate_user_id() {return create_user_id;}
    public void setCreate_user_id(Long create_user_id) {this.create_user_id = create_user_id;}

    public Long getProduct_type_id() {return product_type_id;}
    public void setProduct_type_id(Long product_type_id) {this.product_type_id = product_type_id;}

    @Override
    public String toString() {
        return "ProductDescription{" +
                "id=" + id +
                ", product_description_name='" + product_description_name + '\'' +
                ", create_date=" + create_date +
                ", create_user_id=" + create_user_id +
                ", product_type_id=" + product_type_id +
                '}';
    }
}
