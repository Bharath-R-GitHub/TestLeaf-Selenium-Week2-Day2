package week2.day2.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4_LeafgroundLink {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// 1. Go to Home Page
		driver.findElement(By.xpath("(//a[contains(text(),'Home')])[1]")).click();
		Thread.sleep(2000);
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("home")) {
			System.out.println("I confirmed that the I am currently in Home Page");
		} else {
			System.out.println("I am not in Home Page");
		}

		driver.findElement(By.xpath("//h5[text()='HyperLink']/following-sibling::img")).click();
		Thread.sleep(2000);

		// 2. Find where am supposed to go without clicking me?
		String attribute = driver.findElement(By.xpath("//a[contains(text(),'go without clicking me?')]"))
				.getAttribute("href");
		System.out.println("The link is redirecting to " + attribute);
		Thread.sleep(2000);

		// 3. Verify am I broken?
		driver.findElement(By.xpath("//a[text()='Verify am I broken?']")).click();
		String title = driver.getTitle();
		if (title.contains("404")) {
			System.out.println("I confirmed that the Link is Broken");
		} else {
			System.out.println("The Link is not Broken");
		}

		driver.get("http://leafground.com/pages/Link.html");
		Thread.sleep(2000);

		// 4. Go to Home Page (Interact with same link name)
		driver.findElement(By.xpath("//label[@for='position']/preceding-sibling::a")).click();
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();
		if (url.contains("home")) {
			System.out.println("I confirmed that the I am currently in Home Page");
		} else {
			System.out.println("I am not in Home Page");
		}

		driver.findElement(By.xpath("//h5[text()='HyperLink']/following-sibling::img")).click();
		Thread.sleep(2000);

		// 5. How many links are available in this page?
		String tagName = driver.findElement(By.xpath("//a[contains(text(),'How many links')]")).getTagName();
		List<WebElement> links = driver.findElements(By.tagName(tagName));
		int size = links.size();
		System.out.println("The no. of Links Available in this Page are " + size);
		Thread.sleep(2000);

	}
}
