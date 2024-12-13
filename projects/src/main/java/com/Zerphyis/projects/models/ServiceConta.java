package com.Zerphyis.projects.models;

import com.Zerphyis.projects.contas.ContaUsarios;
import com.Zerphyis.projects.contas.DtoConta;
import com.Zerphyis.projects.contas.RepositoryConta;
import com.Zerphyis.projects.contas.Tratamento.ValidarExecption;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Service
public class ServiceConta {
    @Autowired
    private RepositoryConta repository;

    @Transactional
    public ResponseEntity adicionarConta(@RequestBody  DtoConta conta){
        var novaConta = new ContaUsarios(conta);
        repository.save(novaConta);
        return ResponseEntity.ok(novaConta);
    }

    @Transactional
    public ResponseEntity atualizarConta(@RequestParam Long id,@RequestBody DtoConta conta){
         var verificar=repository.findById(id);
        if (verificar.isEmpty()) {
            throw new ValidarExecption("Não foi possível encontrar a conta");
        }

        ContaUsarios contaAtualziada = verificar.get();
        if (contaAtualziada.getNome() != null) {
            contaAtualziada.setNome(conta.nome());
        }
        if (contaAtualziada.getSobrenome() != null) {
            contaAtualziada.setSobrenome(conta.sobrenome());
        }
        if (contaAtualziada.getSaldoInical() != null) {
            contaAtualziada.setSaldoInical(conta.saldoInical());
        }
        if (contaAtualziada.getDataCriacao() != null) {
            contaAtualziada.setDataCriacao(conta.dataCriacao());
        }
        repository.save(contaAtualziada);
        return ResponseEntity.ok(contaAtualziada);
    }

    @Transactional
    public ResponseEntity deletarUsuarios(Long id) {
        var usuario = repository.findById(id);

        if (usuario.isEmpty()) {
            throw new ValidarExecption("Não foi possível encontrar a conta para deletar");
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    public ResponseEntity listarUsuarios() {
        var contas = repository.findAll();
        return ResponseEntity.ok(contas);
    }



}
