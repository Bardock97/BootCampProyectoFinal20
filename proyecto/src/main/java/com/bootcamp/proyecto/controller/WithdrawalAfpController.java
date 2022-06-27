package com.bootcamp.proyecto.controller;

import com.bootcamp.proyecto.entity.AFP;
import com.bootcamp.proyecto.entity.WithdrawalAfp;
import com.bootcamp.proyecto.repository.WithdrawalAfpRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/withdrawalAfp")
@Slf4j
public class WithdrawalAfpController {

    @Autowired
    WithdrawalAfpRepository withdrawalAfpRepository;

    @PostMapping("/new")
    public String createwithdrawalAFP(@RequestBody WithdrawalAfp withdrawalAfp){

        double amountavailable = withdrawalAfp.getAssociation().getAvailableAmount();
        double amountwithdrawal = withdrawalAfp.getWithdrawalAmount();

        double descuento = amountavailable * 0.5;

        if (amountwithdrawal > amountavailable)
        {
            return "No se puede registrar la solicitud. Monto mayor que el permitido.";
        }else if (amountwithdrawal < descuento)
        {
            return "Monto mínimo no cubierto por favor revise el monto mínimo a retirar.";
        }else if (amountwithdrawal >= descuento && amountwithdrawal <= amountavailable)
        {
            WithdrawalAfp withdrawalAfpResponse = withdrawalAfpRepository.save(withdrawalAfp);
            return "La solicitud del registro de su retiro fue realizada de manera satisfactoria.";
        }else {
            return "Eliminacion requerida";
        }

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<WithdrawalAfp> getAllAfp(){
        log.info("Comienzo del listado de los retiros");
        return withdrawalAfpRepository.findAll();
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<WithdrawalAfp> getWithdrawalAfpID(@PathVariable(value = "id") Long id) {
        log.info("Comienzo del listado del listado por ID");
        Optional<WithdrawalAfp> withdrawalAfp = withdrawalAfpRepository.findById(id);
        if(withdrawalAfp.isPresent()){
            log.info(withdrawalAfp.toString());
            return new ResponseEntity<>(withdrawalAfp.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(withdrawalAfp.get(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public String deletewithdrawalAfp(@PathVariable(value = "id")Long id) {
        log.info("Comienzo de la eliminacion del retiro");
        withdrawalAfpRepository.deleteById(id);
        log.info("Se elimino satisfactoriamente la solicitud de retiro");
        return "Se eliminó la solicitud de retiro de manera satisfactoria";
    }

    @PutMapping("/actualizar/{id}")
    public WithdrawalAfp updatewithdrawalAfp(@RequestBody WithdrawalAfp withdrawalAfp, @PathVariable(value = "id") Long id){
        withdrawalAfp.setId(id);
        log.info("Comienzo de la actualizacion del retiro:");
        withdrawalAfpRepository.save(withdrawalAfp);
        log.info("Se actualizo satisfactoriamente los datos del retiro.");
        return withdrawalAfp;
    }

}
