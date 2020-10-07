package tr.com.turksat.stajyer.magazatakip.jsfbean;

import tr.com.turksat.stajyer.magazatakip.domain.Product;
import tr.com.turksat.stajyer.magazatakip.service.ProductService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class ProductController implements Serializable {

    ProductService productService= new ProductService();

    List<Product> productList = new ArrayList<>();

    @PostConstruct
    public void init() {
        productList = getProducts();
    }

    public List<Product> getProducts(){
        productList = productService.getProducts();
        return productList;
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}




