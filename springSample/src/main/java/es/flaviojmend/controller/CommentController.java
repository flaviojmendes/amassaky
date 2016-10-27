package es.flaviojmend.controller;

import es.flaviojmend.persistence.entity.Cliente;
import es.flaviojmend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by flavio.mendes on 22/08/2016.
 */

@RestController
@RequestMapping("/cliente")
public class CommentController {


    @Autowired
    ClienteService clienteService;

//    @RequestMapping(method = RequestMethod.GET)
//    public Iterable<Comment> get() {
//        return clienteService.listComments();
//    }
//

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> post(@RequestBody Cliente cliente) {
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