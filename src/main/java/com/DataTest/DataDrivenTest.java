package com.DataTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {
	
	WebDriver driver;
	
	
	@BeforeClass
	public void signup() {
		
		System.setProperty("webdriver.chrome.driver","F:\\chrome extension\\chromedriver_win32\\chromedriver.exe");
		
		  driver = new ChromeDriver();
		  
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  
		  driver.manage().window().maximize();
		
	}
	
	@Test (dataProvider="loginData1")
	public void loginTest(String user, String pass) {
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.id("txtUsername")).sendKeys(user);
		
		driver.findElement(By.id("txtPassword")).sendKeys(pass);
		
		driver.findElement(By.id("btnLogin")).click();
		
	     driver.close();
		
	}
	@DataProvider() 
	public Object[][] loginData1() {
		
		Object data [][] = new Object [2][2];
		
		data [0][0]= "Admin";
		data [0][1]= "admin123";
		
		data [1][0]= "Admin";
		data [1][1]= "admin1234";
		
		return data;
		
	}
	
	@AfterClass
	public void tearDown() {
		
		//driver.close();
		
	}

}
