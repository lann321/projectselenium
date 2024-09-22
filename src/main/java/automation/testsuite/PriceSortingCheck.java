package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import automation.common.commonBase;
import automation.constant.CT_PageURLs;

import java.util.ArrayList;
import java.util.List;

public class PriceSortingCheck extends commonBase{
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        // Cài đặt WebDriver
    	driver = initFirefoxDriver(CT_PageURLs.URL_BEPANTOAN);
    }

    @Test
    public void testPriceSorting() throws InterruptedException {
        // Click vào "Thiết Bị Nhà Bếp Khác"
        driver.findElement(By.xpath("//a[text()=' Thiết Bị Nhà Bếp Khác ']")).click();
        Thread.sleep(2000); // Tạm dừng 2 giây

        // Click vào "Giá thấp"
        driver.findElement(By.xpath("//a[text()='Giá thấp']")).click();

        // Tìm tất cả các phần tử giá
        List<WebElement> priceElements = driver.findElements(By.xpath("//div[contains(@class, 'prices')]"));

        // Chuyển đổi giá thành danh sách số
        List<Double> prices = new ArrayList<>();
        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText()
                    .replace("₫", "")
                    .replace("&nbsp;", "")
                    .trim(); // Chỉnh sửa nếu có ký tự khác

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

    @AfterClass
    public void teardown() {
        // Đóng trình duyệt
        if (driver != null) {
            driver.quit();
        }
    }
}
