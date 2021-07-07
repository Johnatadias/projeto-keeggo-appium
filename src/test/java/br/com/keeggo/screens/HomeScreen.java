package br.com.keeggo.screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeScreen extends BaseScreen{

	public HomeScreen(AndroidDriver<MobileElement> driver) {
		super(driver);
	}

	public HomeScreen clicarMenuNaHomePage() {
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("com.Advantage.aShopping:id/imageViewMenu"))).click();
	
		return this;
	}
	
	public LoginScreen clicarIconeLoginDoMenu() {
		driver.findElementById("com.Advantage.aShopping:id/textViewMenuUser").click();
		
		return new LoginScreen(driver);
	}
	
	public String assertNovoUsuario() {
		clicarMenuNaHomePage();
		
		return driver.findElementByXPath("//android.support.v4.widget.DrawerLayout[@content-desc='Main Menu']/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]").getText();
	}
}
