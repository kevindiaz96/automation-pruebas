package components;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Loggers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pasaje {
	private WebDriver driver;

	//Selectors
	private static Logger logger = (Logger) LogManager.getLogger(Loggers.class);
	private By pasajeDrop = By.cssSelector("#busquedaHomeDesktop > ul > li:nth-child(6) > a");
	
	public Pasaje (WebDriver driver) {
		this.driver = driver;	
	}
	
	/***
	 * Select Passages and redirect to the page turismo.com
	 */
	public Pasaje selectPasaje() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		logger.info("Click on Passages ");
		wait.until(ExpectedConditions.elementToBeClickable((pasajeDrop))).click();
		return this;
	}
	
}
