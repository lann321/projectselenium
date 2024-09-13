package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.commonBase;
import automation.constant.CT_PageURLs;

public class Day16_iFrame extends commonBase{
@BeforeMethod
	public void openFireFox()
	{
	driver = initFirefoxDriver(CT_PageURLs.URL_CODESTAR);
	}
	@Test
	public void findIndexIframe()
	{
		pause(5000);
		int totalIframe = getListWebElements(By.tagName("iframe")).size();
		System.out.println("Tổng số ifram"+totalIframe);
		for(int i=0; i< totalIframe; i++)
		{
			System.out.println("Switch tới iframe thứ"+i);
			try {
			driver.switchTo().frame(i);
			if(isElementVisibility(By.xpath("//button[normalize-space()='Gửi ngay']"))==true) 
			{
				System.out.println("iframe ở vị trí thứ:"+i);
			}
		}
			catch(Exception ex)
			{
				System.out.println("có exception xảy ra"+ex);
				findIndexIframe();
			}
		}
	}
	@Test
	public void handleframeDangkytuVan()
	{
		scrollToElement(By.xpath("(//iframe[@title='Khách hàng'])[1]"));
		WebElement btnguingay = getElementPresentDOM(By.xpath("(//iframe[@title='Khách hàng'])[1]"));
		driver.switchTo().frame(btnguingay);
		System.out.println("Switch tới iframe đăng ký tư vấn lộ trình thành công");
		type(By.id("name"), "test");
		type(By.id("phone_number"), "0321456587");
		click(By.xpath("//button[normalize-space()='Gửi ngay']"));
		assertTrue(isElementVisibility(By.xpath("//button[normalize-space()='Gửi ngay']")));
	}
}
