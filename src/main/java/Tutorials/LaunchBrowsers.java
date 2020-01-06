package Tutorials;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LaunchBrowsers {
	
	File file;
	FileInputStream fis=null;
	Properties prop;
	WebDriver driver;
	
	
	@Test
	public void getBroswerAndLaunch() throws IOException
	{
		file=new File(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\config.properties");
		fis=new FileInputStream(file);
		prop= new Properties();
		prop.load(fis);
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+
				"\\src\\main\\java\\Webcontents\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://red.purestudy.com");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.close();
		
	}

}
