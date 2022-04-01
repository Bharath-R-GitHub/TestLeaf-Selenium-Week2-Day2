package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// 1. Load url "https://acme-test.uipath.com/login"
		driver.get("https://acme-test.uipath.com/login");
	

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);

		// 2. Enter email as "kumar.testleaf@gmail.com"
		driver.findElement(By.xpath("//div[contains(@class,'control-group')]//input[@id='email']"))
				.sendKeys("kumar.testleaf@gmail.com");

		// 3. Enter Password as "leaf@12"
		driver.findElement(By.xpath("//label[@for='password']/following-sibling::input[@id='password']"))
				.sendKeys("leaf@12");

		// 4. Click login button
		driver.findElement(By.xpath("//a[@class='btn bg-warning']/preceding-sibling::button")).click();
		Thread.sleep(2000);

		// 5. Get the title of the page and print
		String title = driver.getTitle();
		System.out.println(title);
		
		// 6. Click on Log Out
		driver.findElement(By.xpath("//form[@id='logout-form']/following-sibling::li/a")).click();
		Thread.sleep(2000);

		// 7. Close the browser (use -driver.close())
		driver.close();
	}
}
