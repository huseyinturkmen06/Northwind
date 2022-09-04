//başarılı ve mesaj durumlarının yanında, hangi datayı gönderdğini de söyler

package kodlamaio.northwind.core.utilities.results;

public class DataResult<T> extends Result{


    ///burası çok önemli, --- <T> dönüş tipi verdik ve generic tip olmuş oldu,
    //şimdi data result T yerine her türlü veriyi alabilir



    //Constructor 1---------------------------------
    public DataResult(T data,Boolean success) {
        //***********************************************************
        //***********************************************************

        //burada T değeri generic olduğu için her türlü veri gelebilir
        //mesela ProeductController içinde "return this.productService.getAll()" verisi T tipindeki data verisi yerine gelir
        //***********************************************************
        //***********************************************************

        super(success);    //this success yerine super kullanıldı, Result class ındaki tek parametreli constructor kullanıldı
        this.data=data;
    }


    private T data;

    //Constructor 2  --------------------------------
    public DataResult(T data,Boolean success, String message) {
        super(success, message);   //data class ındaki 2 parametreli constructor kullanıldı
        this.data=data;
    }


    public T getData() {
        //burada return edilen data nın değeri T olduğu için getData değeri de T olmalı
        return this.data;
    }
}
