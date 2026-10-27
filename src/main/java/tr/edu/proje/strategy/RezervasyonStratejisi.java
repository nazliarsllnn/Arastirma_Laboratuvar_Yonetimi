package tr.edu.proje.strategy;

import tr.edu.proje.model.Cihaz;
import java.util.List;

public interface RezervasyonStratejisi {
    Cihaz cihazSec(List<Cihaz> cihazlar);
}
