package com.jm.transacao_saldos.service;

import com.jm.transacao_saldos.controller.TransacaoDTO;
import com.jm.transacao_saldos.infrastructure.entity.Carteira;
import com.jm.transacao_saldos.infrastructure.entity.TipoUsuario;
import com.jm.transacao_saldos.infrastructure.entity.Transacoes;
import com.jm.transacao_saldos.infrastructure.entity.Usuario;
import com.jm.transacao_saldos.infrastructure.entity.repository.TransacoesRepository;
import com.jm.transacao_saldos.infrastructure.exceptions.BadRequestException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor

public class TransacaoService {

    private final UsuarioService usuarioService;
    private final AutorizacaoService autorizacaoService;

    private final CarteiraService carteiraService;

    private final TransacoesRepository repository;

    private final NotificacaoService notificacaoService;
    @Transactional
    public void transferirValores(TransacaoDTO transacaoDTO){
        Usuario pagador  = usuarioService.buscarUsuario(transacaoDTO.payer());
        Usuario recebedor = usuarioService.buscarUsuario(transacaoDTO.payer());

        validaPagadorLojista(pagador);
        validarSaldoUsuario(pagador, transacaoDTO.value());
        validarTransferencia();

        pagador.getCarteira().setSaldo(pagador.getCarteira().getSaldo().subtract(transacaoDTO.value()));
        atualizarSaldoCarteira(pagador.getCarteira());

        recebedor.getCarteira().setSaldo(recebedor.getCarteira().getSaldo().add(transacaoDTO.value()));
        atualizarSaldoCarteira(recebedor.getCarteira());

        Transacoes transacoes = Transacoes.builder()
                .valor(transacaoDTO.value())
                .pagador(pagador)
                .recebedor(recebedor)
                .build();

        repository.save(transacoes);
        enviarNotificacao();

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


    private void atualizarSaldoCarteira(Carteira carteira){
        carteiraService.salvar(carteira);
    }

    private void enviarNotificacao(){
        try{
            notificacaoService.enviarNotificacao();
        } catch (HttpClientErrorException e) {
            throw new BadRequestException("Erro ao enviar notificacao");

        }

    }


}
