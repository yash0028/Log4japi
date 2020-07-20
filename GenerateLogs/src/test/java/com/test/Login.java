package com.test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Login {
	/*
	 * what is a log ?? capturing info/activities at the time of program exceution.
	 * 
	 * Types :
	 * 1.info,
	 * 2.warn,
	 * 3.debug,
	 * 4.fatal
	 * 
	 * how to generate ?? Use Apache Log4j APi
	 * How it works ?? it reads log4j configuration from log4j.properities from src/main/resources- log4j.properties file
	 */
	WebDriver driver;
	
	  Logger log = Logger.getLogger(Login.class);
		/*
		 * String log4jpath
		 * =System.getProperty("user.dir")+"\\src\\main\\resources\\log4j.properties";
		 * PropertyConfigurator.configure(log4jpath);
		 */
	 
			
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Installation\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		log.info("******************** window maximised *****************");

		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		log.debug("this is debug message");
		log.info("******************** opened browser *****************");
		log.warn("Hey this just a warning message");
		log.error("This is Error Message");
		log.fatal("hey this is just fatal error message");


		
	}
	
	
	@Test(priority = 1)
	public void login() {
		
		String title=driver.getTitle();
		System.out.println(title);
		log.info("******************** title captured *****************");

		Assert.assertEquals(title, "Google");
	}
	
	@Test(priority = 2)
	public void googleLogo() {

	boolean b=	driver.findElement(By.xpath("//*[@id=\'hplogo\']")).isDisplayed();
	log.info("******************** Logo Dispalyed *****************");

	Assert.assertTrue(b);
	}
	
	
	
	@AfterMethod
	public void close() {
		
		driver.quit();
		log.info("******************** Closed browser *****************");

		
		
	}
	
	
	
	
	
	
	
	
	

}
