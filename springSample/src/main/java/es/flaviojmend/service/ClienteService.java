package es.flaviojmend.service;

import es.flaviojmend.persistence.entity.Cliente;
import es.flaviojmend.persistence.repo.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by flavio.mendes on 23/08/2016.
 */
@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public void cadastrarCliente(Cliente cliente) throws Exception {
        if(cliente.getCpf() == null || cliente.getCpf().equals("")) {
            throw new Exception("CPF Obrigatório");
        }
        clienteRepository.save(cliente);
    }


    public Iterable<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

}
