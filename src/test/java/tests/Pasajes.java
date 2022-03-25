package tests;

import org.testng.annotations.Test;

import components.Pasaje;
import pages.HomePage;

public class Pasajes  extends WebDriverManager  {
	
	@Test
	public void pruebaSeis() {
		
		//Arrange
        String user = "wolfoneta2022@gmail.com"; 
        String pass = "mercury";
        
        //Act
        HomePage pageLogin = new HomePage (driver);
	    Pasaje componentPasaje = new Pasaje (driver);	
	    pageLogin.goLogin();
		pageLogin.enterUser(user);
		pageLogin.enterPass(pass);
		pageLogin.login();
		componentPasaje.selectPasaje();
		}

}
