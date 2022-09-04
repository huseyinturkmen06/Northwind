package kodlamaio.northwind.core.dataAccess;

import kodlamaio.northwind.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {


    //interface içindeki add metodunun kullandığı save metodu
    // zaten jpa dan hazır geldiği için burda önceden burada yazmaya gerek yok
    //ama özel jpql sorgularımızı burada yazacağız


    User findByEmail(String email);


}
