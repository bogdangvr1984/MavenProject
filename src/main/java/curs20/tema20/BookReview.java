package curs20.tema20;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class BookReview extends BaseTest{
	
	@Test
	public void reviewCarte() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		driver.findElement(By.cssSelector("div[class='menu_main_wrap']>nav[class='menu_main_nav_area']>ul>li:nth-of-type(2)")).click();
		
		jse.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("li[class*='column-1_4'] h2[class*='woocommerce']>a[href='https://keybooks.ro/shop/its-a-really-strange-story/']")).click();
		
		Thread.sleep(2000);
		
		jse.executeScript("window.scrollBy(0,500)");
		
		driver.findElement(By.cssSelector("div[class*='woocommerce-tabs'] li[class='reviews_tab']>a[href='#tab-reviews']")).click();
		
        Thread.sleep(2000);
		
		jse.executeScript("window.scrollBy(0,300)");
		
		WebElement submit = driver.findElement(By.cssSelector("div[class*='woocommerce-Tabs-panel'] p[class='form-submit']>input[value='Submit']"));
		submit.click();
		
		Thread.sleep(3000);
		
		driver.switchTo().alert().accept();
		
		Thread.sleep(500);
		
		driver.findElement(By.cssSelector("div[class='comment-form-rating'] a[class='star-3']")).click();
		
		WebElement review = driver.findElement(By.cssSelector("p[class='comment-form-comment'] textarea[id='comment']"));		
        review.sendKeys("A great read!");
		
        Thread.sleep(500);
     
        WebElement name = driver.findElement(By.cssSelector("p[class='comment-form-author'] input[id='author']"));		
        name.sendKeys("Bogdan");
        
        Thread.sleep(500);
        
        WebElement email = driver.findElement(By.cssSelector("p[class='comment-form-email'] input[id='email']"));
        email.sendKeys("gavriluta@gmail.com");
		
		Thread.sleep(500);
		
		WebElement cookies = driver.findElement(By.cssSelector("p[class='comment-form-cookies-consent']>input[id='wp-comment-cookies-consent']"));
		cookies.click();
		assertEquals(cookies.isSelected(), true);
		Thread.sleep(500);
		
		submit.click();
		
		Thread.sleep(500);
		
		jse.executeScript("window.scrollBy(0,300)");
		
        WebElement result = driver.findElement(By.cssSelector("p[class='meta']>em[class='woocommerce-review__awaiting-approval']"));
        jse.executeScript("arguments[0].setAttribute('style', 'background:yellow;')", result);
        
		assertEquals(result.getText(), "Your review is awaiting approval");
	}

}
