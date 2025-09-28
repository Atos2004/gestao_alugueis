🏠 Gestão de Aluguéis

Sistema de gestão de aluguéis desenvolvido em Spring Boot, com suporte a cadastro de imóveis, inquilinos, controle de pagamentos e listagem de aluguéis atrasados.

🚀 Tecnologias utilizadas

Java 17+

Spring Boot (Web, Data JPA, Validation)

Hibernate

ModelMapper

Banco de Dados H2/MySQL (configurável)

Maven

📌 Funcionalidades

Cadastro de aluguel com vínculo a inquilino e imóvel.

Atualização do status de pagamento (pago → true/false).

Listagem de todos os aluguéis.

Listagem de aluguéis atrasados, com cálculo automático de dias em atraso.

📂 Estrutura do Projeto
src/main/java/br/com/atos/gestao_alugueis
 ┣ 📂 controllers     → Endpoints REST
 ┣ 📂 dtos            → Objetos de transferência (entrada/saída)
 ┣ 📂 models          → Entidades do banco de dados
 ┣ 📂 repositories    → Interfaces JPA
 ┣ 📂 services        → Regras de negócio
 ┗ Application.java   → Classe principal Spring Boot

⚡ Endpoints principais
1. Criar aluguel

POST /alugueis/teste

📥 Body JSON

{
  "imovelId": 1,
  "inquilinoId": 1,
  "valor": 1500.00,
  "dataVencimento": "2025-09-10"
}


📤 Resposta (201 Created)

{
  "id": 1,
  "inquilino": "Maria",
  "imovel": "Apartamento 101",
  "valor": 1500.00,
  "dataVencimento": "2025-09-10",
  "pago": false
}

2. Atualizar status de pagamento

PATCH /alugueis/{id}/pago

📥 Body JSON

{
  "pago": true
}


📤 Resposta (200 OK)

{
  "id": 1,
  "pago": true
}

3. Listar atrasados

GET /alugueis/atrasados

📤 Resposta (200 OK)

[
  {
    "id": 1,
    "inquilino": "Maria",
    "imovel": "Apartamento 101",
    "valor": 1500.00,
    "diasEmAtraso": 12
  }
]

⚙️ Como rodar o projeto

Clone o repositório:

git clone https://github.com/seu-usuario/gestao-alugueis.git


Acesse a pasta:

cd gestao-alugueis


Configure o banco de dados em application.properties.

Rode a aplicação:

mvn spring-boot:run

Importe os endpoints com uma collection (.json).

Teste os cenários de criação, pagamento e listagem atrasados.
