package tr.edu.proje.service;

import tr.edu.proje.model.Rezervasyon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RezervasyonServisi {
    private final List<Rezervasyon> rezervasyonlar = new ArrayList<>();

    public void rezervasyonEkle(Rezervasyon yeni) {
        if (yeni == null) throw new IllegalArgumentException("Rezervasyon boş olamaz.");
        for (Rezervasyon mevcut : rezervasyonlar) {
            if (mevcut.cakisir(yeni)) {
                throw new IllegalArgumentException("Bu cihaz o saatlerde zaten rezerve edilmiş.");
            }
        }
        rezervasyonlar.add(yeni);
    }

    public List<Rezervasyon> getRezervasyonlar() {
        return Collections.unmodifiableList(rezervasyonlar);
    }

    public void yuklenenleriEkle(List<Rezervasyon> kayitlar) {
        for (Rezervasyon r : kayitlar) rezervasyonEkle(r);
    }
}
