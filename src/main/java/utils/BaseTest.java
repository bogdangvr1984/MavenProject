package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;

	@BeforeClass
	public void setup() {
		
		driver = WebDriverManager.chromedriver().create();
		driver.get("https://keybooks.ro");
		//driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
	}
	
	
	@AfterClass
	
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(6000);
		driver.quit();
	}

}
