package utils;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void switchToChildWindow() {
	    String parentWindow = driver.getWindowHandle();
	    Set<String> allWindows = driver.getWindowHandles();
	    for(String childWindow : allWindows) {
		    if(!parentWindow.equalsIgnoreCase(childWindow))
		    	driver.switchTo().window(childWindow);
	   }
	}

}
