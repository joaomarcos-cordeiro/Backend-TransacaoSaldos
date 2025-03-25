package com.jm.transacao_saldos.infrastructure.entity.repository;

import com.jm.transacao_saldos.infrastructure.entity.Carteira;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CarteiraRepository extends JpaRepository<Carteira, Long> {

}
