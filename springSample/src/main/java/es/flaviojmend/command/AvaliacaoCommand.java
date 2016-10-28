package es.flaviojmend.command;

import es.flaviojmend.persistence.entity.Avaliacao;

/**
 * Created by AdrianoLuro on 27/10/16.
 */
public class AvaliacaoCommand {

    private Long idContratacao;
    private Avaliacao avaliacao;


    public Long getIdContratacao() {
        return idContratacao;
    }

    public void setIdContratacao(Long idContratacao) {
        this.idContratacao = idContratacao;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }
}
