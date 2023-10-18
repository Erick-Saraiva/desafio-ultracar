package com.example.demo.dominio;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ordem_de_servico")
public class OrdemDeServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_veiculo")
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "id_servico")
    private Servico servico;

    @ManyToOne
    @JoinColumn(name = "id_peca")
    private Peca peca;

    private String observacao;

    private LocalDateTime dataCriacao;

    private boolean aprovado;
    public OrdemDeServico() {
    }

    public OrdemDeServico(Veiculo veiculo, Servico servico, Peca peca,
                          String observacao, LocalDateTime dataCriacao, boolean aprovado) {
        this.veiculo = veiculo;
        this.servico = servico;
        this.peca = peca;
        this.observacao = observacao;
        this.dataCriacao = dataCriacao;
        this.aprovado = aprovado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    @Override
    public String toString() {
        return "\nOrdemDeServico: " + '\n' +
                "Id: " + id + '\n' +
                "Nome do serviço: " + servico.getNome() + '\n' +
                "Descrição do serviço: " + servico.getDescricao() + '\n' +
                "Nome da Peça: " + peca.getNome() + '\n' +
                "Descrição da Peça: " + peca.getDescricao() + '\n' +
                "Preço da Peça: " + peca.getPreco() + '\n' +
                "Observação: " + observacao + '\n' +
                "Data do serviço: " + dataCriacao + '\n' +
                "Foi aprovado: " + aprovado + '\n';
    }
}
