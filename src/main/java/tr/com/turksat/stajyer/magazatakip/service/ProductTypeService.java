package tr.com.turksat.stajyer.magazatakip.service;

import tr.com.turksat.stajyer.magazatakip.dao.ProductTypeDao;
import tr.com.turksat.stajyer.magazatakip.domain.ProductType;

import java.util.List;

public class ProductTypeService {

    ProductTypeDao productTypeDao = new ProductTypeDao();

    public List<ProductType> getProductTypes(){
        return productTypeDao.getProductTypeList();
    }
}