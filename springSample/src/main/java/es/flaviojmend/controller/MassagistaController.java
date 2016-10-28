package es.flaviojmend.controller;

import es.flaviojmend.persistence.entity.Cliente;
import es.flaviojmend.persistence.entity.Massagista;
import es.flaviojmend.service.ClienteService;
import es.flaviojmend.service.MassagistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by flavio.mendes on 22/08/2016.
 */

@RestController
@RequestMapping("/massagista")
public class MassagistaController {


    @Autowired
    MassagistaService massagistaService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> post(@RequestBody Massagista massagista) throws Exception {
        massagistaService.cadastrarMassagista(massagista);

        HttpHeaders httpHeaders = new HttpHeaders();

        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }

}