package curs21.tema21;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utils.BaseTest;

public class SingleAuthor extends BaseTest{
	
	
	@Test
	public void skills() {
		
		driver.findElement(By.cssSelector("a[href='/margaret-robins/']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div[class='sc_skills_total'][data-stop='95']"), "95%"));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div[class='sc_skills_total'][data-stop='75']"), "75%"));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div[class='sc_skills_total'][data-stop='82']"), "82%"));
	}

}
