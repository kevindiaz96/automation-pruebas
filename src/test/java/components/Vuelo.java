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
import pages.AutosPage;
import pages.VuelosPage;

public class Vuelo {
	private WebDriver driver;
	private static Logger logger = (Logger) LogManager.getLogger(Loggers.class);
	
	//Selectors
	private By vueloDrop = By.cssSelector("#busquedaHomeDesktop > ul > li:nth-child(3) > a > div");
	private By desdeDrop = By.id("ac_ciudadDesde");
	private By hastaDrop = By.id("ac_ciudadHasta");
	private By adultosDrop = By.cssSelector("[data-id='cantAdt']");
	private By cantAdultosDrop = By.cssSelector("[data-id='cantAdt'] + div > ul > li");
	private By niñosDrop = By.cssSelector("[data-id='cantChd']");
	private By cantNiñosDrop = By.cssSelector("[data-id='cantChd'] + div > ul > li");
	private By bebesDrop = By.cssSelector("[data-id='cantInf']");
	private By cantBebesDrop = By.cssSelector("[data-id='cantInf'] + div > ul > li");
	private By buscarDrop = By.cssSelector("[onclick='submitForm();']");
	
	public Vuelo (WebDriver driver) {
		this.driver = driver;
	}
	
	/***
	 * Click on Flights 
	 */
	public Vuelo selectVuelo() { 
		WebDriverWait wait = new WebDriverWait(driver, 10);
		logger.info("Click on Vuelos ");
		wait.until(ExpectedConditions.elementToBeClickable((vueloDrop))).click();
		return this;
	}
	
	/***
	 * Type on the keyboard From where you travel
	 * @param desde
	 */
	public Vuelo selectDesde(String desde) { 
		WebDriverWait wait = new WebDriverWait(driver, 10);
		logger.info("Send a text from where you travel "+desde);
		wait.until(ExpectedConditions.presenceOfElementLocated(desdeDrop));
		driver.findElement(desdeDrop).sendKeys(desde);	
		return this;
	}
	
	/***
	 * Type on the keyboard As far as you travel
	 * @param hasta
	 */
	public Vuelo selectHasta(String hasta) { 
		WebDriverWait wait = new WebDriverWait(driver, 10);
		logger.info("Send a text to where you travel"+hasta);
		wait.until(ExpectedConditions.presenceOfElementLocated(hastaDrop));
		driver.findElement(hastaDrop).sendKeys(hasta);
		return this;
	}
	
	/***
	 * Select how many adults are
	 * @param index
	 */
	public Vuelo selectAdultos(int index) { 
		WebDriverWait wait = new WebDriverWait(driver, 10);
		logger.info("Click on Adults ");
		wait.until(ExpectedConditions.elementToBeClickable((adultosDrop))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(cantAdultosDrop));
		List<WebElement> selectAdt = driver.findElements(cantAdultosDrop);
		selectAdt.get(index).click();	
		return this;
	}
	
	/***
	 * Select how many children are
	 * @param indec
	 */
	public Vuelo selectNiños(int indec) { 
		WebDriverWait wait = new WebDriverWait(driver, 10);
		logger.info("Click on Children ");
		wait.until(ExpectedConditions.elementToBeClickable((niñosDrop))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(cantNiñosDrop));
		List<WebElement> selectChd = driver.findElements(cantNiñosDrop);
		selectChd.get(indec).click();
		return this;
	}
	
	
	/***
	 * Select how many babies are
	 * @param inde
	 */
	public Vuelo selectBebes(int inde) { 
		WebDriverWait wait = new WebDriverWait(driver, 10);
		logger.info("Click on Babies ");
		wait.until(ExpectedConditions.elementToBeClickable((bebesDrop))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(cantBebesDrop));
		List<WebElement> selectInf = driver.findElements(cantBebesDrop);
		//Helpers helper = new Helpers();
		//helper.sleepSeconds(10);
		selectInf.get(inde).click();
		return this;
	}
	
	/***
	 * Search according to the selected
	 */
	public VuelosPage selectBuscar() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		logger.info("Click on Search ");
		wait.until(ExpectedConditions.elementToBeClickable((buscarDrop))).click();
		VuelosPage vueloPage = new VuelosPage(driver);
		return vueloPage;
	}
	
	//public void assertPage() {
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(buscarDrop))).click();
		//Assert.assertTrue(elementToBeClickable(driver.findElement(buscarDrop))).click();
    	//Assert.assertTrue(driver.findElement(buscarDrop).getTagName());
    	//Assert.assertTrue(driver.findElement(titleText).getText().contains("Vuelva a intentarlo en 1 hora. "));
		/*List<WebElement> loginFields =driver.findElements(fields);
		System.out.println(loginFields.size());
		Assert.assertTrue(loginFields.size()==5);*/
    //}
}
