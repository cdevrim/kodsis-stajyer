package tr.com.turksat.stajyer.magazatakip.service;

import tr.com.turksat.stajyer.magazatakip.dao.CustomerAccountDao;
import tr.com.turksat.stajyer.magazatakip.domain.CustomerAccount;

import java.util.List;

public class CustomerAccountService {

    CustomerAccountDao customerAccountDao = new CustomerAccountDao();

    public List<CustomerAccount> getCustomerAccounts(){
        return customerAccountDao.getCustomerAccountList();
    }
}
