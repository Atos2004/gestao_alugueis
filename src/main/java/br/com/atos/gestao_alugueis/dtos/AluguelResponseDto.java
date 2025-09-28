package br.com.atos.gestao_alugueis.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AluguelResponseDto {

    @NotNull
    private Long ImovelId;
    private Long inquilinoId;
    @Min(0)
    private BigDecimal valor;
    private LocalDate dataVencimento;
    private boolean pago;

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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
}
