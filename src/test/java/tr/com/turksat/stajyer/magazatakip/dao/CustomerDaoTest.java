package tr.com.turksat.stajyer.magazatakip.dao;

import org.junit.Test;
import tr.com.turksat.stajyer.magazatakip.domain.Customer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


public class CustomerDaoTest {

    CustomerDAO customerDAO = new CustomerDAO();

    @Test
    public void testGetCustomer(){
        System.out.println("test");

        List<Customer> customerList = customerDAO.getCustomer();
        for(Customer customer : customerList){
            System.out.println("ID : "+customer.getId()+" First Name : "+customer.getFirstName()+
                    " Last Name: " + customer.getLastName()+ " Email: " + customer.getEmail() +
                    " Credit Card: " + customer.getCreditCard() + " Birth Date" + customer.getBirthDate()+
                    " Gender: " + customer.getGender() + " Phone: " + customer.getPhone() +
                    " Create Date: " + customer.getCreateDate() + "Create User ID: " + customer.getCreateUserId());
        }
    }

    @Test
    public void testInsertCustomer(){

        Customer customer = new Customer();
        customer.setFirstName("Ahmet"+Math.random());
        customer.setLastName("Tek"+Math.random());
        customer.setCreateUserId(1L);
        customer.setCreateDate(new Date());
        customer.setCreditCard(123456);
        customer.setPhone("5555555555");
        customer.setGender("ERKEK");
        customer.setEmail("örek@gmail.com");
        customer.setBirthDate(new Date());

        customerDAO.insert(customer);
    }

    @Test
    public void testCustomerDelete(){

        customerDAO.delete(32L); // sonuna L koyunca java da Long oluyor
        //32 silinince tekrar 32 bulamaz yani onu için tek tek test edebilirsin,
        //test yazarak hızlı bir şeykilde JDBC öğrenebilirsin..

    }

    @Test
    public void testCustomerUpdate(){

        Customer customer = new Customer();
        customer.setId(16L);
        customer.setFirstName("Test"+Math.random());
        customer.setLastName("Test"+Math.random());

        customerDAO.update(customer);
    }

}
