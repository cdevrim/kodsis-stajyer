package tr.com.turksat.stajyer.magazatakip.jsfbean;
import tr.com.turksat.stajyer.magazatakip.dao.ProductDAO;
import tr.com.turksat.stajyer.magazatakip.domain.Product;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@ManagedBean
public class ProductController implements Serializable {

    private List<Product> plist;
    private ProductDAO pdao;
    private Product product;


    public String updateForm(Product product) {
        this.product = product;
        return "index";
    }


    public String delete(Product product) {

        this.getPdao().delete(product.getId());
        return "index";
    }


    public String update() {
        this.getPdao().update(this.product);
        return "index";

    }


    public String create() {
        this.getPdao().insert(this.product);
        return "index";
    }


    public ProductController() {
        this.plist = new ArrayList();
        this.pdao = new ProductDAO();
    }

    public List<Product> getPlist() {
        this.plist = this.getPdao().getProduct();
        return plist;
    }

    public void setPlist(List<Product> plist) {
        this.plist = plist;
    }

    public ProductDAO getPdao() {
        if(this.pdao==null)
            this.pdao = new ProductDAO();
        return pdao;
      }
    public void setPdao(ProductDAO pdao) {this.pdao = pdao;}


    public Product getProduct() {
        if(this.product==null)
            this.product = new Product();
        return product;
    }
    public void setProduct(Product product) {this.product = product;}
}
