package pages;

import javax.ws.rs.NotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Loggers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VuelosPage {

	private WebDriver driver;
	private static Logger logger = (Logger) LogManager.getLogger(Loggers.class);
	private By busquedaVuelos = By.id("[id='modal-homeDescripcion']");
	
	public VuelosPage(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	   * Valida que chequee el listado de vuelos.
	   *
	   * @return True muestra un texto que no se encontro vuelo.
	   */
	  public boolean isPageTitleDisplayed() {
	    logger.debug("Comprueba si aparece un listado con los Paquetes");
	    try {
	      return driver.findElement(busquedaVuelos).isDisplayed();
	    } catch (NotFoundException e) {
	      logger.debug("No se muestra el listado.", e);
	      return false;
	    }
	  }
   }

