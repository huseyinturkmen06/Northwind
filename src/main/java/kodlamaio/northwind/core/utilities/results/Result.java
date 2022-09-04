//yalnızca başarılı ve mesaj bilgisi gönderir


package kodlamaio.northwind.core.utilities.results;

public class Result {
    private boolean success;
    private String message;

    public Result(Boolean success){
    this.success=success;
    }


    public Result(Boolean success,String message){
        this(success);     //üstteki constructor kullanıldı//tek satır bile olsa kendini tekrar etme
        this.success=success;
    }


    public boolean isSuccess() {     //neden get değil de is ???

                                //sanırım bool türünden değerlerin getter metodu is diye yazılıyor
        return this.success;
    }



    public String getMessage() {
        return this.message;
    }


}
