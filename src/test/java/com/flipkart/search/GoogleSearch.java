package com.flipkart.search;

import java.time.Duration;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class GoogleSearch {
	@Test
	public void search() {
		
		WebDriver driver = new SafariDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		Wait<WebDriver> wait = new FluentWait<>(driver)
			    .withTimeout(Duration.ofSeconds(30)) // Maximum wait time
			    .pollingEvery(Duration.ofSeconds(2))  // Poll the DOM every 2 seconds
			    .ignoring(org.openqa.selenium.NoSuchElementException.class); 
		
		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(By.name("q")));
		
		driver.findElement(By.name("q")).sendKeys("selenium");
		driver.quit();
	}
}
