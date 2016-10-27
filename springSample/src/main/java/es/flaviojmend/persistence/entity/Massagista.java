package es.flaviojmend.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Massagista {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMassagista;

    // private String cpf;


    public Long getIdMassagista() {
        return idMassagista;
    }

    public void setIdMassagista(Long idMassagista) {
        this.idMassagista = idMassagista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    private String nome;

    // 16 caracteres

    private String email;

    // private String senha;

    //  private String telefone;

    private String especialidade;

    private Integer nota;

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    private String sexo;
}