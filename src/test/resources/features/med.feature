Feature: Gerenciamento de appointmentss via HTTP

   @tagPost
   Scenario Outline: : Criar um novo appointments
    Given que o appointments envia uma solicitacao para criar um novo appointments, com cpf "<cpf>", com nome <nome> e email <email>
    When appointments recebe a solicitacao com code status <status>
    Then o appointments recebe a resposta, com cpf "<cpf>", com nome <nome> e email <email>


     Examples:
     | cpf               | nome             | email              | status |
     |  686.524.400-18   | Appointments Teste1   | appointments1@teste.com | 201    |
     |  123.456.789-09   | Appointments Teste    | appointments@teste.com  | 400    |

  @tagGet
  Scenario Outline: Recuperar informacoes de um appointments pelo CPF
    Given que o appointments envia uma solicitacao para recuperar informacoes de um appointments pelo CPF
    When  appointments recebe as informacoes com code status <status>
    Then recebe as informacoes com a resposta

    Examples:
      | status |
      | 200    |