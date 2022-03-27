package keywords;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericKeywords {
	
	public WebDriver driver;
	public Properties props;
	
	public void openBrowser(String browser) {
		System.out.println("Open Browser "+browser);
		if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\jeral\\Documents\\driver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
    public void navigate(String urlKey) {
		System.out.println("Navigating to "+urlKey);
    	driver.get(props.getProperty(urlKey));
		
	}

    public void click(String locatorKey) {
    	System.out.println("Navigating to "+locatorKey);
    	getElement(props.getProperty(locatorKey)).click();
	
   	}
    
    public void type(String locatorKey, String data) {
    	System.out.println("Typing in "+locatorKey+", Data "+data);
    	getElement(props.getProperty(locatorKey)).sendKeys(data);
   	}
   
    public void quit() {
    	System.out.println("Quitting browser.....");
    	driver.quit();
    }
    
    public void select(String locator, String data) {
		
   	}
    
    public void getText(String locator) {
		
   	}
    
    public WebElement getElement(String locator) {
    	
    	//check the presence
    	if(!isElementPresent(locator)) {
    		//if element returns false report a failure
    		//report failure
    		System.out.println("Element not present"+locator);
    	}
    	//check the visibility
    	if(!isElementVisible(locator)) {
    		//if element returns false report a failure
    		//report failure
    		System.out.println("Element not visible"+locator);
    	}
    	
    	
    	WebElement e = driver.findElement(By.id(locator));
    	return e;
    	
    }
    
    //true - element present
    //false - element not present
    public boolean isElementPresent(String locator) {
    
    	System.out.println("Checking presence of element: "+locator);
      
    	// to check the element present use the explicit wait 	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	try {
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
    	} catch (Exception e) {
    		return false;
    	}
    	
    
    	return true;
    }
    //true - visibile 
    //false - not visibile
    public boolean isElementVisible(String locator) {
    	
    	System.out.println("Checking visibility of element: "+locator);
    	
    	// to check the element present use the explicit wait 	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	try {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
    	} catch (Exception e) {
    		return false;
    	}
    	
    	return true;
    }
}
