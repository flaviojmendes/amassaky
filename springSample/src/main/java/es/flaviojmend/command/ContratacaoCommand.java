package es.flaviojmend.command;

import es.flaviojmend.persistence.entity.Cliente;

/**
 * Created by AdrianoLuro on 27/10/16.
 */
public class ContratacaoCommand {

    private Long idCliente;

    private String especialidade;

    private String sexo;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
