package automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage_Day13_bai2 {
	private WebDriver driver;
	public LoginPage_Day13_bai2(WebDriver _driver)
	{
		this.driver= _driver;
	}
	// xây dựng hàm đăng nhập sử dụng trong các 011
	public void LoginFunction(String email, String password)
	{
	
		
		WebElement Email = driver.findElement(By.xpath("//input[@name='email']"));
		if(Email.isDisplayed())
		{
			
			Email.sendKeys(email);
		}
		WebElement Password = driver.findElement(By.xpath("//input[@name='password']"));
		if(Password.isDisplayed())
		{
			Password.sendKeys(password);
		}
		WebElement btnlogin = driver.findElement(By.xpath("//button[text()='Đăng nhập']"));
		if(btnlogin.isDisplayed())
		{
			btnlogin.click();
		}
	}
}
