package com.jm.transacao_saldos.infrastructure.entity.repository;


import com.jm.transacao_saldos.infrastructure.entity.Transacoes;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransacoesRepository extends JpaRepository<Transacoes, Long> {

}
