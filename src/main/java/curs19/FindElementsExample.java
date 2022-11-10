package curs19;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class FindElementsExample extends BaseTest {

	@Test
	public void testFindElements() {
		
		
		List<WebElement> bookPictures = driver.findElements(By.cssSelector("figure[class*='sc_image_shape_square']"));
		
		bookPictures.get(3);
		
		for(WebElement element : bookPictures) {
			
		}
	
	}
}
