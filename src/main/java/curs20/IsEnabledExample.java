package curs20;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class IsEnabledExample extends BaseTest{
	
    @Test
    public void isEnabledExample() {
    	
    	driver.findElement(By.cssSelector("li[class='menu_user_login']>a[href='#popup_login']")).click();
    	
    	WebElement passwordField = driver.findElement(By.cssSelector("div[class*='password_field']>input"));
    	
    	System.out.println(passwordField.isEnabled());
    	JavascriptExecutor jse = (JavascriptExecutor) driver;
    	jse.executeScript("arguments[0].setAttribute('dsabled', '')", passwordField);
    	
    	System.out.println("After disabled:" + passwordField.isEnabled());
    }

}
