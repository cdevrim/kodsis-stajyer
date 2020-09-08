package tr.com.turksat.stajyer.magazatakip.domain;

public class Feature {

    private Long id;
    private String name;

    public Feature() { } //Her sınıfın boş bir constructor'ı olmalı.

    public Feature(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    @Override
    public String toString() {
        return "Feature{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
