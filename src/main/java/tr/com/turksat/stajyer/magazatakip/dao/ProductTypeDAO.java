package tr.com.turksat.stajyer.magazatakip.dao;


import tr.com.turksat.stajyer.magazatakip.domain.ProductType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ProductTypeDAO {

    public ProductTypeDAO(){

    }


    public List<ProductType> getProductType(){

        Connection c = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        List<ProductType> productTypeList = new ArrayList<>();

        try {

            c = Database.getInstance().getConnection();
            ps = c.prepareStatement("select * from stajyer.product_type");
            rs = ps.executeQuery();
            while (rs.next())
            {
                ProductType productType = new ProductType();
                productType.setId(rs.getLong("id"));
                productType.setCreateDate(rs.getDate("create_date"));
                productType.setCreateUserId(rs.getLong("create_user_id"));
                productType.setProductTypeName(rs.getString("product_type_name"));

                productTypeList.add(productType);
            }

        } catch (Exception ex) {
            System.out.println("hatalı giriş "+ex.getLocalizedMessage());
            return productTypeList;
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

        return productTypeList;
    }



    public void insert(ProductType productType) {

        Connection c = Database.getInstance().getConnection();
        PreparedStatement ps;
        String sqlInsert = "insert into stajyer.product_type(create_date,create_user_id,product_type_name)\n ";
        sqlInsert += " values (?,?,?); \n";

        try{

            ps = c.prepareStatement(sqlInsert);

            ps.setTimestamp(1,new java.sql.Timestamp(productType.getCreateDate().getTime()));
            ps.setLong(2,productType.getCreateUserId());
            ps.setString(3,productType.getProductTypeName());

            ps.executeUpdate();

        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(Long productTypeId) {

        Connection c = Database.getInstance().getConnection();
        PreparedStatement ps = null;

        try{

            ps = c.prepareStatement("DELETE FROM stajyer.product_type WHERE ID = ?");
            ps.setLong(1,productTypeId);
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

    public void update(ProductType productType) {

        Connection c = Database.getInstance().getConnection();
        PreparedStatement ps = null;

        try{

            ps = c.prepareStatement("update product_type set  create_date= ?, create_user_id= ? , product_type_name = ? where id= ?");
            ps.setDate(1,new java.sql.Date(productType.getCreateDate().getTime()));
            ps.setLong(2,productType.getCreateUserId());
            ps.setString(3,productType.getProductTypeName());
            ps.setLong(4,productType.getId());

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
