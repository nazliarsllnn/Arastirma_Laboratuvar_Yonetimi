package tr.edu.proje.service;

import tr.edu.proje.model.Cihaz;
import tr.edu.proje.strategy.RezervasyonStratejisi;
import java.util.List;

public class KaynakPlanlayici {
    private final RezervasyonStratejisi strateji;

    public KaynakPlanlayici(RezervasyonStratejisi strateji) {
        if (strateji == null) throw new IllegalArgumentException("Strateji gereklidir.");
        this.strateji = strateji;
    }

    public Cihaz cihazSec(List<Cihaz> cihazlar) {
        return strateji.cihazSec(cihazlar);
    }
}
