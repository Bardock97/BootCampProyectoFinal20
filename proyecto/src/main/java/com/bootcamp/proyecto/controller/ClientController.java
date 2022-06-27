package com.bootcamp.proyecto.controller;

import com.bootcamp.proyecto.entity.AFP;
import com.bootcamp.proyecto.entity.Client;
import com.bootcamp.proyecto.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/client")
@Slf4j
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Client> getAllClient(){
        return clientRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createClient(@RequestBody Client client){
        log.info("Comienzo del registro del cliente:");
        clientRepository.save(client);
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<Client> getClientID(@PathVariable(value = "id") Long id) {
        Optional<Client> client = clientRepository.findById(id);
        log.info("Comienzo del listado de los clientes:");
        if(client.isPresent()){
            log.info(client.toString());
            return new ResponseEntity<>(client.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(client.get(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public String deleteClient(@PathVariable(value = "id")Long id) {
        log.info("Comienzo del eliminado del cliente:");
        clientRepository.deleteById(id);
        log.info("Se eliminó al cliente satisfactoriamente.");
        return "Se eliminó al cliente satisfactoriamente.";
    }

    @PutMapping("/actualizar/{id}")
    public Client updateClient(@RequestBody Client client, @PathVariable(value = "id") Long id){
        client.setId(id);
        log.info("Comienzo de la actualizacion del cliente:");
        clientRepository.save(client);
        log.info("Se actualizo al cliente satisfactoriamente.");
        return client;
    }



}
