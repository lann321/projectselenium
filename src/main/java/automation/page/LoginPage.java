package automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;
	public LoginPage(WebDriver _driver)
	{
		this.driver= _driver;
	}
	// xây dựng hàm đăng nhập sử dụng trong các 011
	public void LoginFunction(String email, String password)
	{
		WebElement btnDangnhap =driver.findElement(By.xpath("//a[text()='Đăng Nhập']"));
		if(btnDangnhap.isDisplayed()) btnDangnhap.click();
		
		WebElement textEmail = driver.findElement(By.id("txtLoginUsername"));
		if(textEmail.isDisplayed())
		{
			
			textEmail.sendKeys(email);
		}
		WebElement textPassword = driver.findElement(By.id("txtLoginPassword"));
		if(textPassword.isDisplayed())
		{
			textPassword.sendKeys(password);
		}
		WebElement btnlogin = driver.findElement(By.xpath("//button[text()='ĐĂNG NHẬP'and @type ='submit']"));
		if(btnlogin.isDisplayed())
		{
			btnlogin.click();
		}
	}
}
