## Transações Saldos (Class Architecture)
API para gerenciamento de transações financeiras entre usuários, com validação de saldo, regras específicas para diferentes tipos de contas e simulação de serviços externos de autorização e notificação.

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
## ~~~ English -> 

API for managing financial transactions between users, with balance validation, specific rules for different account types, and simulation of external authorization and notification services.

-User Types - Common – Merchant

-User – entity

Full name

CPF/CNPJ - UNIQUE

Email - UNIQUE

Password

Wallet relationship

Transfer relationship

User Type

- Wallet - entity

- Transfer - entity

## Business Rules

- Money Transfer – between users and merchants or only users

- Merchants only receive = cannot make transfers

- Validate user balance

- Validate if the transfer was authorized mock( https://util.devi.tools/api/v2/authorize
) - Microservice - external api

- @Transactional = rollback the operation in case of any failure

- Send email to the user who received the payment - mock ( https://util.devi.tools/api/v1/notify
)

- RESTful Service

- RequestPost
{
"value": 100.0,
"payer": 3, (payer)
"payee": 15 (receiver id)
}

- Pre-populate user and merchant registration data




