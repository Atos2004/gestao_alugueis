package br.com.atos.gestao_alugueis.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "aluguel")
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long aluguelId;

    @ManyToOne
    @JoinColumn(name = "imovelId", nullable = false)
    private Imovel imovel;

    @ManyToOne
    @JoinColumn(name = "inquilinoId", nullable = true)
    private Inquilino inquilino;

    private double valor;

    private LocalDate dataVencimento;

    private boolean pago = false;

    public Aluguel() {
    }

    public Aluguel(Long aluguelId, Imovel imovel, Inquilino inquilino, double valor, LocalDate dataVencimento, boolean pago) {
        this.aluguelId = aluguelId;
        this.imovel = imovel;
        this.inquilino = inquilino;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.pago = pago;
    }

    public Long getAluguelId() {
        return aluguelId;
    }

    public void setAluguelId(Long aluguelId) {
        this.aluguelId = aluguelId;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
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

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
}
