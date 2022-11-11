package curs19.tema19;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class ContactUs extends BaseTest{
	
	@Test
	
	public void contactUsForm () throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		WebElement contacts = driver.findElement(By.cssSelector("a[href='https://keybooks.ro/contacts/']"));
		   contacts.click();
		   
		   Thread.sleep(2000);
		   
		   jse.executeScript("window.scrollBy(0,500)");
		   
	    WebElement nameField = driver.findElement(By.cssSelector("input[name='your-name']"));		
           nameField.sendKeys("Bogdan");
           
           Thread.sleep(2000);
        
        WebElement emailField = driver.findElement(By.cssSelector("input[name='your-email']"));		
           emailField.sendKeys("gavriluta@gmail.com");
		
           Thread.sleep(2000);
        
        WebElement subjectField = driver.findElement(By.cssSelector("input[name='your-s']"));		
           subjectField.sendKeys("tema19");
           
           Thread.sleep(2000);
           
        WebElement messageField = driver.findElement(By.cssSelector("textarea[name='your-message']"));	
           messageField.sendKeys("Tema 19 am facut. Testul asta a trecut!");
           
        WebElement sendMessage = driver.findElement(By.cssSelector("input[value='Send Message']"));	
            sendMessage.click();
            
            Thread.sleep(2000);
       
        WebElement messageSent = driver.findElement(By.cssSelector("div[class='wpcf7-response-output'][aria-hidden='true']"));
        jse.executeScript("arguments[0].setAttribute('style', 'background:yellow;')", messageSent);
        
            assertTrue(messageSent.getText().contains("Thank you for your message. It has been sent."));
           
	}

}
