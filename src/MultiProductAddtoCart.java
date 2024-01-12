import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiProductAddtoCart {

	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		String[] itemsRequired = {"Cauliflower", "Beetroot", "Brinjal"};
		int j = 0;
		
		List<WebElement> productname =  driver.findElements(By.xpath("//h4[@class='product-name']"));
		
		List<String> iteminCart = Arrays.asList(itemsRequired);
		
		for(int i = 0; i<productname.size(); i++) {
			
			String[] name = productname.get(i).getText().split(" - ");
			String filteredname = name[0].trim();
			
			if(iteminCart.contains(filteredname)) {
				
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				j++;
			}
			
			// .length() is used for array and .size() is used for arraylist
			
			if(j == 3) {
				
				break;
			}
			
		}
		
		driver.findElement(By.xpath("//a[@class='cart-icon']/img")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

	}
	

}
