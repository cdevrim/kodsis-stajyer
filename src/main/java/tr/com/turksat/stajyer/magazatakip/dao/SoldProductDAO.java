package tr.com.turksat.stajyer.magazatakip.dao;




import tr.com.turksat.stajyer.magazatakip.domain.SoldProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SoldProductDAO {

    public SoldProductDAO() {
    }


    public List<SoldProduct> getSoldProduct(){


        Connection c = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        List<SoldProduct> soldProductList = new ArrayList<>();

        try {

            c = Database.getInstance().getConnection();
            ps = c.prepareStatement("select * from stajyer.sold_product");
            rs = ps.executeQuery();
            while (rs.next())
            {
                SoldProduct soldProduct = new SoldProduct();
                soldProduct.setId(rs.getLong("id"));
                soldProduct.setSoldDate(rs.getDate("sold_date"));
                soldProduct.setCustomerAccountId(rs.getLong("customer_account_id"));
                soldProduct.setCreateDate(rs.getDate("create_date"));
                soldProduct.setCreateUserId(rs.getLong("create_user_id"));
                soldProduct.setProductId(rs.getLong("product_id"));

                soldProductList.add(soldProduct);
            }

        } catch (Exception ex) {
            System.out.println("hatalı giriş "+ex.getLocalizedMessage());
            return soldProductList;
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

        return  soldProductList;
    }


    public void insert(SoldProduct soldProduct) {

        Connection c = Database.getInstance().getConnection();
        PreparedStatement ps;
        String sqlInsert = "insert into stajyer.customer(sold_date,customer_account_id,create_date,create_user_id,product_id)\n ";
        sqlInsert += " values (?,?,?,?,?); \n";

        try{

            ps = c.prepareStatement(sqlInsert);

            ps.setDate(1,new java.sql.Date(soldProduct.getSoldDate().getTime()));
            ps.setLong(2,soldProduct.getCustomerAccountId());
            ps.setTimestamp(3,new java.sql.Timestamp(soldProduct.getCreateDate().getTime()));
            ps.setLong(4,soldProduct.getCreateUserId());
            ps.setLong(5,soldProduct.getProductId());


            ps.executeUpdate();

        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(Long soldProductId) {

        Connection c = Database.getInstance().getConnection();
        PreparedStatement ps = null;

        try{

            ps = c.prepareStatement("DELETE FROM stajyer.sold_product WHERE ID = ?");
            ps.setLong(1,soldProductId);
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

    public void update(SoldProduct soldProduct) {

        Connection c = Database.getInstance().getConnection();
        PreparedStatement ps = null;

        try{

            ps = c.prepareStatement("update sold_product set sold_date = ? ,customer_account_id= ? ,create_date = ?,create_user_id = ?,product_id= ? where id= ?");
            ps.setDate(1,new java.sql.Date(soldProduct.getSoldDate().getTime()));
            ps.setLong(2,soldProduct.getCustomerAccountId());
            ps.setDate(3,new java.sql.Date(soldProduct.getCreateDate().getTime()));
            ps.setLong(4,soldProduct.getCreateUserId());
            ps.setLong(5,soldProduct.getProductId());
            ps.setLong(6,soldProduct.getId());

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
