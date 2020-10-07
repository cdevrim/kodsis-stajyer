package tr.com.turksat.stajyer.magazatakip.jsfbean;

import tr.com.turksat.stajyer.magazatakip.domain.ProductType;
import tr.com.turksat.stajyer.magazatakip.service.ProductTypeService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class ProductTypeController implements Serializable {

    ProductTypeService productTypeService= new ProductTypeService();

    List<ProductType> productTypeList = new ArrayList<>();

    @PostConstruct
    public void init() {
        productTypeList = getProductTypes();
    }

    public List<ProductType> getProductTypes(){
        productTypeList = productTypeService.getProductTypes();
        return productTypeList;
    }

    public ProductTypeService getProductTypeService() {
        return productTypeService;
    }

    public void setProductTypeService(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    public List<ProductType> getProductTypeList() {
        return productTypeList;
    }

    public void setProductTypeList(List<ProductType> productTypeList) {
        this.productTypeList = productTypeList;
    }
}

