package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_1 {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");

		driver.manage().window().maximize();

		// 2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// 3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		Thread.sleep(2000);

		// 4. Click on CRM/SFA Link
		driver.findElement(By.xpath("//div[@for='crmsfa']/a")).click();
		Thread.sleep(2000);

		// 5. Click on contacts Button
		driver.findElement(By.xpath("(//div[@class='x-panel-header'])[3]/a")).click();
		Thread.sleep(2000);

		// 6. Click on Create Contact
		driver.findElement(By.xpath("//ul[@class='shortcuts']/li[2]/a")).click();
		Thread.sleep(2000);

		// 7. Enter FirstName Field Using id Locator
		driver.findElement(By.id("firstNameField")).sendKeys("Bharath");

		// 8. Enter LastName Field Using id Locator
		driver.findElement(By.id("lastNameField")).sendKeys("R");

		// 9. Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Bharu");

		// 10. Enter LastName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Raju");

		// 11. Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Information Technology");

		// 12. Enter Description Field Using any Locator of your choice
		driver.findElement(By.id("createContactForm_description")).sendKeys("Software - IT");

		// 13. Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("barathrju@gmail.com");

		// 14. Select State/Province as NewYork Using Visible Text
		WebElement elements = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select dd = new Select(elements);
		dd.selectByVisibleText("New York");

		// 15. Click on Create Contact
		driver.findElement(By.xpath("//input[@value='Create Contact']")).click();
		Thread.sleep(2000);

		// 16. Click on edit button
		driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[text()='Edit']")).click();
		Thread.sleep(2000);

		// 17. Clear the Description Field using .clear
		driver.findElement(By.id("updateContactForm_description")).clear();

		// 18. Fill ImportantNote Field with Any text
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Week 2 - Assignment 2.1");

		// 19. Click on update button using Xpath locator
		driver.findElement(By.xpath("//td[@class='label']/following-sibling::td/input[@value='Update']")).click();

		// 20. Get the Title of Resulting Page.
		String title = driver.getTitle();
		System.out.println(title);
	}
}
