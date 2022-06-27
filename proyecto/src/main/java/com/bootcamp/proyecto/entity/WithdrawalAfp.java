package com.bootcamp.proyecto.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("withdrawalAfp")
@Data
@NoArgsConstructor
public class WithdrawalAfp {

    @Id
    private Long id;
    private double withdrawalAmount;
    private Association association;

}
