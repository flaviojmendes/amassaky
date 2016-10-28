package es.flaviojmend.controller;

import es.flaviojmend.command.ContratacaoCommand;
import es.flaviojmend.command.LoginCommand;
import es.flaviojmend.service.ContratacaoService;
import es.flaviojmend.service.ValidarLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by flavio.mendes on 22/08/2016.
 */

@RestController
@RequestMapping("/login")
public class ValidarLoginController {


    @Autowired
    ValidarLoginService validarLoginService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> post(@RequestBody LoginCommand loginCommand) throws Exception {
       String usuario=validarLoginService.validarLogin(loginCommand);

        HttpHeaders httpHeaders = new HttpHeaders();

        if(usuario == null || usuario.equals("")) {
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(usuario, httpHeaders, HttpStatus.OK);


    }
}