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
        customer.setFirstName("Mehmet Test"+Math.random());
        customer.setLastName("Tek"+Math.random());
        customer.setCreateUserId(1L);
        customer.setCreateDate(new Date());
        customer.setCreditCard(123456);
        customer.setPhone("5555555555");
        customer.setGender("MALE");
        customer.setEmail("örek@gmail.com");
        customer.setBirthDate(new Date());

        customerDAO.insert(customer);
    }

    @Test
    public void testCustomerDelete(){

        customerDAO.delete(33L);
    }

    @Test
    public void testCustomerUpdate(){

        Customer customer = new Customer();
        customer.setId(16L);
        customer.setFirstName("Test"+Math.random());
        customer.setLastName("Test"+Math.random());
        customer.setCreateUserId(1L);
        customer.setCreateDate(new Date());
        customer.setCreditCard(1);
        customer.setPhone("1");
        customer.setGender("TEST");
        customer.setEmail("test@gmail.com");
        customer.setBirthDate(new Date());

        customerDAO.update(customer);
    }

}
