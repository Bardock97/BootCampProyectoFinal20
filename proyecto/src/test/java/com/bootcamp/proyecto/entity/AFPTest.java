package com.bootcamp.proyecto.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AFPTest {

    @Test
    @DisplayName("probando test")

    void testAfp(){
        AFP afp = new AFP(1L,"INTEGRA");

        String dniEs = "INTEGRA";
        String dniOri = afp.getName();

        Assertions.assertEquals(dniEs,dniOri);
    }

}