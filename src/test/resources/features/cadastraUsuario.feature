#language:pt

@validarCadastro
Funcionalidade: Validar cadastro

	Como um usuario do sistema
	Eu quero me cadastrar no app da loja
	Para que eu possa realizar compras

Contexto:
	  Dado que o usuario esteja na pagina cadastro de usuario
  	
@testPositivo
  Cenario: Deve cadastrar um novo usuario com sucesso
 		Quando realizar um cadastro valido
 		Entao o usuario deve ser notificado que o usuario esta logado
   	
@testNegativo
  Cenario: Deve validar campos obrigatorios
  	Quando realizar o cadastro sem preencher os campos obrigatorios
  	Entao usuario e notificado com a mensagem 
  	| User name required | Email required | Password required | Confirm password required |
  	