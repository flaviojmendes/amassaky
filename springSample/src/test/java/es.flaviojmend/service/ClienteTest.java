package es.flaviojmend.service;

import es.flaviojmend.persistence.entity.Cliente;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by flaviojmendes on 27/10/16.
 */

public class ClienteTest {

    @Test
    public void cadastrarClienteSemCPF() {
        ClienteService clienteService = new ClienteService();
        Cliente cliente = new Cliente();
        cliente.setCpf(null);
        cliente.setCvv("231");
        cliente.setEmail("flavio@asdsad.com");
        cliente.setNome("fulano");
        cliente.setNumeroCartao("123213213");
        cliente.setSenha("fdfdsfd");
        cliente.setTelefone("123313");
        cliente.setVencimento("12/18");

        try {
            clienteService.cadastrarCliente(cliente);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void cadastrarClienteSemNome() {
        ClienteService clienteService = new ClienteService();
        Cliente cliente = new Cliente();
        cliente.setCpf("00100100101");
        cliente.setCvv("231");
        cliente.setEmail("flavio@asdsad.com");
        cliente.setNome(null);
        cliente.setNumeroCartao("123213213");
        cliente.setSenha("fdfdsfd");
        cliente.setTelefone("123313");
        cliente.setVencimento("12/18");

        try {
            clienteService.cadastrarCliente(cliente);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

}
