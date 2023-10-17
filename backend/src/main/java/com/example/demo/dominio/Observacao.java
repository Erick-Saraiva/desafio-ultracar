package com.example.demo.dominio;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "observacao")
public class Observacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_veiculo")
    private Veiculo veiculo;

    private String observacao;

    private LocalDateTime data;

    public Observacao() {

    }
    public Observacao(Veiculo veiculo, String observacao, LocalDateTime data) {
        this.veiculo = veiculo;
        this.observacao = observacao;
        this.data = data;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Observacao{" +
                "id=" + id +
                ", veiculo=" + veiculo +
                ", observacao='" + observacao + '\'' +
                ", data=" + data +
                '}';
    }
}
