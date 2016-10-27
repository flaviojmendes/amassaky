package es.flaviojmend.persistence.repo;

import es.flaviojmend.persistence.entity.Cliente;
import es.flaviojmend.persistence.entity.Contratacao;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by flavio on 19/07/16.
 */
public interface ContratacaoRepository extends CrudRepository<Contratacao, Long> {



}

