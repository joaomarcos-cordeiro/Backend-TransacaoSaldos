package com.jm.transacao_saldos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TransacaoSaldosApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransacaoSaldosApplication.class, args);
	}

}
