package automation.testsuite;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.commonBase;
import automation.constant.CT_PageURLs;

public class TBNB extends commonBase{
	@BeforeMethod
	public void openFireFox()
	{
		driver =initFirefoxDriver(CT_PageURLs.URL_BEPANTOAN);
	}
	@Test (priority = 1)
	public void LoctheoDanhmuc()
	{
		// Click vào liên kết
		click(By.xpath("//a[text()=' Thiết Bị Nhà Bếp Khác ']"));
		pause(2000);

		// Khai báo danh sách các thẻ
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='mb-1']")); 
		int count = elements.size();
		System.out.println("Số lượng thẻ: " + count);

		// Giá trị mong muốn cho từng thẻ
		String[] expectedValues = {
		    "MÁY SẤY CHÉN BÁT", 
		    "LÒ NƯỚNG ĐA NĂNG", 
		    "LÒ VI SÓNG",
		    "ĐỒ GIA DỤNG",
		    "MÁY LỌC NƯỚC",
		    "TỦ LẠNH CHÍNH HÃNG",
		    "TỦ RƯỢU MẪU MÃ ĐẸP",
		    "VIÊN RỬA BÁT ĐA NĂNG",
		    "QUẠT ĐIỀU HÒA",
		    "NỒI CHIÊN KHÔNG DẦU CHÍNH HÃNG",
		    "CÂY NƯỚC NÓNG LẠNH GIÁ RẺ, CAY NUOC NONG LANH LOẠI NÀO TỐT?",
		    "MÁY GIẶT",
		    "   "
		}; // Thay thế bằng các giá trị mong muốn cho từng thẻ

		// Kiểm tra xem số lượng thẻ có nhiều hơn số lượng giá trị mong muốn không
		if (count > expectedValues.length) {
		    System.out.println("Cảnh báo: Số lượng thẻ lớn hơn số lượng giá trị mong muốn. Sẽ chỉ thực hiện với số lượng giá trị mong muốn.");
		    count = expectedValues.length; // Giới hạn số lượng click
		}

		// Click vào từng thẻ và assert giá trị
		for (int i = 0; i < count; i++) {
			
		    elements.get(i).click(); // Click vào phần tử
		    pause(2000);
		    
		    // Assert giá trị sau khi click
		    WebElement resultElement = driver.findElement(By.xpath("//div[@class='mb-1 xl:mb-5']")); 
		    String actualValue = resultElement.getText();
		    System.out.println("Giá trị thực tế cho thẻ " + (i + 1) + ": " + actualValue); // In ra giá trị thực tế
		    System.out.println("Giá trị mong muốn cho thẻ " + (i + 1) + ": " + expectedValues[i]); // In ra giá trị mong muốn

		    // So sánh giá trị mong muốn và thực tế
		    Assert.assertEquals(expectedValues[i], actualValue,"Giá trị không khớp cho thẻ " + (i + 1));
		    
		    // Chờ 1 giâsy giữa các lần click
		    pause(3000);

		    // Quay lại trang trước
		    driver.navigate().back();
		    pause(3000);
		    

		    // Cập nhật lại danh sách các thẻ
		    elements = driver.findElements(By.xpath("//div[@class='mb-1']")); // Cập nhật lại danh sách thẻ
		}

		// Đóng trình duyệt
		driver.quit();

    }
		
	}

