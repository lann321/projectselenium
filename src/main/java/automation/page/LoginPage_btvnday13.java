package automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage_btvnday13 {
	private WebDriver driver;
	public LoginPage_btvnday13(WebDriver _driver)
	{
		this.driver= _driver;
	}
	// xây dựng hàm đăng nhập sử dụng trong các 011
	public void LoginFunction(String email, String password)
	{
	
		
		WebElement textEmail = driver.findElement(By.id("email"));
		if(textEmail.isDisplayed())
		{
			
			textEmail.sendKeys(email);
		}
		WebElement textPassword = driver.findElement(By.id("password"));
		if(textPassword.isDisplayed())
		{
			textPassword.sendKeys(password);
		}
		WebElement btnlogin = driver.findElement(By.xpath("//button[text()='Login']"));
		if(btnlogin.isDisplayed())
		{
			btnlogin.click();
		}
	}
}
