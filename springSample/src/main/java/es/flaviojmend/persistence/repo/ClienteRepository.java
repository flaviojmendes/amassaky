package es.flaviojmend.persistence.repo;

import es.flaviojmend.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by flavio on 19/07/16.
 */
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    List<Cliente> findBySenhaAndEmail(String senha, String email);

}

