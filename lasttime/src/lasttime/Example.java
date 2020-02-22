package lasttime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Example {
	
	private static WebDriver driver;
	
    final String Title = "This is a Liferary Forms";
    final String Website = "https://forms.liferay.com/web/forms/shared/-/form/122548";
    final String path = "/Users/najibelguertit/eclipse-workspace/lastime/chromedriver";
    

	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", path);
		driver.get(Website);
		
	}
	
	@Test
	public void Tryme() {
		
		
		WebElement text = driver.findElement(By.xpath("//*[contains(text(),'party rock')]"));
		WebElement name = driver.findElement(By.cssSelector("input[name*=WhatIsYourName]"));
		WebElement date_field = driver.findElement(By.cssSelector("input[ref=inputElement]"));
		WebElement area = driver.findElement(By.cssSelector("textarea[name*=WhyDidYouJoinTheTestingArea]"));
		WebElement field = driver.findElement(By.xpath("//*[contains(text(),'This field is required.')]"));
		
		//check of the page title
		assertEquals(Title,driver.getTitle());

		assertTrue("the party rock was not found", text.isDisplayed());
		
		name.sendKeys("najib");
		name.sendKeys(Keys.TAB);
		
		//take a date from your computer
		DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
		Date date= new Date();
		String today = dateformat.format(date);
		
		date_field.sendKeys(today);

		area.sendKeys("it is a long story");
		
		driver.findElement(By.cssSelector("button[type=Submit]")).click();
		
		//if one field was missing test wont pass
		assertTrue("Field is missing", field.isDisplayed());
	}
	@After
	public void close() {
		driver.close();
	}

}
