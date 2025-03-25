package com.jm.transacao_saldos.infrastructure.entity.repository;

import com.jm.transacao_saldos.infrastructure.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
