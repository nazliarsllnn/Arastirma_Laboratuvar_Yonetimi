package tr.edu.proje.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Laboratuvar implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String kod;
    private final String ad;
    private final int kapasite;
    private final List<Cihaz> cihazlar = new ArrayList<>();

    public Laboratuvar(String kod, String ad, int kapasite) {
        if (kod == null || kod.isBlank() || ad == null || ad.isBlank()) {
            throw new IllegalArgumentException("Laboratuvar kodu ve adı boş olamaz.");
        }
        if (kapasite <= 0) throw new IllegalArgumentException("Kapasite pozitif olmalıdır.");
        this.kod = kod;
        this.ad = ad;
        this.kapasite = kapasite;
    }

    public void cihazEkle(Cihaz cihaz) {
        if (cihaz == null) throw new IllegalArgumentException("Cihaz boş olamaz.");
        boolean varMi = cihazlar.stream().anyMatch(c -> c.getKod().equalsIgnoreCase(cihaz.getKod()));
        if (varMi) throw new IllegalArgumentException("Bu cihaz kodu laboratuvarda zaten var.");
        cihazlar.add(cihaz);
    }

    public String getKod() { return kod; }
    public String getAd() { return ad; }
    public int getKapasite() { return kapasite; }
    public List<Cihaz> getCihazlar() { return Collections.unmodifiableList(cihazlar); }

    @Override
    public String toString() {
        return kod + " - " + ad + " (kapasite: " + kapasite + ", cihaz: " + cihazlar.size() + ")";
    }
}
