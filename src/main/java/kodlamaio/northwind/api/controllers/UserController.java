package kodlamaio.northwind.api.controllers;


import kodlamaio.northwind.business.abstracts.UserService;
import kodlamaio.northwind.core.entities.User;
import kodlamaio.northwind.core.utilities.results.ErrorDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(value="/api/users")
public class UserController {
    UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }




    @PostMapping("/add")   ///burada body olarak alacağı için komple nesenin kendisini parametre olarak verdik
    public ResponseEntity<?> add(@RequestBody User user){

        return ResponseEntity.ok( this.userService.add(user) );
    }


    //validation hataları: requered, not null, email vs (yine anotatinlar ile olur)
    //bu hatalar ExceptionHandler ile çözülür



    //burasının içi Spring validation paketinden gelir//pom.xml de tanımlandı
    @ExceptionHandler(MethodArgumentNotValidException.class)    //burası tipi vermek için!!
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String,String>();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()){
          validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
        return errors;
    }

    //sistemde MethodArgumentNotValidException türünden bir hata olursa






}
