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
import org.testng.Assert;

import pages.PaquetesPage;
import tests.WebDriverManager;

public class Paquete extends WebDriverManager{
	private WebDriver driver;
	private static Logger logger = (Logger) LogManager.getLogger(Loggers.class);
	
	//Selectors
	private By passengersDrop = By.cssSelector("[data-id='codCiudadSalida']");
	private By dropDownOrigen = By.cssSelector("[data-original-index]");
	private By passDrop = By.cssSelector("[data-id='codDestTuristico']");
	private By dropDownDestino = By.cssSelector("[data-original-index]");
	private By fromDrop = By.cssSelector("[data-id='comboCodDestinoTuristico1']");
	private By dropDownFrom = By.cssSelector("[data-original-index=\'3\']");
	private By nochesDrop =  By.cssSelector("[data-id='duracion']");
	private By dropDownNoches = By.cssSelector("[data-original-index]");
	private By buscarDrop = By.id("boton-busqueda-paquete");
	
	public Paquete(WebDriver driver) {
		this.driver = driver;
	}
    
	/***
	 * Click on Packages and origen
	 * @param indec
	 */
	public Paquete selectOrigen(int indec) { 
		WebDriverWait wait = new WebDriverWait(driver, 10);
		logger.info("Click on Packages ");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(passengersDrop))).click();
		List<WebElement> selectProv = driver.findElements(dropDownOrigen);
		selectProv.get(indec);
		return this;
	
    }
	
	/***
	 * Select the Destination
	 * @param index
	 */
	public Paquete selecDestino(int index) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		logger.info("Click on the Origin ");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(passDrop))).click();
		List<WebElement> selectPais = driver.findElements(dropDownDestino);
		selectPais.get(index);
		return this;
		
	}
	
	/***
	 * Select on State of the Destination
	 * @param inde
	 */
	public Paquete selectFromPort(int inde) {
		logger.info("Click on the destination city ");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(fromDrop))).click();
		List<WebElement> selectDestinoProv = driver.findElements(dropDownFrom);
		selectDestinoProv.get(inde);
		return this;
    }
	
	/***
	 * Select the number of nights
	 * @param indx
	 */
	public Paquete selectNoches(int indx) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		logger.info("Click on the nights of stay ");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(nochesDrop))).click();
		List<WebElement> selectNgth = driver.findElements(dropDownNoches);
		selectNgth.get(indx);
		return this;
    }
	
	/***
	 * Search according to the selected
	 */
	public PaquetesPage selectBuscar() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		logger.info("Click on Search ");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(buscarDrop))).click();
		PaquetesPage paquetePage = new PaquetesPage(driver);
		return paquetePage;
	}
	
	/*//@Override
	  protected void isLoaded() throws Error {
	    try {
	      // verifique que cada elemento se muestre antes de continuar
	      driver.findElement(passengersDrop);
	      logger.debug("Click on Packages ");
	      driver.findElement(passDrop);
	      logger.debug("Select the Destination");
	      driver.findElement(fromDrop);
	      logger.debug("Select on State of the Destination");
	      driver.findElement(dropDownFrom);
	      logger.debug("Select on Type ");
	      driver.findElement(buscarDrop);
	      logger.debug("Click on Search ");
	    } catch (Exception e) {
	      throwNotLoadedException("The footer component was not loaded correctly", e);
	    }

	    logger.debug("Footer component was loaded correctly");
	  }*/
}