package tr.com.turksat.stajyer.magazatakip.jsfbean;

import tr.com.turksat.stajyer.magazatakip.service.ProductTypeService;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@ManagedBean
public class ProductTypeForm  implements Serializable {

    private ProductTypeService productTypeService = new ProductTypeService();

}
