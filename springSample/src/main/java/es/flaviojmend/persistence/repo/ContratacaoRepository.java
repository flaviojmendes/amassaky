package es.flaviojmend.persistence.repo;

import es.flaviojmend.persistence.entity.Avaliacao;
import es.flaviojmend.persistence.entity.Cliente;
import es.flaviojmend.persistence.entity.Contratacao;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by flavio on 19/07/16.
 */
public interface ContratacaoRepository extends CrudRepository<Contratacao, Long> {


    List<Contratacao> findByClienteAndAvaliacao(Cliente cliente,  Avaliacao avaliacao);

}

