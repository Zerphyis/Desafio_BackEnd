package com.Zerphyis.projects.contas;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;

import java.text.DateFormat;

@Entity
@Table(name = "tb_contas")
@EqualsAndHashCode(of = "id")
public class ContaUsarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotNull
    private Float saldoInical;
    @FutureOrPresent
    private DateFormat dataCriacao;
    private  TipoConta tipoConta;

    public ContaUsarios(){

    }
    public  ContaUsarios(DtoConta conta){
        this.nome= conta.nome();
        this.sobrenome= conta.sobrenome();
        this.saldoInical=conta.saldoInical();
        this.tipoConta=conta.tipoConta();
        this.dataCriacao=conta.dataCriacao();
    }

    public Long getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Float getSaldoInical() {
        return saldoInical;
    }

    public void setSaldoInical(Float saldoInical) {
        this.saldoInical = saldoInical;
    }

    public DateFormat getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(DateFormat dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }
}
