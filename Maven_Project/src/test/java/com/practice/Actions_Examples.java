package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Actions_Examples {
	
	@Test
	public void mouse_Over(){
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://flipkart.com");
		//driver.findElement(By.cssSelector("span[role='button']")).click();
		WebElement move = driver.findElement(By.xpath("//span[text()='Login']"));
		Actions action = new Actions(driver);
		// mouse over action
		action.moveToElement(move).build().perform();
		
		driver.findElement(By.xpath("//*[text()='My Profile']")).click();
		
		WebElement textBox = driver.findElement(By.cssSelector("input[title='Search for products, brands and more']"));
		// Key Actions
		action.moveToElement(textBox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		driver.close();
	}

}
