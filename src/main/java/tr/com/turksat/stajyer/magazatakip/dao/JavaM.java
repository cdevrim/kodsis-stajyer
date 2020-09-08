package tr.com.turksat.stajyer.magazatakip.dao;

import tr.com.turksat.stajyer.magazatakip.domain.Customer;

public class JavaM {
    public static void main(String Args[]){

        CustomerDAO cdao =new CustomerDAO();
        for(Customer c : cdao.getCustomer()){
            System.out.println(c);
        }

    }
}
