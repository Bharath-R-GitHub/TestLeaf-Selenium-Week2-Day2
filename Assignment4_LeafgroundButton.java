package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4_LeafgroundButton {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		
		// 1. Click button to travel home page
		driver.findElement(By.xpath("//button[@id='home']")).click();
		Thread.sleep(2000);
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("home")) {
			System.out.println("I confirmed that the Current Page is Home Page");
		} else {
			System.out.println("The Current Page is not a Home Page");
		}
		
		driver.findElement(By.xpath("//h5[contains(text(),'Button')]/following-sibling::img")).click();
		Thread.sleep(2000);

		// 2. Find position of button (x,y)
		Point location = driver.findElement(By.xpath("//button[@id='position']")).getLocation();
		System.out.println("The Location of the Button is " + location);
		Thread.sleep(2000);

		// 3. Find button color
		String cssValue = driver.findElement(By.xpath("//button[@id='color']")).getCssValue("background-color");
		System.out.println("The Color of the Button " + cssValue);
		Thread.sleep(2000);

		// 4. Find the height and width
		Dimension size = driver.findElement(By.xpath("//button[@id='size']")).getSize();
		System.out.println("The Dimension of the Button is " + size);
		Thread.sleep(2000);

	}
}
