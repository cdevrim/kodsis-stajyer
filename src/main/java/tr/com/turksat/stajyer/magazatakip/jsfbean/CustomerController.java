package tr.com.turksat.stajyer.magazatakip.jsfbean;


import tr.com.turksat.stajyer.magazatakip.dao.CustomerDAO;
import tr.com.turksat.stajyer.magazatakip.domain.Customer;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
@ManagedBean
public class CustomerController implements Serializable {

   private List<Customer> clist;
   private CustomerDAO cdao;
   private Customer customer;





    public String updateForm(Customer cust){
        this.customer = cust;
        return "index";
    }


   public String delete(Customer cust){

     this.getCdao().delete(cust);
             return "index";
   }



    public String update(){
        this.getCdao().update(this.customer);
        return "index";

    }



   public String create(){
       this.getCdao().insert(this.customer);
       return "index";
   }



    public CustomerController() {
        this.clist= new ArrayList();
        this.cdao =new CustomerDAO();
    }




    public List<Customer> getClist() {
        this.clist = this.getCdao().getCustomer();
        return clist;
    }
    public void setClist(List<Customer> clist) {
        this.clist = clist;
    }



    public CustomerDAO getCdao() {
        if(this.cdao==null)
            this.cdao = new CustomerDAO();
        return cdao;
    }
    public void setCdao(CustomerDAO cdao) {
        this.cdao = cdao;
    }




    public Customer getCustomer() {
        if(this.customer==null)
            this.customer = new Customer();
                return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
