package tr.com.turksat.stajyer.magazatakip.jsfbean;

import tr.com.turksat.stajyer.magazatakip.domain.ProductTypeFeature;
import tr.com.turksat.stajyer.magazatakip.service.ProductTypeFeatureService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class ProductTypeFeatureController implements Serializable {

    ProductTypeFeatureService productTypeFeatureService= new ProductTypeFeatureService();

    List<ProductTypeFeature> productTypeFeatureList = new ArrayList<>();

    @PostConstruct
    public void init() {
        productTypeFeatureList = getProductTypeFeatures();
    }

    public List<ProductTypeFeature> getProductTypeFeatures(){
        productTypeFeatureList = productTypeFeatureService.getProductTypeFeatures();
        return productTypeFeatureList;
    }

    public ProductTypeFeatureService getProductTypeFeatureService() {
        return productTypeFeatureService;
    }

    public void setProductTypeFeatureService(ProductTypeFeatureService productTypeFeatureService) {
        this.productTypeFeatureService = productTypeFeatureService;
    }

    public List<ProductTypeFeature> getProductTypeFeatureList() {
        return productTypeFeatureList;
    }

    public void setProductTypeFeatureList(List<ProductTypeFeature> productTypeFeatureList) {
        this.productTypeFeatureList = productTypeFeatureList;
    }
}
