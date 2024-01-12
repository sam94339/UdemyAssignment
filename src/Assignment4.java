import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//label[@for='benz']")).click();
		String option = driver.findElement(By.xpath("//label[@for='benz']")).getText();
		Select drpdwnchoose = new Select(driver.findElement(By.id("dropdown-class-example")));
		drpdwnchoose.selectByVisibleText(option);
		driver.findElement(By.id("name")).sendKeys(option);
		driver.findElement(By.id("alertbtn")).click();
		String alertmessage = driver.switchTo().alert().getText();
		System.out.println(alertmessage.contains(option));

	}

}
