package es.flaviojmend.service;

import es.flaviojmend.command.AvaliacaoCommand;
import es.flaviojmend.persistence.entity.Avaliacao;
import es.flaviojmend.persistence.entity.Cliente;
import es.flaviojmend.persistence.entity.Contratacao;
import es.flaviojmend.persistence.entity.Massagista;
import es.flaviojmend.persistence.repo.AvaliacaoRepository;
import es.flaviojmend.persistence.repo.ContratacaoRepository;
import es.flaviojmend.persistence.repo.MassagistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by flavio.mendes on 23/08/2016.
 */
@Service
public class AvaliacaoService {

    @Autowired
    AvaliacaoRepository avaliacaoRepository;

    @Autowired
    ContratacaoRepository contratacaoRepository;


    public void avaliarMassagista(AvaliacaoCommand avaliacaoCommand) throws Exception {

        Contratacao contratacao = contratacaoRepository
                .findOne(avaliacaoCommand.getIdContratacao());

        contratacao.setAvaliacao(avaliacaoCommand.getAvaliacao());
        contratacaoRepository.save(contratacao);
    }




}
