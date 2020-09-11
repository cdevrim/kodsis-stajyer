package tr.com.turksat.stajyer.magazatakip.dao;


import tr.com.turksat.stajyer.magazatakip.domain.Feature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FeatureDao {

    public List<Feature> getFeature(){
        Connection con = null;
        PreparedStatement ps = null;
        List<Feature> featureList = new ArrayList<>();
        try {

            con = Database.getInstance().getConnection();
            ps = con.prepareStatement(
                    "select * from stajyer.feature");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Feature feature = new Feature();
                feature.setId(rs.getLong("id"));
                feature.setName(rs.getString("name"));
                featureList.add(feature);
            }

        } catch (Exception ex) {
            System.out.println("hatalı giriş "+ex.getLocalizedMessage());
            return featureList;
        } finally {
            Database.close(con);
        }

        return  featureList;
    }



    public void insert(Feature feature) {

        Connection c = Database.getInstance().getConnection();
        PreparedStatement ps;
        String sqlInsert = "insert into stajyer.feature(name)\n ";
        sqlInsert += " values (?); \n";

        try{

            ps = c.prepareStatement(sqlInsert);
            //Burada parametre set ederken veritabanındaki tiplere(veri tipi) göre set etmen önemli,
            //birt_date date tipinde
            // bak hepsnin sırası değişti. onu düzelltik
            ps.setString(1,feature.getName());


            ps.executeUpdate();

        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(Long featureID) {

        Connection c = Database.getInstance().getConnection();
        PreparedStatement ps = null;

        try{

            ps = c.prepareStatement("DELETE FROM stajyer.FEATURE WHERE ID = ?");
            ps.setLong(1,featureID);
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

    public void update(Feature feature) {

        Connection c = Database.getInstance().getConnection();
        PreparedStatement ps = null;

        try{

            ps = c.prepareStatement("update feature set name= ? where id= ?");
            ps.setString(1,feature.getName());


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
