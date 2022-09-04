package kodlamaio.northwind.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T> {

    public SuccessDataResult(T data, String message) {
        super(data, true,message);
    }

    public SuccessDataResult(T data) {
        super(data, true);
    }


    public SuccessDataResult(String mesage) {
        super(null, true,mesage);
    }

    public SuccessDataResult() {
        super(null, true);
    }




}
