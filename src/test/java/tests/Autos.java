package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import components.Auto;
import pages.AutosPage;
import pages.HomePage;

public class Autos extends WebDriverManager {

	@Test
	public void pruebaCinco() {
		
		//Arrange
		String user = "wolfoneta2022@gmail.com";
		String pass = "mercury";
		String retira = "Buenos Aires, Argentina";
		String devuelve = "el mismo estado";
		int index = 3;
		
		//Act
		HomePage homePage = new HomePage(driver); 
		AutosPage autosPage = homePage.goLogin()
				.enterUser(user)
				.enterPass(pass)
				.login()
				.selecAuto()
				.selectRetira(retira)
				.selectDevuelve(devuelve)
				.selectTipoDeAuto(index)
				.selectBuscar();
		
		//Assert
  		Assert.assertEquals(autosPage.isPageTitleDisplayed(), "No se encontraron tarifas para la fecha solicitada.");
	}

}
