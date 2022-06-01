package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public static WebDriver driver;
	public static Properties prop;
	public String basePath=System.getProperty("user.dir");
	
	public WebDriver initializeDriver() throws IOException {
		String pathString=basePath+"\\src\\main\\java\\resources\\Data.properties";
		FileInputStream fileInputStream=new FileInputStream(pathString);
		prop=new Properties();
		prop.load(fileInputStream);
		String browser=prop.getProperty("browser");
		
		if(browser.contains("chrome")) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\SeleniumWebdriver\\chromedriver.exe");
        driver=new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}

}
