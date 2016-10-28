package es.flaviojmend.controller;

import es.flaviojmend.command.ContratacaoCommand;
import es.flaviojmend.persistence.entity.Avaliacao;
import es.flaviojmend.persistence.entity.Cliente;
import es.flaviojmend.persistence.entity.Contratacao;
import es.flaviojmend.persistence.entity.Massagista;
import es.flaviojmend.service.ClienteService;
import es.flaviojmend.service.ContratacaoService;
import es.flaviojmend.service.MassagistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by flavio.mendes on 22/08/2016.
 */

@RestController
@RequestMapping("/contratacao")
public class ContratacaoController {


    @Autowired
    ContratacaoService contratacaoService;


    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/naoAvaliadas/{id}")
    public ResponseEntity<?> recuperarContratacoesNaoAvaliadas(@PathVariable("id") Long idCliente) throws Exception {
        List<Contratacao> avaliacaoList = contratacaoService.recuperarContratacoesNaoAvaliadas(idCliente);

        HttpHeaders httpHeaders = new HttpHeaders();

        return new ResponseEntity<>(avaliacaoList, httpHeaders, HttpStatus.CREATED);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> post(@RequestBody ContratacaoCommand contratacaoCommand) throws Exception {
       contratacaoService.contratarServico(contratacaoCommand);

        HttpHeaders httpHeaders = new HttpHeaders();

        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }
}