package com.example.repositoryexercise.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {

    //ID :
    //Cannot be null
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //name :
    //Cannot be null
    //Length more than4
    @NotEmpty(message = "name can't be null")
    @Size(min = 5, message = "name must be at least 5 characters")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    //username :
    //Cannot be null
    //Length more than4
    //must be unique
    @NotEmpty(message = "username can't be null")
    @Size(min = 5, message = "username must be at least 5 characters")
    @Column(columnDefinition = "varchar(20) not null")
    //  @Unique = true
    private String username;
    //password :
    //Cannot be null
    @NotEmpty(message = "password can't be null")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String password;
    //email :
    //Cannot be null
    //must be valid email
    //must be unique
    @NotEmpty(message = "email can't be null")
    @Email
    @Column(columnDefinition = "varchar(50) not null unique")
    private String email;
    //role :
    //Cannot be null
    //must be user or admin only
    @NotEmpty(message = "role can't be null")
    @Pattern(regexp = "^(user|admin)$")
    @Column(columnDefinition = "varchar(7) not null")
    private String role;
    //age :
    //Cannot be null
    //must be integer
    @NotNull(message = "age can't be null")
    @Column(columnDefinition = "int not null")
    private Integer age;

}
