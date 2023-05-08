package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public WebDriver driver;
	
	public WebDriver webDriverManager() throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\java_k_programs\\cucumberFramework\\src\\test\\Resources\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QAurl");
		
		if(driver == null) {
			if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Selenium_k\\Driver\\chromedriver.exe");
			    driver = new ChromeDriver();
			    
			}else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
				//firefox code
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(url);
		}

		return driver;
	}

}
