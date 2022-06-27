package com.bootcamp.proyecto.controller;

import com.bootcamp.proyecto.entity.AFP;
import com.bootcamp.proyecto.repository.AfpRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/afp")
@Slf4j
public class AfpController {

    @Autowired
    private AfpRepository afpRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AFP> getAllAfp(){
        List<AFP> response = afpRepository.findAll();
        log.info("Comienzo del listado de las afp:");
        log.info(response.toString());
        return response;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createAfp(@RequestBody AFP afp){
        afpRepository.save(afp);
        log.info("Se registraron los datos de la AFP satisfactoriamente");
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<AFP> getAfpID(@PathVariable(value = "id") Long id) {
        Optional<AFP> afp = afpRepository.findById(id);
        log.info("Comienzo del listado por ID de las afp:");
        if(afp.isPresent()){
            log.info(afp.toString());
            return new ResponseEntity<>(afp.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(afp.get(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public String deleteAfp(@PathVariable(value = "id")Long id) {
        log.info("Comienzo del borrado de la afp:");
        afpRepository.deleteById(id);
        log.info("Se eliminó la afp de manera satisfactoriamente");
        return "Se eliminó la afp de manera satisfactoria.";
    }

    @PutMapping("/actualizar/{id}")
    public AFP updateAfp(@RequestBody AFP afp, @PathVariable(value = "id") Long id){
        afp.setId(id);
        log.info("Comienzo de la actualizacion del registro de las afp:");
        afpRepository.save(afp);
        log.info("Se actualizo la informacion de manera satisfactoria.");
        return afp;
    }


}
