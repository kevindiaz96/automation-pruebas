package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import components.Vuelo;
import pages.AutosPage;
import pages.HomePage;
import pages.PaquetesPage;
import pages.VuelosPage;


public class Vuelos extends WebDriverManager {
   	@Test
	public void pruebaCinco() {
   		
   	    //Arrange
   		String user = "wolfoneta2022@gmail.com";
		String pass = "mercury";
		String desde = "Buenos Aires, Argentina";
		String hasta = "Atlantida, Uruguay";
		int index = 1;
		int indec = 3;
		int inde = 1;
		
		//Act
		HomePage homePage = new HomePage(driver); 
		VuelosPage vuelosPage = homePage.goLogin()
				.enterUser(user)
				.enterPass(pass)
				.login()
				.selectVuelo()
				.selectDesde(desde)
				.selectHasta(hasta)
				.selectAdultos(index)
				.selectNiños(indec)
				.selectBebes(inde)
				.selectBuscar();
		
	    //Assert
  		Assert.assertNotEquals(vuelosPage.isPageTitleDisplayed(), "Debe ingresar correctamente la ciudad de salida");
   }
   	
       
  	}
