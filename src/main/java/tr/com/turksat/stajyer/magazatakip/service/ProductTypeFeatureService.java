package tr.com.turksat.stajyer.magazatakip.service;

import tr.com.turksat.stajyer.magazatakip.dao.ProductTypeFeatureDao;
import tr.com.turksat.stajyer.magazatakip.domain.ProductTypeFeature;

import java.util.List;

public class ProductTypeFeatureService {

    ProductTypeFeatureDao productTypeFeatureDao = new ProductTypeFeatureDao();

    public List<ProductTypeFeature> getProductTypeFeatures(){
        return productTypeFeatureDao.getProductTypeFeatureList();
    }
}