package br.com.atos.gestao_alugueis.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "inquilino")
public class Inquilino {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long inquilinoId;

    private String nome;

    private String email;

    public Inquilino() {
    }

    public Inquilino(Long inqilinoId, String nome, String email) {
        this.inquilinoId = inqilinoId;
        this.nome = nome;
        this.email = email;
    }

    public Long getInqilinoId() {
        return inquilinoId;
    }

    public void setInqilinoId(Long inqilinoId) {
        this.inquilinoId = inqilinoId;
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
}
