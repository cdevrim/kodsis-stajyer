package tr.com.turksat.stajyer.magazatakip.service;

import tr.com.turksat.stajyer.magazatakip.dao.CustomerDao;
import tr.com.turksat.stajyer.magazatakip.domain.Customer;

import java.util.List;

public class CustomerService {

    CustomerDao customerDao = new CustomerDao();

    public List<Customer> getCustomers(){
        return customerDao.getCustomerList();
    }
}
