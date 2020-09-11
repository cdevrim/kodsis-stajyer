package tr.com.turksat.stajyer.magazatakip.dao;


import tr.com.turksat.stajyer.magazatakip.domain.ProductType;
import org.junit.Test;
import java.util.Date;
import java.util.List;

public class ProductTypeDaoTest {

  ProductTypeDAO productTypeDAO = new ProductTypeDAO();

    @Test
    public void testGetProductType(){
        System.out.println("test");

        List<ProductType> productTypeList = productTypeDAO.getProductType();
        for(ProductType productType : productTypeList){
            System.out.println("ID : "+productType.getId()+ " Create Date: " + productType.getCreateDate() +
                               "Create User ID: " + productType.getCreateUserId()+"Product Type Name: " + productType.getProductTypeName());
        }
    }

    @Test
    public void testInsertProductType(){

        ProductType productType = new ProductType();
        productType.setCreateUserId(1L);
        productType.setCreateDate(new Date());
        productType.setProductTypeName("Test");

       productTypeDAO.insert(productType);
    }

    @Test
    public void testProductTypeDelete(){

     productTypeDAO.delete(13L);
    }

    @Test
    public void testProductTypeUpdate(){

        ProductType productType = new ProductType();
        productType.setId(15L);
        productType.setCreateDate(new Date());
        productType.setCreateUserId(1L);
        productType.setProductTypeName("TEST");


      productTypeDAO.update(productType);
    }

}
