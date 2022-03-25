package pages;

import javax.ws.rs.NotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Loggers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;

import tests.WebDriverManager;

public class PaquetesPage extends WebDriverManager{
	private WebDriver driver;
	private static Logger logger = (Logger) LogManager.getLogger(Loggers.class);
	private By busquedaPaquete = By.id("listadoPaquetesCotizados");
	
	public PaquetesPage(WebDriver driver) {
		this.driver = driver;	
	}
	
	/**
	   * Valida que chequee el listado de paquetes
	   *
	   * @return True si muestra los paquetes, false en caso contrario.
	   */
	  public boolean isPageTitleDisplayed() {
		 logger.debug("Comprueba si aparece un listado con los Paquetes");
	    try {
	      return driver.findElement(busquedaPaquete).isDisplayed();
	    } catch (NotFoundException e) {
	      logger.debug("No se muestra el listado.", e);
	      return false;
	    }
	    
	 }
}