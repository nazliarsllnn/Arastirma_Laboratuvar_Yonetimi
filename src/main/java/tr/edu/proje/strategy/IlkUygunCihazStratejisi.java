package tr.edu.proje.strategy;

import tr.edu.proje.model.Cihaz;
import java.util.List;

public class IlkUygunCihazStratejisi implements RezervasyonStratejisi {
    @Override
    public Cihaz cihazSec(List<Cihaz> cihazlar) {
        if (cihazlar == null || cihazlar.isEmpty()) return null;
        return cihazlar.get(0);
    }
}
