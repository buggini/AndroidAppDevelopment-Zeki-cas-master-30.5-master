package rs.aleph.android.example12.model;

import java.util.ArrayList;
import java.util.List;

public class Sastojak {

    private int id;
    private String naziv;
    private Jelo jelo;
//    private List<Kategorija> kategorija;


    public Sastojak(){

//        kategorija =  new ArrayList<>();

    }

    public Sastojak(int idSastojci, String nazivSastojic) {
        this.id = idSastojci;
        this.naziv = nazivSastojic;

//        kategorija =  new ArrayList<>();

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Jelo getJelo() {
        return jelo;
    }

    public void setJelo(Jelo jelo) {
        this.jelo = jelo;
    }




    public String getNazivSastojic() {
        return naziv;
    }




    @Override
    public String toString() {
        return  naziv;

    }
}
