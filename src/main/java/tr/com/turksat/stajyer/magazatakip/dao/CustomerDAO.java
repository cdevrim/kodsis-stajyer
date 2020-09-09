package tr.com.turksat.stajyer.magazatakip.dao;

import tr.com.turksat.stajyer.magazatakip.domain.Customer;
import tr.com.turksat.stajyer.magazatakip.domain.Feature;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Connection;

import java.time.LocalDateTime;
import java.util.Date;


public class CustomerDAO {

    public List<Customer> getCustomer(){
        Connection c = null;
        PreparedStatement ps = null;
        List<Customer> customerList = new ArrayList<>();

        try {

            c = Database.getInstance().getConnection();
            ps = c.prepareStatement(
                    "select * from stajyer.customer");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Customer customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setFirstName(rs.getString("firstName"));
                customer.setLastName(rs.getString("lastName"));
                customer.setEmail(rs.getString("email"));
                customer.setCreditCard(rs.getInt("creditCard"));
                customer.setBirthDate(rs.getDate("birthDate"));
                customer.setGender(rs.getString("gender"));
                customer.setPhone(rs.getString("phone"));
                customer.setCreateDate(rs.getDate("createDate"));
                customer.setCreateUserId(rs.getLong("createUserId"));

                customerList.add(customer);
            }

        } catch (Exception ex) {
            System.out.println("hatalı giriş "+ex.getLocalizedMessage());
            return customerList;
        } finally {
            Database.close(c);
        }

        return  customerList;
    }

    public void insert(Customer customer) {
        Database db = new Database();
        Connection c = db.getConnection();
        PreparedStatement preparedStatement;

        try{


            c.prepareStatement("insert into stajyer.customer(first_name,last_name,email,credit_card,birth_date,gender,phone,create_date,create_user_ıd)" +
                    "values ('"+customer.getFirstName()+"'), ('"+customer.getLastName()+"'),('"+customer.getEmail()+"'), ('"+customer.getCreditCard()+"'), ('"+customer.getBirthDate()+"'), ('"+customer.getGender()+"'), ('"+customer.getPhone()+"'), ('"+customer.getCreateDate()+"'), ('"+customer.getCreateUserId()+"'),");




        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(Customer cust) {
        Database db = new Database();
        Connection c = db.getConnection();
        PreparedStatement preparedStatement;

        try{

            c.prepareStatement("DELETE FROM CUSTOMER WHERE ID="+cust.getId());

        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update(Customer customer) {
        Database db = new Database();
        Connection c = db.getConnection();
        PreparedStatement preparedStatement;

        try{

            c.prepareStatement("update customer set first_name='"+customer.getFirstName()+"'where id="+customer.getId());


        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}
