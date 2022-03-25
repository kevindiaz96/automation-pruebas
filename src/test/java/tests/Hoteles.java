package tests;

import org.testng.annotations.Test;

import components.Hotel;
import pages.HomePage;

public class Hoteles extends WebDriverManager {
	@Test
	public void pruebaCuatro() {
		
		//Arrange
		String user = "wolfoneta2022@gmail.com";
		String pass = "mercury";
		String destino = "La Paloma, Uruguay";
		
		//Act
		HomePage pageLogin = new HomePage (driver);
		Hotel componentHotel = new Hotel (driver);
		pageLogin.goLogin();
		pageLogin.enterUser(user);
		pageLogin.enterPass(pass);
		pageLogin.login();
		componentHotel.selectHotel();
	    componentHotel.enterDestino(destino);
		componentHotel.selectHabitaciones(0);
		componentHotel.selectAdultos(2);
		componentHotel.selectMenores(0);
		componentHotel.selectBuscar();
		
		
		//componentHotel.AssertPaquetes();
		
		//Assert
		
	
	}
}
