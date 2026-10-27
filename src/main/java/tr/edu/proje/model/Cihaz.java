package tr.edu.proje.model;

import java.io.Serializable;

public class Cihaz implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String kod;
    private final String ad;

    public Cihaz(String kod, String ad) {
        if (kod == null || kod.isBlank() || ad == null || ad.isBlank()) {
            throw new IllegalArgumentException("Cihaz kodu ve adı boş olamaz.");
        }
        this.kod = kod;
        this.ad = ad;
    }

    public String getKod() { return kod; }
    public String getAd() { return ad; }

    @Override
    public String toString() {
        return kod + " - " + ad;
    }
}
