package tr.com.turksat.stajyer.magazatakip.dao;

import org.junit.Test;

import tr.com.turksat.stajyer.magazatakip.domain.Feature;


import java.util.List;

public class FeatureDaoTest {

   FeatureDao featureDAO = new FeatureDao();

    @Test
    public void testGetFeature(){
        System.out.println("test");
        FeatureDao featureDao = new FeatureDao();
        List<Feature> featureList = featureDao.getFeature();
        for(Feature feature : featureList){
            System.out.println("ID : "+feature.getId()+" Name : "+feature.getName());
        }
    }

    @Test
    public void testInsertFeature(){

        Feature feature = new Feature();
        feature.setName("Ali"+Math.random());


        featureDAO.insert(feature);
    }

    @Test
    public void testFeatureDelete(){

        featureDAO.delete(1L); // sonuna L koyunca java da Long oluyor
        //32 silinince tekrar 32 bulamaz yani onu için tek tek test edebilirsin,
        //test yazarak hızlı bir şeykilde JDBC öğrenebilirsin..

    }

    @Test
    public void testFeatureUpdate(){

        Feature feature = new Feature();

        feature.setName("Test"+Math.random());


        featureDAO.update(feature);
    }
}
