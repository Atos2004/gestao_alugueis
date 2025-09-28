package br.com.atos.gestao_alugueis.dtos;

import jakarta.validation.constraints.NotBlank;

public class ImovelDto {

    @NotBlank(message = "Descrição é obrigatória")
    private String descricao;

    private String endereco;

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
