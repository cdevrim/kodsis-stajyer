package tr.com.turksat.stajyer.magazatakip.dao;

import org.junit.Test;

import java.sql.Connection;

public class ProductDescriptionTest {

    @Test
    public void listele(){
        Connection con = null;
        con = Database.getInstance().getConnection();

        System.out.println("test2");

    }

}
