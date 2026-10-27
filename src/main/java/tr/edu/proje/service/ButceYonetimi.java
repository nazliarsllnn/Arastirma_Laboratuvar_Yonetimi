package tr.edu.proje.service;

import tr.edu.proje.model.ArastirmaProjesi;

public class ButceYonetimi {
    public void harcamaYap(ArastirmaProjesi proje, double tutar) {
        if (proje == null) throw new IllegalArgumentException("Proje seçilmelidir.");
        proje.harcamaEkle(tutar);
    }
}
