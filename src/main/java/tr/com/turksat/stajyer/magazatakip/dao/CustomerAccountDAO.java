package tr.com.turksat.stajyer.magazatakip.dao;


import tr.com.turksat.stajyer.magazatakip.domain.CustomerAccount;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerAccountDAO {

         public CustomerAccountDAO(){

        }


        public List<CustomerAccount> getCustomerAccount(){

            //Değişkenler try block içerisine genelde oluşturulmaz.
            Connection c = null;
            ResultSet rs = null;
            PreparedStatement ps = null;
            List<CustomerAccount> customerAccountList = new ArrayList<>();

            try {

                c = Database.getInstance().getConnection();
                ps = c.prepareStatement("select * from stajyer.customer_account");
                rs = ps.executeQuery();
                while (rs.next())
                {
                    CustomerAccount customerAccount = new CustomerAccount();
                    customerAccount.setId(rs.getLong("id"));
                    customerAccount.setCustomerId(rs.getLong("customer_id"));
                    customerAccount.setCreateDate(rs.getDate("create_date"));
                    customerAccount.setCreateUserId(rs.getLong("create_user_id"));
                    customerAccount.setBillingAddress(rs.getString("billing_address"));

                    customerAccountList.add(customerAccount);
                }

            } catch (Exception ex) {
                System.out.println("hatalı giriş "+ex.getLocalizedMessage());
                return customerAccountList;
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

            return  customerAccountList;
        }

    public void insert(CustomerAccount customerAccount) {

        Connection c = Database.getInstance().getConnection();
        PreparedStatement ps;
        String sqlInsert = "insert into stajyer.customer_account(customer_id,create_date,create_user_id, billing_address )\n ";
        sqlInsert += " values (?,?,?,?); \n";

        try{

            ps = c.prepareStatement(sqlInsert);

            ps.setLong(1,customerAccount.getCustomerId());
            ps.setTimestamp(2,new java.sql.Timestamp(customerAccount.getCreateDate().getTime()));
            ps.setLong(3,customerAccount.getCreateUserId());
            ps.setString(4,customerAccount.getBillingAddress());

            ps.executeUpdate();

        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(Long customerAccountId) {

        Connection c = Database.getInstance().getConnection();
        PreparedStatement ps = null;

        try{

            ps = c.prepareStatement("DELETE FROM stajyer.customer_account WHERE ID = ?");
            ps.setLong(1,customerAccountId);
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

    public void update(CustomerAccount customerAccount) {

        Connection c = Database.getInstance().getConnection();
        PreparedStatement ps = null;

        try{

            ps = c.prepareStatement("update customer_account set customer_id= ?, create_date= ?, create_user_id= ?, billing_address = ? where id= ?");
            ps.setLong(1,customerAccount.getCustomerId());
            ps.setDate(2,new java.sql.Date(customerAccount.getCreateDate().getTime()));
            ps.setLong(3,customerAccount.getCreateUserId());
            ps.setString(4,customerAccount.getBillingAddress());
            ps.setLong(5,customerAccount.getId());

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
