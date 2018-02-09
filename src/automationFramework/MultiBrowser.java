package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultiBrowser {
	public WebDriver driver;
	 
	  @Parameters("browser")	 
	  @BeforeClass	 
	  // Passing Browser parameter from TestNG xml	 
	  public void beforeTest(String browser) {
	 
	  	 
	  if(browser.equalsIgnoreCase("firefox")) {
		  System.setProperty("webdriver.gecko.driver", "C:\\Users\\Vikrant Nandan\\Desktop\\SQT\\Selenium WebDriver"
					+ "\\Selenium Drivers\\Browser Driver\\geckodriver.exe");
		  driver = new FirefoxDriver(); 
	 
	  }else if (browser.equalsIgnoreCase("ie")) { 
		  	 
		  System.setProperty("webdriver.ie.driver", "C:\\Users\\Vikrant Nandan\\Desktop\\SQT\\Selenium WebDriver"
					+ "\\Selenium Drivers\\Browser Driver\\IEDriverServer.exe");
		  driver = new InternetExplorerDriver();
	 
	  }else if (browser.equalsIgnoreCase("chrome")) {
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vikrant Nandan\\Desktop\\SQT\\Selenium WebDriver"
					+ "\\Selenium Drivers\\Browser Driver\\chromedriver.exe");
		  driver = new ChromeDriver();
		  
	  }else if (browser.equalsIgnoreCase("edge")){
		  System.setProperty("webdriver.edge.driver", "C:\\Users\\Vikrant Nandan\\Desktop\\SQT\\Selenium WebDriver"
					+ "\\Selenium Drivers\\Browser Driver\\MicrosoftWebDriver.exe");
		  driver = new EdgeDriver();
		  
	  }	
	  
		  driver.get("http://www.facebook.com"); 	 
	  }	 
	  
	  @Test 
	  public void login() throws InterruptedException {
	 
		driver.findElement(By.xpath(".//*[@id='account']/a")).click();
	 
	    driver.findElement(By.id("log")).sendKeys("testuser_1");
	 
	    driver.findElement(By.id("pwd")).sendKeys("Test@123");
	 
	    driver.findElement(By.id("login")).click();
	 
		}  
	 
	  @AfterClass
	  public void afterTest() {
	 
			driver.quit();
	 
		}

}
