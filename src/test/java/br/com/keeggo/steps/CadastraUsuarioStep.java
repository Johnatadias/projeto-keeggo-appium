package br.com.keeggo.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import br.com.keeggo.screens.BaseScreen;
import br.com.keeggo.screens.FormCadastraoUsuarioScreen;
import br.com.keeggo.screens.HomeScreen;
import br.com.keeggo.supports.DriverFactory;
import cucumber.api.DataTable;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class CadastraUsuarioStep {

	private HomeScreen homeScreen = new HomeScreen(DriverFactory.getDriver());
	private FormCadastraoUsuarioScreen formCadastroScreen = new FormCadastraoUsuarioScreen(DriverFactory.getDriver());
	
	@Dado("^que o usuario esteja na pagina cadastro de usuario$")
	public void que_o_usuario_esteja_na_pagina_cadastro_de_usuario() {
		homeScreen.clicarMenuNaHomePage().clicarIconeLoginDoMenu().clicarNovaConta();
	}
	
	@Quando("^realizar um cadastro valido$")
	public void realizarUmCadastroValido() {
		formCadastroScreen.inseriUserName(formCadastroScreen.getNomeUsuarioRandom(6))
						  .inseriEmail("a@a.com")
					      .inseriPassword("John20")
						  .inseriConfirPassword("John20")
					      .inseriFirstName("Johnata")
						  .inseriLastName("Dias")
						  .inseriPhoneNumber("1234-1234")
						  .inseriCountry("Brazil")
						  .inseriStates("SP")
						  .inseriAddress("Rua xyz, 198")
						  .inseriCity("Sao Paulo")
						  .inseriZipCode("12345-123")
						  .checkBoxReceberPromocoes();
		
		formCadastroScreen.btnRegistrar();
	}

	@Entao("^o usuario deve ser notificado que o usuario esta logado$")
	public void oUsuarioDeveSerNotificadoQueOUsuarioEstaLogado() throws Throwable {
		assertNotEquals("LOGIN", homeScreen.assertNovoUsuario());
	}

	@Quando("^realizar o cadastro sem preencher os campos obrigatorios$")
	public void realizar_o_cadastro_sem_preencher_os_campos_obrigatorios() {
		formCadastroScreen.inseriUserName("")
						  .inseriEmail("")
						  .inseriPassword("")
						  .inseriConfirPassword("")
						  .inseriFirstName("Johnata")
						  .inseriLastName("Dias")
						  .inseriPhoneNumber("1234-1234")
						  .inseriCountry("Brazil")
						  .inseriStates("SP")
						  .inseriAddress("Rua xyz, 198")
						  .inseriZipCode("12345-123")
						  .inseriCity("São Paulo")
						  .checkBoxReceberPromocoes();
		
		formCadastroScreen.btnRegistrar();
	}

	@Entao("^usuario e notificado com a mensagem$")
	public void usuario_e_notificado_com_a_mensagem(DataTable mensagens) {
		List<List<String>> data = mensagens.raw();
		
		new BaseScreen(DriverFactory.getDriver()).scrollByDimension(0.2, 0.8);
		assertEquals(data.get(0).get(0), formCadastroScreen.campoUserNameRequired());
		assertEquals(data.get(0).get(1), formCadastroScreen.campoEmailRequired());
		assertEquals(data.get(0).get(2), formCadastroScreen.campoPasswordRequired());
		assertEquals(data.get(0).get(3), formCadastroScreen.campoConfirmPasswordRequired());
	}
}
