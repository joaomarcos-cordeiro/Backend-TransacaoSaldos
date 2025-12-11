## Transações Saldos (Class Architecture)
API backend para gerenciamento de transações financeiras entre usuários, com validação de saldo, regras específicas para diferentes tipos de contas e simulação de serviços externos de autorização e notificação.

- Tipos de usuários - Comum – Lojista
- Usuário – entidade
  
	Nome completo

	CPF/CNPJ - UNICO

  	Email - UNICO

  
  	Senha


	Relação com carteira

   
  	Relação com Transferência


  	Tipo de Usuário

- Carteira - entidade
- Transferência - entidade 

## Regra de Negócio 
- Transferência de Dinheiro – entre usuários e lojistas ou somente usuários
- Lojistas somente recebe = não podem fazer transferências

- Validar saldo do usuário
- Validar se a transferência foi autorizada  mock( https://util.devi.tools/api/v2/authorize) - Microservice - apiexterna

- @Transactional = reverter a operação em caso de qualquer falha
- Enviar email ao usuário que recebeu o pagamento -  mock ( https://util.devi.tools/api/v1/notify) 
- Serviço RESTful

- RequestPost
{
  "value": 100.0,
  "payer": 3, (pagador)
  "payee": 15 (id do recebedor)
}

- Pre popular os dados de cadastro de usuários e lojista




