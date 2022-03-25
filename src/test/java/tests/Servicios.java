package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import components.Servicio;
import pages.HomePage;
import pages.ServiciosPage;

public class Servicios extends WebDriverManager {
	
	@Test
	public void pruebaSeis() {
		
		//Arrange
		String user = "wolfoneta2022@gmail.com";
		String pass = "mercury";
		
		//Act
		HomePage homePage = new HomePage(driver); 
		ServiciosPage serviciosPage = homePage.goLogin()
				.enterUser(user)
				.enterPass(pass)
				.login()
				.selectServicio()
				.selectDestino()
				.selectDestinoProv()
				.selectService()
				.selectBuscar();
		
		//Assert
		Assert.assertEquals(serviciosPage.isPageTitleDisplayed(), "Imagen de Boston Seguros.");
	}
}
