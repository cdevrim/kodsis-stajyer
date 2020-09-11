package tr.com.turksat.stajyer.magazatakip.dao;



import org.junit.Test;
import tr.com.turksat.stajyer.magazatakip.domain.Product;
import java.util.Date;
import java.util.List;

public class ProductDaoTest {

    ProductDAO productDAO = new ProductDAO();

    @Test
    public void testGetProduct(){
        System.out.println("test");

        List<Product> productList = productDAO.getProduct();
        for(Product product : productList){
            System.out.println("ID : "+product.getId()+" Product Name : "+product.getProductName()+
                    " Price: " + product.getPrice()+ " Create Date: " + product.getCreateDate() +
                    " Create User ID: " + product.getCreateUserId() + " Product Date" + product.getProductDate()+
                    " Product Description ID: " + product.getProductDescriptionId() );
        }
    }

    @Test
    public void testInsertProduct(){

        Product product = new Product();
        product.setProductName("Test"+Math.random());
        product.setPrice(2500.02);
        product.setCreateDate(new Date());
        product.setCreateUserId(1L);
        product.setProductDate(new Date());
        product.setProductDescriptionId(12L);

       productDAO.insert(product);
    }

    @Test
    public void testProductDelete(){

        productDAO.delete(10L);
    }

    @Test
    public void testProductUpdate(){

        Product product = new Product();
        product.setId(10L);
        product.setProductName("Test"+Math.random());
        product.setPrice(2000.50);
        product.setCreateDate(new Date());
        product.setCreateUserId(1L);
        product.setProductDate(new Date());
        product.setProductDescriptionId( 12L);

      productDAO.update(product);
    }
}
