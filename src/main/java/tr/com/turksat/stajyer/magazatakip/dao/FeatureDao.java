package tr.com.turksat.stajyer.magazatakip.dao;

import tr.com.turksat.stajyer.magazatakip.domain.Feature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    //TODO: Insert,Delete,Update yapılsın
}
