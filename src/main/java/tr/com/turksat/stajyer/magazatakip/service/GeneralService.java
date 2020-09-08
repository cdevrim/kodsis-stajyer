package tr.com.turksat.stajyer.magazatakip.service;

import tr.com.turksat.stajyer.magazatakip.dao.FeatureDao;
import tr.com.turksat.stajyer.magazatakip.dao.KullaniciDao;
import tr.com.turksat.stajyer.magazatakip.domain.Feature;

import java.util.List;

public class GeneralService {

    KullaniciDao kullaniciDao = new KullaniciDao();
    FeatureDao featureDao = new FeatureDao();

    public List<Feature> listFeauture(){
        return featureDao.getFeature();
    }
}
