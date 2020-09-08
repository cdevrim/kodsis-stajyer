package tr.com.turksat.stajyer.magazatakip.jsfbean;

import tr.com.turksat.stajyer.magazatakip.domain.Feature;
import tr.com.turksat.stajyer.magazatakip.service.GeneralService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class FeatureController implements Serializable {

    GeneralService generalService = new GeneralService();

    List<Feature> featureList = new ArrayList<>();

    @PostConstruct
    public void init() {
        featureList = getFeatures();
    }
    public List<Feature> getFeatures(){
        return  generalService.listFeauture();
    }

    public List<Feature> getFeatureList() {
        return featureList;
    }
}
