# VETERİNER PROJESİ
 <hr>
<br>

### Proje: Veteriner uygulaması
- Kullanıcı girişi ve kayıdı bulunmaktadır.
- Hayvan tanıtımı ( tür, cins, isim, yaş, açıklama ) yapılabiliyor.
- Hayvan Sahibi tanıtımı ( ad soyad, iletişim bilgileri, telefon,e-posta ) yapılabiliyor.
- Hayvan adı ya da hayvan sahibi adı üzerinden arama yapılabiliyor.
- Bir hayvan sahibine n adet hayvan tanımı yapılabiliyor
- Var olan bir kayıt üzerinde değişiklik yapılabiliyor
- Var olan kayıtlar listeleniyor
- Var olan bir kayıt silme işlemi yapılabiliyor
- Var olan bir kayıt güncelleme işlemi yapılabiliyor
- Kullanıcı rolüne bağlı olarak yetki işlemi vardır. Örneğin yalnızca 'Admin' kullanıcıları ekleme işlemi yapabilmektedir.
- Kullanıcı şifresi veritabanında hashlenerek tutulmaktadır.
- Sistemde kullanıcı rolü olarak sadece ADMIN ve USER bulunmaktadır.
- Veri giriş işlemlerinde validation kontrolü yapılmaktadır.


### Kullanılan teknolojiler:

- Spring boot, Java 1.8, Thymeleaf, Maven, Bootstrap, Spring Security, Mysql, Lombok, JPA
- Bootstrap: responsive tasarım için kullandım
- Lombok: Kodların sade ve okunabilir olması için kullandım
- Spring Security: Kullanıcı giriş ve yetkilendirmesi için kullandım. 
- Mysql: projedeki veritabanı. Bu veritanında bulunan kayıtlar üzerinden işlem yapılmaktadır.
- Thymeleaf extra: yetkilendirme işlemlerinde html sayfasında kontroller için kullanıldı.
- Proje OOP ve SOLID prensiplerine uygun şekilde yazılmıştır.


### EndPoints:
 - [GET] / => Kullanıcı giriş sayfası<br>
 - [GET] /users => Kullanıcıların listelendiği ve bilgilerin üzerinde işlem yapıldığı sayfa<br>
 - [GET] /owners => Hayvan sahiplerinin listelendiği ve bilgilerin üzerinde işlem yapıldığı sayfa<br>
 - [GET] /pets => Hayvanların listelendiği ve bilgilerin üzerinde işlem yapıldığı sayfa<br>
 - [GET] /search => Hayvan veya sahip ismi üzerinden arama işlemi yapılan sayfa<br>
 - [GET] /register => Kullanıcı kayıt sayfası<br>
 - [POST] /login =>Kullanıcı giriş işlemini yapan endpoint<br>
 - [POST] /register =>Kullanıcı kayıt işlemini yapan endpoint<br>
 - [POST] /addOwner =>Hayvan sahibi kayıt işlemini yapan endpoint<br>
 - [POST] /deleteOwner/{id} =>Hayvan sahibi silme işlemini yapan endpoint<br>
 - [POST] /updateOwner/{id} =>Hayvan sahibi güncelleme işlemini yapan endpoint<br>
 - [POST] /addPet =>Hayvan kayıt işlemini yapan endpoint<br>
 - [POST] /deletePet/{id} =>Hayvan silme işlemini yapan endpoint<br>
 - [POST] /updatePet/{id} =>Hayvan güncelleme işlemini yapan endpoint<br>
 - [POST] /addUser =>Kullanıcı kayıt işlemini yapan endpoint<br>
 - [POST] /deleteUser/{id} =>Kullanıcı silme işlemini yapan endpoint<br>
 - [POST] /updateUser/{id} =>Kullanıcı güncelleme işlemini yapan endpoint<br>
