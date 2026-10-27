package tr.edu.proje.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArastirmaProjesi implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String kod;
    private final String ad;
    private final double baslangicButcesi;
    private double harcama;
    private final List<Gorev> gorevler = new ArrayList<>();

    public ArastirmaProjesi(String kod, String ad, double baslangicButcesi) {
        if (kod == null || kod.isBlank() || ad == null || ad.isBlank()) {
            throw new IllegalArgumentException("Proje kodu ve adı boş olamaz.");
        }
        if (baslangicButcesi < 0) throw new IllegalArgumentException("Bütçe negatif olamaz.");
        this.kod = kod;
        this.ad = ad;
        this.baslangicButcesi = baslangicButcesi;
        this.harcama = 0;
    }

    public void harcamaEkle(double tutar) {
        if (tutar <= 0) throw new IllegalArgumentException("Harcama pozitif olmalıdır.");
        if (tutar > kalanButce()) throw new IllegalArgumentException("Harcama kalan bütçeyi aşamaz.");
        harcama += tutar;
    }

    public void gorevEkle(Gorev gorev) {
        if (gorev == null) throw new IllegalArgumentException("Görev boş olamaz.");
        gorevler.add(gorev);
    }

    public double kalanButce() { return baslangicButcesi - harcama; }
    public String getKod() { return kod; }
    public String getAd() { return ad; }
    public double getBaslangicButcesi() { return baslangicButcesi; }
    public double getHarcama() { return harcama; }
    public List<Gorev> getGorevler() { return Collections.unmodifiableList(gorevler); }

    @Override
    public String toString() {
        return kod + " - " + ad + " | Başlangıç bütçesi: " + baslangicButcesi
                + " TL | Harcama: " + harcama + " TL | Kalan: " + kalanButce() + " TL";
    }
}
