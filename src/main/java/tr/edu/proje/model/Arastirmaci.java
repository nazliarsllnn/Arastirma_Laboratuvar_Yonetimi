package tr.edu.proje.model;

public class Arastirmaci extends Personel {
    private static final long serialVersionUID = 1L;
    private final String uzmanlik;

    public Arastirmaci(String ad, String soyad, String uzmanlik) {
        super(ad, soyad);
        if (uzmanlik == null || uzmanlik.isBlank()) {
            throw new IllegalArgumentException("Uzmanlık alanı boş olamaz.");
        }
        this.uzmanlik = uzmanlik;
    }

    public String getUzmanlik() { return uzmanlik; }

    @Override
    public String bilgiGetir() {
        return getAd() + " " + getSoyad() + " - Uzmanlık: " + uzmanlik;
    }
}
