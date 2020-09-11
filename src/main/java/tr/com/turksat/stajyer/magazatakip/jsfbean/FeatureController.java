package tr.com.turksat.stajyer.magazatakip.jsfbean;

import tr.com.turksat.stajyer.magazatakip.dao.CustomerDAO;
import tr.com.turksat.stajyer.magazatakip.dao.FeatureDao;
import tr.com.turksat.stajyer.magazatakip.domain.Customer;
import tr.com.turksat.stajyer.magazatakip.domain.Feature;
import tr.com.turksat.stajyer.magazatakip.service.GeneralService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class FeatureController implements Serializable {


    private Feature feature;
    private FeatureDao featureDao;
    GeneralService generalService = new GeneralService();
    List<Feature> featureList = new ArrayList<>();

    public FeatureController(){

        this.featureList= new ArrayList();
        this.featureDao =new FeatureDao();
    }




    public String updateForm(Feature feature){
        this.feature = feature;
        return "index";
    }


    public String delete(Feature feature){

        this.getFeaturedao().delete(feature.getId());
        return "index";
    }



    public String update(){
        this.getFeaturedao().update(this.feature);
        return "index";

    }



    public String create(){
        this.getFeaturedao().insert(this.feature);
        return "index";
    }


    @PostConstruct
    public void init() {
        featureList = getFeatures();
    }
    public List<Feature> getFeatures(){
        return  generalService.listFeauture();
    }

    public List<Feature> getFeatureList() {
        this.featureList = this.getFeaturedao().getFeature();
      return featureList;
    }

    public Feature getFeature() {
        if(this.feature==null)
            this.feature = new Feature();
        return feature;
     }
    public void setFeature(Feature feature) {this.feature = feature;}

    public FeatureDao getFeaturedao() {
        if(this.featureDao==null)
            this.featureDao = new FeatureDao();
        return featureDao;

    }
    public void setFeaturedao(FeatureDao featuredao) {this.featureDao = featuredao;}

    public void setFeatureList(List<Feature> featureList) {this.featureList = featureList;}
}
