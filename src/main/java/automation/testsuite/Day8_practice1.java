package automation.testsuite;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.*;

import automation.common.commonBase;
public class Day8_practice1 extends commonBase{
	@BeforeMethod
	public void openBrowser() {
		driver = initChromeDriver("https://selectorshub.com/xpath-practice-page/");
		
	}
	@Test
	public void findElementBy()
	{
		WebElement txtuseremail = driver.findElement(By.name("Email"));
		System.out.println(txtuseremail);

		WebElement txtpassword = driver.findElement(By.id("pass"));
		System.out.println(txtpassword);
		WebElement txtcompany = driver.findElement(By.name("company"));
		System.out.println(txtcompany);
		WebElement mobilenumber = driver.findElement(By.className("company"));
		System.out.println(mobilenumber);
		WebElement buttonSubmit = driver.findElement(By.tagName("button"));
		System.out.println(buttonSubmit);
		
	}

}
