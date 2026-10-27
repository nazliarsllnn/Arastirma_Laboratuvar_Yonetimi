package tr.edu.proje.factory;

import tr.edu.proje.model.ArastirmaProjesi;

public class ProjeFabrikasi {
    public ArastirmaProjesi projeOlustur(String kod, String ad, double butce) {
        return new ArastirmaProjesi(kod, ad, butce);
    }
}
