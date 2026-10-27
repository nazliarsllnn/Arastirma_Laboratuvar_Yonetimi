# Üniversite Araştırma ve Laboratuvar Yönetimi Sistemi

## 1. Proje Hakkında

Bu proje, üniversitelerde yürütülen araştırma projelerinin, araştırmacıların, laboratuvarların, cihazların, görevlerin ve bütçelerin yönetilmesini sağlayan Java tabanlı bir konsol uygulamasıdır.

Uygulama, Nesne Yönelimli Programlama (NYP) prensipleri kullanılarak geliştirilmiştir. Projede kalıtım, soyutlama, çok biçimlilik ve kapsülleme gibi nesne yönelimli programlama kavramlarının yanı sıra SOLID prensipleri ve tasarım kalıpları uygulanmıştır.

## 2. Projenin Amaçları

* Araştırma projelerinin ve araştırmacı kayıtlarının yönetilmesi.
* Laboratuvar ve cihaz bilgilerinin tutulması.
* Cihaz rezervasyonlarının oluşturulması ve zaman çakışmalarının kontrol edilmesi.
* Proje bütçelerinin ve harcamaların takip edilmesi.
* Proje görevlerinin oluşturulması ve tamamlanma durumlarının izlenmesi.
* Verilerin kalıcı olarak saklanması ve program yeniden açıldığında yüklenmesi.

## 3. Kullanılan Teknolojiler

* **Programlama dili:** Java 17
* **Geliştirme ortamı:** IntelliJ IDEA
* **Proje yönetimi:** Maven
* **Test aracı:** JUnit 5
* **Versiyon kontrolü:** Git ve GitHub

## 4. Uygulamanın Özellikleri

* Araştırmacı ve araştırma projesi kayıt işlemleri
* Laboratuvar ve cihaz yönetimi
* Cihaz rezervasyonu oluşturma
* Rezervasyonlarda zaman çakışması kontrolü
* Proje bütçesi ve harcama takibi
* Görev ekleme ve tamamlama işlemleri
* Verilerin dosyaya kaydedilmesi ve yeniden yüklenmesi
* Konsol üzerinden menü tabanlı kullanım

## 5. Nesne Yönelimli Programlama

Projede aşağıdaki nesne yönelimli programlama kavramlarından yararlanılmıştır:

* **Kapsülleme (Encapsulation):** Sınıfların verileri ve bu verilere erişim sağlayan metotlar kullanılarak veri bütünlüğünün korunması.
* **Kalıtım (Inheritance):** Araştırmacı gibi alt sınıfların ortak personel özelliklerinden yararlanması.
* **Soyutlama (Abstraction):** Ortak özelliklerin ve davranışların soyut sınıflar veya arayüzler aracılığıyla modellenmesi.
* **Çok Biçimlilik (Polymorphism):** Ortak arayüzler üzerinden farklı uygulamaların kullanılabilmesi.

## 6. SOLID Prensipleri

Projede aşağıdaki SOLID prensiplerine örnekler bulunmaktadır:

* **SRP – Single Responsibility Principle:** Bütçe, veri yönetimi, rezervasyon ve proje işlemlerinin farklı sınıflarda ele alınması.
* **OCP – Open/Closed Principle:** Rezervasyon stratejilerinin ortak bir arayüz üzerinden genişletilebilmesi.
* **LSP – Liskov Substitution Principle:** Alt sınıfların uygun durumlarda üst sınıflarının yerine kullanılabilmesi.
* **DIP – Dependency Inversion Principle:** Rezervasyon stratejisi gibi soyutlamalara bağımlı tasarım yapılması.

## 7. Kullanılan Tasarım Kalıpları

### Strategy Pattern

Rezervasyon sırasında uygun cihazın seçilmesi için farklı stratejilerin kullanılabilmesini sağlar. Yeni stratejiler ortak arayüz üzerinden sisteme eklenebilir.

### Factory Pattern

Araştırma projesi oluşturma işleminin `ProjeFabrikasi` sınıfı üzerinden gerçekleştirilmesini sağlar.

## 8. Proje Sınıfları

Projede bulunan temel sınıflardan bazıları şunlardır:

* `Personel`: Personel bilgilerini temsil eden temel sınıf.
* `Arastirmaci`: Araştırmacı bilgilerini temsil eder.
* `ArastirmaProjesi`: Araştırma projesi ve bütçe bilgilerini yönetir.
* `Laboratuvar`: Laboratuvar bilgilerini ve cihaz listesini tutar.
* `Cihaz`: Laboratuvar cihazlarına ait bilgileri temsil eder.
* `Rezervasyon`: Cihaz rezervasyonlarının başlangıç ve bitiş zamanlarını tutar.
* `Gorev`: Proje görevlerini ve tamamlanma durumlarını yönetir.
* `ButceYonetimi`: Harcama ve kalan bütçe işlemlerini gerçekleştirir.
* `KaynakPlanlayici`: Uygun cihazların belirlenmesine yardımcı olur.
* `VeriYoneticisi`: Verilerin dosyaya kaydedilmesi ve yeniden yüklenmesi işlemlerini yürütür.
* `RezervasyonStratejisi`: Rezervasyon stratejileri için ortak arayüz sağlar.
* `ProjeFabrikasi`: Araştırma projesi oluşturma işlemlerini yönetir.

## 9. Kurulum ve Çalıştırma

### Gereksinimler

* JDK 17 veya üzeri
* IntelliJ IDEA
* Maven

## 10. Veri Saklama

Uygulamada oluşturulan kayıtlar dosya tabanlı kalıcı saklama mekanizmasıyla yönetilir. Program yeniden başlatıldığında daha önce kaydedilmiş veriler yüklenebilir.

## 11. Testler

Projede JUnit 5 kullanılarak birim testleri hazırlanmıştır.

Testleri çalıştırmak için IntelliJ IDEA içerisindeki Maven araçlarından `test` görevi çalıştırılabilir. Alternatif olarak proje klasöründe aşağıdaki komut kullanılabilir:

```bash
mvn test
```

Testlerin başarılı olması, ilgili işlevlerin beklenen sonuçları verdiğini doğrulamaya yardımcı olur.

## 12. UML Diyagramı

Projede sınıflar arasındaki ilişkileri, kalıtımı ve yapısal düzeni göstermek amacıyla UML sınıf diyagramı hazırlanmıştır.

UML diyagramı `UML.md` dosyasında bulunmaktadır.

## 13. Proje Ekibi

Proje ekibindeki üyelerin adları, soyadları, öğrenci numaraları ve görevleri `proje_takimi.txt` dosyasında belirtilmiştir.

## 14. Sonuç

Bu proje kapsamında araştırma projelerinin, laboratuvarların, cihazların, rezervasyonların, görevlerin ve bütçelerin yönetilmesine yönelik nesne yönelimli bir yazılım geliştirilmiştir.

Proje sayesinde Java ile nesne yönelimli programlama, SOLID prensipleri, tasarım kalıpları, dosya tabanlı veri saklama ve birim testleri konularında uygulama yapılmıştır.
