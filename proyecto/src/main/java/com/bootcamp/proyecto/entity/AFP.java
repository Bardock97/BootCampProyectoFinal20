package com.bootcamp.proyecto.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("afp")
@Data
@NoArgsConstructor
public class AFP {

    @Id
    private Long id;
    private String name;

    public AFP(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
