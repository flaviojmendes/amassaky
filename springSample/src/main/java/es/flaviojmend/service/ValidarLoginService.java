package es.flaviojmend.service;

import es.flaviojmend.command.ContratacaoCommand;
import es.flaviojmend.command.LoginCommand;
import es.flaviojmend.persistence.entity.Cliente;
import es.flaviojmend.persistence.entity.Contratacao;
import es.flaviojmend.persistence.entity.Massagista;
import es.flaviojmend.persistence.repo.ClienteRepository;
import es.flaviojmend.persistence.repo.MassagistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

/**
 * Created by flavio.mendes on 23/08/2016.
 */
@Service
public class ValidarLoginService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    MassagistaRepository massagistaRepository;

    public String validarLogin(LoginCommand loginCommand){
        List<Massagista> massagistas = massagistaRepository
                .findBySenhaAndEmail(loginCommand.getSenha(), loginCommand.getLogin());
        if (massagistas.size() > 0){
            return "{\"result\":\"massagista\"}";
        };

        List<Cliente> clientes = clienteRepository
                    .findBySenhaAndEmail(loginCommand.getSenha(), loginCommand.getLogin());

        if (clientes.size() > 0){
            return "{\"result\":\"cliente\"}";
        };
            return null;
    }
}