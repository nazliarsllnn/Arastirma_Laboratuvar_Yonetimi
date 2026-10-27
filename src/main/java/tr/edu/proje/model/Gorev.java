package tr.edu.proje.model;

import java.io.Serializable;

public class Gorev implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String aciklama;
    private boolean tamamlandi;

    public Gorev(String aciklama) {
        if (aciklama == null || aciklama.isBlank()) {
            throw new IllegalArgumentException("Görev açıklaması boş olamaz.");
        }
        this.aciklama = aciklama;
        this.tamamlandi = false;
    }

    public void tamamla() { tamamlandi = true; }
    public String getAciklama() { return aciklama; }
    public boolean isTamamlandi() { return tamamlandi; }

    @Override
    public String toString() {
        return (tamamlandi ? "[Tamamlandı] " : "[Bekliyor] ") + aciklama;
    }
}
