import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxAssertionPractice {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption2")).isSelected());
		driver.findElement(By.id("checkBoxOption2")).click();
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption2")).isSelected());
		
		driver.findElements(By.xpath("//input[@type = 'checkbox']")).size();
		Assert.assertEquals(driver.findElements(By.xpath("//input[@type = 'checkbox']")).size(), 3);

	}

}
