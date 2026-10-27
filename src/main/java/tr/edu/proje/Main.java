package tr.edu.proje;

import tr.edu.proje.factory.ProjeFabrikasi;
import tr.edu.proje.model.*;
import tr.edu.proje.service.*;
import tr.edu.proje.strategy.IlkUygunCihazStratejisi;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    private static final String VERI_DOSYASI = "data/uygulama-verisi.dat";
    private static final Scanner scanner = new Scanner(System.in);

    private static final List<Laboratuvar> laboratuvarlar = new ArrayList<>();
    private static final List<Arastirmaci> arastirmacilar = new ArrayList<>();
    private static final List<ArastirmaProjesi> projeler = new ArrayList<>();
    private static final List<Rezervasyon> rezervasyonlar = new ArrayList<>();

    private static final VeriYoneticisi veriYoneticisi = new VeriYoneticisi();
    private static final RezervasyonServisi rezervasyonServisi = new RezervasyonServisi();
    private static final ProjeFabrikasi projeFabrikasi = new ProjeFabrikasi();

    public static void main(String[] args) {
        verileriYukle();
        boolean devam = true;
        while (devam) {
            menuGoster();
            String secim = scanner.nextLine().trim();
            try {
                switch (secim) {
                    case "1" -> laboratuvarEkle();
                    case "2" -> cihazEkle();
                    case "3" -> arastirmaciEkle();
                    case "4" -> projeEkle();
                    case "5" -> gorevEkle();
                    case "6" -> rezervasyonYap();
                    case "7" -> harcamaYap();
                    case "8" -> kayitlariGoster();
                    case "9" -> verileriKaydet();
                    case "0" -> {
                        verileriKaydet();
                        devam = false;
                        System.out.println("Veriler kaydedildi. Program kapatılıyor.");
                    }
                    default -> System.out.println("Geçersiz seçim. Tekrar deneyin.");
                }
            } catch (IllegalArgumentException | IllegalStateException ex) {
                System.out.println("İşlem yapılamadı: " + ex.getMessage());
            } catch (IOException ex) {
                System.out.println("Dosya işlemi hatası: " + ex.getMessage());
            }
        }
    }

    private static void menuGoster() {
        System.out.println("\n===== ÜNİVERSİTE ARAŞTIRMA VE LABORATUVAR YÖNETİMİ =====");
        System.out.println("1. Laboratuvar ekle");
        System.out.println("2. Laboratuvara cihaz ekle");
        System.out.println("3. Araştırmacı ekle");
        System.out.println("4. Araştırma projesi ekle");
        System.out.println("5. Projeye görev ekle");
        System.out.println("6. Cihaz rezervasyonu yap");
        System.out.println("7. Projeye harcama ekle");
        System.out.println("8. Kayıtları görüntüle");
        System.out.println("9. Verileri kaydet");
        System.out.println("0. Kaydet ve çık");
        System.out.print("Seçiminiz: ");
    }

    private static void laboratuvarEkle() {
        System.out.print("Laboratuvar kodu: ");
        String kod = scanner.nextLine().trim();
        System.out.print("Laboratuvar adı: ");
        String ad = scanner.nextLine().trim();
        System.out.print("Kapasite: ");
        int kapasite = Integer.parseInt(scanner.nextLine().trim());
        laboratuvarlar.add(new Laboratuvar(kod, ad, kapasite));
        System.out.println("Laboratuvar eklendi.");
    }

    private static void cihazEkle() {
        if (laboratuvarlar.isEmpty()) {
            System.out.println("Önce laboratuvar eklemelisiniz.");
            return;
        }
        laboratuvarlariGoster();
        System.out.print("Cihaz eklenecek laboratuvarın kodu: ");
        String labKodu = scanner.nextLine().trim();
        Laboratuvar lab = laboratuvarlar.stream()
                .filter(l -> l.getKod().equalsIgnoreCase(labKodu)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Laboratuvar bulunamadı."));
        System.out.print("Cihaz kodu: ");
        String kod = scanner.nextLine().trim();
        System.out.print("Cihaz adı: ");
        String ad = scanner.nextLine().trim();
        lab.cihazEkle(new Cihaz(kod, ad));
        System.out.println("Cihaz eklendi.");
    }

    private static void arastirmaciEkle() {
        System.out.print("Ad: ");
        String ad = scanner.nextLine().trim();
        System.out.print("Soyad: ");
        String soyad = scanner.nextLine().trim();
        System.out.print("Uzmanlık alanı: ");
        String uzmanlik = scanner.nextLine().trim();
        arastirmacilar.add(new Arastirmaci(ad, soyad, uzmanlik));
        System.out.println("Araştırmacı eklendi.");
    }

    private static void projeEkle() {
        System.out.print("Proje kodu: ");
        String kod = scanner.nextLine().trim();
        System.out.print("Proje adı: ");
        String ad = scanner.nextLine().trim();
        System.out.print("Başlangıç bütçesi (TL): ");
        double butce = Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
        projeler.add(projeFabrikasi.projeOlustur(kod, ad, butce));
        System.out.println("Araştırma projesi eklendi.");
    }

    private static void gorevEkle() {
        ArastirmaProjesi proje = projeSec();
        if (proje == null) return;
        System.out.print("Görev açıklaması: ");
        proje.gorevEkle(new Gorev(scanner.nextLine().trim()));
        System.out.println("Görev eklendi.");
    }

    private static void rezervasyonYap() {
        List<Cihaz> tumCihazlar = laboratuvarlar.stream()
                .flatMap(l -> l.getCihazlar().stream()).toList();
        if (tumCihazlar.isEmpty()) {
            System.out.println("Önce laboratuvar ve cihaz eklemelisiniz.");
            return;
        }
        System.out.println("Cihazlar:");
        tumCihazlar.forEach(System.out::println);
        KaynakPlanlayici planlayici = new KaynakPlanlayici(new IlkUygunCihazStratejisi());
        Cihaz onerilen = planlayici.cihazSec(tumCihazlar);
        System.out.println("Örnek stratejinin ilk önerisi: " + onerilen);
        System.out.print("Rezervasyon yapılacak cihaz kodu: ");
        String cihazKodu = scanner.nextLine().trim();
        System.out.print("Proje kodu: ");
        String projeKodu = scanner.nextLine().trim();
        System.out.print("Başlangıç tarihi ve saati (YYYY-AA-GG SS:DD): ");
        LocalDateTime baslangic = LocalDateTime.parse(scanner.nextLine().trim().replace(' ', 'T'));
        System.out.print("Bitiş tarihi ve saati (YYYY-AA-GG SS:DD): ");
        LocalDateTime bitis = LocalDateTime.parse(scanner.nextLine().trim().replace(' ', 'T'));
        Rezervasyon r = new Rezervasyon(cihazKodu, projeKodu, baslangic, bitis);
        rezervasyonServisi.rezervasyonEkle(r);
        rezervasyonlar.add(r);
        System.out.println("Rezervasyon oluşturuldu.");
    }

    private static void harcamaYap() {
        ArastirmaProjesi proje = projeSec();
        if (proje == null) return;
        System.out.print("Harcama tutarı (TL): ");
        double tutar = Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
        new ButceYonetimi().harcamaYap(proje, tutar);
        System.out.println("Harcama kaydedildi. Kalan bütçe: " + proje.kalanButce() + " TL");
    }

    private static ArastirmaProjesi projeSec() {
        if (projeler.isEmpty()) {
            System.out.println("Önce araştırma projesi eklemelisiniz.");
            return null;
        }
        projeler.forEach(System.out::println);
        System.out.print("Proje kodu: ");
        String kod = scanner.nextLine().trim();
        return projeler.stream().filter(p -> p.getKod().equalsIgnoreCase(kod))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Proje bulunamadı."));
    }

    private static void kayitlariGoster() {
        System.out.println("\n--- LABORATUVARLAR ---");
        if (laboratuvarlar.isEmpty()) System.out.println("Kayıt yok.");
        laboratuvarlar.forEach(System.out::println);
        System.out.println("\n--- ARAŞTIRMACILAR ---");
        if (arastirmacilar.isEmpty()) System.out.println("Kayıt yok.");
        arastirmacilar.forEach(a -> System.out.println(a.bilgiGetir()));
        System.out.println("\n--- PROJELER ---");
        if (projeler.isEmpty()) System.out.println("Kayıt yok.");
        projeler.forEach(p -> {
            System.out.println(p);
            p.getGorevler().forEach(System.out::println);
        });
        System.out.println("\n--- REZERVASYONLAR ---");
        if (rezervasyonlar.isEmpty()) System.out.println("Kayıt yok.");
        rezervasyonlar.forEach(System.out::println);
    }

    private static void laboratuvarlariGoster() {
        laboratuvarlar.forEach(System.out::println);
    }

    private static void verileriKaydet() throws IOException {
        Map<String, Object> veri = new LinkedHashMap<>();
        veri.put("laboratuvarlar", laboratuvarlar);
        veri.put("arastirmacilar", arastirmacilar);
        veri.put("projeler", projeler);
        veri.put("rezervasyonlar", rezervasyonlar);
        veriYoneticisi.kaydet(veri, VERI_DOSYASI);
        System.out.println("Veriler kaydedildi.");
    }

    @SuppressWarnings("unchecked")
    private static void verileriYukle() {
        if (!veriYoneticisi.dosyaVarMi(VERI_DOSYASI)) return;
        try {
            Object nesne = veriYoneticisi.yukle(VERI_DOSYASI);
            Map<String, Object> veri = (Map<String, Object>) nesne;
            laboratuvarlar.addAll((List<Laboratuvar>) veri.getOrDefault("laboratuvarlar", List.of()));
            arastirmacilar.addAll((List<Arastirmaci>) veri.getOrDefault("arastirmacilar", List.of()));
            projeler.addAll((List<ArastirmaProjesi>) veri.getOrDefault("projeler", List.of()));
            rezervasyonlar.addAll((List<Rezervasyon>) veri.getOrDefault("rezervasyonlar", List.of()));
            rezervasyonServisi.yuklenenleriEkle(rezervasyonlar);
            System.out.println("Kayıtlı veriler yüklendi.");
        } catch (IOException | ClassNotFoundException | ClassCastException ex) {
            System.out.println("Kayıtlı veriler yüklenemedi: " + ex.getMessage());
        }
    }
}
