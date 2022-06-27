package com.bootcamp.proyecto.controller;

import com.bootcamp.proyecto.entity.AFP;
import com.bootcamp.proyecto.entity.Association;
import com.bootcamp.proyecto.repository.AssociationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/association")
@Slf4j
public class AssociationController {

    @Autowired
    private AssociationRepository associationRepository;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    public String createAssociation(@RequestBody Association association) {

        Boolean exist = associationRepository.existsByClient(association.getClient());

        if (exist) {
            return  "El cliente ya cuenta con una AFP asociada.";

        } else {
            associationRepository.save(association);
            log.info("El cliente se registro satisfactoriamente.");
            return  "El cliente se registro satisfactoriamente.";
        }


    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Association> getAllAssociation(){
        log.info("Comienzo del listado de las Asociaciones:");
        return associationRepository.findAll();
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<Association> getAssociationID(@PathVariable(value = "id") Long id) {
        Optional<Association> association = associationRepository.findById(id);
        log.info("Comienzo del listado por ID de las Asociaciones:");
        if(association.isPresent()){
            log.info(association.toString());
            return new ResponseEntity<>(association.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(association.get(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public String deleteAssociation(@PathVariable(value = "id")Long id) {
        associationRepository.deleteById(id);
        log.info("Se eliminó la asociacion de manera satisfactoria.");
        return "Se eliminó la asociacion de manera satisfactoria";
    }

    @PutMapping("/actualizar/{id}")
    public Association updateAssociation(@RequestBody Association association, @PathVariable(value = "id") Long id){
        association.setId(id);
        log.info("Comienzo de la actualizacion de la asociacion a cambiar:");
        associationRepository.save(association);
        log.info("Se actualizo el registro de la asociacion de manera satisfactoria.");
        return association;
    }







}
