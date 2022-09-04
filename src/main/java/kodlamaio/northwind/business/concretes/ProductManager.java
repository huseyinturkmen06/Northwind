package kodlamaio.northwind.business.concretes;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.domain.Pageable;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;


//ssevis sınıfı


@Service   //bu class projede servis görevi görecek,, bussiness katmanının oluşturacak demektir
//bean oluşacak

public class ProductManager implements ProductService {

    private ProductDao productDao;    //veriye erişen ProductDao Class ına erişmemiz gerekiyor

    //product dao injection u yapıldı
    //product dao da(interface) jparepository(interface) ye gidiyor
    //burda bir class yok
    //sring arka planda spring bir repository class ı oluşturuyor
    //bi tane instance oluşturuyor ve o instance yi buraya verecek
    //Spring arka planda Product dao nun instance si olabilecek bir class üretiyor ve onu veriyor
    // @Autowired   sayesinde

    @Autowired   //constructor injection  (direkt attribute den önce yazarsan --- field injection)
    //bu anatosyon direk olarak ProdutDao nunbaşına da yazılablirdi ama ondan başkası da gelebilir diye
    //constractor un başına yazıldı
    //böylece hepsini kapsamış oldu
    //javada bu anotasyon olmazsa olmaz!!!!!!!!!!!!!!!!!!


    //CONSTRUCTOR INJECTION
    //BİR BAĞIMLILIĞI CONSTRUCTOR ÜZERİNDEN ENJEKTE ETMEK
    public ProductManager(ProductDao productDao) {
       // super();                                 /// neden super yazıyoruz????
        this.productDao = productDao; ///********************************CONSTRUCTOR INJECTION için Repository sınıfını private olrak tanımla

    }
    //autowirred sayesinde product dao otomatik olarak new leniyor ve buradaki constructora veriliyor

    @Override
    public DataResult<List<Product>> getAll() {

        return new SuccessDataResult<List<Product>>
                (this.productDao.findAll() , "Data Listelendi");    //jpa dan gelen findall() fonksiyonunu kullandık


        //Product dao içindeki JPA dan gelen gelen nesnenin tüm özelliklerini döndürür

        //product Dao jpa repository den inherite ettiği için,
        //her türlü veri tabanı işlemi hazır fonksiyonları içinde bulunur


        //sanrım this burada productları işaret ediyor

        //success verisi zaten SuccessDataResult da defeult olduğu için onu yazmaya gerek yok
        //constructor içine sırayla data ve Strin message  yolladık
                 //tümd dataları getirir//parametre vermezsek
    }


    //pagination
    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        return new SuccessDataResult<List<Product>> (this.productDao.findAll(pageable).getContent());
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort=Sort.by(Sort.Direction.DESC,"productName");
        return new SuccessDataResult<List<Product>> ( this.productDao.findAll(sort),"Başarılı");

        //neden new???
    }


    @Override
    public Result add(Product product) {
        this.productDao.save(product);

        return new SuccessResult("Ürün eklendi");
    }

    //************************ product dao içinde kendi yazdıklarımızı override etme---
    //**************************************************************************************
    //**************************************************************************************
    //**************************************************************************************




    @Override
    public DataResult<Product> getByProductName( String productName) {
        return new SuccessDataResult<Product>
                (this.productDao.getByProductName(productName) , "Data Listelendi");
    }
    //Dao dan gelen getByProductName metodunu burda çağırıyoruz ve içine kendi fonksiyonumuzdan parametre veriyoruz



    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {

        //bussiness codes here

        return new SuccessDataResult<Product>
                (this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId) , "Data Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByProductNameOrCategory_CategoryId(productName,categoryId) , "Data Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByCategory_CategoryIdIn(categories) , "Data Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByProductNameContains(productName) , "Data Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByProductNameStartsWith(productName) , "Data Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByNameAndCategory_CategoryId(productName,categoryId) , "Data Listelendi");
    }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return new SuccessDataResult<List<ProductWithCategoryDto>>
                (this.productDao.getProductWithCategoryDetails(),"Data Listelendi");
    }


//**************************************************************************************
























}
