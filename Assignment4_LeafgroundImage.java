package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4_LeafgroundImage {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// 1. Click on this image to go home page
		driver.findElement(By.xpath("//label[contains(text(),'go home page')]/following-sibling::img")).click();
		Thread.sleep(2000);
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("home")) {
			System.out.println("I confirmed that the I am currently in Home Page");
		} else {
			System.out.println("I am not in Home Page");
		}

		driver.findElement(By.xpath("//h5[text()='Image']/following-sibling::img")).click();
		Thread.sleep(2000);

		// 2. Am I Broken Image?
		WebElement image = driver.findElement(By.xpath("//label[text()='Am I Broken Image?']/following-sibling::img"));
		if (image.getAttribute("naturalWidth").equals("0")) {
			System.out.println("I confirmed that the Image is Broken");
		} else {
			System.out.println("The Image is not Broken");
		}

		// 3. Click me using Keyboard or Mouse
		driver.findElement(By.xpath("//label[contains(text(),'Click me')]/following-sibling::img")).click();
		System.out.println("On Clicking the image it is Redirecting to " + driver.getCurrentUrl());
		Thread.sleep(2000);

	}
}
