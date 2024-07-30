package automation.testsuite;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.*;

import automation.common.commonBase;
public class Day8 extends commonBase {
	@BeforeMethod
	public void openBrowser()
	{
		driver = initChromeDriver("https://alada.vn/tai-khoan/dang-ky.html");
		
	}
	@Test
	public void getElementBy()
	{
		WebElement txthovaten = driver.findElement(By.id("txtFirstname"));
		System.out.println(txthovaten);
		
		WebElement txtEmail =driver.findElement(By.name("txtEmail"));
		System.out.println(txtEmail);
		
		WebElement linkchinhsach =driver.findElement(By.linkText("chính sách"));
		System.out.println(linkchinhsach);
		
		WebElement linkthoathuansudung = driver.findElement(By.partialLinkText("thỏa thuận"));
		System.out.println(linkthoathuansudung);
		
		WebElement checkboxdongy = driver.findElement(By.className("marleft0"));
		System.out.println(checkboxdongy);
		
		WebElement buttondangky = driver.findElement(By.tagName("button"));
		System.out.println(buttondangky);
	}
}
