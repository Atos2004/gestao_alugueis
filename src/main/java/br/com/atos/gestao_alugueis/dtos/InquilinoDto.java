package br.com.atos.gestao_alugueis.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class InquilinoDto {

    @NotBlank(message = "nome é obrigatório")
    private String nome;

    @Email(message = "Email inválido")
    private String email;

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
