//jpa respository için bir intterface ekle
//buradaki tüm sorgular jpql sorguları ve database isimlerine göre değil, entity attribute isimlerine göre yazılır

package kodlamaio.northwind.dataAccess.abstracts;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {
    //hangi CLass a ve bağlı olduğu ve Primary key in değişken tip
    //@Entity anotasyonu ile süslenmiş veri tiği-class için  //primary key i int olduğu için Integer yazılır
    //qrute dediğimiz database e ekleme, silme, güncelleme işlemelri yapmamızı sağlar
    //her nesne için çalışabildiğinden generic bir yapıdır

    //burada JPA nın default'unda save, findall gibi gibi metodlar otomatik olarak vardır
    //ama biz sql sorgusu yazar gibi belli durumlara göre göre özelliklerini alalcaksank
    //veya yalnızca bazı productları çekeceksek,
    //sql deki sorgulara eşdeğer olan ve java ya özel olan bir syntax ile fonksiyon yazmalıyız




    //
    //Product içinde productname alanı var ama categoryıd yok, category var -- yani gategoryıd  yazmıyoruz

    Product getByProductName(String productName);



    Product getByProductNameAndCategory_CategoryId(String productName,int categoryId);
    //_CategoryId yazmamız gerekiyor ki hangi kolonla eşleştiği belli olsun


    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

    List<Product> getByCategory_CategoryIdIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);

    @Query("From Product where productName=:productName and category.categoryId=:categoryId")   //?????????????
    List<Product> getByNameAndCategory_CategoryId(String productName, int categoryId);
    //bu alanlar Product class ındaki değişken isimleri----database e göre değil yani
    //2. ler ise direkt fonksiyona gelen parametre simleri sanırım


    //select * from products where productName=x and categoryId=y


@Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto" +
        "(p.id, p.productName, c.categoryName) " +     //buralar ProductWithCategoryDto içine göre
        "From Category c Inner Join c.products p")
List<ProductWithCategoryDto> getProductWithCategoryDetails();

//jpa repository bizim için sorguyu çalıştırır ve sonucu List<ProductWithCategoryDto> kısmına atar













//önce ana tabloyu yaz
//önce nereye aktaracağız, sonra neyi aktaracağız
//tüm değil de belli özellikleri çektiimiz için alias ve slect kullanıyoruz
//AllArgsConstructor u çalıştırmak  için

    //liste değil de product dönderirsek en üstteki product ı getirir

    //select p.productID, p.productName,c.categoryName from Category c inner join Product p
    //on c.categoryId = p.categoryId

        //JPQL ve HQL :kullandığı argümanlar veritabanı tabloları yerine Entity nesneleridir.

























    //ProductMeanager içerisinde oluşan Bean buraya gelir
    //Ioc container


   // Product getByProductName(String productName){
        // get görünce tablolara bakar ve tablodaki ilgili koşula göre where koşulu
   // }


    //repositoru burası mı oldu???



//
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//













    //find all: filtreleme, sıralama, pagination (sayfalama)


}
