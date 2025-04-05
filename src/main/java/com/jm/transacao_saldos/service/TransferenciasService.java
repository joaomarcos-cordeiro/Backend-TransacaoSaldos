package com.jm.transacao_saldos.service;

import com.jm.transacao_saldos.controller.TransacaoDTO;
import com.jm.transacao_saldos.infrastructure.entity.TipoUsuario;
import com.jm.transacao_saldos.infrastructure.entity.Usuario;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor

public class TransferenciasService {

    private final UsuarioService usuarioService;
    private final AutorizacaoService autorizacaoService;
    @Transactional
    public void transferirValores(TransacaoDTO transacaoDTO){
        Usuario pagador  = usuarioService.buscarUsuario(transacaoDTO.payer());
        Usuario recebedor = usuarioService.buscarUsuario(transacaoDTO.payer());

        validaPagadorLojista(pagador);
        validarSaldoUsuario(pagador, transacaoDTO.value());
        validarTransferencia();


    }

    private void validaPagadorLojista(Usuario usuario){
        try{
            if(usuario.getTipoUsuario().equals(TipoUsuario.LOJISTA)){
                throw new IllegalArgumentException("Transação não autorizada para esse tipo de usuario");
            }
        } catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }

    }
    private void validarSaldoUsuario(Usuario usuario, BigDecimal valor){
        try{
            if(usuario.getCarteira().getSaldo().compareTo(valor) < 0){
                throw new IllegalArgumentException("Transação não autorizada, saldo insuficiente");

            }
        } catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void validarTransferencia(){
        try{
            if(!autorizacaoService.validarTransferencia()){
                throw new IllegalArgumentException("Transação não autorizada pela API ");

            }
        } catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }


}
