package tr.com.turksat.stajyer.magazatakip.dao;

import org.junit.Test;
import tr.com.turksat.stajyer.magazatakip.domain.CustomerAccount;
import java.util.List;

public class CustomerAccountDaoTest {

    private CustomerAccountDao customerAccountDao = new CustomerAccountDao();

    @Test
    public void testGetCustomerAccountList(){
        List<CustomerAccount> list = customerAccountDao.getCustomerAccountList();
        for(CustomerAccount customerAccount : list){
            System.out.println("Id : " + customerAccount.getId() + " Name : " + customerAccount.getAccountName() + " Billing Address : "+ customerAccount.getBillingAddress() + " Customer Id : " + customerAccount.getCustomerId());
        }
    }

    //@Test
    public void testCreateCustomerAccount(){
        customerAccountDao.createCustomerAccount("Test123", "Test123", 1L);
    }
    //@Test
    public void testUpdateCustomerAccount(){
        customerAccountDao.updateCustomerAccount(16L, "Test333", "Test333", 1L);
    }

    //@Test
    public void testDeleteCustomerAccount(){
        customerAccountDao.deleteCustomerAccount(16L);
    }
}
