package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Edit {
	private WebDriver driver;
	@FindBy(xpath = "//div[@class='avatar2']") WebElement Taikhoan;
	@FindBy(xpath = "(//a[@class='btn-anis-effect'])[2]") WebElement Dangnhap;
	@FindBy(className = "txtLoginUsername") WebElement Username;
	@FindBy(className = "txtLoginPassword") WebElement Password;
	@FindBy(xpath = "(//button[text()='ĐĂNG NHẬP'])[3]") WebElement btnDangnhap;
	@FindBy(xpath = "//a[text()='Chỉnh sửa thông tin']") WebElement Chinhsua;
	@FindBy(xpath = "//input[@class='maxwidth']") WebElement Tendangnhap;
	@FindBy(className = "//input[@placeholder='Mật khẩu hiện tại']") WebElement PassHienTai;
	@FindBy(id = "txtnewpass") WebElement NewPass;
	@FindBy(id = "txtrenewpass") WebElement ReNewPass;
	@FindBy(xpath = "//button[@onclick='checkFormPass();']") WebElement BtnSaveNewPass;
	@FindBy(xpath = "//a[text()='Thoát']") WebElement Logout;
	public Edit(WebDriver _driver)
	{
		this.driver= _driver;
		PageFactory.initElements(_driver, this);
	}
	public void Edit(String username, String password,String newpass,String renewpass)
	{
		
		Username.sendKeys(username);
		Password.sendKeys(password);
		btnDangnhap.click();
		Taikhoan.click();
		Chinhsua.click();
		Tendangnhap.sendKeys(username);
		PassHienTai.sendKeys(password);
		NewPass.sendKeys(newpass);
		ReNewPass.sendKeys(renewpass);
		BtnSaveNewPass.click();
		Taikhoan.click();
		Logout.click();
		Username.sendKeys(username);
		Password.sendKeys(newpass);
		
		
	}
	
}
