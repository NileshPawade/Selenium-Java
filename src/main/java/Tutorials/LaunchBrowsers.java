package Tutorials;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LaunchBrowsers {
	
	File file;
	FileInputStream fis=null;
	Properties prop;
	WebDriver driver;
	
	
	@Test(priority=0)
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
		
		
	}
	
	@Test(priority=1)
	public void verifyLoginPage()
	{
		if(driver.findElement(By.xpath("//*[@id=\"user_name\"]")).isEnabled())
		{
			driver.findElement(By.xpath("//*[@id=\"user_name\"]")).sendKeys("admin");
		}
		else {
			System.out.println("Username field is disabled");
		}
		if(driver.findElement(By.xpath("//*[@id=\"user_password\"]")).isEnabled())
		{
			driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys("123456");
		}
		else
		{
			System.out.println("password field is disabled");
		}
		
		driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[2]/div/form/div[3]/div[1]/input")).click();
		
		
		driver.close();
		
		System.out.println("project successfully build");
		
	}

}
