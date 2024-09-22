package automation.testsuite;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.commonBase;
import automation.constant.CT_PageURLs;
import automation.page.Function_bepantoan;

public class ThietBiNhaBep extends commonBase {
	@BeforeMethod
	public void openFireFox() {
		driver = initFirefoxDriver(CT_PageURLs.URL_BEPANTOAN);
	}
	@Test
	public void LoctheoDanhmuc() {
		click(By.xpath("//a[text()=' Thiết Bị Nhà Bếp Khác ']"));
		pause(2000);
		click(By.xpath("//a[text()='Viên Rửa Bát Chén']"));
		assertTrue(isElementVisibility(By.xpath("//h1[contains(text(),'Viên rửa bát đa năng')]")));
	}
	@Test
	public void LoctheoHangSX() {
		click(By.xpath("//a[text()=' Thiết Bị Nhà Bếp Khác ']"));
		pause(2000);
		click(By.xpath("(//span[text()='Xem thêm'])[1]"));
		click(By.xpath("(//div[@class='grid grid-cols-3 gap-1 md:grid-cols-2']/descendant::a)[3]"));
		assertTrue(isElementVisibility(By.xpath("//h4[contains(text(),'Eurosun')]")));
	}

	public void loctheoMucgia() {
		click(By.xpath("//a[text()=' Thiết Bị Nhà Bếp Khác ']"));
		pause(2000);
		click(By.xpath("(//div[@class='mb-3'])[2]"));
		assertTrue(isElementVisibility(By.xpath("//span[contains(text(),'3.300.000')]")));
		assertFalse(isElementVisibility(By.xpath("//span[contains(text(),'1.550.000')]")));
		assertFalse(isElementVisibility(By.xpath("//span[contains(text(),'7.600.000')]")));

	}

	public void LoctheoXuatXu() {
		click(By.xpath("//a[text()=' Thiết Bị Nhà Bếp Khác ']"));
		pause(2000);
		click(By.xpath("(//span[text()='Xem thêm'])[2]"));
		click(By.xpath("(//span[text()='Slovakia'])"));
		assertTrue(isElementVisibility(By.xpath("//h4[contains(text(),'Máy Pha Cà Phê BOSCH')]")));
	}

	public void Loctheochatlieu() {
		click(By.xpath("//a[text()=' Thiết Bị Nhà Bếp Khác ']"));
		pause(2000);
		click(By.xpath("(//div[@class='mb-3'])[3]"));
		click(By.xpath("(//div[@class='mb-1 show-more__item'])[3]"));
		assertTrue(isElementVisibility(
				By.xpath("//span[text()='Rất tiếc, không tìm thấy sản phẩm phù hợp với lựa chọn của bạn']")));
	}

	public void loctheoTGBaoHanh() {
		click(By.xpath("//a[text()=' Thiết Bị Nhà Bếp Khác ']"));
		pause(2000);
		click(By.xpath("//input[@id='3-nam-1113']"));
		assertTrue(isElementVisibility(By.xpath("//h4[contains(text(),'NỒI CHIÊN KHÔNG DẦU 6L EUROSUN')]")));
	}

	public void LoctheoXuatXuVaBaoHanh() {
		click(By.xpath("//a[text()=' Thiết Bị Nhà Bếp Khác ']"));
		pause(2000);
		click(By.xpath("(//span[text()='Xem thêm'])[2]"));
		click(By.xpath("(//div[@class='mb-1 show-more__item'])/descendant::input[@id='thailand-1020']"));
		click(By.xpath("//span[text()='3 năm']"));
		assertTrue(isElementVisibility(By.xpath("//h4[contains(text(),'NỒI CHIÊN KHÔNG DẦU 6L EUROSUN')]")));
	}

	/// fail
	public void LoctheoXuatXuVaChatLieu() {
		click(By.xpath("//a[text()=' Thiết Bị Nhà Bếp Khác ']"));
		pause(2000);
		click(By.xpath("(//span[text()='Xem thêm'])[2]"));
		click(By.xpath("(//span[text()='Slovakia'])"));
		pause(2000);
		scrollToElement(By.xpath("(//div[@class='mb-3'])[3]"));
		click(By.xpath("(//div[@class='mb-3'])[3]"));
		click(By.xpath("(//div[@class='mb-1 show-more__item'])[3]"));
		assertTrue(isElementVisibility(
		By.xpath("//span[text()='Rất tiếc, không tìm thấy sản phẩm phù hợp với lựa chọn của bạn']")));
	}

	public void LoctheoChatLieuVaBaoHanh() {
		click(By.xpath("//a[text()=' Thiết Bị Nhà Bếp Khác ']"));
		pause(2000);
		click(By.xpath("(//div[@class='mb-3'])[3]"));
		click(By.xpath("//span[text()='3 năm']"));
		assertTrue(isElementVisibility(
				By.xpath("//span[text()='Rất tiếc, không tìm thấy sản phẩm phù hợp với lựa chọn của bạn']")));
	}

	public void DanhSachPhoBien() {
		Function_bepantoan Export;
		click(By.xpath("//a[text()=' Thiết Bị Nhà Bếp Khác ']"));
		pause(2000);
		click(By.xpath("//a[@class='menu-tab active']"));
		Export = new Function_bepantoan(driver);
		Export.xuatDanhSachSanPham();

	}

	
	public void danhSachGiamGiaNhieu() {
		Function_bepantoan Export;
		click(By.xpath("//a[text()=' Thiết Bị Nhà Bếp Khác ']"));
		pause(2000);
		click(By.xpath("//a[text()='Giảm giá nhiều']"));
		Export = new Function_bepantoan(driver);
		Export.xuatDanhSachSanPham(); // Gọi hàm xuất danh sách sản phẩm
		assertTrue(isElementVisibility(By.xpath("//div[@class='absolute top-0 right-0 z-10']")));
		
		List<WebElement> discountelements = driver.findElements(By.xpath("//div[@class='absolute top-0 right-0 z-10']"));
		List<Double> discounts = new ArrayList<>();
		for (WebElement discountelement: discountelements) {
			String discounttext = discountelement.getText().replace("%", "").replace("-", "").trim();
			try {
				double discountvalue = Double.parseDouble(discounttext);
				discounts.add(discountvalue);
			} catch (NumberFormatException e) {
				System.out.println("chuyển đổi: " + discounttext);
			}
		}
		for (double discount : discounts) {
            System.out.println(discount);
        }
		 boolean isSorted = true;
	        for (int i = 1; i < discounts.size(); i++) {
	            if (discounts.get(i) < discounts.get(i - 1)) {
	                isSorted = false;
	                break;
	            }
	        }
	        // Kết quả
	        Assert.assertTrue(isSorted, "Danh sách hàng hóa không được sắp xếp theo giảm nhiều (tăng dần) .");
	    }
		

	
		 
		    public void DanhSachGiaThap() throws InterruptedException {
			 click(By.xpath("//a[text()=' Thiết Bị Nhà Bếp Khác ']"));
			 pause(2000);
			 click(By.xpath("//a[text()='Giá thấp']")); 
		        // Tìm tất cả các phần tử giá
		     List<WebElement> priceElements = driver.findElements(By.xpath("//div[contains(@class, 'prices')]"));

		        // Chuyển đổi giá thành danh sách số
		        List<Double> prices = new ArrayList<>();
		        for (WebElement priceElement : priceElements) {
		            String priceText = priceElement.getText()
		                    .replace("₫", "")//loại bỏ ký tự đ
		                    .replace("&nbsp;", "")
		                    .trim();

		            // Chuyển đổi sang số
		            try {
		                double priceValue = Double.parseDouble(priceText);
		                prices.add(priceValue);
		            } catch (NumberFormatException e) {
		                System.out.println("Không thể chuyển đổi giá: " + priceText);
		            }
		        } 
		        // In ra các giá đã chuyển đổi
		        for (double price : prices) {
		            System.out.println(price);
		        }
		        // Kiểm tra xem danh sách giá có sắp xếp tăng dần không
		        boolean isSorted = true;
		        for (int i = 1; i < prices.size(); i++) {
		            if (prices.get(i) < prices.get(i - 1)) {
		                isSorted = false;
		                break;
		            }
		        }
		        // Kết quả
		        Assert.assertTrue(isSorted, "Danh sách hàng hóa không được sắp xếp theo giá tăng dần.");
		    }
		 
		    public void DanhSachGiaCao()  {
			 click(By.xpath("//a[text()=' Thiết Bị Nhà Bếp Khác ']"));
			 pause(2000);
			 click(By.xpath("//a[text()='Giá cao']")); 
		        // Tìm tất cả các phần tử giá
		     List<WebElement> priceElements = driver.findElements(By.xpath("//div[contains(@class, 'prices')]"));

		        // Chuyển đổi giá thành danh sách số
		        List<Double> prices = new ArrayList<>();
		        for (WebElement priceElement : priceElements) {
		            String priceText = priceElement.getText()
		                    .replace("₫", "")//loại bỏ ký tự đ
		                    .replace("&nbsp;", "")
		                    .trim();

		            // Chuyển đổi sang số
		            try {
		                double priceValue = Double.parseDouble(priceText);
		                prices.add(priceValue);
		            } catch (NumberFormatException e) {
		                System.out.println("chuyển đổi giá: " + priceText);
		            }
		        } 
		        // In ra các giá đã chuyển đổi
		        for (double price : prices) {
		            System.out.println(price);
		        }
		        // Kiểm tra xem danh sách giá có sắp xếp tăng dần không
		        boolean isSorted = true;
		        for (int i = 1; i < prices.size(); i++) {
		            if (prices.get(i) < prices.get(i - 1)) {
		                isSorted = true;
		                break;
		            }
		        }
		        // Kết quả
		        Assert.assertTrue(isSorted, "Danh sách hàng hóa không được sắp xếp theo giá giảm dần.");
		    }
		 
		 @Test
		 public void CheckBtnXemThem()
		 {
			 click(By.xpath("//a[text()=' Thiết Bị Nhà Bếp Khác ']"));
			 pause(2000);
			 List<WebElement> elementBeforeClick = driver.findElements(By.xpath("//div[@class='max-w-[228px] m-auto']"));
			 int countBeforeClick = elementBeforeClick.size();
			
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement xemthem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Xem thêm'])[4]")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", xemthem);
			 pause(2000);
			// click(By.xpath("(//span[text()='Xem thêm'])[4]"));
			 List<WebElement> elementAfterClick = driver.findElements(By.xpath("//div[@class='max-w-[228px] m-auto']"));
			 int countAfterClick = elementAfterClick.size();
			 assertTrue(countBeforeClick < countAfterClick , "số lượng không tăng sau khi nhấn nút");
		 }
		 
	@AfterMethod
	public void CloseFireFox() {
		driver.close();
	}

}
