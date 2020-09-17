package tr.com.turksat.stajyer.magazatakip.dao;

import tr.com.turksat.stajyer.magazatakip.domain.ProductType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductTypeDao {
    public ProductTypeDao() { }

    //örnek olarak elimin altında Kullanıcı Dao var
    //bundan örnek larak ProductType nesnesine ait tüm db işlemlerini
    //Yapacak olan sınıf bu veritabanı ile harberleşmeyi bu sağlıuyor
    //Data Access Object = DAO
    //DAO katmanı diye geçer
    public List<ProductType> getProductTypeList() {
        Connection con = null;
        List<ProductType> liste = new ArrayList<>();
        ProductType productType = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("select * from stajyer.product_type");
            rs = ps.executeQuery();
            while (rs.next()) {
                productType = new ProductType();
                productType.setId(rs.getLong("id"));
                productType.setName(rs.getString("name"));
                liste.add(productType);
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

        return liste;
    }

    public void createProductType(String productTypeName){
        Connection con = null;
        ProductType productType = null;
        PreparedStatement ps = null;

        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("insert into stajyer.product_type(name) values (?)");
            ps.setString(1,productTypeName);
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

    public void updateProductType(Long id,String name){
        Connection con = null;
        ProductType productType = null;
        PreparedStatement ps = null;

        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("update stajyer.product_type set name = ? where id = ?");
            ps.setString(1,name);
            ps.setLong(2,id);
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

    public void deleteProductType(Long id){
        Connection con = null;
        ProductType productType = null;
        PreparedStatement ps = null;

        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("delete from stajyer.product_type where id = ?");
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
