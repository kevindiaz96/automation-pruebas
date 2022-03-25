package pages;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Loggers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import components.Auto;
import components.Hotel;
import components.Paquete;
import components.Pasaje;
import components.Servicio;
import components.Vuelo;
import helpers.Helpers;


public class HomePage{
    private WebDriver driver;	
    private static Logger logger = (Logger) LogManager.getLogger(Loggers.class);
 
    //Selectors
	private By loginBoton = By.id("loggedIn");	
	private By userField = By.id("parEmail");
	private By passwordField = By.id("parPass");
	private By loginButton = By.id("btnLogin");
	
	//Components
	 private Paquete paquetes;
	 private Hotel hoteles;
	 private Vuelo vuelos;
	 private Auto autos;
	 private Servicio servicios;
	 private Pasaje pasajes;
	
	 
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	/***
	 * Log in to the page
	 * 
	 */
	public HomePage goLogin() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		logger.info("Envia informacion sobre si se da click");
		wait.until(ExpectedConditions.elementToBeClickable(loginBoton));
		driver.findElement(loginBoton).click();
		return this;
	}
	
	/***
	 * Put the User
	 * 
	 */
	public HomePage enterUser(String user) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		logger.debug("Envia informe sobre el usuario "+user);
		wait.until(ExpectedConditions.presenceOfElementLocated(userField));
		driver.findElement(userField).sendKeys(user);
		return this;
	}
	
	/***
	 * Put the Password
	 * 
	 */
	public HomePage enterPass(String pass) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		logger.info("Envia informacion sobre el password "+pass);
		wait.until(ExpectedConditions.presenceOfElementLocated(passwordField)); 
		driver.findElement(passwordField).sendKeys(pass);
		return this;
	}
	
	/***
	 * Click on the button to login
	 * 
	 */
	public HomePage login() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		logger.info("Este mensaje es para que se pueda loguear");
		wait.until(ExpectedConditions.elementToBeClickable(loginButton)); 
		driver.findElement(loginButton).click();
		return this;	
	}
	
	/***
	 * Click on Packages
	 */
	public Paquete selectOrigen() {
		logger.info("Click on Packages ");
		Paquete paquete = new Paquete (driver);
		paquete.selectOrigen(1);
	    return paquete;	
	}
	
	/***
	 * Click on Hotels
	 */
	public Hotel selectHotel() { 
		logger.info("Click on Hotels ");
		Hotel hotel = new Hotel(driver);
		hotel.selectHotel();
		return hotel;
	}
	
	/***
	 * Click on Flights 
	 */
	public Vuelo selectVuelo() { 
		logger.info("Click on Vuelos ");
		Vuelo vuelo = new Vuelo(driver);
		vuelo.selectVuelo();
		return vuelo;
	}

	/***
	 * Click on Cars
	 */
	public Auto selecAuto() {
		logger.info("Click on Cars ");
		Auto auto = new Auto(driver);
		auto.selecAuto();
		return auto;
	}
	
	/***
	 * Click on Services
	 */
	public Servicio selectServicio() { 
		logger.info("Click on Services ");
		Servicio servicio = new Servicio(driver);
		servicio.selectServicio();
		return servicio;
	}
	
	public Pasaje pasajes() {
		return pasajes;
	}
}
