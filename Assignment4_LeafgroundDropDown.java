package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4_LeafgroundDropDown {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//1. Select training program using Index
		WebElement dropDown1 = driver.findElement(By.id("dropdown1"));
		Select dd1=new Select(dropDown1);
		dd1.selectByIndex(1);
		Thread.sleep(2000);
		
		//2. Select training program using Text
		WebElement dropDown2 = driver.findElement(By.name("dropdown2"));
		Select dd2=new Select(dropDown2);
		dd2.selectByVisibleText("Appium");
		Thread.sleep(2000);

		//3. Select training program using Value
		WebElement dropDown3 = driver.findElement(By.id("dropdown3"));
		Select dd3=new Select(dropDown3);
		dd3.selectByValue("3");
		Thread.sleep(2000);
		
		//4. Get the number of dropdown options
		WebElement dropDown = driver.findElement(By.className("dropdown"));
		Select dd=new Select(dropDown);
		int size=dd.getOptions().size();
		System.out.println("The no. of Options in the Dropdown are "+size);
		Thread.sleep(2000);
		
		//5. You can also use sendKeys to select
		driver.findElement(By.xpath("(//select)[5]")).sendKeys("Selenium");		
		Thread.sleep(2000);

		//6. 
		WebElement dropDown4 = driver.findElement(By.xpath("(//select)[5]/following::select"));
		Select dd4=new Select(dropDown4);
		dd4.selectByValue("2");
		Thread.sleep(2000);
	}
}
