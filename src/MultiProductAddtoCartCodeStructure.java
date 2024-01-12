import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiProductAddtoCartCodeStructure {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		String[] itemsRequired = {"Cauliflower", "Beetroot", "Brinjal"};
		
		MultiProductAddtoCartCodeStructure object = new MultiProductAddtoCartCodeStructure();
		object.addtocart(driver, itemsRequired);
		object.checkoutproceed(driver);
	}
	
	public void addtocart(WebDriver driver, String[] itemsRequired) {
		int j=0;
		List<WebElement> productname =  driver.findElements(By.xpath("//h4[@class='product-name']"));
		
		List<String> iteminCart = Arrays.asList(itemsRequired);
		
		for(int i = 0; i<productname.size(); i++) {
			
			String[] name = productname.get(i).getText().split(" - ");
			String filteredname = name[0].trim();
			
			if(iteminCart.contains(filteredname)) {
				
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;
			}
			
			// .length() is used for array and .size() is used for arraylist
			
			if(j == itemsRequired.length) {
				
				break;
			}
			
		}
	}
	
	public void checkoutproceed(WebDriver driver) {
		
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());
	}

}
