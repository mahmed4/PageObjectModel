package com.qa.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class GoogleTitileTest {
	WebDriver driver;
	@BeforeMethod
	public void setUp() { 
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Md Ahmed\\Documents\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://www.google.com");
  
	}
		
	@Test(priority=2,groups="title")
	public void googleTitleTest() { 
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Google");
			
	}
	@Test(priority=1,groups="logo", invocationCount=5)
	public void googleLogoTest() { 
		boolean b = driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed();
		//Assert.assertTrue(b);
		Assert.assertEquals(b, true);
	}
	@Test(priority=2,groups="link")
	public void gmailLinkTest() { 
		boolean c = driver.findElement(By.linkText("Gmail")).isDisplayed();
		//Assert.assertTrue(b);
		Assert.assertEquals(c, true);
	}
	@Test(priority=2,groups="gmailPageLink")
	public void gmailClickTest() { 
		 driver.findElement(By.linkText("Gmail")).click();
		 boolean b = driver.findElement(By.linkText("Create an account")).isDisplayed();
		Assert.assertEquals(b, true);
	}
	@Test(priority=1,groups="gmailPageLink")
	public void gmaillinkTest() { 
		 driver.findElement(By.linkText("Gmail")).click();
		 boolean b = driver.findElement(By.linkText("Sign in")).isDisplayed();
		Assert.assertEquals(b, true);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
