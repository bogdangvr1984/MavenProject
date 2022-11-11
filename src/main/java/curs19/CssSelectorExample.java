package curs19;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class CssSelectorExample extends BaseTest{
	
	//@Test
	public void cssSelectorExample1() {
		
		// ul.menu_user_nav
		// ul[class='menu_user_nav']
		
		// cssSelector pentru id --> #
		// #menu_user --> gaseste orice element care are id (#) cu valoarea 'menu_user'
		// ul#menu_user --> gaseste doar elementele care au tagname ul si au id (#) cu valoarea 'Menu_user'
		// ul[id='menu_user'] --> gaseste doar elementele care au tagname ul si au id (#) cu valoarea 'Menu_user'
		// ul--> tagname
		//id(#) --> atribut
		// menu_user --> valoare atribut
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		WebElement loginMenu = driver.findElement(By.cssSelector("#menu_user"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:green; border: 4px solid red;')", loginMenu);
		
		
		WebElement logoSlogan = driver.findElement(By.cssSelector("div[class='logo_slogan']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:green; border: 4px solid red;')", logoSlogan);	
		
	}
	
	//@Test
	public void cssSelectorExample2() {
	
		WebElement loginPopup = driver.findElement(By.cssSelector("a[href='#popup_login']"));
				   loginPopup.click();
		//AND
		WebElement userNameField = driver.findElement(By.cssSelector("input#log[type='text']"));
		           userNameField.sendKeys("TestUser");
		
		//input#log[type='text']
		//input[id='log'][type='text']		
		
		           //OR
		           WebElement passwordField = driver.findElement(By.cssSelector("input[id='password,],[name='pwd']"));		
		           passwordField.sendKeys("testuser");
		
	}
	
	//@Test
	public void cssSelectorExample3() {
		
		//* --> contains
		WebElement book1 = driver.findElement(By.cssSelector("a[href*='road'"));
		System.out.println(book1.getText());
		
		// ~ --> contains word
		WebElement book2 = driver.findElement(By.cssSelector("h3[class~='sc_title']"));
		System.out.println(book2.getText());
		
		// ^ --> starts with
		WebElement book3 = driver.findElement(By.cssSelector("a[href^='life']"));
		System.out.println(book3.getText());
		
		//$ --> ends with
		WebElement book4 = driver.findElement(By.cssSelector("a[href$='story']"));
		System.out.println(book4.getText());
		
	}
	
	@Test
	public void cssSelectorExample4() throws InterruptedException {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		WebElement selectedOption = driver.findElement(By.cssSelector("li[class*='sc_tabs_title'][aria-selected='true']"));
		
		jse.executeScript("arguments[0].setAttribute('style', 'background:green; border: 4px solid black;')", selectedOption);
		
		//NOT
		
		List<WebElement> menuEntries = driver.findElements(By.cssSelector("li[class*='sc_tabs_title']:not([aria-selected='true'])"));
		
		for(WebElement element : menuEntries) {
		
			jse.executeScript("arguments[0].setAttribute('style', 'background:orange; border: 4px solid black;')", element);
			Thread.sleep(6000);
			
		}
		
	}
	

}
