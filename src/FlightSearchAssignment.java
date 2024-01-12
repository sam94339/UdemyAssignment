import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlightSearchAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		// Step: 1 Select the country dropdown
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
		
		for(WebElement option: options) {
			
			if(option.getText().equalsIgnoreCase("India")) {
				
				option.click();
				break;
			}
		}
		
		//Step: 2 Select the destination dropdowns
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='CCU']")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.xpath("(//a[@value='IXJ'])[2]")).click();
		
		//Step: 3 Select the current date from the calender.
		driver.findElement(By.cssSelector(".ui-datepicker-days-cell-over.ui-datepicker-today")).click();
		
//		System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date1")).isEnabled());
//		System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		
		
		// Step:3 Incremental dropdwon
		driver.findElement(By.id("divpaxinfo")).click();
		
		for(int i = 1; i<4; i++) {
			
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		
		//Step: 4 static dropdown
		Select values =new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		
		values.selectByVisibleText("USD");
		
		//Step: 5 select the checkbox
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		
		//Step: 6 Click on submit button
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

	}

}
