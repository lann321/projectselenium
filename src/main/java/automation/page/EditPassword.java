package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditPassword {
	private WebDriver driver;
	@FindBy(xpath = "//ul[@class='menu fright marbot0']//li[@id='showsub']//a[@class='fleft w100per headcate']") WebElement submenu;
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
	public EditPassword(WebDriver _driver)
	{
		this.driver= _driver;
		PageFactory.initElements(_driver, this);
	}
	public void EditPassword(String username, String password,String newpass,String renewpass)
	{
		//dang nhap
		Username.sendKeys(username);
		Password.sendKeys(password);
		btnDangnhap.click();
		
		//chon button chinh sua
		submenu.click();
		Chinhsua.click();
		//chinh sua pass
		Tendangnhap.sendKeys(username);
		PassHienTai.sendKeys(password);
		NewPass.sendKeys(newpass);
		ReNewPass.sendKeys(renewpass);
		BtnSaveNewPass.click();
		//logout
		submenu.click();
		Logout.click();
		//login voi pass moi
		Username.sendKeys(username);
		Password.sendKeys(newpass);
		btnDangnhap.click();
		
		
	}
	
}
