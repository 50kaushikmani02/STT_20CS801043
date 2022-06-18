import org.openqa.selenium.By;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
public class Flight {
	public static void main(String args[]) throws InterruptedException {
		// Code by 20CS801043_Kaushik
		System.setProperty("webdriver.edge.driver","E:\\\\Setup Files\\\\edgedriver_win64\\\\msedgedriver.exe"); // Accessing the page
		WebDriver driver = new EdgeDriver();
		// Simulating entering values and button click to check flight status.
		driver.get(" http://www.variflight.com/en/flight-status");
		WebElement searchbox = driver.findElement(By.xpath("//input[@id='search-flight-num']"));
		searchbox.sendKeys("UA7991");
		WebElement clickDate = driver.findElement(By.xpath("//input[@id=\"searchFlightDate\"]"));
		clickDate.click();
		Thread.sleep(2000); // To pause actions so that it is visible to the user / examiner.
		WebElement selectDate = driver.findElement(By.xpath("//td[@lay-ymd=\"2022-6-23\"]"));
		selectDate.click();
		Thread.sleep(2000);
		WebElement findFlightBtn = driver.findElement(By.xpath("//div[@id='searchBtn']"));
		findFlightBtn.click();
		Thread.sleep(3000);
		WebElement actual_from = driver.findElement(By.xpath("//i[text()='Tokyo']/text()"));
		// Assertion
		String expected_from = "Tokyo";
		Assert.assertEquals(expected_from, actual_from.toString());
	}
}
