package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Loggers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LogonPage {

	private WebDriver driver;
	
	private WebElement titleTextElement;
	private By descripcion_modal_beagle;
	
	private static Logger logger = (Logger) LogManager.getLogger(Loggers.class);

	public LogonPage(WebDriver driver) {
		this.driver = driver;	
		descripcion_modal_beagle = By.xpath("/html/body/div[1]/div/div/div[2]");
	}
	
	public void assertLogonPage() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		logger.info("Envia informacion si no se loguea");
		Assert.assertFalse(driver.findElement(descripcion_modal_beagle).getText().contains("El usuario y/o la contraseña son incorrectos, vuelva a intentarlo"));
	}


}
