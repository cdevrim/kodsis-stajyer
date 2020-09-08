package tr.com.turksat.stajyer.magazatakip.domain;

import java.util.Date;
import java.time.LocalDateTime;

public class CustomerAccount {
    private Long id;
    private Long customer_id;
    private Date create_date;
    private Long create_user_id;
    private String billing_address;

    public CustomerAccount(Long id, Long customer_id, Date create_date, Long create_user_id, String billing_address) {
        this.id = id;
        this.customer_id = customer_id;
        this.create_date = create_date;
        this.create_user_id = create_user_id;
        this.billing_address = billing_address;
    }

    public Long getId() {return id; }
    public void setId(Long id) {this.id = id;}


    public Long getCustomer_id() {return customer_id;}
    public void setCustomer_id(Long customer_id) {this.customer_id = customer_id;}

    public Date getCreate_date() {return create_date;}
    public void setCreate_date(Date create_date) {this.create_date = create_date;}


    public Long getCreate_user_id() {return create_user_id;}
    public void setCreate_user_id(Long create_user_id) {this.create_user_id = create_user_id;}

    public String getBilling_address() {return billing_address;}
    public void setBilling_address(String billing_address) {this.billing_address = billing_address;}

    @Override
    public String toString() {
        return "CustomerAccount{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", create_date=" + create_date +
                ", create_user_id=" + create_user_id +
                ", billing_address='" + billing_address + '\'' +
                '}';
    }
}
