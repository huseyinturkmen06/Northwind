package kodlamaio.northwind.api.controllers;


//url ile sorgulama yaparken kullanıdığımız değişkenlerin hespsi burada kullanılan değişkenler

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api/products")       //dış dünyadan istek gelirsebu controller a gel demek
//@CrossOrigin   //js requests için
public class ProductsController {

//aynı service/repository/configuration…

    //ÖZET: Controllerdan bussiness'a, bussiness'dan data access'e , data access den de entity ye erişiyoruz



    //BURAYA DİKKAT!!!!!
    //ProductService interface inden oluşan referans, @Autowired anotasyonu ile otoamtikten ProductManager nesnesine eşitlenir
    //ve sonra ProductService refaransı ile eriştiğimiz tüm metodlar zaten ProductManager içinde yazan metodlar olur
    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    //!!!!!! Autowired: projetyi tarıyor, bakıyor kim ProductService'i imlemente etmiş bakıyor
    //ProductManager etmiş
    //ProductManager p = new ProductManager(); yapıyor
    //sonra p yi gelip bu üstteki constructor içerisine veriyor
    //özetle new yapmayı durdurmuş oluyoruz
    //birden fazla somut sınıf varsa (ProductManager  gibi ) Autowired patlar

    // (spring ) bean ile servis sınıfımızdan (product manager) bir nesne oluşturuyor ve Ioc Container (ProductDao ) içerisine atıyor
    //biz lazım oldukça bu objeyi kullanacağız


    @GetMapping("/getall")
    public DataResult<List<Product>> getAll(){

        return this.productService.getAll();
    }



    //*******************************************************  DTO dan gelen join tablosunun kolunları
    @GetMapping("/getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){

        return this.productService.getProductWithCategoryDetails();
    }




    //pagination************************************************
    @GetMapping("/getAllByPage")
    DataResult<List<Product>> getAll(int pageNo,int pageSize){
        return this.productService.getAll(pageNo-1,pageSize);
    }

    @GetMapping("/getAllDesc")
    public DataResult<List<Product>> getAllSorted(){
        return this.productService.getAllSorted();
    }






    @PostMapping("/add")
    public Result add(@RequestBody Product product){//burda kullanılan anotasyon ile bilgiler json objesine çevrilir
        //örneğin instagramda vs de böyle, tüm bilgiler bir araya konur ve gönderilir
        //RequestBody ile gönderilen bu bilgiler aslında bir producttır.
        //Porduct sınıfının tüm özelliklerini alıp bizim için bir product oluşturuyor ve
        //bu product aşağıda kullanıyotuz

        return this.productService.add(product);
    }
    //body ister


    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName){
        //RequestParam: yapılan isteğin parametrelerini oku v o parametrelere göre gerekli parametreyi getir
        return this.productService.getByProductName(productName);

    }
    //parametre ister


    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategoryId(@RequestParam String productName,@RequestParam int categoryId) {

        return this.productService.getByProductNameAndCategoryId(productName,categoryId);


    }

    @GetMapping("/getByProductNameOrCategoryId")
    public DataResult<List<Product>> getByProductNameOrCategoryId(@RequestParam String productName,@RequestParam  int categoryId){
        return this.productService.getByProductNameOrCategoryId(productName,categoryId);
    }


    @GetMapping("/getByCategoryIdIn")
    public DataResult<List<Product>> getByCategoryIdIn(@RequestParam List<Integer> categories){
        return this.productService.getByCategoryIdIn(categories);
    }


    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
        return this.productService.getByProductNameContains(productName);
    }


    @GetMapping("/getByProductNameStartsWith")
    public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam String productName){
        return this.productService.getByProductNameStartsWith(productName);
    }


    @GetMapping("/getByNameAndCategory")
    public DataResult<List<Product>> getByNameAndCategory(@RequestParam String productName,@RequestParam int categoryId){
        return this.productService.getByNameAndCategory(productName,categoryId);

    }

    //@RequestParam anotasyonu url deki değişkenleri alarak local değişkenimize verir








}
