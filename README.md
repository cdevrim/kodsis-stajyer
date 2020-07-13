**Mağaza Satış Takip Programı**

**Projenin çalıştırılması
run komutu: "clean install jetty:run"   
url: http://localhost:9091/kodsis-stajyer/giris.jsf

**Projeyi çalıştırmadan önce izlenecek adımlar
Projedeki database ve parametrik propertyler src/main/resources/project-config.properties dosyası içerisindedir.
maven komutlarını intellijidea içinde edit configuration'a maven komutu olarak ekleyebilirsiniz.

**Aşağıdaki sorgular ile manuel veritabanı , rol ,şema oluşturulur

CREATE ROLE stajyer LOGIN
  ENCRYPTED PASSWORD '1'
  SUPERUSER INHERIT CREATEDB CREATEROLE NOREPLICATION;
  
CREATE DATABASE stajyer
  WITH OWNER = stajyer
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
	   CONNECTION LIMIT = -1;

CREATE SCHEMA IF NOT EXISTS stajyer ;
	
Kullanıcı tablosunun ve verilerinin oluşturulması için aşağıdaki maven komutu çalıştırılarak db migrate olur
Oluştururacağınız diğer sorgular V3__1_migration.sql şeklinde isimlendirilerek(artan sırada versiyonlanarak)  src/main/resources/db/migration'a eklenir.
Db Migrate komutu = "compile flyway:migrate"


Projede yapısı
dao : Veritabanı ile ilgili tüm işler
domain : entity ve modeller
jsfbean : jsf bean
service  : iş mantıkları


web : arayüz 

web->jsfbean(domain)->service(dao,domain)

	      
	   
	   
	   