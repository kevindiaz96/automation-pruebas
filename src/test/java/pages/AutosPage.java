package pages;

import javax.ws.rs.NotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Loggers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import tests.WebDriverManager;

public class AutosPage extends WebDriverManager{

	private WebDriver driver;
	private static Logger logger = (Logger) LogManager.getLogger(Loggers.class);
	private By busquedaAutos = By.id("[id='modal-buscandoResultados'] > div > div > div > div:nth-child(1)");
	
	public AutosPage(WebDriver driver) {
		this.driver = driver;	
	}
	
	/**
	   * Valida que chequee el listado de autos.
	   *
	   * @return True muestra un texto que no se encontro auto.
	   */
	  public String isPageTitleDisplayed() {
	    logger.info("Muestra un texto por pantalla");
	    return driver.findElement(busquedaAutos).getText();
	    
    }
}
