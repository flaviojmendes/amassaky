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
@RequestMapping("/massagista")
public class MassagistaController {


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

//    @RequestMapping(method = RequestMethod.PUT)
//    public ResponseEntity<?> put(@RequestBody Comment comment) {
//        HttpHeaders httpHeaders = new HttpHeaders();
//
//        try {
//            clienteService.updateComment(comment);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, httpHeaders, HttpStatus.BAD_REQUEST);
//        }
//
//        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE)
//    public ResponseEntity<?>  delete(@RequestBody Comment comment) {
//        clienteService.deleteComment(comment);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        return new ResponseEntity<>(null, httpHeaders, HttpStatus.OK);
//    }

}