package tr.com.turksat.stajyer.magazatakip.dao;

import org.junit.Test;
import tr.com.turksat.stajyer.magazatakip.domain.Feature;

import java.util.List;

public class FeatureDaoTest {

    @Test
    public void testGetFeature(){
        System.out.println("test");
        FeatureDao featureDao = new FeatureDao();
        List<Feature> featureList = featureDao.getFeature();
        for(Feature feature : featureList){
            System.out.println("ID : "+feature.getId()+" Name : "+feature.getName());
        }
    }
}
