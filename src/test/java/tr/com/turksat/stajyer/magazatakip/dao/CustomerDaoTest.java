package tr.com.turksat.stajyer.magazatakip.dao;

import org.junit.Test;
import tr.com.turksat.stajyer.magazatakip.domain.Customer;
import java.util.List;

public class CustomerDaoTest {

    private  CustomerDao customerDao = new CustomerDao();

    @Test
    public void testGetCustomerList(){
        List<Customer> list = customerDao.getCustomerList();
        for(Customer customer : list){
            System.out.println("Id : " + customer.getId() + " Name : " + customer.getName() + customer.getSurname() + customer.getPhone_number() + customer.getEmail() + customer.getAddress() + customer.getPostcode() + customer.getAge() + customer.getGender());
        }
    }

    //@Test
    public void testCreateCustomer(){
        customerDao.createCustomer("Test123", "Test123", "Test123", "Test123", "Test123", "Test123", "11", "f");
    }
    //@Test
    public void testUpdateCustomer(){
        customerDao.updateCustomer(11L,"Test333", "Test333", "Test333", "Test333", "Test333", "Test333", "22", "m");
    }

    //@Test
    public void testDeleteCustomer(){
        customerDao.deleteCustomer(11L);
    }
}
