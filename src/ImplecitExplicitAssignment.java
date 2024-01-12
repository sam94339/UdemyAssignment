import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplecitExplicitAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		String[] products = {"iphone", "Samsung", "Nokia", "Blackberry"};
		
		ImplecitExplicitAssignment fncll = new ImplecitExplicitAssignment();
		fncll.Login(driver, wait);
		fncll.AddtoCart(driver, products, wait);
	}
	
	public void Login(WebDriver driver, WebDriverWait wait) throws InterruptedException {
		
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		
		driver.findElement(By.xpath("//input[@value='user']/following-sibling::span")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		
		Select drpdwn = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		drpdwn.selectByVisibleText("Consultant");
		
		driver.findElement(By.id("terms")).click();
		
		driver.findElement(By.id("signInBtn")).click();
	}
	
	public void AddtoCart(WebDriver driver, String[] products, WebDriverWait wait) throws InterruptedException {
		
		List<String> neededproduct = Arrays.asList(products);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='card-title']/a")));
		
		List<WebElement> productList = driver.findElements(By.xpath("//h4[@class='card-title']/a"));
		
		for(int i=0; i<productList.size(); i++) {
			
			String[] name = productList.get(i).getText().split(" ");
			String filteredname = name[0];
			
			if(neededproduct.contains(filteredname)) {
				
				driver.findElements(By.cssSelector(".btn.btn-info")).get(i).click();
			}
			
		}
		
		driver.findElement(By.cssSelector(".nav-link.btn.btn-primary")).click();

	}

}
