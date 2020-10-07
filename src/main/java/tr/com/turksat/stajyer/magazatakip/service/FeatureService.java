package tr.com.turksat.stajyer.magazatakip.service;

import tr.com.turksat.stajyer.magazatakip.dao.FeatureDao;
import tr.com.turksat.stajyer.magazatakip.domain.Feature;

import java.util.List;

public class FeatureService {

    FeatureDao featureDao = new FeatureDao();

    public List<Feature> getFeatures(){
        return featureDao.getFeatureList(); // bunu sen yapmıştın.
    }
}
