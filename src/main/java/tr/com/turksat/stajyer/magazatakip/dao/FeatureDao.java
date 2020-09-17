package tr.com.turksat.stajyer.magazatakip.dao;



import tr.com.turksat.stajyer.magazatakip.domain.Feature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FeatureDao {

    public FeatureDao() { }

    public List<Feature> getFeatureList() {
        Connection con = null;
        List<Feature> list = new ArrayList<>();
        Feature feature = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("select * from stajyer.feature");
            rs = ps.executeQuery();
            while (rs.next()) {
                feature = new Feature();
                feature.setId(rs.getLong("id"));
                feature.setName(rs.getString("name"));
                list.add(feature);
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

    public void createFeature(String name){
        Connection con = null;
        Feature feature = null;
        PreparedStatement ps = null;

        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("insert into stajyer.feature(name) values (?)");
            ps.setString(1,name);
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

    public void updateFeature(Long id,String name){
        Connection con = null;
        Feature feature = null;
        PreparedStatement ps = null;

        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("update stajyer.feature set name = ? where id = ?");
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

    public void deleteFeature(Long id){
        Connection con = null;
        Feature feature = null;
        PreparedStatement ps = null;

        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("delete from stajyer.feature where id = ?");
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
