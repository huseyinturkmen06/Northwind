package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

import java.util.List;

public interface ProductService {

//    List<Product> getAll();

    //ilk 2 yapıyı zaten biz (findall ve save) JPA repository nin default yapsıından kullanıyoruduk

    public DataResult<List<Product>>  getAll();     //Product sınıfından elemanlar ve özellikleri liste olarak gelecek

    public DataResult<List<Product>>  getAll(int pageNo,int pageSize);


    public DataResult<List<Product>>  getAllSorted();

    Result add(Product product);

    //direkt olarak List<Product> göndermek yerine, bunu Data result a 1. parametre olarak veriyoruz ve
    //yanında success, message gibi bilgiler de gönderiyoruz

    //sınırlamalar ve kurallar burada belirlenir
    //içerikleri ProductManager içinde yazılır

    //üsttekiler JPA repository default metodlarıydı

 //*********************************şimdi kendi yazdıklarımızı kullanalım



    DataResult<Product> getByProductName(String productName);

    DataResult<Product> getByProductNameAndCategoryId(String productName,int categoryId);

    DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);

    DataResult<List<Product>> getByProductNameContains(String productName);

    DataResult<List<Product>> getByProductNameStartsWith(String productName);

    DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);


    //+++++++++++++++++++++++++++++++++++++++++++++++++
    // ++++++++++++++++++++++++++++++++++++++++

    DataResult< List<ProductWithCategoryDto> > getProductWithCategoryDetails();




















}
