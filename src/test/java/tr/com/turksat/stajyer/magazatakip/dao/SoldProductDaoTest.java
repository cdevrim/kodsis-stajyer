package tr.com.turksat.stajyer.magazatakip.dao;


import org.junit.Test;
import tr.com.turksat.stajyer.magazatakip.domain.SoldProduct;


import java.util.Date;
import java.util.List;


public class SoldProductDaoTest {

   SoldProductDAO soldProductDAO = new SoldProductDAO();

    @Test
    public void testGetSoldProduct(){
        System.out.println("test");

        List<SoldProduct> soldProductList = soldProductDAO.getSoldProduct();
        for(SoldProduct soldProduct : soldProductList){
            System.out.println("ID : "+soldProduct.getId()+" Sold Date : "+soldProduct.getSoldDate()+
                    " Customer Account ID: " + soldProduct.getCustomerAccountId()+ " Create Date: " + soldProduct.getCreateDate() +
                    "Create User ID: " + soldProduct.getCreateUserId() + " Product ID" + soldProduct.getProductId());
        }
    }

    @Test
    public void testInsertSoldProduct(){

        SoldProduct soldProduct = new SoldProduct();
        soldProduct.setSoldDate(new Date());
        soldProduct.setCustomerAccountId( (12L);
        soldProduct.setCreateDate(new Date());
        soldProduct.setCreateUserId(1L);
        soldProduct.setProductId(2L);


       soldProductDAO.insert(soldProduct);
    }

    @Test
    public void testSoldProductDelete(){

      soldProductDAO.delete(8L);
    }

    @Test
    public void testSoldProductUpdate(){

        SoldProduct soldProduct = new SoldProduct();
        soldProduct.setId(9L);
        soldProduct.setSoldDate(new Date());
        soldProduct.setCustomerAccountId(4L);
        soldProduct.setCreateUserId(1L);
        soldProduct.setCreateDate(new Date());
        soldProduct.setProductId(2L);


        soldProductDAO.update(soldProduct);
    }

}
