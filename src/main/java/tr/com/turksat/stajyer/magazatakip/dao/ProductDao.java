package tr.com.turksat.stajyer.magazatakip.dao;


import tr.com.turksat.stajyer.magazatakip.domain.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    public ProductDao() { }

    public List<Product> getProductList() {
        Connection con = null;
        List<Product> list = new ArrayList<>();
        Product product = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("select * from stajyer.product");
            rs = ps.executeQuery();
            while (rs.next()) {
                product = new Product();
                product.setId(rs.getLong("id"));
                product.setPrice(rs.getFloat("price"));
                product.setProductionDate(rs.getTimestamp("production_date"));
                product.setDateOfSale(rs.getTimestamp("date_of_sale"));
                product.setDescriptionId(rs.getLong("description_id"));
                product.setAccountId(rs.getLong("account_id"));
                list.add(product);
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

    public void createProduct(Float price, Timestamp production_date, Timestamp date_of_sale, Long description_id, Long account_id){
        Connection con = null;
        Product product = null;
        PreparedStatement ps = null;

        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("insert into stajyer.product(price, production_date, date_of_sale, description_id, account_id) values (?,?,?,?,?)");
            ps.setFloat(1,price);
            ps.setTimestamp(2,production_date);
            ps.setTimestamp(3,date_of_sale);
            ps.setLong(4,description_id);
            ps.setLong(5,account_id);
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

    public void updateProduct(Long id, Float price, Timestamp production_date, Timestamp date_of_sale, Long description_id, Long account_id){
        Connection con = null;
        Product product = null;
        PreparedStatement ps = null;

        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("update stajyer.product set price = ?, production_date = ?, date_of_sale = ?, description_id = ?, account_id = ? where id = ?");
            ps.setFloat(1,price);
            ps.setTimestamp(2,production_date);
            ps.setTimestamp(3,date_of_sale);
            ps.setLong(4,description_id);
            ps.setLong(5,account_id);
            ps.setLong(6,id);
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

    public void deleteProduct(Long id){
        Connection con = null;
        Product product = null;
        PreparedStatement ps = null;

        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("delete from stajyer.product where id = ?");
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
