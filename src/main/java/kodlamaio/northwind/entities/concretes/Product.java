//POJO CLASS
//İçinde temel olarak atttribute ler, getter, setter ve constructor bulunan class


package kodlamaio.northwind.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data      //lombock kullanmış olduk ve getter, setter yazmaya gerek kalmadı
@Entity
@Table(name="products")
@AllArgsConstructor
@NoArgsConstructor
public class Product {




    //buradaki isimler veri tabanlarındaki isimler ile aynı olmak zorunda  [(name=" ") olan kısımlar yani ]
    //bu yüzden farklı db ler ile çalışırken hepsinde aynı isimleri kullan

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //oracle için sequence
    @Column(name="product_id")
    private int id;

//    @Column(name="category_id")
//    private int categoryId;

    @Column(name="product_name")
    private String productName;
    @Column(name="unit_price")
    private double unitPrice;

    @Column(name="units_in_stock")
    private short unitsInStock;

    @Column(name="quantity_per_unit")
    private String quantityPerUnit;

    //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
    @ManyToOne()       //birden fazla product aynı kategoriye ait olabilir
    @JoinColumn(name = "category_id")    //bşrleştirği diğer class (tablo daki category_id attrube ünü verdik, ordan gelir  )
    private Category category;   //kiminle bağlantı kuracaksan ondan nesne olşutr, burası doğru
                                 //kategori içindeki category_id ile mi birleşti????*
    //buradaki category öteki class dan türemeleri ve burada foreign key olmalı

    //Category de product ile ilgili bir bilgi yok ama product içinde kategory den olan bir bilgi var (category_id)
    //bu yüzden Product ı category_id kolonuna göre categoty ye join yapıyoruz
    //en üstteki category_id ortadan kalmış oldu (alta geldi)


    //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$


















    public Category getCategory() {     //Category de data anotasyonnuna sahip olduğu için get ve set gelir
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    //dışarıdan gelen anahtarların getter ve setterlarını yazıyoruz



//    @ManyToOne()
//    @JoinColumn(name="category_id")
//    private Category categories;



//    public Category getCategories() {
//        return categories;
//    }
//
//    public void setCategories(Category categories) {
//        this.categories = categories;
//    }
























    //    public Product(int id, int categoryId, String productName, double unitPrice, short unitsInStock, String quantityPerUnit) {
//        this.id = id;
//        this.categoryId = categoryId;
//        this.productName = productName;
//        this.unitPrice = unitPrice;
//        this.unitsInStock = unitsInStock;
//        this.quantityPerUnit = quantityPerUnit;
//    }
//
//
//    public Product() {
//        //burayı oluşturman istedi ama neden alnlamadım
//    }











}
