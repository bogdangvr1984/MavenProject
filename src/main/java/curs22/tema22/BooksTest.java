package curs22.tema22;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.MenuPage;
import utils.BaseTest;

public class BooksTest extends BaseTest{
	
	@Test
	public void shopPage() throws InterruptedException {
	
	JavascriptExecutor jse = (JavascriptExecutor) driver;
		MenuPage menu = new MenuPage(driver);
		menu.navigateTo(menu.booksLink);
	jse.executeScript("window.scrollBy(0,300)");
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[contains( text(), 'New galaxy' )]")).click();
	
	Thread.sleep(2000);
	
	WebElement zoom = driver.findElement(By.xpath("//a[@href='#' and @class='woocommerce-product-gallery__trigger']"));
	jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid blue')", zoom);
		assertEquals(zoom.isDisplayed(), true);
		
	Thread.sleep(2000);
	
	WebElement rating = driver.findElement(By.xpath("//div[@class='woocommerce-product-rating']/div[@class='star-rating']"));
	jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid blue')", rating);
	    assertEquals(rating.isDisplayed(), true);
	    
	Thread.sleep(2000);
	
	WebElement title = driver.findElement(By.xpath("//h1[contains( text(), 'New galaxy')]"));
	jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid blue')", title);
	    assertEquals(title.isDisplayed(), true);
	    
    Thread.sleep(2000);
		
	WebElement price = driver.findElement(By.xpath("(//p[@class='price']/span)[1]"));
	jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid blue')", price);
		assertEquals(price.isDisplayed(), true);
		
	Thread.sleep(2000);
	
	WebElement quantity = driver.findElement(By.xpath("//div[@class='quantity']/descendant::input[@type='number']"));
	jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid blue')", quantity);
		assertEquals(quantity.isDisplayed(), true);
	
	Thread.sleep(2000);
	
	WebElement description = driver.findElement(By.xpath("//div[@class='woocommerce-product-details__short-description']/p[contains( text(), 'Weston-super-Mare')]"));
	jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid blue')", description);
		assertEquals(description.isDisplayed(), true);
	
	Thread.sleep(2000);
	
	WebElement addToCart = driver.findElement(By.xpath("//button[@type='submit' and @name='add-to-cart']"));
	jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid blue')", addToCart);
		assertEquals(addToCart.isDisplayed(), true);
	
	Thread.sleep(2000);
	
	WebElement categories = driver.findElement(By.xpath("//div[@class='product_meta']/span[@class='posted_in']"));
	jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid blue')", categories);
		assertEquals(categories.isDisplayed(), true);	
	
	}

}
