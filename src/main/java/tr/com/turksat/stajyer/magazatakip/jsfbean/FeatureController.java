package tr.com.turksat.stajyer.magazatakip.jsfbean;

import tr.com.turksat.stajyer.magazatakip.domain.Feature;
import tr.com.turksat.stajyer.magazatakip.service.FeatureService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean; //özellikle bunun kullanıldığından emin ol.
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean //Demin managed beanı annotte eettik ama anlamamıoş :( sinir ...
public class FeatureController implements Serializable { //illa ismi form olmak zosunda degıl controlelr da olabilir

    FeatureService featureService = new FeatureService();

    List<Feature> featureList = new ArrayList<>(); // bu nesne ekrana bind olan nesne, ama bos onu set etmek lazım ki gürnsün.

    @PostConstruct //ILk olusurken baslaması gereken şeyler bu annotion ile verilir, ve init default standart bir addır.
    public void init() {
        featureList = getFeatures();
    }

    public List<Feature> getFeatures(){
        featureList = featureService.getFeatures(); //Eranın ilk urayacağı yer buradan servis burdan dao diye gider.
        //Çünkü öyle yazdık :)
        return featureList;
    }

    public FeatureService getFeatureService() {
        return featureService;
    }

    public void setFeatureService(FeatureService featureService) {
        this.featureService = featureService;
    }

    public List<Feature> getFeatureList() {
        return featureList;
    }

    public void setFeatureList(List<Feature> featureList) {
        this.featureList = featureList;
    }
}
