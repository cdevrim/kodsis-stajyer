package tr.com.turksat.stajyer.magazatakip.domain;

public class ProductTypeFeature {
    private String value;
    private int productTypeId;
    private int featureId;



    public ProductTypeFeature()
    {

    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

    public int getFeatureId() {
        return featureId;
    }

    public void setFeatureId(int featureId) {
        this.featureId = featureId;
    }
}