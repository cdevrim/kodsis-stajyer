package tr.com.turksat.stajyer.magazatakip.dao;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductTypeTest {

    //        con = Database.getInstance().getConnection();
//        try(PreparedStatement ps2 =  con.prepareStatement("select * from stajyer.product_type");){
//            System.out.println("ProductTypeTest listele1");
//            rs = ps.executeQuery();
//            while (rs.next()){
//                System.out.println("id :"+rs.getLong("id") + "Name :"+rs.getString("name"));
//            }
//        }catch (Exception ex){
//
//        }

    //Exception handling
    @Test
    public void listele()  {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("select * from stajyer.product_type");
            rs = ps.executeQuery();
            System.out.println("ProductTypeTest listele2");
            while (rs.next()){
                System.out.println("id :"+rs.getLong("id") + "Name :"+rs.getString("name"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try{
                if(rs!=null)
                    rs.close();
                if(con!=null)
                    con.close();
                if(ps!=null)
                    ps.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        System.out.println("test");
    }

    @Test
    //ProductType productType
    public void olustur(){
        Connection con = null;
        con = Database.getInstance().getConnection();
        //Veritabanına bağlantı
        //Insert into ProductType
    }

    @Test
    public void sil(){
        Connection con = null;
        con = Database.getInstance().getConnection();
        //Veritabanına bağlantı
        //Delete from ProductType
    }

}
