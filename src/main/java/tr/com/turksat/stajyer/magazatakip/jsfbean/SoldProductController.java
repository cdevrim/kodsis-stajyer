package tr.com.turksat.stajyer.magazatakip.jsfbean;


import tr.com.turksat.stajyer.magazatakip.dao.SoldProductDAO;
import tr.com.turksat.stajyer.magazatakip.domain.SoldProduct;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SoldProductController implements Serializable {

    private List<SoldProduct> splist;
    private SoldProductDAO spdao;
    private SoldProduct soldProduct;





    public String updateForm(SoldProduct soldProduct){
        this.soldProduct = soldProduct;
        return "index";
    }


    public String delete(SoldProduct soldProduct){

        this.getSpdao().delete(soldProduct.getId());
        return "index";
    }



    public String update(){
        this.getSpdao().update(this.soldProduct);
        return "index";

    }



    public String create(){
        this.getSpdao().insert(this.soldProduct);
        return "index";
    }



    public SoldProductController() {
        this.splist= new ArrayList();
        this.spdao =new SoldProductDAO();
    }

    public List<SoldProduct> getSplist() {
        this.splist = this.getSpdao().getSoldProduct();
        return splist;
    }

    public void setSplist(List<SoldProduct> splist) {
        this.splist = splist;
    }

    public SoldProductDAO getSpdao() {
        if(this.spdao==null)
            this.spdao = new SoldProductDAO();
        return spdao;
    }

    public void setSpdao(SoldProductDAO spdao) {
        this.spdao = spdao;
    }

    public SoldProduct getSoldProduct() {
        if(this.soldProduct==null)
            this.soldProduct = new SoldProduct();
        return soldProduct;
    }

    public void setSoldProduct(SoldProduct soldProduct) {
        this.soldProduct = soldProduct;
    }
}

