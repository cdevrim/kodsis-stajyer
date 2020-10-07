package tr.com.turksat.stajyer.magazatakip.jsfbean;

import tr.com.turksat.stajyer.magazatakip.domain.CustomerAccount;
import tr.com.turksat.stajyer.magazatakip.service.CustomerAccountService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class CustomerAccountController implements Serializable {

    CustomerAccountService customerAccountService= new CustomerAccountService();

    List<CustomerAccount> customerAccountList = new ArrayList<>();

    @PostConstruct
    public void init() {
        customerAccountList = getCustomerAccounts();
    }

    public List<CustomerAccount> getCustomerAccounts(){
        customerAccountList = customerAccountService.getCustomerAccounts();
        return customerAccountList;
    }

    public CustomerAccountService getCustomerAccountService() {
        return customerAccountService;
    }

    public void setCustomerAccountService(CustomerAccountService customerAccountService) {
        this.customerAccountService = customerAccountService;
    }

    public List<CustomerAccount> getCustomerAccountList() {
        return customerAccountList;
    }

    public void setCustomerAccountList(List<CustomerAccount> customerAccountList) {
        this.customerAccountList = customerAccountList;
    }
}


