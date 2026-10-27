package tr.edu.proje;

import org.junit.jupiter.api.Test;
import tr.edu.proje.model.Rezervasyon;
import tr.edu.proje.service.RezervasyonServisi;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class RezervasyonTest {
    private LocalDateTime saat(int hour) {
        return LocalDateTime.of(2026, 10, 25, hour, 0);
    }

    @Test void ayniCihazdakiCakisanRezervasyonReddedilir() {
        RezervasyonServisi servis = new RezervasyonServisi();
        servis.rezervasyonEkle(new Rezervasyon("C1", "P1", saat(9), saat(11)));
        assertThrows(IllegalArgumentException.class,
                () -> servis.rezervasyonEkle(new Rezervasyon("C1", "P2", saat(10), saat(12))));
    }

    @Test void farkliCihazlardakiRezervasyonlarCakismaSayilmaz() {
        Rezervasyon a = new Rezervasyon("C1", "P1", saat(9), saat(11));
        Rezervasyon b = new Rezervasyon("C2", "P2", saat(10), saat(12));
        assertFalse(a.cakisir(b));
    }

    @Test void ardisikRezervasyonlarCakismaSayilmaz() {
        Rezervasyon a = new Rezervasyon("C1", "P1", saat(9), saat(10));
        Rezervasyon b = new Rezervasyon("C1", "P2", saat(10), saat(11));
        assertFalse(a.cakisir(b));
    }
}
