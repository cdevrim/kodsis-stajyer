package tr.com.turksat.stajyer.magazatakip.service;

import tr.com.turksat.stajyer.magazatakip.dao.ProductDescriptionDao;
import tr.com.turksat.stajyer.magazatakip.domain.ProductDescription;

import java.util.List;

public class ProductDescriptionService {

    ProductDescriptionDao productDescriptionDao = new ProductDescriptionDao();

    public List<ProductDescription> getProductDescriptions(){
        return productDescriptionDao.getProductDescriptionList();
    }
}
