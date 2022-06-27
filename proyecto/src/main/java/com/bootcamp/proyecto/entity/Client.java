package com.bootcamp.proyecto.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("client")
@Data
@NoArgsConstructor
public class Client {

    @Id
    private long id;
    private String name;
    private String lastName;
    private String dni;
    private String phone;
    private String email;

    public Client(long id, String name, String lastName, String dni, String phone, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.phone = phone;
        this.email = email;
    }
}
