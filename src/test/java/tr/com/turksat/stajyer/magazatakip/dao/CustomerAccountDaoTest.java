package tr.com.turksat.stajyer.magazatakip.dao;

import org.junit.Test;
import tr.com.turksat.stajyer.magazatakip.domain.CustomerAccount;
import java.util.Date;
import java.util.List;

public class CustomerAccountDaoTest {
    CustomerAccountDAO customerAccountDAO = new CustomerAccountDAO();

    @Test
    public void testGetCustomerAccount(){
        System.out.println("test");

        List<CustomerAccount> customerAccountList = customerAccountDAO.getCustomerAccount();
        for(CustomerAccount customerAccount : customerAccountList){
            System.out.println("ID : "+customerAccount.getId()+" Customer ID : "+customerAccount.getCustomerId()+
                     " Create Date: " + customerAccount.getCreateDate()+ "Create User ID: " + customerAccount.getCreateUserId()
                    + " Billing Address: " + customerAccount.getBillingAddress());
        }
    }

    @Test
    public void testInsertCustomerAccount(){

        CustomerAccount customerAccount = new CustomerAccount();
        customerAccount.setCustomerId(23L);
        customerAccount.setCreateDate(new Date());
        customerAccount.setCreateUserId(1L);
        customerAccount.setBillingAddress("Yenimahalle");

        customerAccountDAO.insert(customerAccount);
    }

    @Test
    public void testCustomerAccountDelete(){

        customerAccountDAO.delete(99999999999L);

    }

    @Test
    public void testCustomerAccountUpdate(){

        CustomerAccount customerAccount = new CustomerAccount();
        customerAccount.setId(1L);
        customerAccount.setCustomerId(17L);
        customerAccount.setCreateDate(new Date());
        customerAccount.setCreateUserId(1L);
        customerAccount.setBillingAddress("Test billing address"+Math.random());

        customerAccountDAO.update(customerAccount);
    }

}
