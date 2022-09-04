package kodlamaio.northwind.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity   //veri tabanı nesnesi olmayı anlatır
@Data
@AllArgsConstructor
@NoArgsConstructor   // ben ekeldim
@Table(name="categories")    //veri tabanı tablosu olmayı anlatır
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
//kategoriler içinde productlar, productlar  içinde de kategoriler olduğu için
//karşılıklı sorgu yapmaya çalışıyor süreklü ve , sonsuz döngüye giriyor
//bu anotation bu sıkıntıyı çözüyor


public class Category {

    @Id
    @Column(name="category_id")    //database deki isimler ile aynı olmasına dikkat et
    //generated value olmadı çünkü category ler otomatik artmaz

    private int categoryId;

    @Column(name="category_name")
    private String categoryName;



    //jpa hybernate implementasyonu yapmış oluruz


    //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    @OneToMany(mappedBy = "category",fetch=FetchType.LAZY )    //burdan kategorilere one to many //1 kategori birden falaz product a gideblilir
    private List<Product> products;  //kategori birden fazla product alacağı için liste olarak alır

//    //öteki tarafta bu class dan türettiğimiz category nesnesini buraya bağlamışş oluyoruz
//
//    //hoca kategories yazdı ama???


    //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$




    //burası çalışmadı (üst taraf) ???????????????*!!!!!!!!!!!





}
