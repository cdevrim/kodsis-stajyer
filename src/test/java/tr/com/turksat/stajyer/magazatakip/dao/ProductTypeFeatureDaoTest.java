package tr.com.turksat.stajyer.magazatakip.dao;

import org.junit.Test;
import tr.com.turksat.stajyer.magazatakip.domain.ProductTypeFeature;

import java.util.List;

public class ProductTypeFeatureDaoTest {

    private ProductTypeFeatureDao productTypeFeatureDao = new ProductTypeFeatureDao();

    @Test
    public void testGetProductTypeFeatureList(){
        List<ProductTypeFeature> list = productTypeFeatureDao.getProductTypeFeatureList();
        for(ProductTypeFeature productTypeFeature : list){
            System.out.println("Id: "+ productTypeFeature.getId() + " Value: " + productTypeFeature.getValue() + " Product Type Id: " + productTypeFeature.getProductTypeId() + " Feature Id: " + productTypeFeature.getFeatureId());
        }
    }

    //@Test
    public void testCreateProductTypeFeature(){
        productTypeFeatureDao.createProductTypeFeature("Test123", 1L,2L);
        //productTypeFeatureDao.createProductTypeFeature("Test"+Math.random(), 1L,1L);
    }

    //@Test
    public void testUpdateProductTypeFeature(){
        productTypeFeatureDao.updateProductTypeFeature(13L,"Test333",1L,3L);
        //productTypeFeatureDao.updateProductTypeFeature(6L,"Test"+Math.random(),1L,1L);
    }

    //@Test
    public void testDeleteProductTypeFeature(){
        productTypeFeatureDao.deleteProductTypeFeature(13L);
    }

}
