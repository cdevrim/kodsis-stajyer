package tr.com.turksat.stajyer.magazatakip.dao;

import tr.com.turksat.stajyer.magazatakip.domain.Customer;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CustomerDAO {


    public CustomerDAO(){

    }


    public List<Customer> getCustomer(){

        //Değişkenler try block içerisine genelde oluşturulmaz.
        Connection c = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        List<Customer> customerList = new ArrayList<>();

        try {

            c = Database.getInstance().getConnection();
            ps = c.prepareStatement("select * from stajyer.customer");
            rs = ps.executeQuery();
            while (rs.next())
            {
                Customer customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setEmail(rs.getString("email"));
                customer.setCreditCard(rs.getInt("credit_card"));
                customer.setBirthDate(rs.getDate("birth_date"));
                customer.setGender(rs.getString("gender"));
                customer.setPhone(rs.getString("phone"));
                customer.setCreateDate(rs.getDate("create_date"));
                customer.setCreateUserId(rs.getLong("create_user_id"));

                customerList.add(customer);
            }

        } catch (Exception ex) {
            System.out.println("hatalı giriş "+ex.getLocalizedMessage());
            return customerList;
        } finally {
            //ilk oluşturulan son kapatılır
            try {
                rs.close();
                ps.close();
                Database.close(c);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

        return  customerList;
    }


    public void insert(Customer customer) {

        Connection c = Database.getInstance().getConnection();
        PreparedStatement ps;
        String sqlInsert = "insert into stajyer.customer(first_name,last_name,email,credit_card,birth_date,gender,phone,create_date,create_user_id)\n ";
        sqlInsert += " values (?,?,?,?,?,?,?,?,?); \n";

        try{

            ps = c.prepareStatement(sqlInsert);
            //Burada parametre set ederken veritabanındaki tiplere(veri tipi) göre set etmen önemli,
            //birt_date date tipinde
            // bak hepsnin sırası değişti. onu düzelltik
            ps.setString(1,customer.getFirstName());
            ps.setString(2,customer.getLastName());
            ps.setString(3,customer.getEmail());
            ps.setInt(4,customer.getCreditCard());
            ps.setDate(5,new java.sql.Date(customer.getBirthDate().getTime()));
            ps.setString(6,customer.getGender());
            ps.setString(7,customer.getPhone());
            ps.setTimestamp(8,new java.sql.Timestamp(customer.getCreateDate().getTime()));
            ps.setLong(9,customer.getCreateUserId());

            ps.executeUpdate();

        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(Long customerId) {

        Connection c = Database.getInstance().getConnection();
        PreparedStatement ps = null;

        try{

           ps = c.prepareStatement("DELETE FROM stajyer.CUSTOMER WHERE ID = ?");
           ps.setLong(1,customerId);
           ps.executeUpdate();

        }catch(SQLException ex) {
            ex.printStackTrace();
        }finally {
            try {
                ps.close();
                Database.close(c);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void update(Customer customer) {

        Connection c = Database.getInstance().getConnection();
        PreparedStatement ps = null;

        try{

            ps = c.prepareStatement("update customer set first_name= ?, last_name = ? where id= ?");
            ps.setString(1,customer.getFirstName());
            ps.setString(2,customer.getLastName());
            ps.setLong(3,customer.getId());

            ps.executeUpdate();

        }catch(SQLException ex) {
            ex.printStackTrace();
        }finally {
            try {
                ps.close();
                Database.close(c);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
