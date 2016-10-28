package es.flaviojmend.persistence.repo;

import es.flaviojmend.persistence.entity.Cliente;
import es.flaviojmend.persistence.entity.Massagista;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by flavio on 19/07/16.
 */
public interface MassagistaRepository extends CrudRepository<Massagista, Long> {

    List<Massagista> findByEspecialidadeAndSexo(String especialidade, String sexo);

    List<Massagista> findBySenhaAndEmail(String senha, String email);
}

