package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.*;
import automation.common.commonBase;

public class Day8_practice2 extends commonBase {
	@BeforeMethod
	public void openbrowser()
	{
		driver = initChromeDriver("https://automationfc.github.io/basic-form/index.html");
	}
	
	@Test
	public void findElement()
	{
		WebElement txtuseremail = driver.findElement(By.id("mail"));
		System.out.println(txtuseremail);
		WebElement txtpassword = driver.findElement(By.name("disable_password"));
		System.out.println(txtpassword);
		WebElement txtnumber = driver.findElement(By.id("number"));
		System.out.println(txtnumber);
		WebElement Checkboxunder18 = driver.findElement(By.id("under_18v"));
		System.out.println(Checkboxunder18);
		
	}
	

}
