package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_3 {
	public static void main(String[] args) throws InterruptedException {
		
		// 1 Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// 2 Enter the username
		driver.findElement(By.id("username")).sendKeys("DemoCSR");

		// 3 Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// 4 Click Login
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(2000);

		// 5 Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
		Thread.sleep(2000);

		// 6 Click Leads link
		driver.findElement(By.linkText("Leads")).click();
		Thread.sleep(2000);

		// 7 Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(2000);

		// 8 Click on Email
		driver.findElement(By.linkText("Email")).click();
		Thread.sleep(2000);

		// 9 Enter Email
		driver.findElement(By.xpath("//label[text()='Email Address:']/following-sibling::div/input"))
				.sendKeys("barathrju@gmail.com");

		// 10 Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);

		// 11 Capture name of First Resulting lead
		String fName = driver.findElement(By.xpath("//div[contains(@class,'x-grid3-col-firstName')]/a")).getText();
		String lName = driver.findElement(By.xpath("//div[contains(@class,'x-grid3-col-lastName')]/a")).getText();
		String name = fName + " " + lName;
		System.out.println("The First Resulting Lead is " + name);

		// 12 Click First Resulting lead
		driver.findElement(By.xpath("//div[contains(@class,'x-grid3-col-partyId')]/a")).click();
		Thread.sleep(2000);

		// 13 Click Duplicate Lead
		driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[text()='Duplicate Lead']")).click();
		Thread.sleep(2000);

		// 14 Verify the title as 'Duplicate Lead'
		if (driver.getTitle().contains("Duplicate Lead")) {
			System.out.println("I Verified that the Current Page title is Duplicate Lead");
		} else {
			System.out.println("The Current Page is not a Duplicate Lead page");
		}

		// 15 Click Create Lead
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		Thread.sleep(2000);

		// 16 Confirm the duplicated lead name is same as captured name
		String dupFName = driver.findElement(By.xpath("//span[contains(@id,'firstName')]")).getText();
		String dupLName = driver.findElement(By.xpath("//span[contains(@id,'lastName')]")).getText();
		String dupName = dupFName + " " + dupLName;
		if (name.equals(dupName)) {
			System.out.println("I confimed that the Duplicated Lead Name is same as Captured Lead Name");
		} else {
			System.out.println("The Duplicated Lead Name is not same as Captured Lead Name");
		}
		
		Thread.sleep(2000);
		
		// 17 Close the browser (Do not log out)
		driver.close();
	}
}
