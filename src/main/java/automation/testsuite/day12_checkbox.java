package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.commonBase;
import automation.constant.CT_PageURLs;

public class day12_checkbox extends commonBase{
	@BeforeMethod
	public void openChrome()
	{
		driver = initChromeDriver(CT_PageURLs.URL_SELENIUMEASY);
	}
	@Test
	public void case1_CheckDefaultValue()
	{
		WebElement defaultCheck = driver.findElement(By.xpath("//label[@class='checkbox-inline'][2]/descendant::input"));
		// kiểm tra giá trị mặc định xpath được check hay chưa kết quả mong muốn isSelected = true
		defaultCheck.isSelected();
		assertTrue(defaultCheck.isSelected());
	}
	@Test
	public void case2_CheckTthischeckboxSuccessfully()
	{
		WebElement Thischeckbox = driver.findElement(By.xpath("//div[@class='checkbox']/descendant::input[@id='isAgeSelected']"));
		// nếu checkbox chưa được chọn
		if(Thischeckbox.isSelected()==false)
		{
			// chọn vào checkbox
			Thischeckbox.click();
			WebElement testsuccess = driver.findElement(By.id("txtAge"));
			assertTrue(testsuccess.isDisplayed());
		}
	}
	@Test
	public void case1_CheckmultipleCheckboxSuccessfully()
	{
		List<WebElement> listcheckbox = driver.findElements(By.xpath("(//div[@class='panel-body'])[3]/descendant::input[@type='checkbox']"));
		for(int i=0; i<listcheckbox.size(); i++)
		{
			WebElement checkbox = listcheckbox.get(i);
			if(checkbox.isSelected()==false)
			{
				checkbox.click();
				assertTrue(checkbox.isSelected());
				System.out.println("Checkbox thư" +(i+1)+"đã được check");
			}
		}
	}
	@Test
	public void case2_CheckmultipleCheckboxSuccessfully()
	{
		List<WebElement> listcheckbox = driver.findElements(By.xpath("(//div[@class='panel-body'])[3]/descendant::input[@type='checkbox']"));
		for(int i=0; i<listcheckbox.size(); i++)
		{
			WebElement checkbox = driver.findElement(By.xpath("(//div[@class='panel-body'])[3]/descendant::input[@type='checkbox']["+(i+1)+"]"));
			if(checkbox.isSelected()==false)
			{
				checkbox.click();
				assertTrue(checkbox.isSelected());
			}
		}
	}
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
	
}
