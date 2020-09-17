package tr.com.turksat.stajyer.magazatakip.dao;

import org.junit.Test;
import tr.com.turksat.stajyer.magazatakip.domain.ProductType;

import java.util.List;

public class ProductTypeDaoTest {

    private ProductTypeDao productTypeDao = new ProductTypeDao();

    //Exception handling
    //Zaten burada benzer yapmışsın sen :) ama dao ile iligli
    //tüm işlemler dao tarafında kalmalı
    //Bu senın yaptığın kısımdı, tüm db işlemlerini içerisinde barındıran
    //böyle olmayacak ya bu kısımları kaldıralım mı?= kaldırabiliriz ya da yorum satırına alıp sonradan ben silebilirim
    //tamam oöyle yapalım.
    //Ctrl / seçili satıları coomment yapar veya
    /*
     --bu da yapar
     */
    /*
    //TODO:SONRA KALDIR
    @Test
    public void listele()  {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("select * from stajyer.product_type");
            rs = ps.executeQuery();
            System.out.println("ProductTypeTest listele2");
            while (rs.next()){
                System.out.println("id :"+rs.getLong("id") + "Name :"+rs.getString("name"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try{
                if(rs!=null)
                    rs.close();
                if(con!=null)
                    con.close();
                if(ps!=null)
                    ps.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        System.out.println("test");
    }
    */

    @Test
    public void testGetProductTypeList(){
        List<ProductType> list = productTypeDao.getProductTypeList();
        for(ProductType productType : list){
            System.out.println("Id : " + productType.getId() + " Name : " + productType.getName());
        }
    }

    //@Test
    public void testCreateProductType(){
        productTypeDao.createProductType("Test"+Math.random());
    }
    //@Test
    public void testUpdateProductType(){
        productTypeDao.updateProductType(6L,"Test"+Math.random());
    }

    //@Test
    public void testDeleteProductType(){
        productTypeDao.deleteProductType(6L);
    }


    /*
    TODO:SONRA KALDIR
    @Test
    //ProductType productType
    public void olustur(){
        Connection con = null;
        con = Database.getInstance().getConnection();
       // productTypeDao.getProductTypeList();
        //Veritabanına bağlantı
        //Insert into ProductType
    }
*/
/*
    TODO:SONRA KALDIR
    @Test
    public void sil(){
        Connection con = null;
        con = Database.getInstance().getConnection();
        //Veritabanına bağlantı
        //Delete from ProductType
    }

 */

}
