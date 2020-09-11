package tr.com.turksat.stajyer.magazatakip.dao;


import tr.com.turksat.stajyer.magazatakip.domain.ProductDescription;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductDescriptionDAO {


    public ProductDescriptionDAO(){

    }


    public List<ProductDescription> getProductDescription(){

        Connection c = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        List<ProductDescription> productDescriptionList = new ArrayList<>();

        try {

            c = Database.getInstance().getConnection();
            ps = c.prepareStatement("select * from stajyer.product_description");
            rs = ps.executeQuery();
            while (rs.next())
            {
                ProductDescription productDescription = new ProductDescription();
                productDescription.setId(rs.getLong("id"));
                productDescription.setProductDescriptionName(rs.getString("product_description_name"));
                productDescription.setCreateDate(rs.getDate("create_date"));
                productDescription.setCreateUserId(rs.getLong("create_user_id"));
                productDescription.setProductTypeId(rs.getLong("product_type_id"));

                productDescriptionList.add(productDescription);
            }

        } catch (Exception ex) {
            System.out.println("hatalı giriş "+ex.getLocalizedMessage());
            return productDescriptionList;
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

        return  productDescriptionList;
    }

    public void insert(ProductDescription productDescription) {

        Connection c = Database.getInstance().getConnection();
        PreparedStatement ps;
        String sqlInsert = "insert into stajyer.product_description(product_description_name,create_date,create_user_id,product_type_id)\n ";
        sqlInsert += " values (?,?,?,?); \n";

        try{

            ps = c.prepareStatement(sqlInsert);

            ps.setString(1,productDescription.getProductDescriptionName());
            ps.setTimestamp(2,new java.sql.Timestamp(productDescription.getCreateDate().getTime()));
            ps.setLong(3,productDescription.getCreateUserId());
            ps.setLong(4,productDescription.getProductTypeId());
            ps.executeUpdate();

        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(Long productDescriptionId) {

        Connection c = Database.getInstance().getConnection();
        PreparedStatement ps = null;

        try{

            ps = c.prepareStatement("DELETE FROM stajyer.product_description WHERE ID = ?");
            ps.setLong(1,productDescriptionId);
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

    public void update(ProductDescription productDescription) {

        Connection c = Database.getInstance().getConnection();
        PreparedStatement ps = null;

        try{

            ps = c.prepareStatement("update product_description set product_description_name= ? ,create_date = ? ,create_user_id= ?,product_type_id= ? where id= ?");
            ps.setString(1,productDescription.getProductDescriptionName());
            ps.setDate(2,new java.sql.Date(productDescription.getCreateDate().getTime()));
            ps.setLong(3,productDescription.getCreateUserId());
            ps.setLong(4,productDescription.getProductTypeId());
            ps.setLong(5,productDescription.getId());

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
