package tr.com.turksat.stajyer.magazatakip.dao;

import org.junit.Test;
import tr.com.turksat.stajyer.magazatakip.domain.Feature;


import java.util.List;

public class FeatureDaoTest {

    private FeatureDao featureDao = new FeatureDao();

    @Test
    public void testGetFeatureList(){
        List<Feature> list = featureDao.getFeatureList();
        for(Feature feature : list){
            System.out.println("Id : " + feature.getId() + " Name : " + feature.getName());
        }
    }

    //@Test
    public void testCreateFeature(){
        featureDao.createFeature("Test123");
    }
    //@Test
    public void testUpdateFeature(){
        featureDao.updateFeature(6L,"Test333");
    }

    //@Test
    public void testDeleteFeature(){
        featureDao.deleteFeature(6L);
    }
}
