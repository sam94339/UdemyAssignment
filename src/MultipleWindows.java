import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindows {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		driver.findElement(By.xpath("//div[@class='example']/a")).click();
		
		Set<String> window = driver.getWindowHandles();
		
		Iterator<String> windowhandle = window.iterator();
		
		String parent = windowhandle.next();
		String child = windowhandle.next();
		
		driver.switchTo().window(child);
		
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
		
		driver.switchTo().window(parent);
		
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());

	}

}
