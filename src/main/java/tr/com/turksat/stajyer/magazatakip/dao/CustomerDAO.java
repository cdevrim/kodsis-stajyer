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

                  Customer tmp = new Customer(rs.getLong("id") , rs.getString("first_name") , rs.getString("last_name") , rs.getString("email"), rs.getInt("credit_card"),rs.getDate("birth_date"), rs.getString("gender"),rs.getString("phone"),  rs.getDate("create_date"),rs.getLong("create_user_id"));
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
            st.executeUpdate("INSERT INTO CUSTOMER(first_name) VALUES ('"+customer.getFirst_name()+"') ");


        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}
