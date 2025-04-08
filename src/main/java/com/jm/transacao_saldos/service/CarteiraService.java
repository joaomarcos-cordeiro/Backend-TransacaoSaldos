package com.jm.transacao_saldos.service;

import com.jm.transacao_saldos.infrastructure.entity.Carteira;
import com.jm.transacao_saldos.infrastructure.entity.Usuario;
import com.jm.transacao_saldos.infrastructure.entity.repository.CarteiraRepository;
import com.jm.transacao_saldos.infrastructure.entity.repository.UsuarioRepository;
import com.jm.transacao_saldos.infrastructure.exceptions.UserNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarteiraService {
    private final CarteiraRepository repository;

    public void salvar(Carteira carteira){

      repository.save(carteira);
    }
}
