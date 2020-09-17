package tr.com.turksat.stajyer.magazatakip.dao;

import org.junit.Test;
import tr.com.turksat.stajyer.magazatakip.domain.Product;

import java.sql.Timestamp;
import java.util.List;

public class ProductDaoTest {

    private ProductDao productDao = new ProductDao();

    @Test
    public void testGetProductList(){
        List<Product> list = productDao.getProductList();
        for(Product product : list){
            System.out.println("Id: " + product.getId() + " Price: " + product.getPrice() + " Production Date: " + product.getProductionDate() + " Date Of Sale: " + product.getDateOfSale() + " Description: "  + product.getDescriptionId() + " Account Id: " + product.getAccountId());
        }
    }

    //@Test
    public void testCreateProduct(){
        productDao.createProduct(1F, Timestamp.valueOf("1111-11-11 11:11:11"), Timestamp.valueOf("1111-11-11 11:11:11") , 1L, 1L);
    }
    //@Test
    public void testUpdateProduct(){
        productDao.updateProduct(19L,1F, Timestamp.valueOf("2111-11-11 11:11:11"), Timestamp.valueOf("2111-11-11 11:11:11") , 2L, 2L);
    }

    //@Test
    public void testDeleteProduct(){
        productDao.deleteProduct(19L);
    }
}
