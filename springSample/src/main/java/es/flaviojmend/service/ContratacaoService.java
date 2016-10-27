package es.flaviojmend.service;

import es.flaviojmend.command.ContratacaoCommand;
import es.flaviojmend.persistence.entity.Cliente;
import es.flaviojmend.persistence.entity.Contratacao;
import es.flaviojmend.persistence.entity.Massagista;
import es.flaviojmend.persistence.repo.ClienteRepository;
import es.flaviojmend.persistence.repo.ContratacaoRepository;
import es.flaviojmend.persistence.repo.MassagistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by flavio.mendes on 23/08/2016.
 */
@Service
public class ContratacaoService {

    @Autowired
    ContratacaoRepository contratacaoRepository;

    @Autowired
    MassagistaRepository massagistaRepository;

    public void contratarServico(ContratacaoCommand contratacaoCommand) throws Exception {

        List<Massagista> massagistas = massagistaRepository.findByEspecialidade(contratacaoCommand.getEspecialidade());

        Contratacao contratacao = new Contratacao();

        contratacao.setCliente(contratacaoCommand.getCliente());
        contratacao.setMassagista(massagistas.get(0));

        contratacaoRepository.save(contratacao);

    }
}