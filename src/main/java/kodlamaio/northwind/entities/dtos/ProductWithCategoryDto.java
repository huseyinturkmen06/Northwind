//dto özet
//bizim nasıl her tablo için başında entity olan bir class ımız varsa (category ve product)
//bu tablolardaki bazı kolonları alıp join yapınca da yeni bir tablo oluşur
//biz bu join işlemleri ile oluşan her bir tablo için dto içinde yeni bir class oluştururuz ve başlarına @Entity koyarız
//bu sayede eldeki tablolardan yeni tablolar oluşturmuş oluruz


package kodlamaio.northwind.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   //getter ve setterlar oluşturuldu
@AllArgsConstructor
@NoArgsConstructor

public class ProductWithCategoryDto {

    private int id;
    private String productName;

    private String categoryName;


}
