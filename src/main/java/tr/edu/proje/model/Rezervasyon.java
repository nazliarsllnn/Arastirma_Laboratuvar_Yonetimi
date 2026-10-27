package tr.edu.proje.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Rezervasyon implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String cihazKodu;
    private final String projeKodu;
    private final LocalDateTime baslangic;
    private final LocalDateTime bitis;

    public Rezervasyon(String cihazKodu, String projeKodu,
                       LocalDateTime baslangic, LocalDateTime bitis) {
        if (cihazKodu == null || cihazKodu.isBlank() || projeKodu == null || projeKodu.isBlank()) {
            throw new IllegalArgumentException("Cihaz ve proje kodu boş olamaz.");
        }
        if (baslangic == null || bitis == null || !bitis.isAfter(baslangic)) {
            throw new IllegalArgumentException("Bitiş zamanı başlangıçtan sonra olmalıdır.");
        }
        this.cihazKodu = cihazKodu;
        this.projeKodu = projeKodu;
        this.baslangic = baslangic;
        this.bitis = bitis;
    }

    public boolean cakisir(Rezervasyon diger) {
        if (!cihazKodu.equalsIgnoreCase(diger.cihazKodu)) return false;
        return baslangic.isBefore(diger.bitis) && diger.baslangic.isBefore(bitis);
    }

    public String getCihazKodu() { return cihazKodu; }
    public String getProjeKodu() { return projeKodu; }
    public LocalDateTime getBaslangic() { return baslangic; }
    public LocalDateTime getBitis() { return bitis; }

    @Override
    public String toString() {
        return "Cihaz " + cihazKodu + " | Proje " + projeKodu + " | "
                + baslangic + " - " + bitis;
    }
}
