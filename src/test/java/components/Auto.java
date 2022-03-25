package components;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Loggers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.AutosPage;
import pages.PaquetesPage;

public class Auto {
	private WebDriver driver;
	private static Logger logger = (Logger) LogManager.getLogger(Loggers.class);
	
	//Selectors
	private By autoDrop = By.cssSelector("#busquedaHomeDesktop > ul > li:nth-child(4) > a");
	private By retiraDrop = By.id("ac_codAutCiudadRetiro");
	private By devuelveDrop = By.id("ac_codAutCiudadDevolucion");
	private By tipoDrop = By.cssSelector("[title='Todas las categorías']");
	private By tipoAutoDrop = By.cssSelector("[title='Todas las categorías'] + div > ul > li");
	private By buscarDrop = By.cssSelector("[onclick='submitFormConsultaTarifasAutos();']");
	
	public Auto(WebDriver driver) {
		this.driver = driver;
	}
	
	/***
	 * Click on Cars
	 */
	public Auto selecAuto() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		logger.info("Click on Cars ");
		wait.until(ExpectedConditions.elementToBeClickable((autoDrop))).click();
		return this;
	}
	
	/***
	 * Write by keyboard where Pick up the car
	 * @param retirar
	 */
	public Auto selectRetira(String retirar) { 
		WebDriverWait wait = new WebDriverWait(driver, 10);
		logger.info("Write a text where you withdraw "+retirar);
		wait.until(ExpectedConditions.presenceOfElementLocated(retiraDrop));
		driver.findElement(retiraDrop).sendKeys(retirar);
		return this;
	}
	
	/***
	 * Write by keyboard where Return the car
	 * @param devuelve
	 */
	public Auto selectDevuelve(String devuelve) { 
		WebDriverWait wait = new WebDriverWait(driver, 10);
		logger.info("Write a text where it returns "+devuelve);
		wait.until(ExpectedConditions.presenceOfElementLocated(devuelveDrop));
		driver.findElement(devuelveDrop).sendKeys(devuelve);
		return this;
	}
	
	/***
	 * Select car type
	 * @param index
	 */
	public Auto selectTipoDeAuto(int index) { 
		WebDriverWait wait = new WebDriverWait(driver, 10);
		logger.info("Click on Type ");
		wait.until(ExpectedConditions.elementToBeClickable((tipoDrop))).click();
		List<WebElement> selectCar = driver.findElements(tipoAutoDrop);
		selectCar.get(index).click();
		return this;
	}
	
	/***
	 * Search according to the selected
	 */
	public AutosPage selectBuscar() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		logger.info("Click on Search ");
		wait.until(ExpectedConditions.elementToBeClickable((buscarDrop))).click();
		AutosPage autoPage = new AutosPage(driver);
		return autoPage;
	}
	
	//@Override
	 /* protected void isLoaded() {
	    try {
	      // verifique que cada elemento se muestre antes de continuar
	      driver.findElement(autoDrop);
	      logger.debug("Click on Cars ");
	      driver.findElement(retiraDrop);
	      logger.debug("Write by keyboard where Pick up the car");
	      driver.findElement(devuelveDrop);
	      logger.debug("Write a text where it returns");
	      driver.findElement(tipoDrop);
	      logger.debug("Select on Type ");
	      driver.findElement(buscarDrop);
	      logger.debug("Click on Search ");
	    } catch (Exception e) {
	      throwNotLoadedException("The footer component was not loaded correctly", e);
	    }

	    logger.debug("Footer component was loaded correctly");
	  }*/
	
}
