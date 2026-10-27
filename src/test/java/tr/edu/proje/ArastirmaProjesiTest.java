package tr.edu.proje;

import org.junit.jupiter.api.Test;
import tr.edu.proje.model.ArastirmaProjesi;
import tr.edu.proje.model.Gorev;
import static org.junit.jupiter.api.Assertions.*;

class ArastirmaProjesiTest {
    @Test void projeOlusturulur() {
        ArastirmaProjesi p = new ArastirmaProjesi("P1", "Yapay Zeka", 1000);
        assertEquals("Yapay Zeka", p.getAd());
    }
    @Test void negatifButceReddedilir() {
        assertThrows(IllegalArgumentException.class, () -> new ArastirmaProjesi("P1", "Proje", -1));
    }
    @Test void harcamaSonrasiKalanButceHesaplanir() {
        ArastirmaProjesi p = new ArastirmaProjesi("P1", "Proje", 1000);
        p.harcamaEkle(250);
        assertEquals(750, p.kalanButce());
    }
    @Test void butceyiAsanHarcamaReddedilir() {
        ArastirmaProjesi p = new ArastirmaProjesi("P1", "Proje", 100);
        assertThrows(IllegalArgumentException.class, () -> p.harcamaEkle(101));
    }
    @Test void gorevEklenir() {
        ArastirmaProjesi p = new ArastirmaProjesi("P1", "Proje", 100);
        p.gorevEkle(new Gorev("Literatür araştırması"));
        assertEquals(1, p.getGorevler().size());
    }
}
