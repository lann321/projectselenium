package automation.page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Function_bepantoan {
	private WebDriver driver;
	public Function_bepantoan(WebDriver _driver)
	{
		this.driver = _driver;
		PageFactory.initElements(_driver, this);
	}
	public void xuatDanhSachSanPham() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    try {
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='flex flex-wrap product-list']//a")));
	        List<WebElement> productList = driver.findElements(By.xpath("//div[@class='flex flex-wrap product-list']//a"));

	        if (productList.isEmpty()) {
	            System.out.println("Không có sản phẩm nào được tìm thấy.");
	        } else {
	            for (WebElement product : productList) {
	                try {
	                    WebElement productNameElement = product.findElement(By.xpath(".//h4"));
	                    String productName = productNameElement.getText();
	                    System.out.println("Tên sản phẩm: " + productName);
	                } catch (StaleElementReferenceException e) {
	                    System.out.println("Không thể lấy tên sản phẩm, phần tử bị lỗi: " + e.getMessage());
	                }
	            }
	        }
	    } catch (Exception e) {
	        System.out.println("Có lỗi xảy ra khi lấy danh sách sản phẩm: " + e.getMessage());
	    }
	}
}
