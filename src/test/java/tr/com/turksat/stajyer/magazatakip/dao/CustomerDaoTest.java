package tr.com.turksat.stajyer.magazatakip.dao;

import tr.com.turksat.stajyer.magazatakip.domain.Customer;
import tr.com.turksat.stajyer.magazatakip.domain.Feature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoTest {

    public void testGetCustomer(){
        System.out.println("test");
        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> customerList = customerDAO.getCustomer();
        for(Customer customer : customerList){
            System.out.println("ID : "+customer.getId()+" First Name : "+customer.getFirstName()+
                    " Last Name: " + customer.getLastName()+ " Email: " + customer.getEmail() +
                    " Credit Card: " + customer.getCreditCard() + " Birth Date" + customer.getBirthDate()+
                    " Gender: " + customer.getGender() + " Phone: " + customer.getPhone() +
                    " Create Date: " + customer.getCreateDate() + "Create User ID: " + customer.getCreateUserId());
        }
    }
}
