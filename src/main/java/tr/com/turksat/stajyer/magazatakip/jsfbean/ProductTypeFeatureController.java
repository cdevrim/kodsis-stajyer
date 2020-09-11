package tr.com.turksat.stajyer.magazatakip.jsfbean;


import tr.com.turksat.stajyer.magazatakip.dao.ProductTypeFeatureDAO;
import tr.com.turksat.stajyer.magazatakip.domain.ProductTypeFeature;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean


public class ProductTypeFeatureController implements  Serializable{

    private List<ProductTypeFeature> ptypefeaturelist;
    private ProductTypeFeatureDAO ptypefeaturedao;
    private ProductTypeFeature productTypeFeature;





    public String updateForm(ProductTypeFeature productTypeFeature){
        this.productTypeFeature = productTypeFeature;
        return "index";
    }


    public String delete(ProductTypeFeature productTypeFeature){

        this.getPtypefeaturedao().delete(productTypeFeature.getId());
        return "index";
    }



    public String update(){
        this.getPtypefeaturedao().update(this.productTypeFeature);
        return "index";

    }



    public String create(){
        this.getPtypefeaturedao().insert(this.productTypeFeature);
        return "index";
    }



    public ProductTypeFeatureController() {
        this.ptypefeaturelist= new ArrayList();
        this.ptypefeaturedao =new ProductTypeFeatureDAO();
    }

    public List<ProductTypeFeature> getPtypefeaturelist() {
        this.ptypefeaturelist = this.getPtypefeaturedao().getProductTypeFeature();
        return ptypefeaturelist;
    }

    public void setPtypefeaturelist(List<ProductTypeFeature> ptypefeaturelist) {

        this.ptypefeaturelist = ptypefeaturelist;
    }

    public ProductTypeFeatureDAO getPtypefeaturedao() {
        if(this.ptypefeaturedao==null)
            this.ptypefeaturedao = new ProductTypeFeatureDAO();
        return ptypefeaturedao;
    }

    public void setPtypefeaturedao(ProductTypeFeatureDAO ptypefeaturedao) {
        this.ptypefeaturedao = ptypefeaturedao;
    }

    public ProductTypeFeature getProductTypeFeature() {
        if(this.productTypeFeature==null)
            this.productTypeFeature = new ProductTypeFeature();
        return productTypeFeature;
    }

    public void setProductTypeFeature(ProductTypeFeature productTypeFeature) {
        this.productTypeFeature = productTypeFeature;
    }
}
