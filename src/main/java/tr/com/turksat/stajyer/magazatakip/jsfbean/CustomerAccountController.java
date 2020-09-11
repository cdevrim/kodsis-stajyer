package tr.com.turksat.stajyer.magazatakip.jsfbean;

import tr.com.turksat.stajyer.magazatakip.dao.CustomerAccountDAO;
import tr.com.turksat.stajyer.magazatakip.dao.CustomerDAO;
import tr.com.turksat.stajyer.magazatakip.domain.Customer;
import tr.com.turksat.stajyer.magazatakip.domain.CustomerAccount;

import javax.faces.bean.ManagedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


    @ManagedBean
    public class CustomerAccountController implements Serializable {

        private List<CustomerAccount> custAccList;
        private CustomerAccountDAO custAccDao;
        private CustomerAccount customerAccount;





        public String updateForm(CustomerAccount customerAccount){
            this.customerAccount = customerAccount;
            return "index";
        }


        public String delete(CustomerAccount customerAccount){

            this.getCustAccDao().delete(customerAccount.getId());
            return "index";
        }



        public String update(){
            this.getCustAccDao().update(this.customerAccount);
            return "index";

        }



        public String create(){
            this.getCustAccDao().insert(this.customerAccount);
            return "index";
        }



        public CustomerAccountController() {
            this.custAccList= new ArrayList();
            this.custAccDao =new CustomerAccountDAO();
        }


        public List<CustomerAccount> getCustAccList() {
            this.custAccList = this.getCustAccDao().getCustomerAccount();
         return custAccList;
        }

        public void setCustAccList(List<CustomerAccount> custAccList) {
            this.custAccList = custAccList;
        }



        public CustomerAccountDAO getCustAccDao() {
            if(this.custAccDao==null)
                this.custAccDao = new CustomerAccountDAO();
          return custAccDao;
        }
        public void setCustAccDao(CustomerAccountDAO custAccDao) {this.custAccDao = custAccDao;}


        public CustomerAccount getCustomerAccount() {
            if(this.customerAccount==null)
                this.customerAccount = new CustomerAccount();
            return customerAccount;
        }
        public void setCustomerAccount(CustomerAccount customerAccount) {this.customerAccount = customerAccount;}
    }
