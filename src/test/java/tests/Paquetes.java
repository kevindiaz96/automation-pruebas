package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import components.Paquete;
import components.Pasaje;
import pages.HomePage;
import pages.PaquetesPage;



public class Paquetes extends WebDriverManager {
	@Test
	public void pruebaTres() {
		
		//Arrange
		String user = "wolfoneta2022@gmail.com";
		String pass = "mercury";
		int indec = 1;
		int index = 1;
		int inde = 3;
		int indx = 1;
		
		//Act
		HomePage homePage = new HomePage(driver); 
		PaquetesPage paquetesPage = homePage.goLogin()
				.enterUser(user)
				.enterPass(pass)
				.login()
                .selectOrigen()
				.selecDestino(index)
				.selectFromPort(inde)
				.selectNoches(indx)
				.selectBuscar();
	
		//Assert 
		Assert.assertTrue(paquetesPage.isPageTitleDisplayed(), "El titulo no esta desplegado");
	}

}
