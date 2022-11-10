package curs18;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class SeleniumLocatorExample extends BaseTest{
	
	@Test(priority = 1)
	public void tagNameLocator() {
		
		//<em>Discover</em>
		
		//driver.findElement(By.tagName("em")).click();
		
		WebElement discoverText = driver.findElement(By.tagName("em"));
		String text = discoverText.getText();
		
		System.out.println(text);
		System.out.println(discoverText.getText());
		
		assertEquals(text, "Discover");
		
	}
	
	@Test(priority = 2)
	public void linkTextLocator() throws InterruptedException {
		
		//<a href="https://keybooks.ro/shop/" aria-current="page">Books</a>
		
		WebElement bookLink = driver.findElement(By.linkText("BOOKS"));
		bookLink.click();
		
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/");
		
		
		Thread.sleep(3000);
	}
	
	@Test(priority = 3)
	public void partialLinkTextLocator() throws InterruptedException {
		WebElement cookingBook = driver.findElement(By.partialLinkText("Cooking"));
		cookingBook.click();
		
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/cooking-with-love/");
		
		Thread.sleep(3000);
		
	}
	
	@Test(priority = 4)
	public void classNameLocator() throws InterruptedException {
		WebElement price = driver.findElement(By.className("price"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border: 2px solid red')", price);
		
		assertTrue(price.getText().contains("20.55"));
		
		Thread.sleep(3000);
	}
	
	@Test(priority = 5)
	public void idLocator() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)");
		WebElement reviewTab = driver.findElement(By.id("tab-title-reviews"));
		reviewTab.click();
		WebElement commentBox = driver.findElement(By.id("comment"));
		
		assertTrue(commentBox.isDisplayed());
		
		Thread.sleep(3000);
		
	}
	
	@Test(priority = 6)
	public void nameLocator() throws InterruptedException {
		
		WebElement commentBox = driver.findElement(By.name("comment"));
		commentBox.sendKeys("My super comment");
		
		Thread.sleep(3000);
	}
	
	@Test(priority = 7)
	public void cssSelectorLocator() throws InterruptedException {
		
		WebElement authorField = driver.findElement(By.cssSelector("input[name='author']"));
		authorField.sendKeys("Test Ceva");
		
		Thread.sleep(3000);
		authorField.clear();
		authorField.sendKeys("Test Altceva");
		Thread.sleep(3000);
	}
	
	@Test(priority = 8)
	public void xpathLocator() throws InterruptedException {
		
		WebElement emailField = driver.findElement(By.xpath("//input[@name='email']"));
		emailField.sendKeys("test@test.ceva");
		
		Thread.sleep(3000);
	}
	

}
