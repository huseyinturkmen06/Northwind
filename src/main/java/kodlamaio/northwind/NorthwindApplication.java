package kodlamaio.northwind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EnableSwagger2
public class NorthwindApplication {

	public static void main(String[] args) {
		SpringApplication.run(NorthwindApplication.class, args);	//IoC Container a erişme kodu


	}

//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("northwind"))
//
//				.build();
//	}

 //ArrayList<String> e=new ArrayList<>();


	//Dependency Injection aslında IoC’nin implement edilmesini sağlayan bir pattern’dır





}
