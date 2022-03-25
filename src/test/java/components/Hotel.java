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

import helpers.Helpers;

public class Hotel {
	private WebDriver driver;
	private static Logger logger = (Logger) LogManager.getLogger(Loggers.class);
	
	//Selectors
	private By hotelDrop = By.cssSelector("#busquedaHomeDesktop > ul > li:nth-child(2) > a > div");
	private By destinoDrop = By.id("ac_codCiudad");
	private By habitacionesDrop = By.cssSelector("[data-id='hoteles_cantHabitacion']");
	private By cantHabitacionesDrop = By.cssSelector("[data-id='hoteles_cantHabitacion'] + div > ul > li");
	private By adultosDrop = By.cssSelector("[class=\"btn-group bootstrap-select form-control dropup\"] button");
	private By cantAdultosDrop = By.cssSelector("[class='btn-group bootstrap-select form-control dropup open'] > div > ul > li");
	private By menoresDrop = By.id("habitaciones_hoteles");
	private By cantMenoresDrop = By.cssSelector("[data-original-index]");
	private By buscarDrop = By.id("botonBuscarHoteles");
	
	public Hotel(WebDriver driver) {
		this.driver = driver;	
	}
	
	/***
	 * Click on Hotels
	 */
	public Hotel selectHotel() { 
		WebDriverWait wait = new WebDriverWait(driver, 10);
		logger.info("Click on Hotels ");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(hotelDrop))).click();
		return this;
	}
	
	/***
	 * Type the destination on the keyboard
	 * @param destino
	 */
	public Hotel enterDestino(String destino) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		logger.debug("Envia informe sobre el destino "+destino);
		wait.until(ExpectedConditions.presenceOfElementLocated(destinoDrop));
		wait.until(ExpectedConditions.presenceOfElementLocated(destinoDrop)).clear();
		driver.findElement(destinoDrop).sendKeys(destino);
		return this;
	}
	
	/***
	 * Select the number of rooms
	 * @param indec
	 */
	public Hotel selectHabitaciones(int indec) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		logger.info("Click on Rooms ");
		wait.until(ExpectedConditions.elementToBeClickable((habitacionesDrop))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(cantHabitacionesDrop));
		List<WebElement> cantHabitaciones = driver.findElements(cantHabitacionesDrop);
		cantHabitaciones.get(indec).click();
		return this;
	}
	
	/***
	 * Select how many adults are
	 * @param index
	 */
	public Hotel selectAdultos(int index) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		logger.info("Click on Adults ");
		wait.until(ExpectedConditions.elementToBeClickable((adultosDrop))).click();
		//Helpers helper = new Helpers();
		//helper.sleepSeconds(10);
		//driver.findElement(adultosDrop);
		wait.until(ExpectedConditions.presenceOfElementLocated(cantAdultosDrop));
		List<WebElement> loginFields = driver.findElements(cantAdultosDrop); 
		loginFields.get(index);
		return this;
	}
	
	/*public void veryFields(int index) {
		selectAdultos();
		List<WebElement> loginFields = driver.findElements(cantAdultosDrop);
		loginFields.get(index).isSelected();		
	}*/
	
	/***
	 * Select how many minors they are
	 * @param inde
	 */
	public Hotel selectMenores(int inde) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		logger.info("Click on Kids ");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(menoresDrop))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(cantMenoresDrop))).click();
		List<WebElement> cantMenores = driver.findElements(cantMenoresDrop);
		cantMenores.get(inde);
		return this;
	}
	
	/***
	 * Search according to the selected
	 */
	public Hotel selectBuscar() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		logger.info("Click on Searchr ");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(buscarDrop))).click();
		return this;
	}
	
	/*public Hotel AssertPaquetes() {
		List<WebElement> cantMenr =driver.findElements(cantMenoresDrop);
		System.out.println(cantMenr.size());
		Assert.assertTrue(cantMenr.size()==5);
		return this;
	}*/
}
