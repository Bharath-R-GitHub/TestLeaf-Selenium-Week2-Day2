package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_4 {
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

		// 8 Enter first name
		driver.findElement(
				By.xpath("//div[contains(@class,'x-tab-item')]/following-sibling::div/div/input[@name='firstName']"))
				.sendKeys("Bharath");

		// 9 Click Find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);

		// 10 Click on first resulting lead
		driver.findElement(By.xpath("//div[contains(@class,'x-grid3-col-partyId')]/a")).click();
		Thread.sleep(2000);

		// 11 Verify title of the page
		if (driver.getTitle().contains("View Lead")) {
			System.out.println("I Verified that the Current Page title is View Lead");
		} else {
			System.out.println("The Current Page is not a View Lead page");
		}

		// 12 Click Edit
		driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[3]")).click();
		Thread.sleep(2000);

		// 13 Change the company name
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
		String changedCompany = "Cognizant Technology Solutions";
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys(changedCompany);

		// 14 Click Update
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		Thread.sleep(2000);

		// 15 Confirm the changed name appears
		String company = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (company.contains(changedCompany)) {
			System.out.println("I confirmed that the Changed Company Name Appeared");
		} else {
			System.out.println("The Changed Company Name does not Appeared");
		}
		
		Thread.sleep(2000);
		
		// 16 Close the browser (Do not log out)
		driver.close();
	}
}
