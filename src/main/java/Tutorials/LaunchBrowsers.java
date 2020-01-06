package Tutorials;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LaunchBrowsers {
	@Test
	public void getBroswerAndLaunch()
	{
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+
				"\\src\\main\\java\\Webcontents\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://red.purestudy.com");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.close();
		
	}

}
