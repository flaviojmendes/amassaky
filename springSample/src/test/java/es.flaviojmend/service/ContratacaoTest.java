package es.flaviojmend.service;

import es.flaviojmend.command.ContratacaoCommand;
import org.junit.Test;

/**
 * Created by flaviojmendes on 28/10/16.
 */
public class ContratacaoTest {




    @Test
    public void contratarServicoSemCliente() {

        ContratacaoService contratacaoService = new ContratacaoService();


        ContratacaoCommand contratacaoCommand = new ContratacaoCommand();
        contratacaoCommand.setEspecialidade("Tantrica");
        contratacaoCommand.setSexo("f");
        contratacaoCommand.setIdCliente(1l);

        try {
            contratacaoService.contratarServico(contratacaoCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
