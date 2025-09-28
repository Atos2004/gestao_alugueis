package br.com.atos.gestao_alugueis.models;

import jakarta.persistence.*;



@Entity
@Table(name = "imovel")
public class Imovel {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long imovelId;

    private String descricao;

    private String endereco;

    public Imovel() {
    }

    public Imovel(Long imovelId, String descricao, String endereco) {
        this.imovelId = imovelId;
        this.descricao = descricao;
        this.endereco = endereco;
    }

    public Long getImovelId() {
        return imovelId;
    }

    public void setImovelId(Long imovelId) {
        this.imovelId = imovelId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
