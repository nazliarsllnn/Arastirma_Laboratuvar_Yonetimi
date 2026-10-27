# Üniversite Araştırma ve Laboratuvar Yönetimi Sistemi

Java 17 ile hazırlanmış, konsol üzerinden çalışan örnek bir Nesneye Yönelik Programlama projesidir.

## Özellikler
- Araştırma projesi ve araştırmacı kaydı
- Laboratuvar ve cihaz kaydı
- Cihaz rezervasyonu oluşturma ve zaman çakışması kontrolü
- Proje bütçesi ve harcama takibi
- Görev ekleme ve tamamlama
- Verileri dosyaya kaydetme ve program açıldığında yükleme
- Strategy ve Factory tasarım kalıplarına örnekler
- JUnit 5 ile birim testleri

## Gereksinimler
- JDK 17 veya üstü
- IntelliJ IDEA
- Maven (IntelliJ, `pom.xml` dosyasını açınca projeyi Maven olarak tanıyabilir)

## IntelliJ IDEA'da açma
1. ZIP dosyasını bilgisayarında bir klasöre çıkar.
2. IntelliJ IDEA'yı aç.
3. **Open** seçeneğine tıkla ve çıkarılan `Arastirma_Laboratuvar_Yonetimi` klasörünü seç.
4. `pom.xml` için Maven projesi olarak yükleme/Load Maven Project bildirimi çıkarsa onayla.
5. JDK olarak 17 veya üstünü seç.
6. `src/main/java/tr/edu/proje/Main.java` dosyasını aç.
7. `main` metodunun yanındaki yeşil çalıştırma simgesine bas.

Alternatif olarak IntelliJ içindeki Maven penceresinden `test` görevini çalıştırabilirsin.

## Konsol menüsü
Program açılınca numaralı menü gösterilir. İlk kullanımda örnek veri ekleyebilir veya menüden kendi kayıtlarını girebilirsin. Veriler proje klasöründeki `data/uygulama-verisi.dat` dosyasına kaydedilir.

## Sınıfların kısa açıklaması
- `Personel`: Ortak personel bilgilerini içeren soyut sınıf.
- `Arastirmaci`: Personel sınıfından türeyen araştırmacı.
- `ArastirmaProjesi`: Proje ve bütçe bilgileri.
- `Laboratuvar`: Laboratuvar bilgileri ve cihaz listesi.
- `Cihaz`: Laboratuvar cihazı ve müsaitlik bilgisi.
- `Rezervasyon`: Cihazın başlangıç/bitiş tarihleri.
- `Gorev`: Proje görevi ve tamamlanma durumu.
- `ButceYonetimi`: Harcama ve kalan bütçe işlemleri.
- `KaynakPlanlayici`: Uygun cihazları bulmaya yardımcı olur.
- `VeriYoneticisi`: Serileştirme ile kalıcı kayıt.
- `RezervasyonStratejisi` / `IlkUygunCihazStratejisi`: Strategy örneği.
- `ProjeFabrikasi`: Factory örneği.

## SOLID örnekleri
- **SRP:** Bütçe, kayıt, rezervasyon ve proje yönetimi farklı sınıflardadır.
- **OCP:** Yeni rezervasyon stratejileri `RezervasyonStratejisi` arayüzünü uygulayarak eklenebilir.
- **LSP:** `Arastirmaci`, `Personel` yerine kullanılabilir.
- **DIP:** `KaynakPlanlayici`, somut strateji sınıfı yerine `RezervasyonStratejisi` arayüzüne bağlıdır.

## Tasarım kalıpları
- **Strategy:** Rezervasyon için uygun cihazı seçme stratejisi değiştirilebilir.
- **Factory:** `ProjeFabrikasi`, araştırma projesi oluşturmayı tek noktada toplar.

## Algoritma
Rezervasyon servisi, aynı cihazın mevcut rezervasyonlarıyla yeni rezervasyonun zaman aralıklarını karşılaştırır. Aralıklar çakışıyorsa rezervasyon reddedilir. Bitiş zamanı, sonraki rezervasyonun başlangıç zamanına eşitse çakışma sayılmaz.

## Teslimden önce
- `proje_takimi.txt` içindeki takım bilgilerini gerçek bilgilerinizle doldurun.
- Kendi bilgisayarınızda programı çalıştırın ve bütün testlerin geçtiğini doğrulayın.
- GitHub deposunu public yapın ve kaynak kodlarını yükleyin.
- UML diyagramını gözden geçirip hocanızın beklediği biçimde teslim edin.
- Sunum videosunu en fazla 10 dakika olacak şekilde kaydedin.
