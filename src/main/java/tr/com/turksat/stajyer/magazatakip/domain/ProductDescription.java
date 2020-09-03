package tr.com.turksat.stajyer.magazatakip.domain;

public class ProductDescription {
    private float price;
    private int productTypeId;
    private String name;


    public ProductDescription()
    {

    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}