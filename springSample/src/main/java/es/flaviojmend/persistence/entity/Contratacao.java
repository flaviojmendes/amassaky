package es.flaviojmend.persistence.entity;

import javax.persistence.*;


@Entity
public class Contratacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idContratacao;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_massagista")
    private Massagista massagista;

    public Long getIdContratacao() {
        return idContratacao;
    }

    public void setIdContratacao(Long idContratacao) {
        this.idContratacao = idContratacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Massagista getMassagista() {
        return massagista;
    }

    public void setMassagista(Massagista massagista) {
        this.massagista = massagista;
    }
}