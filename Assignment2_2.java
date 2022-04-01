package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_2 {
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
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		Thread.sleep(2000);

		// 7 Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		Thread.sleep(2000);

		// 8 Click on Phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		Thread.sleep(2000);

		// 9 Enter phone number
		driver.findElement(By.name("phoneNumber")).sendKeys("8973534991");

		// 10 Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);

		// 11 Capture lead ID of First Resulting lead
		String firstLeadID = driver.findElement(By.xpath("//div[contains(@class,'x-grid3-col-partyId')]/a[1]"))
				.getText();
		System.out.println("The First Lead ID is " + firstLeadID);
		Thread.sleep(2000);

		// 12 Click First Resulting lead
		driver.findElement(By.xpath("//div[contains(@class,'x-grid3-col-partyId')]/a[1]")).click();
		Thread.sleep(2000);

		// 13 Click Delete
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		Thread.sleep(2000);

		// 14 Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		Thread.sleep(2000);

		// 15 Enter captured lead ID
		driver.findElement(By.xpath("//div[@class='x-form-element']/input[@name='id']")).sendKeys(firstLeadID);

		// 16 Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);

		// 17 Verify message "No records to display" in the Lead List. This message
		// confirms the successful deletion
		String verify = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		if (verify.equals("No records to display")) {
			System.out.println("I confirmed that the Lead ID " + firstLeadID + " has been Deleted Successfully");
		} else {
			System.out.println("The Lead ID " + firstLeadID + " has not Deleted yet");
		}

		Thread.sleep(2000);
		
		// 18 Close the browser (Do not log out)
		driver.close();
	}
}
