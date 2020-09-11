package tr.com.turksat.stajyer.magazatakip.dao;


import tr.com.turksat.stajyer.magazatakip.domain.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductDAO {

    public ProductDAO(){

    }


    public List<Product> getProduct() {

        Connection c = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        List<Product> productList = new ArrayList<>();

        try {

            c = Database.getInstance().getConnection();
            ps = c.prepareStatement("select * from stajyer.product");
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getLong("id"));
                product.setProductName(rs.getString("product_name"));
                product.setPrice(rs.getDouble("price"));
                product.setCreateDate(rs.getDate("create_date"));
                product.setCreateUserId(rs.getLong("create_user_id"));
                product.setProductDate(rs.getDate("product_date"));
                product.setProductDescriptionId(rs.getLong("product_description_id"));



                productList.add(product);
            }

        } catch (Exception ex) {
            System.out.println("hatalı giriş " + ex.getLocalizedMessage());
            return productList;
        } finally {

            try {
                rs.close();
                ps.close();
                Database.close(c);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

        return productList;
    }


    public void insert(Product product) {

        Connection c = Database.getInstance().getConnection();
        PreparedStatement ps;
        String sqlInsert = "insert into stajyer.product(product_name,price,create_date,create_user_id, product_date,product_description_id)\n ";
        sqlInsert += " values (?,?,?,?,?,?); \n";

        try{

            ps = c.prepareStatement(sqlInsert);
            ps.setString(1,product.getProductName());
            ps.setDouble(2,product.getPrice());
            ps.setTimestamp(3,new java.sql.Timestamp(product.getCreateDate().getTime()));
            ps.setLong(4,product.getCreateUserId());
            ps.setDate(5,new java.sql.Date(product.getProductDate().getTime()));
            ps.setLong(6,product.getProductDescriptionId());

            ps.executeUpdate();

        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(Long productId) {

        Connection c = Database.getInstance().getConnection();
        PreparedStatement ps = null;

        try{

            ps = c.prepareStatement("DELETE FROM stajyer.PRODUCT WHERE ID = ?");
            ps.setLong(1,productId);
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

    public void update(Product product) {

        Connection c = Database.getInstance().getConnection();
        PreparedStatement ps = null;

        try{

            ps = c.prepareStatement("update product set product_name= ?, price = ?,create_date= ?, create_user_id= ?, product_date = ?, product_description_id = ? where id= ?");
            ps.setString(1,product.getProductName());
            ps.setDouble(2,product.getPrice());
            ps.setDate(3,new java.sql.Date(product.getCreateDate().getTime()));
            ps.setLong(4,product.getCreateUserId());
            ps.setDate(5,new java.sql.Date(product.getProductDate().getTime()));
            ps.setLong(6,product.getProductDescriptionId());
            ps.setLong(7,product.getId());

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
