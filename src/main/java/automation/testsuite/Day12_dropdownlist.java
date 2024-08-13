package automation.testsuite;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.commonBase;
import automation.constant.CT_PageURLs;

public class Day12_dropdownlist extends commonBase{
	@BeforeMethod
	public void openChrome()
	{
		driver = initChromeDriver(CT_PageURLs.URL_SELENIUMEASY3);
	}
	@Test
	public void case1_dropdownlist()
	{
		Select dropdownDay =new Select(driver.findElement(By.id("select-demo")));
		//kiem tra size cua dropdown
		assertEquals(dropdownDay.getOptions().size(),8);
		//chon monday va kiem tra gia tri sau khi chon
		dropdownDay.selectByVisibleText("Monday");
		//dropdownDay.getFirstSelectedOption().getText();
		assertEquals(dropdownDay.getFirstSelectedOption().getText(), "Monday");
		
		dropdownDay.selectByValue("Tuesday");
		assertEquals(dropdownDay.getFirstSelectedOption().getText(), "Tuesday");
		dropdownDay.selectByIndex(1);
		assertEquals(dropdownDay.getFirstSelectedOption().getText(), "Sunday");
	}
}
