package tr.com.turksat.stajyer.magazatakip.jsfbean;

import tr.com.turksat.stajyer.magazatakip.domain.Customer;
import tr.com.turksat.stajyer.magazatakip.service.CustomerService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class CustomerController implements Serializable {

    CustomerService customerService= new CustomerService();

    List<Customer> customerList = new ArrayList<>();

    @PostConstruct
    public void init() {
        customerList = getCustomers();
    }

    public List<Customer> getCustomers(){
        customerList = customerService.getCustomers();
        return customerList;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}


