package kodlamaio.northwind.core.entities;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity   //veri tabanı nesnesi olmayı anlatır
@Data
@Table(name="users")

public class User {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Email   //email formatında olmak zorunda
    @NotBlank
    @NotNull
    @Column(name="email")
    private String email;

    @Column(name="password")
    @NotBlank
    @NotNull
    private String password;
}
