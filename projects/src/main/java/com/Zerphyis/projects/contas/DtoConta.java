package com.Zerphyis.projects.contas;

import java.text.DateFormat;

public record DtoConta(String nome,
                       String sobrenome,
                       Float saldoInical,
                       DateFormat dataCriacao,
                       TipoConta tipoConta) {
}
