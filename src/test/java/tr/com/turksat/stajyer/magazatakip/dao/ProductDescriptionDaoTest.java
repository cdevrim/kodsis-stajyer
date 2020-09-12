package tr.com.turksat.stajyer.magazatakip.dao;

import org.junit.Test;

import tr.com.turksat.stajyer.magazatakip.domain.ProductDescription;

import java.util.Date;
import java.util.List;

public class ProductDescriptionDaoTest {

    ProductDescriptionDAO productDescriptionDAO = new ProductDescriptionDAO();

    @Test
    public void testGetProductDescription(){
        System.out.println("test");

        List<ProductDescription> productDescriptionList = productDescriptionDAO.getProductDescription();
        for(ProductDescription productDescription : productDescriptionList){
            System.out.println("ID : "+productDescription.getId()+" Product Description Name : "+productDescription.getProductDescriptionName()+
                    " Create Date: " + productDescription.getCreateDate()+ " Create User ID: " + productDescription.getCreateUserId() +
                    " Product Type ID: " + productDescription.getProductTypeId() );
        }
    }

    @Test
    public void testInsertProductDescription(){

        ProductDescription productDescription = new ProductDescription();
        productDescription.setProductDescriptionName("Samsung TEST S10 White 32GB"+Math.random());
        productDescription.setCreateDate(new Date());
        productDescription.setCreateUserId(1L);
        productDescription.setProductTypeId(12L);


        productDescriptionDAO.insert(productDescription);
    }

    @Test
    public void testProductDescriptionDelete(){

        productDescriptionDAO.delete(99999999999L);
    }

    @Test
    public void testProductDescriptionUpdate(){

        ProductDescription productDescription = new ProductDescription();
        productDescription.setId(5L);
        productDescription.setProductDescriptionName("Iphone 8 32GB"+Math.random());
        productDescription.setCreateDate(new Date());
        productDescription.setCreateUserId(1L);
        productDescription.setProductTypeId(  12L);


       productDescriptionDAO.update(productDescription);
    }
}
