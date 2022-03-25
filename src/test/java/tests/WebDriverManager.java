package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.sun.istack.NotNull;

import helpers.Helpers;

public class WebDriverManager {
protected WebDriver driver;
protected ExtentReports extent;
	
    /**
     * Aqui van las condiciones comunes a todos los test
     */
 	@BeforeMethod
	public void setUp() {
		DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.buquebusturismo.com/");
		Helpers helper = new Helpers();
		helper.sleepSeconds(5);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	/**
	   * Logs and throws the exception caught when loading the component.
	   * @param customMessage The custom message to write in the log.
	   * @param e Exception caught when trying to load the component.
	   */
	  //protected void throwNotLoadedException(String customMessage, @NotNull Exception e) {
	   //   throw new SlowLoadableComponent(customMessage + "\n" + e.getMessage(), e.getCause());
	  //}


}
