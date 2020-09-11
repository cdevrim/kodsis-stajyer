package tr.com.turksat.stajyer.magazatakip.jsfbean;



import tr.com.turksat.stajyer.magazatakip.dao.ProductDescriptionDAO;
import tr.com.turksat.stajyer.magazatakip.domain.ProductDescription;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class ProductDescriptionController implements  Serializable{

    private List<ProductDescription> pdesclist;
    private ProductDescriptionDAO pdescdao;
    private ProductDescription productDescription;





    public String updateForm(ProductDescription productDescription){
        this.productDescription = productDescription;
        return "index";
    }


    public String delete(ProductDescription productDescription){

        this.getPdescdao().delete(productDescription.getId());
        return "index";
    }



    public String update(){
        this.getPdescdao().update(this.productDescription);
        return "index";

    }



    public String create(){
        this.getPdescdao().insert(this.productDescription);
        return "index";
    }



    public ProductDescriptionController() {
        this.pdesclist= new ArrayList();
        this.pdescdao =new ProductDescriptionDAO();
    }

    public List<ProductDescription> getPdesclist() {
        this.pdesclist = this.getPdescdao().getProductDescription();
        return pdesclist;
    }

    public void setPdesclist(List<ProductDescription> pdesclist) {
        this.pdesclist = pdesclist;
    }

    public ProductDescriptionDAO getPdescdao() {
        if(this.pdescdao==null)
            this.pdescdao = new ProductDescriptionDAO();
        return pdescdao;
    }
    public void setPdescdao(ProductDescriptionDAO pdescdao) {this.pdescdao = pdescdao;}


    public ProductDescription getProductDescription() {
        if(this.productDescription==null)
            this.productDescription = new ProductDescription();
        return productDescription;
    }
    public void setProductDescription(ProductDescription productDescription) {this.productDescription = productDescription;}
}
