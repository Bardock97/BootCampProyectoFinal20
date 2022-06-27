package com.bootcamp.proyecto.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document("association")
@Data
@NoArgsConstructor
public class Association {

    @Id
    private Long id;
    private String  accountNumber;
    private double availableAmount;
    private Date dateWithdrawal;
    private Client client;
    private AFP afp;

}
