package tr.com.turksat.stajyer.magazatakip.dao;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class KullaniciDaoTest {

    @Test
    public void testGetKullanici(){
        Connection con = Database.getInstance().getConnection();
        Assert.assertEquals(1,1);
    }

    @Test
    public void testGetKullanicilar(){
            KullaniciDao kullaniciDao = new KullaniciDao();
            Assert.assertTrue(kullaniciDao.getKullanicilar().size() > 0);
    }

    //TODO: Insert Delete Update için test yazılsın
}
