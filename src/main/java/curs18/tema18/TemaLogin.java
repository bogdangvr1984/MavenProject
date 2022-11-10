package curs18.tema18;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class TemaLogin extends BaseTest{
	
	@Test
	public void verificaLogin() throws InterruptedException {
		WebElement clickLogin = driver.findElement(By.linkText("Login"));
		clickLogin.click();
		Thread.sleep(3000);
		
		WebElement loginField = driver.findElement(By.id("log"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red')", loginField);
		assertTrue(loginField.isDisplayed());
		Thread.sleep(3000);
		
		WebElement passwordField = driver.findElement(By.id("password"));
		jse.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red')", passwordField);
		assertTrue(passwordField.isDisplayed());
		Thread.sleep(3000);
		
		loginField.click();
		Thread.sleep(3000);
		
	}

}
