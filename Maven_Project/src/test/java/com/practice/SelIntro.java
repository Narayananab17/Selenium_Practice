package com.practice;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelIntro {

	@Test
	public void selenium_Intro() throws InterruptedException {
		// TODO Auto-generated method stub

		// WebDriver driver = new SafariDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		String password = getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		driver.findElement(By.id("inputUsername")).sendKeys("Naren");
		driver.findElement(By.name("inputPassword")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@class='submit signInBtn']")).click();

		System.out.println(driver.findElement(By.cssSelector(".error")).getText());

		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("*[placeholder='Name']")).sendKeys("Naren");
		driver.findElement(By.xpath("//*[@placeholder='Email']")).sendKeys("Naren@gmail.com");
		driver.findElement(By.xpath("//*[@type='text'][3]")).sendKeys("8983123456");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		// System.out.println(driver.findElement(By.cssSelector(".infoMsg")).getText());
		// String text = driver.findElement(By.cssSelector(".infoMsg")).getText();
		// String Password = text.substring(31,49);
		// System.out.println(Password);

		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("inputUsername")).sendKeys("Naren");
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.cssSelector("#chkboxOne")).click();
		driver.findElement(By.cssSelector("*[name='chkboxTwo']")).click();
		driver.findElement(By.xpath("//*[@class='submit signInBtn']")).click();

		System.out.println(driver.findElement(By.xpath("//*[text()='You are successfully logged in.']")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//*[text()='You are successfully logged in.']")).getText(),
				"You are successfully logged ");
		driver.findElement(By.cssSelector(".logout-btn")).click();
		driver.close();

	}

	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

		String passwordtext = driver.findElement(By.cssSelector(".infoMsg")).getText();
		String[] passwordArray = passwordtext.split("'");
		String[] passwordArray2 = passwordArray[1].split("'");
		String password = passwordArray2[0];
		return password;

	}

}
