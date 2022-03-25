package pages;

import javax.ws.rs.NotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Loggers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ServiciosPage {
	private WebDriver driver;
	private static Logger logger = (Logger) LogManager.getLogger(Loggers.class);
	private By busquedaServicios = By.cssSelector("onerror=\"quitarImagenDeGaleria('galeria_318489-', 'galeria_318489')\"]");
	
	public ServiciosPage(WebDriver driver) {
		this.driver = driver;	
	}
	
	/**
	   * Valida que chequee el listado de sevicios
	   *
	   * @return True si muestra los servicios, false en caso contrario.
	   */
	  public boolean isPageTitleDisplayed() {
	     logger.debug("Comprueba si aparece un listado con los Servicios");
	    try {
	      return driver.findElement(busquedaServicios).isDisplayed();
	    } catch (NotFoundException e) {
	      logger.debug("No se muestra el listado.", e);
	      return false;
	    }
	}
}
