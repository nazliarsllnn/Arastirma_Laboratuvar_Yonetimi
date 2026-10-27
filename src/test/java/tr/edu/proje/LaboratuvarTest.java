package tr.edu.proje;

import org.junit.jupiter.api.Test;
import tr.edu.proje.model.Cihaz;
import tr.edu.proje.model.Laboratuvar;
import static org.junit.jupiter.api.Assertions.*;

class LaboratuvarTest {
    @Test void cihazLaboratuvaraEklenir() {
        Laboratuvar lab = new Laboratuvar("L1", "Robotik", 20);
        lab.cihazEkle(new Cihaz("C1", "3B Yazıcı"));
        assertEquals(1, lab.getCihazlar().size());
    }
    @Test void ayniCihazKoduIkinciKezEklenemez() {
        Laboratuvar lab = new Laboratuvar("L1", "Robotik", 20);
        lab.cihazEkle(new Cihaz("C1", "3B Yazıcı"));
        assertThrows(IllegalArgumentException.class,
                () -> lab.cihazEkle(new Cihaz("C1", "Başka cihaz")));
    }
    @Test void sifirKapasiteReddedilir() {
        assertThrows(IllegalArgumentException.class, () -> new Laboratuvar("L1", "Lab", 0));
    }
}
