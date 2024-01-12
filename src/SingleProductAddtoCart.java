import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SingleProductAddtoCart {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
		
		for(int i = 0; i<products.size(); i++) {
			
			String productname = products.get(i).getText();
			if(productname.contains("Cashews")) {
				
				// for click on the "+" button
				for(int a = 1; a<3; a++) {
					
					driver.findElements(By.xpath("//a[@class='increment']")).get(i).click();
				}
				
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				break;
			}
		}
	}

}
