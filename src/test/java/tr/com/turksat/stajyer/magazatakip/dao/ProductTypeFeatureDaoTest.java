package tr.com.turksat.stajyer.magazatakip.dao;


import org.junit.Test;
import tr.com.turksat.stajyer.magazatakip.domain.ProductTypeFeature;

import java.util.Date;
import java.util.List;



public class ProductTypeFeatureDaoTest {

    ProductTypeFeatureDAO productTypeFeatureDAO = new ProductTypeFeatureDAO();

    @Test
    public void testGetCustomer(){
        System.out.println("test");

        List<ProductTypeFeature> productTypeFeatureList = productTypeFeatureDAO.getProductTypeFeature();
        for(ProductTypeFeature productTypeFeature : productTypeFeatureList){
            System.out.println("ID : "+productTypeFeature.getId()+" Value : "+productTypeFeature.getValue()
                    + " Create Date: " + productTypeFeature.getCreateDate()+ "Create User ID: " + productTypeFeature.getCreateUserId()
                    + "Product Type ID : "+productTypeFeature.getProductTypeId() + "Feature ID: " + productTypeFeature.getFeatureId());
        }
    }

    @Test
    public void testInsertProductTypeFeature(){

        ProductTypeFeature productTypeFeature = new ProductTypeFeature();
        productTypeFeature.setValue("TEST");
        productTypeFeature.setCreateDate(new Date());
        productTypeFeature.setCreateUserId(2L);
        productTypeFeature.setProductTypeId( (13L);
        productTypeFeature.setFeatureId(3L);

        productTypeFeatureDAO.insert(productTypeFeature);
    }

    @Test
    public void testProductTypeFeatureDelete(){

        productTypeFeatureDAO.delete(104L);
    }

    @Test
    public void testProductTypeFeatureUpdate(){
        ProductTypeFeature productTypeFeature = new ProductTypeFeature();
        productTypeFeature.setId(85L);
        productTypeFeature.setCreateDate(new Date());
        productTypeFeature.setCreateUserId(1L);
        productTypeFeature.setProductTypeId(12L);
        productTypeFeature.setFeatureId(1L);

        productTypeFeatureDAO.update(productTypeFeature);
    }


}
