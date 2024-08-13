package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.commonBase;
import automation.constant.CT_PageURLs;

public class day12_btvn extends commonBase{
	@BeforeMethod
	public void openChrome()
	{
		driver = initChromeDriver(CT_PageURLs.URL_SELENIUMEASY4);
	}
	@Test
	public void case1_dropdownlistState()
	{
		Select dropdownState =new  Select(driver.findElement(By.xpath("//select[@name='state']")));
		//kiem tra size
		assertEquals(dropdownState.getOptions().size(), 52);
		//chon 1 gia tri
		dropdownState.selectByVisibleText("Texas");
		assertEquals(dropdownState.getFirstSelectedOption().getText(), "Texas");
	}
	@Test
	public void case2_checkboxHosting()
	{
		WebElement checkboxYes= driver.findElement(By.xpath("//input[@name ='hosting' and @value='yes']"));
		if(checkboxYes.isSelected())
		{
			checkboxYes.click();
			assertTrue(checkboxYes.isSelected());
		}
		WebElement checkboxNo = driver.findElement(By.xpath("//input[@name ='hosting' and @value='no']"));
		if(checkboxNo.isSelected())
		{
			checkboxNo.click();
			assertTrue(checkboxNo.isSelected());
			assertFalse(checkboxYes.isSelected());
		}
	}
}
