package es.flaviojmend.service;

import com.sun.deploy.util.SessionState;
import es.flaviojmend.persistence.entity.Cliente;
import es.flaviojmend.persistence.repo.ClienteRepository;
import es.flaviojmend.persistence.repo.MassagistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by flavio.mendes on 23/08/2016.
 */
@Service
public class MassagistaService {

    @Autowired
    MassagistaRepository massagistaRepository;

    public void chamarMassagista(Cliente cliente) throws Exception {
            //to do
    }

}
