import java.io.File;
import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadFile {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver;
		
		driver = new FirefoxDriver();
		driver.get("https://get.jenkins.io/windows-stable/2.426.1/jenkins.msi");
		
		String path = "\\eclipse-workspace\\UdemyAssignment\\Download";
		String filename = "jenkins(2).msi";
		
		File file = new File(path, filename);
		
		FluentWait<File> wait = new FluentWait<File>(file).withTimeout(Duration.ofMinutes(5))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(Exception.class).withMessage("File not downladed");
		
		try{
			
			Boolean b =  wait.until(f -> f.exists() && f.canRead());
			
			if(b) {
				
				System.out.println("file is completely 100% downloaded");
			}
		}catch(TimeoutException e) {
			
			System.out.println("file is not completely  downloaded");
		}                                    

	}

}
