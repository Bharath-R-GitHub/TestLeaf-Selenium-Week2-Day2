package week2.day2.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4_LeafgroundCheckBox {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);

		// 1. Select the languages that you know?
		driver.findElement(By.xpath("//label[contains(text(),'Select the languages')]/following-sibling::input[1]"))
				.click();
		Thread.sleep(2000);

		// 2. Confirm Selenium is checked
		boolean selected = driver
				.findElement(By.xpath("//label[contains(text(),'Selenium is checked')]/following-sibling::input[1]"))
				.isSelected();
		if (selected) {
			System.out.println("I confirmed that Selenium is Checked");
		} else {
			System.out.println("The Selenium is not Checked");
		}
		Thread.sleep(2000);

		// 3. DeSelect only checked
		List<WebElement> elements = driver.findElements(By
				.xpath("//label[contains(text(),'DeSelect only checked')]/following-sibling::input[@type='checkbox']"));
		for (int i = 0; i < elements.size(); i++) {
			if (elements.get(i).isSelected()) {
				elements.get(i).click();
				System.out.println("The "+"Checkbox "+(i+1)+" is selected. Hence it is Deselected");
			} else {
				continue;
			}
		}
		Thread.sleep(2000);

		// 4. Select all below checkboxes
		List<WebElement> checkBoxes = driver
				.findElements(By.xpath("//label[contains(text(),'Select all')]/following-sibling::input"));
		for (int i = 0; i < checkBoxes.size(); i++) {
			if (checkBoxes.get(i).isSelected() == false) {
				checkBoxes.get(i).click();
				Thread.sleep(1000);
			} else {
				continue;
			}
		}
	}
}
