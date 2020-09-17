package tr.com.turksat.stajyer.magazatakip.dao;

import tr.com.turksat.stajyer.magazatakip.domain.CustomerAccount;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerAccountDao {

    public CustomerAccountDao() { }

    public List<CustomerAccount> getCustomerAccountList() {
        Connection con = null;
        List<CustomerAccount> list = new ArrayList<>();
        CustomerAccount customerAccount = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("select * from stajyer.customer_account");
            rs = ps.executeQuery();
            while (rs.next()) {
                customerAccount = new CustomerAccount();
                customerAccount.setId(rs.getLong("id"));
                customerAccount.setAccountName(rs.getString("account_name"));
                customerAccount.setBillingAddress(rs.getString("billing_address"));
                customerAccount.setCustomerId(rs.getLong("customer_id"));
                list.add(customerAccount);
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

    public void createCustomerAccount(String account_name, String billing_address, Long customer_id){
        Connection con = null;
        CustomerAccount customer_account = null;
        PreparedStatement ps = null;

        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("insert into stajyer.customer_account(account_name, billing_address, customer_id) values (?,?,?)");
            ps.setString(1,account_name);
            ps.setString(2,billing_address);
            ps.setLong(3,customer_id);
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

    public void updateCustomerAccount(Long id, String account_name, String billing_address, Long customer_id){
        Connection con = null;
        CustomerAccount customerAccount = null;
        PreparedStatement ps = null;

        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("update stajyer.customer_account set account_name = ?, billing_address = ?, customer_id = ? where id = ?");
            ps.setString(1,account_name);
            ps.setString(2,billing_address);
            ps.setLong(3,customer_id);
            ps.setLong(4,id);
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

    public void deleteCustomerAccount(Long id){
        Connection con = null;
        CustomerAccount customerAccount = null;
        PreparedStatement ps = null;

        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("delete from stajyer.customer_account where id = ?");
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
