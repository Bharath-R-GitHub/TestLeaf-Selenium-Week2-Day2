package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {
	public static void main(String[] args) throws InterruptedException {
		
		// 1: Download and set the path
		WebDriverManager.chromedriver().setup();

		// 2: Launch the chrome browser
		ChromeDriver driver = new ChromeDriver();

		// 3: Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");

		// 4: Maximize the window
		driver.manage().window().maximize();

		// 5: Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// 6: Click on Create New Account button
		driver.findElement(By.xpath("//form[@data-testid='royal_login_form']/div[5]/a")).click();
		Thread.sleep(2000);

		// 7: Enter the first name
		driver.findElement(By.xpath("//input[@placeholder='First name']")).sendKeys("Bharath");

		// 8: Enter the last name
		driver.findElement(By.xpath("//div[text()='Surname']/following-sibling::input")).sendKeys("Raju");

		// 9: Enter the mobile number
		driver.findElement(By.xpath("//div[contains(text(),'Mobile number')]/following-sibling::input"))
				.sendKeys("8973534991");

		// 10: Enter the password
		driver.findElement(By.id("password_step_input")).sendKeys("Bharu@1010");

		// 11: Handle all the three drop downs
		WebElement dropdown1 = driver.findElement(By.xpath("//span[@data-name='birthday_wrapper']//select[1]"));
		Select dd1 = new Select(dropdown1);
		dd1.selectByValue("10");
		WebElement dropdown2 = driver.findElement(By.xpath("//span[@data-name='birthday_wrapper']//select[2]"));
		Select dd2 = new Select(dropdown2);
		dd2.selectByValue("10");
		WebElement dropdown3 = driver.findElement(By.xpath("//span[@data-name='birthday_wrapper']//select[3]"));
		Select dd3 = new Select(dropdown3);
		dd3.selectByValue("1997");

		// 12: Select the radio button
		driver.findElement(By.xpath("//span[@data-name='gender_wrapper']/span[2]/input")).click();
	}
}
