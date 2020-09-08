package tr.com.turksat.stajyer.magazatakip.domain;

import java.time.LocalDateTime;
import java.util.Date;


public class Customer {
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private int credit_card;
    private Date birth_date;
    private String gender;
    private String phone;
    private  Date create_date;
    private Long create_user_id;

    public Customer(Long id, String first_name, String last_name, String email, int credit_card, Date birth_date, String gender, String phone, Date create_date, Long create_user_id ) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.credit_card = credit_card;
        this.birth_date = birth_date;
        this.gender = gender;
        this.phone = phone;
        this.create_date = create_date;
        this.create_user_id = create_user_id;

    }

    public Customer() {

    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getFirst_name() {return first_name; }
    public void setFirst_name(String first_name) {this.first_name = first_name;}

    public String getLast_name() {return last_name;}
    public void setLast_name(String last_name) {this.last_name = last_name; }

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public int getCredit_card() {return credit_card;}
    public void setCredit_card(int credit_card) {this.credit_card = credit_card;}

    public Date getBirth_date() {return birth_date;}
    public void setBirth_date(Date birth_date) {this.birth_date = birth_date;}

    public String getGender() {return gender;}
    public void setGender(String gender) {this.gender = gender;}

    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}

    public  Date getCreate_date() {return create_date;}
    public void setCreate_date(Date create_date) {this.create_date = create_date;}

    public Long getCreate_user_id() {return create_user_id;}
    public void setCreate_user_id(Long create_user_id) {this.create_user_id = create_user_id;}


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", credit_card=" + credit_card +
                ", birth_date=" + birth_date +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", create_date=" + create_date +
                ", create_user_id=" + create_user_id +
                '}';
    }
}
