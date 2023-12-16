package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FrameTest {
	
	@Test
	public void drag_And_Drop() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get("https://jqueryui.com/droppable");
		
		//get count of iframes
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		// switch to iframe
		//index of iframe
		//driver.switchTo().frame(0);
		
		// switch to iframe
		//WebElement
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		
		Actions action = new Actions(driver);
		
		WebElement source = driver.findElement(By.cssSelector("div#draggable"));
		
		WebElement target = driver.findElement(By.cssSelector("div#droppable"));
		action.dragAndDrop(source, target).build().perform();
		
		// back to default window
		driver.switchTo().defaultContent();
		driver.close();
	}

}
