package br.com.keeggo.screens;

import java.util.Random;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class FormCadastraoUsuarioScreen extends BaseScreen{

	public FormCadastraoUsuarioScreen(AndroidDriver<MobileElement> driver) {
		super(driver);
	}

	public FormCadastraoUsuarioScreen inseriUserName(String userName) {
		MobileElement campoUserName = driver.findElementByXPath(".//android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.EditText");
		campoUserName.click();
		campoUserName.sendKeys(userName);
		
		return this;
	}
	
	public FormCadastraoUsuarioScreen inseriEmail(String email) {
		MobileElement campoEmail = driver.findElementByXPath("//android.view.ViewGroup[@content-desc='Home Page']/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText");
		campoEmail.click();
		campoEmail.sendKeys(email);
		
		return this;
	}
	
	public FormCadastraoUsuarioScreen inseriPassword(String password) {
		MobileElement campoPassword = driver.findElementByXPath(".//android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.EditText");
		campoPassword.click();
		campoPassword.sendKeys(password);
		
		return this;
	}
	
	public FormCadastraoUsuarioScreen inseriConfirPassword(String confirmPassword) {
		MobileElement campoConfirmPassword = driver.findElementByXPath(".//android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.EditText");
		campoConfirmPassword.click();
		campoConfirmPassword.sendKeys(confirmPassword);
		
		return this;
	}
	
	public FormCadastraoUsuarioScreen inseriLastName(String lastName) {
		MobileElement campoLastName = driver.findElementByXPath(".//android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.EditText");
		campoLastName.click();
		campoLastName.sendKeys(lastName);
		
		return this;
	}
	
	public FormCadastraoUsuarioScreen inseriFirstName(String firstName) {
		MobileElement campoFirstName = driver.findElementByXPath(".//android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.EditText");
		campoFirstName.click();
		campoFirstName.sendKeys(firstName);
		
		return this;
	}
	
	public FormCadastraoUsuarioScreen inseriPhoneNumber(String phoneNumber) {
		MobileElement campoPhoneNumber = driver.findElementByXPath(".//android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText");
		campoPhoneNumber.click();
		campoPhoneNumber.sendKeys(phoneNumber);
		scrollByDimension(0.9, 0.0);
		
		return this;
	}
	
	public FormCadastraoUsuarioScreen inseriCountry(String country) {
		driver.findElementById("com.Advantage.aShopping:id/textViewCountries").click();
		scrollClick(country);
		
		return this;
	}
	
	public FormCadastraoUsuarioScreen inseriStates(String states) {
		MobileElement campoStates = driver.findElementByXPath(".//android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText");
		campoStates.click();
		campoStates.sendKeys(states);
		
		return this;
	}
	
	public FormCadastraoUsuarioScreen inseriAddress(String address) {
		MobileElement campoAddress = driver.findElementByXPath(".//android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText");
		campoAddress.click();
		campoAddress.sendKeys(address);
		
		return this;
	}
	
	public FormCadastraoUsuarioScreen inseriCity(String city) {
		MobileElement campoCity = driver.findElementByXPath(".//android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.EditText");
		campoCity.click();
		campoCity.sendKeys(city);
		
		return this;
	}

	public FormCadastraoUsuarioScreen inseriZipCode(String zipCode) {
		MobileElement campoZip = driver.findElementByXPath(".//android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[2]/android.widget.EditText");
		campoZip.click();
		campoZip.sendKeys(zipCode);
		
		return this;
	}

	public FormCadastraoUsuarioScreen checkBoxReceberPromocoes() {
		driver.findElementById("com.Advantage.aShopping:id/checkBoxRecieveOffers").click();
		
		return this;
	}

	public HomeScreen btnRegistrar() {
		driver.findElementById("com.Advantage.aShopping:id/buttonRegister").click();
		
		return new HomeScreen(driver);
	}
	
	public HomeScreen cadastroDeUsuario(String userName, String email, String password, String confirmPassword, String firstName,
			String lastName, String phoneNumber, String country, String states, String address, String city, String zipCode) {
		
		inseriUserName(userName);
		inseriEmail(email);
		inseriPassword(password);
		inseriConfirPassword(confirmPassword);
		inseriLastName(lastName);
		inseriFirstName(firstName);
		inseriPhoneNumber(phoneNumber);
		inseriCountry(country);
		inseriStates(states);
		inseriAddress(address);
		inseriZipCode(zipCode);
		inseriCity(city);
		checkBoxReceberPromocoes();
		
		btnRegistrar();
		
		return new HomeScreen(driver);
	}
	
	public String campoUserNameRequired() {
		return driver.findElementByXPath("//android.view.ViewGroup[@content-desc='Home Page']/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView").getText();
	}
	
	public String campoEmailRequired() {
		return driver.findElementByXPath("//android.view.ViewGroup[@content-desc='Home Page']/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView").getText();
	}
	
	public String campoPasswordRequired() {
		return driver.findElementByXPath("//android.view.ViewGroup[@content-desc='Home Page']/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.TextView").getText();
	}
	
	public String campoConfirmPasswordRequired() {
		return driver.findElementByXPath("//android.view.ViewGroup[@content-desc='Home Page']/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.TextView").getText();
	}
	
	public String getNomeUsuarioRandom(int qtdLetra) {
		Random random = new Random();
		int index;
		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVYWXZabcdefghijklmnopqrstuvxwyz0123456789";
		String palavraRandom = "";

		for (int i = 0; i <= qtdLetra - 1; i++) {
			index = random.nextInt(caracteres.length());
			palavraRandom += caracteres.substring(index, index + 1);
		}
		return palavraRandom;
	}
}
