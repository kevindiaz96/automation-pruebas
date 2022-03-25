package components;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Loggers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.AutosPage;
import pages.ServiciosPage;

public class Servicio {
	private WebDriver driver;

	//Selectors
	private static Logger logger = (Logger) LogManager.getLogger(Loggers.class);
    private By servicioDrop = By.cssSelector("#busquedaHomeDesktop > ul > li:nth-child(5) > a");
    private By destinoDrop = By.id("codDestinoTuristicoActividades");
    private By destinoPaisDrop = By.cssSelector("#codDestinoTuristicoActividades > option:nth-child(2)");
    private By destinoLugarDrop = By.id("codDestinoTuristico1Actividades");
    private By destinoProvDrop = By.cssSelector("#codDestinoTuristico1Actividades > option:nth-child(4)");
    private By serviceDrop = By.id("codSubservicio");
    private By asistenteDrop = By.cssSelector("#codSubservicio > option:nth-child(2)");
    private By buscarDrop = By.cssSelector("[onclick='functionSubmit();']");
	
	public Servicio(WebDriver driver) {
		this.driver = driver;
	}
	
	/***
	 * Click on Services
	 */
	public Servicio selectServicio() { 
		WebDriverWait wait = new WebDriverWait(driver, 10);
		logger.info("Click on Services ");
		wait.until(ExpectedConditions.elementToBeClickable((servicioDrop))).click();
		return this;
	}
	
	/***
	 * Select the destination country
	 */
	public Servicio selectDestino() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		logger.info("Click on the destination country ");
		wait.until(ExpectedConditions.elementToBeClickable(destinoDrop)).click();
		wait.until(ExpectedConditions.elementToBeClickable(destinoPaisDrop)).click();
		return this;
	}
	
	/***
	 * Select the destination Province
	 */
	public Servicio selectDestinoProv() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		logger.info("Click on the destination province ");
		wait.until(ExpectedConditions.elementToBeClickable(destinoLugarDrop)).click();
		wait.until(ExpectedConditions.elementToBeClickable(destinoProvDrop)).click();
		return this;
	}
	
	/***
	 * Select the service you want
	 */
	public Servicio selectService() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		logger.info("Click on the service ");
		wait.until(ExpectedConditions.elementToBeClickable(serviceDrop)).click();
		wait.until(ExpectedConditions.elementToBeClickable(asistenteDrop)).click();
		return this;
	}
	
	/***
	 * Search according to the selected
	 */
	public ServiciosPage selectBuscar() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		logger.info("Click on Search ");
		wait.until(ExpectedConditions.elementToBeClickable(buscarDrop)).click();
		ServiciosPage servicioPage = new ServiciosPage(driver);
		return servicioPage;
	}
}
