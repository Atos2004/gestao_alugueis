package br.com.atos.gestao_alugueis.dtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class AluguelDto {

    @NotNull
    private Long ImovelId;
    private Long inquilinoId;
    @DecimalMin(value = "0.0", inclusive = true, message = "O valor do aluguel deve ser maior ou igual a zero.")
    private double valor;
    private LocalDate dataVencimento;

    public Long getImovelId() {
        return ImovelId;
    }

    public void setImovelId(Long imovelId) {
        ImovelId = imovelId;
    }

    public Long getInquilinoId() {
        return inquilinoId;
    }

    public void setInquilinoId(Long inquilinoId) {
        this.inquilinoId = inquilinoId;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}
