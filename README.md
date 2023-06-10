# Loyalty API

### _Tecnologias utilizadas_
- [x] Java (17)
- [x] Spring Boot (3.0.2)
- [x] PostgreSQL
- [x] JPA
- [x] Lombok
- [x] Swagger UI

### _Objetivo_
- Criar um sistema de pontuação de benefícios.

## Endpoints
> **Customer (CRUD)**
>> - GET v1/customer/health: testa a integridade do sistema de cliente.
>> - POST /v1/customer: salva um novo cliente no sistema.
>> - GET /v1/customer: lista todos os clientes salvos no sistema.
>> - GET /v1/customer/{id}: encontra um cliente pelo ID.
>> - UPDATE /v1/customer/update/{id}: atualiza os dados de um cliente.
>> - DELETE /v1/customer/delete/{id}: delete um cliente pelo ID.

>**Rule (CRUD)**
>> - GET v1/rule/health: testa a integridade do sistema de regras.
>> - POST /v1/rule: salva uma nova regra no sistema.
>> - GET /v1/rule: lista todas as regras salvas no sistema.
>> - GET /v1/rule/{id}: encontra uma regra pelo ID.
>> - UPDATE /v1/rule/update/{id}: atualiza os dados de uma regra.
>> - DELETE /v1/rule/delete/{id}: delete uma regra pelo ID.

>**Store (CRUD)**
>> - GET v1/store/health: testa a integridade do sistema de lojas.
>> - POST /v1/store: salva uma nova loja no sistema.
>> - GET /v1/store: lista todas as lojas salvas no sistema.
>> - GET /v1/store/{id}: encontra uma loja pelo ID.
>> - UPDATE /v1/store/update/{id}: atualiza os dados de uma loja.
>> - DELETE /v1/store/delete/{id}: delete uma loja pelo ID.

>**Transaction**
>> - GET v1/transaction/health: testa a integridade do sistema de transações.
>> - GET v1/transaction/customerId: lista de transações do cliente.
>> - GET v1/transaction/check: verifique as pontuações do cliente.
>> - POST v1/transaction/point: lança uma pontuação.
>> - POST v1/transaction/redeem: resgata um benefício.