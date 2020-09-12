package tr.com.turksat.stajyer.magazatakip.dao;



import tr.com.turksat.stajyer.magazatakip.domain.ProductTypeFeature;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductTypeFeatureDAO {

    public ProductTypeFeatureDAO(){

    }


    public List<ProductTypeFeature> getProductTypeFeature() {


        Connection c = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        List<ProductTypeFeature> productTypeFeatureList = new ArrayList<>();

        try {

            c = Database.getInstance().getConnection();
            ps = c.prepareStatement("select * from stajyer.product_type_feature");
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductTypeFeature productTypeFeature = new ProductTypeFeature();
                productTypeFeature.setId(rs.getLong("id"));
                productTypeFeature.setValue(rs.getString("value"));
                productTypeFeature.setCreateDate(rs.getDate("create_date"));
                productTypeFeature.setCreateUserId(rs.getLong("create_user_id"));
                productTypeFeature.setProductTypeId(rs.getLong("product_type_id"));
                productTypeFeature.setFeatureId(rs.getLong("feature_id"));

                productTypeFeatureList.add(productTypeFeature);
            }

        } catch (Exception ex) {
            System.out.println("hatalı giriş " + ex.getLocalizedMessage());
            return productTypeFeatureList;
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

        return productTypeFeatureList;

    }


    public void insert(ProductTypeFeature productTypeFeature) {

        Connection c = Database.getInstance().getConnection();
        PreparedStatement ps;
        //burayı düzelt.
        String sqlInsert = "insert into stajyer.product_type_feature(value,create_date,create_user_id,product_type_id,feature_id)\n ";
        sqlInsert += " values (?,?,?,?,?); \n";

        try{

            ps = c.prepareStatement(sqlInsert);

            ps.setString(1,productTypeFeature.getValue());
            ps.setTimestamp(2,new java.sql.Timestamp(productTypeFeature.getCreateDate().getTime()));
            ps.setLong(3,productTypeFeature.getCreateUserId());
            ps.setLong(4,productTypeFeature.getProductTypeId());
            ps.setLong(5,productTypeFeature.getFeatureId());

            ps.executeUpdate();

        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(Long productTypeFeatureId) {

        Connection c = Database.getInstance().getConnection();
        PreparedStatement ps = null;

        try{

            ps = c.prepareStatement("DELETE FROM stajyer.product_type_feature WHERE ID = ?");
            ps.setLong(1,productTypeFeatureId);
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

    public void update(ProductTypeFeature productTypeFeature) {

        Connection c = Database.getInstance().getConnection();
        PreparedStatement ps = null;

        try{

            ps = c.prepareStatement("update product_type_feature set value = ?,create_date= ?,create_user_id= ?,product_type_id= ?,feature_id= ? where id= ?");
            ps.setString(1,productTypeFeature.getValue());
            ps.setDate(2,new java.sql.Date(productTypeFeature.getCreateDate().getTime()));
            ps.setLong(3,productTypeFeature.getCreateUserId());
            ps.setLong(4,productTypeFeature.getProductTypeId());
            ps.setLong(5,productTypeFeature.getFeatureId());
            ps.setLong(6,productTypeFeature.getId());


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
