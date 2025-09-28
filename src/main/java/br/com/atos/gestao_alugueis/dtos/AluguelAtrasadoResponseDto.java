package br.com.atos.gestao_alugueis.dtos;

import java.math.BigDecimal;

public class AluguelAtrasadoResponseDto {

    private Long id;
    private String imovel;
    private String inquilino;
    private BigDecimal valor;
    private long diasEmAtraso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImovel() {
        return imovel;
    }

    public void setImovel(String imovel) {
        this.imovel = imovel;
    }

    public String getInquilino() {
        return inquilino;
    }

    public void setInquilino(String inquilino) {
        this.inquilino = inquilino;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public long getDiasEmAtraso() {
        return diasEmAtraso;
    }

    public void setDiasEmAtraso(long diasEmAtraso) {
        this.diasEmAtraso = diasEmAtraso;
    }
}
