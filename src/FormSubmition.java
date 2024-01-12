import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FormSubmition {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("Soumyadeep Ghosh");
		driver.findElement(By.name("email")).sendKeys("ghoshsoumyadeep828293@gmail.cm");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("1234");
		driver.findElement(By.id("exampleCheck1")).click();
		driver.findElement(By.id("exampleFormControlSelect1")).click();
		Select gender = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
		gender.selectByVisibleText("Male");
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.xpath("//input[@type='date']")).sendKeys("02011996");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());

	}

}
