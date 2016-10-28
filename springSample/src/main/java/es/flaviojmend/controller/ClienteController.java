package es.flaviojmend.controller;

import es.flaviojmend.persistence.entity.Cliente;
import es.flaviojmend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by flavio.mendes on 22/08/2016.
 */

@RestController
@RequestMapping("/cliente")
public class ClienteController {


    @Autowired
    ClienteService clienteService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Cliente> get() {
        return clienteService.listarClientes();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> post(@RequestBody Cliente cliente) throws Exception {
        clienteService.cadastrarCliente(cliente);

        HttpHeaders httpHeaders = new HttpHeaders();

        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }


}