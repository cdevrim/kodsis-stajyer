package tr.com.turksat.stajyer.magazatakip.dao;

import tr.com.turksat.stajyer.magazatakip.domain.ProductTypeFeature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductTypeFeatureDao {

    public ProductTypeFeatureDao() { }

    public List<ProductTypeFeature> getProductTypeFeatureList() {
        Connection con = null;
        List<ProductTypeFeature> list = new ArrayList<>();
        ProductTypeFeature productTypeFeature = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("select * from stajyer.product_type_feature");
            rs = ps.executeQuery();
            while (rs.next()) {
                productTypeFeature = new ProductTypeFeature();
                productTypeFeature.setId(rs.getLong("id"));
                productTypeFeature.setValue(rs.getString("value"));
                productTypeFeature.setProductTypeId(rs.getLong("product_type_id"));
                productTypeFeature.setFeatureId(rs.getLong("feature_id"));
                list.add(productTypeFeature);
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

    public void createProductTypeFeature(String value, Long product_type_id, Long feature_id){
        Connection con = null;
        ProductTypeFeature productTypeFeature = null;
        PreparedStatement ps = null;

        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("insert into stajyer.product_type_feature(value ,product_type_id,feature_id) values (?,?,?)");
            ps.setString(1,value);
            ps.setLong(2,product_type_id);
            ps.setLong(3,feature_id);
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

    public void updateProductTypeFeature(Long id,String value, Long product_type_id, Long feature_id){
        Connection con = null;
        ProductTypeFeature productTypeFeature = null;
        PreparedStatement ps = null;

        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("update stajyer.product_type_feature set value = ?, product_type_id = ? , feature_id = ? where id = ?");
            ps.setString(1, value);
            ps.setLong(2, product_type_id);
            ps.setLong(3,feature_id);
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

    public void deleteProductTypeFeature(Long id){
        Connection con = null;
        ProductTypeFeature productTypeFeature = null;
        PreparedStatement ps = null;

        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("delete from stajyer.product_type_feature where id = ?");
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
