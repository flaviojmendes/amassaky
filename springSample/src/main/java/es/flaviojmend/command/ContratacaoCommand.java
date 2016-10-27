package es.flaviojmend.command;

import es.flaviojmend.persistence.entity.Cliente;

/**
 * Created by AdrianoLuro on 27/10/16.
 */
public class ContratacaoCommand {

    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    private String especialidade;

    private String sexo;

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
