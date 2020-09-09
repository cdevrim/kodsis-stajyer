package tr.com.turksat.stajyer.magazatakip.domain;

import java.time.LocalDateTime;
import java.util.Date;


public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int creditCard;
    private Date birthDate;
    private String gender;
    private String phone;
    private  Date createDate;
    private Long createUserId;



    public Customer() {

    }

    public Customer(Long id, String firstName, String lastName, String email, int creditCard, Date birthDate, String gender, String phone, Date createDate, Long createUserId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.creditCard = creditCard;
        this.birthDate = birthDate;
        this.gender = gender;
        this.phone = phone;
        this.createDate = createDate;
        this.createUserId = createUserId;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public int getCreditCard() {return creditCard;}
    public void setCreditCard(int creditCard) {this.creditCard = creditCard;}

    public Date getBirthDate() {return birthDate;}
    public void setBirthDate(Date birthDate) {this.birthDate = birthDate;}

    public String getGender() {return gender;}
    public void setGender(String gender) {this.gender = gender;}

    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}

    public Date getCreateDate() {return createDate;}
    public void setCreateDate(Date createDate) {this.createDate = createDate;}

    public Long getCreateUserId() {return createUserId;}
    public void setCreateUserId(Long createUserId) {this.createUserId = createUserId;}

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", creditCard=" + creditCard +
                ", birthDate=" + birthDate +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", createDate=" + createDate +
                ", createUserId=" + createUserId +
                '}';
    }
}
