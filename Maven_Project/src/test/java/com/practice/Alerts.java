package com.practice;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	@Test
	public  void alerts_Tests() {
		// TODO Auto-generated method stub

		String text = "Narayanan";

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.id("name")).sendKeys(text);

		driver.findElement(By.cssSelector("[id='alertbtn']")).click();

		// get the text from the alert pop-up
		System.out.println(driver.switchTo().alert().getText());

		// Click OK
		driver.switchTo().alert().accept();

		driver.findElement(By.id("confirmbtn")).click();

		// get the text from the alert pop-up
		System.out.println(driver.switchTo().alert().getText());

		// Click Cancel

		driver.switchTo().alert().dismiss();

		driver.close();

	}

}
