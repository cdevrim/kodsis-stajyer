package tr.com.turksat.stajyer.magazatakip.dao;

import tr.com.turksat.stajyer.magazatakip.domain.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    public CustomerDao() { }

    public List<Customer> getCustomerList() {
        Connection con = null;
        List<Customer> list = new ArrayList<>();
        Customer customer = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("select * from stajyer.customer");
            rs = ps.executeQuery();
            while (rs.next()) {
                customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setName(rs.getString("name"));
                customer.setSurname(rs.getString("surname"));
                customer.setPhone_number(rs.getString("phone_number"));
                customer.setEmail(rs.getString("email"));
                customer.setAddress(rs.getString("address"));
                customer.setPostcode(rs.getString("postcode"));
                customer.setAge(rs.getString("age"));
                customer.setGender(rs.getString("gender").charAt(0));
                list.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {

            try {
                if (rs != null)
                    rs.close();
                if (ps != null)
                    ps.close();
                if(con != null)
                    con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return list;
    }

    public void createCustomer(String name, String surname, String phone_number, String email, String address, String postcode, String age, String gender){
        Connection con = null;
        Customer customer = null;
        PreparedStatement ps = null;

        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("insert into stajyer.customer(name, surname, phone_number, email, address, postcode, age, gender) values (?,?,?,?,?,?,?,?)");
            ps.setString(1,name);
            ps.setString(2,surname);
            ps.setString(3,phone_number);
            ps.setString(4,email);
            ps.setString(5,address);
            ps.setString(6,postcode);
            ps.setString(7,age);
            ps.setString(8,gender); // char yerine string oldu sorun olabilir!!!
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
                if(con != null)
                    con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void updateCustomer(Long id,String name, String surname, String phone_number, String email, String address, String postcode, String age, String gender){
        Connection con = null;
        Customer customer = null;
        PreparedStatement ps = null;

        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("update stajyer.customer set name = ?, surname = ?, phone_number = ?, email = ?, address = ?, postcode = ?, age = ?, gender = ?  where id = ?");
            ps.setString(1,name);
            ps.setString(2,surname);
            ps.setString(3,phone_number);
            ps.setString(4,email);
            ps.setString(5,address);
            ps.setString(6,postcode);
            ps.setString(7,age);
            ps.setString(8,gender);
            ps.setLong(9,id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
                if(con != null)
                    con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void deleteCustomer(Long id){
        Connection con = null;
        Customer customer = null;
        PreparedStatement ps = null;

        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("delete from stajyer.customer where id = ?");
            ps.setLong(1,id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
                if(con != null)
                    con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
