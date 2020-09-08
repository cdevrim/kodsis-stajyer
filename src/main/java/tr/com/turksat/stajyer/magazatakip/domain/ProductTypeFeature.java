package tr.com.turksat.stajyer.magazatakip.domain;
import java.util.Date;
import javax.ejb.Local;
import java.time.LocalDateTime;

public class ProductTypeFeature {

    private Long id;
    private String value;
    private Date create_date;
    private Long create_user_id;
    private Long product_type_id;
    private Long feature_id;

    public ProductTypeFeature(Long id, String value, Date create_date, Long create_user_id, Long product_type_id, Long feature_id) {
        this.id = id;
        this.value = value;
        this.create_date = create_date;
        this.create_user_id = create_user_id;
        this.product_type_id = product_type_id;
        this.feature_id = feature_id;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getValue() {return value;}
    public void setValue(String value) {this.value = value;}

    public Date getCreate_date() {return create_date;}
    public void setCreate_date(Date create_date) {this.create_date = create_date;}

    public Long getCreate_user_id() {return create_user_id;}
    public void setCreate_user_id(Long create_user_id) {this.create_user_id = create_user_id;}

    public Long getProduct_type_id() {return product_type_id;}
    public void setProduct_type_id(Long product_type_id) {this.product_type_id = product_type_id;}

    public Long getFeature_id() {return feature_id;}
    public void setFeature_id(Long feature_id) {this.feature_id = feature_id;}

    @Override
    public String toString() {
        return "ProductTypeFeature{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", create_date=" + create_date +
                ", create_user_id=" + create_user_id +
                ", product_type_id=" + product_type_id +
                ", feature_id=" + feature_id +
                '}';
    }
}
