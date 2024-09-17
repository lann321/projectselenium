package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import automation.common.commonBase;
import automation.constant.CT_PageURLs;
import automation.page.UpdatePassWord_PageFactory;

public class UpdatePassWordTest_Day15 extends commonBase{

	@BeforeMethod
	@Parameters("browser")
	
	public void openChrome(String browserName)
	{
		setupDriver(browserName);
		driver.get(CT_PageURLs.URL_TERU);
		//driver =initMSEdgeDriver(CT_PageURLs.URL_TERU);
	}
	
	@Test
	public void UpdatePasswordSuccessfully()throws InterruptedException
	{
		UpdatePassWord_PageFactory updatepass = new UpdatePassWord_PageFactory(driver);
		updatepass.LoginFuntion("Lan@gmail.com", "1234567");
		pause(5000);
		updatepass.UpdatePassWord("1234567", "1234567");
		assertTrue(driver.findElement(By.xpath("//div[text()='Đổi mật khẩu thành công. Mời bạn đăng nhập lại.']")).isDisplayed());
	}
	
	public void SearchKhoahoc() throws InterruptedException
	{
		UpdatePassWord_PageFactory search = new UpdatePassWord_PageFactory(driver);
		search.LoginFuntion("Lan@gmail.com", "123456");
		Thread.sleep(10000);
		search.Search("asp.net");
		assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Lập trình dự án Website bán hàng ASP.NET MVC 4')]")).isDisplayed());
		
	}
}
