package tr.com.turksat.stajyer.magazatakip.dao;

import org.junit.Test;
import tr.com.turksat.stajyer.magazatakip.domain.ProductDescription;



import java.util.List;

public class ProductDescriptionDaoTest {

    private ProductDescriptionDao productDescriptionDao = new ProductDescriptionDao();


    @Test
    public void testGetProductDescriptionList(){
        List<ProductDescription> list = productDescriptionDao.getProductDescriptionList();
        for(ProductDescription productDescription : list){
            System.out.println("Id: " + productDescription.getId() + " Price: " + productDescription.getPrice() + " Product Type Id: " + productDescription.getProductTypeId() + " Name: " + productDescription.getName());
        }
    }

    //@Test
    public void testCreateProductDescription(){
        productDescriptionDao.createProductDescription(1F, 1L,"Test123");
    }
    //@Test
    public void testUpdateProductDescription(){
        productDescriptionDao.updateProductDescription(11L,2F,1L,"Test333");
    }

    //@Test
    public void testDeleteProductDescription(){
        productDescriptionDao.deleteProductDescription(11L);
    }
}
