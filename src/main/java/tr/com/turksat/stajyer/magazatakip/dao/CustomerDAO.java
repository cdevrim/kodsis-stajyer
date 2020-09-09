package tr.com.turksat.stajyer.magazatakip.dao;

import tr.com.turksat.stajyer.magazatakip.domain.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import java.time.LocalDateTime;
import java.util.Date;


public class CustomerDAO {

    public List<Customer> getCustomer(){

            List<Customer> clist = new ArrayList();

          Database db = new Database();
         Connection c = db.getConnection();


            try{
             Statement st = c.createStatement();
              ResultSet rs = st.executeQuery("SELECT * FROM CUSTOMER");

                 while(rs.next()){

                  Customer tmp = new Customer(rs.getLong("id") , rs.getString("firstName") , rs.getString("lastName") , rs.getString("email"), rs.getInt("creditCard"),rs.getDate("birthDate"), rs.getString("gender"),rs.getString("phone"),  rs.getDate("createDate"),rs.getLong("createUserId"));
                  clist.add(tmp);

                 }
             }catch(SQLException ex) {
                ex.printStackTrace();
            }

     return clist;
    }

    public void insert(Customer customer) {
        Database db = new Database();
        Connection c = db.getConnection();

        try{
            Statement st= c.createStatement();
            st.executeUpdate("INSERT INTO CUSTOMER(first_name) VALUES ('"+customer.getFirstName()+"') ");
            st.executeUpdate("INSERT INTO CUSTOMER(first_name) VALUES ('"+customer.getLastName()+"') ");
            st.executeUpdate("INSERT INTO CUSTOMER(first_name) VALUES ('"+customer.getEmail()+"') ");
            st.executeUpdate("INSERT INTO CUSTOMER(first_name) VALUES ('"+customer.getGender()+"') ");
            st.executeUpdate("INSERT INTO CUSTOMER(first_name) VALUES ('"+customer.getPhone()+"') ");
            st.executeUpdate("INSERT INTO CUSTOMER(first_name) VALUES ('"+customer.getBirthDate()+"') ");
            st.executeUpdate("INSERT INTO CUSTOMER(first_name) VALUES ('"+customer.getCreditCard()+"') ");

        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(Customer cust) {
        Database db = new Database();
        Connection c = db.getConnection();

        try{
            Statement st= c.createStatement();
            st.executeUpdate("DELETE FROM CUSTOMER WHERE ID="+cust.getId());

        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update(Customer customer) {
        Database db = new Database();
        Connection c = db.getConnection();

        try{
            Statement st= c.createStatement();
            st.executeUpdate("update customer set name='"+customer.getFirstName()+"'where id="+customer.getId());

        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}
