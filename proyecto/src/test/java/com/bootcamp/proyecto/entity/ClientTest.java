package com.bootcamp.proyecto.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    @DisplayName("probando data del cliente")

    void testCustomer(){
        Client client = new Client(1,"Oscar","Cifuentes","70384757","99666333","oscar@hotmail.com");

        String dniEs = "70384757";
        String dniOri = client.getDni();

        Assertions.assertEquals(dniEs,dniOri);
    }

}