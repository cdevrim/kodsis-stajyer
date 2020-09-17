package tr.com.turksat.stajyer.magazatakip.dao;

import tr.com.turksat.stajyer.magazatakip.domain.ProductDescription;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDescriptionDao {

    public ProductDescriptionDao() { }

    public List<ProductDescription> getProductDescriptionList() {
        Connection con = null;
        List<ProductDescription> list = new ArrayList<>();
        ProductDescription productDescription = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("select * from stajyer.product_description");
            rs = ps.executeQuery();
            while (rs.next()) {
                productDescription = new ProductDescription();
                productDescription.setId(rs.getLong("id"));
                productDescription.setPrice(rs.getFloat("price"));
                productDescription.setProductTypeId(rs.getLong("product_type_id"));
                productDescription.setName(rs.getString("name"));
                list.add(productDescription);
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

    public void createProductDescription(Float price, Long product_type_id, String name){
        Connection con = null;
        ProductDescription productDescription = null;
        PreparedStatement ps = null;

        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("insert into stajyer.product_description(price ,product_type_id,name) values (?,?,?)");
            ps.setFloat(1,price);
            ps.setLong(2,product_type_id);
            ps.setString(3,name);
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

    public void updateProductDescription(Long id, Float price, Long product_type_id, String name){
        Connection con = null;
        ProductDescription productDescription = null;
        PreparedStatement ps = null;

        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("update stajyer.product_description set price = ?, product_type_id = ?, name = ? where id = ?");
            ps.setFloat(1, price);
            ps.setLong(2, product_type_id);
            ps.setString(3,name);
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

    public void deleteProductDescription(Long id){
        Connection con = null;
        ProductDescription productDescription = null;
        PreparedStatement ps = null;

        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("delete from stajyer.product_description where id = ?");
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
