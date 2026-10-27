package tr.edu.proje.model;

import java.io.Serializable;

public abstract class
Personel implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String ad;
    private final String soyad;

    protected Personel(String ad, String soyad) {
        if (ad == null || ad.isBlank() || soyad == null || soyad.isBlank()) {
            throw new IllegalArgumentException("Ad ve soyad boş olamaz.");
        }
        this.ad = ad;
        this.soyad = soyad;
    }

    public String getAd() { return ad; }
    public String getSoyad() { return soyad; }
    public abstract String bilgiGetir();
}
