package br.com.keeggo.screens;

import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class BaseScreen {

	protected AndroidDriver<MobileElement> driver;
	protected TouchAction<?> touchAction;
	
	public BaseScreen(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	public BaseScreen(AndroidDriver<MobileElement> driver, TouchAction<?> touchAction) {
		this.driver = driver;
		this.touchAction = touchAction;
	}
	
	public void scrollClick(String visibleText) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))").click();
	}
	
	public void scrollAndStop(String visibleText) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))");
	}
	
	public void scrollUp() {
		touchAction.press(PointOption.point(1063, 265)).moveTo(PointOption.point(1055, 1931)).perform();
	}
	
	public void scrollDown() {
		touchAction.press(PointOption.point(1063, 1680)).moveTo(PointOption.point(1055, 349)).perform();
	}
	
	public void hideKeyboard() {
		driver.hideKeyboard();
	}
	
	public void bntNextLine() {
		touchAction.tap(PointOption.point(992, 2099)).perform();
	}
	
	public void scrollByDimension(double inicio, double fim) {
	       
        Dimension size = driver.manage().window().getSize();
       
        int x = size.width / 2;
       
        int yInicial = (int) (size.height * inicio);
        int yFinal = (int) (size.height * fim);
       
        new TouchAction(driver)
        .press(PointOption.point(x, yInicial))
        .waitAction()
        .moveTo(PointOption.point(x, yFinal))
        .release().perform();
    }
}
