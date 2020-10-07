package tr.com.turksat.stajyer.magazatakip.jsfbean;

import tr.com.turksat.stajyer.magazatakip.domain.ProductDescription;
import tr.com.turksat.stajyer.magazatakip.service.ProductDescriptionService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class ProductDescriptionController implements Serializable {

    ProductDescriptionService productDescriptionService= new ProductDescriptionService();

    List<ProductDescription> productDescriptionList = new ArrayList<>();

    @PostConstruct
    public void init() {
        productDescriptionList = getProductDescriptions();
    }

    public List<ProductDescription> getProductDescriptions(){
        productDescriptionList = productDescriptionService.getProductDescriptions();
        return productDescriptionList;
    }

    public ProductDescriptionService getProductDescriptionService() {
        return productDescriptionService;
    }

    public void setProductDescriptionService(ProductDescriptionService productDescriptionService) {
        this.productDescriptionService = productDescriptionService;
    }

    public List<ProductDescription> getProductDescriptionList() {
        return productDescriptionList;
    }

    public void setProductDescriptionList(List<ProductDescription> productDescriptionList) {
        this.productDescriptionList = productDescriptionList;
    }
}


