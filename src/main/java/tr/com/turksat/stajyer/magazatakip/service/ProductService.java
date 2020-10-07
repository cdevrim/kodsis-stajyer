package tr.com.turksat.stajyer.magazatakip.service;

import tr.com.turksat.stajyer.magazatakip.dao.ProductDao;
import tr.com.turksat.stajyer.magazatakip.domain.Product;

import java.util.List;

public class ProductService {

    ProductDao productDao = new ProductDao();

    public List<Product> getProducts(){
        return productDao.getProductList();
    }
}
