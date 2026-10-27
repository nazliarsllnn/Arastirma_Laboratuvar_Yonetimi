package tr.edu.proje.service;

import java.io.*;

public class VeriYoneticisi {
    public void kaydet(Object veri, String dosyaYolu) throws IOException {
        File dosya = new File(dosyaYolu);
        File ebeveyn = dosya.getParentFile();
        if (ebeveyn != null && !ebeveyn.exists() && !ebeveyn.mkdirs()) {
            throw new IOException("Veri klasörü oluşturulamadı.");
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dosya))) {
            out.writeObject(veri);
        }
    }

    public Object yukle(String dosyaYolu) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(dosyaYolu))) {
            return in.readObject();
        }
    }

    public boolean dosyaVarMi(String dosyaYolu) {
        return new File(dosyaYolu).isFile();
    }
}
