package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import helpers.Helpers;
import pages.HomePage;

/**
 * 
 * Esta clase de ExtentReport es para ver que sucede en cada parte del test
 *
 */
public class ExtentReportTestNG {

	ExtentReports extent;
	ExtentSparkReporter spark;
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("ExtentReportUsandoTestNg.html");
		extent.attachReporter(spark);
		
	}

	@BeforeTest
	public void setUpTest() {
	ExtentTest test= extent.createTest("Entrando en la page");
	DesiredCapabilities caps = new DesiredCapabilities();
	System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.navigate().to("https://www.buquebusturismo.com/");
	test.pass("Entro en la pagina");
	Helpers helper = new Helpers();
	helper.sleepSeconds(5);
	}
	
	
	/*@Test
	public void test3() {
	ExtentTest test= extent.createTest("Test del caso 3", "Loguearse en la pagina");
	
	HomePage pageLogin = new HomePage(driver);
	test.pass("Logueo para entrar en la pagina");
	
	pageLogin.enterUser("wolfoneta2022@gmail.com");
	pageLogin.enterPass("pass");
	test.pass("Logueo user y pass"); 
	test.info("Test completado");
	
	
	test.log(Status.INFO, "");
	test.info("");	
	//test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath+("screenshott.png"));	
	test.addScreenCaptureFromPath("screenshoot.png");
	}*/
	
	//@Test
	//public void test4() {
		//ExtentTest test= extent.createTest("Test del caso 3", "Loguearse el pa pagina");
		//test.log(Status.INFO, "");
		//test.info("");
		//test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshott.png"));
		//test.addScreenCaptureFromBase64String("screenshot.png");
	//}
	
	@AfterTest
	public void tearDown() {
		extent.flush();	
		driver.close();
	}
}
