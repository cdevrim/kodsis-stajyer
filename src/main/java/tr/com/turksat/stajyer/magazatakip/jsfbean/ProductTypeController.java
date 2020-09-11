package tr.com.turksat.stajyer.magazatakip.jsfbean;




import tr.com.turksat.stajyer.magazatakip.dao.ProductTypeDAO;
import tr.com.turksat.stajyer.magazatakip.domain.ProductType;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class ProductTypeController implements Serializable {


    private List<ProductType> ptypelist;
    private ProductTypeDAO ptypedao;
    private ProductType productType;





    public String updateForm(ProductType productType ){
        this.productType = productType;
        return "index";
    }


    public String delete(ProductType productType){

        this.getPtypedao().delete(productType.getId());
        return "index";
    }



    public String update(){
        this.getPtypedao().update(this.productType);
        return "index";

    }



    public String create(){
        this.getPtypedao().insert(this.productType);
        return "index";
    }



    public ProductTypeController() {
        this.ptypelist= new ArrayList();
        this.ptypedao =new ProductTypeDAO();
    }

    public List<ProductType> getPtypelist() {
        this.ptypelist = this.getPtypedao().getProductType();
        return ptypelist;
    }

    public void setPtypelist(List<ProductType> ptypelist) {
        this.ptypelist = ptypelist;
    }

    public ProductTypeDAO getPtypedao() {
        if(this.ptypedao==null)
            this.ptypedao = new ProductTypeDAO();
        return ptypedao;
    }

    public void setPtypedao(ProductTypeDAO ptypedao) {
        this.ptypedao = ptypedao;
    }

    public ProductType getProductType() {
        if(this.productType==null)
            this.productType = new ProductType();
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
