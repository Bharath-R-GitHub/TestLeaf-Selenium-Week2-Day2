package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4_LeafgroundEdit {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// 1. Enter your email address
		driver.findElement(By.id("email")).sendKeys("barathrju@gmail.com");
		Thread.sleep(2000);

		// 2. Append a text and press keyboard tab
		driver.findElement(By.xpath("//label[contains(text(),'Append a text')]/following-sibling::input"))
				.sendKeys("Bharath", Keys.TAB);
		Thread.sleep(2000);

		// 3. Get default text entered
		String defaultText = driver
				.findElement(By.xpath("//label[contains(text(),'Get default')]/following-sibling::input"))
				.getAttribute("value");
		System.out.println("The Default Text is " + defaultText);
		Thread.sleep(2000);

		// 4.Clear the text
		driver.findElement(By.xpath("//label[contains(text(),'Clear')]/following-sibling::input")).clear();
		Thread.sleep(2000);

		// 5.Confirm that edit field is disabled
		boolean enabled = driver.findElement(By.xpath("//label[@for='disabled']/following-sibling::input")).isEnabled();
		if (enabled) {
			System.out.println("I confirmed that the Edit Field is Enabled");
		} else {
			System.out.println("I confirmed that the Edit Field is Disabled");

		}
		Thread.sleep(2000);

	}
}
