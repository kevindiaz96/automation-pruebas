package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LogonPage;

public class Login extends WebDriverManager {

	/**
	 * El test "pruebaUno" es para verificar que se loguea de manera incorrecta
	 */
	@Test
	public void pruebaUno() {
		//Arrange
		String user = "wolfoneta2022@gmail.com";
		String password = "pass";
		
		//Act			
		HomePage pageLogin = new HomePage(driver);
		LogonPage pageLogon = new LogonPage(driver);
		pageLogin.goLogin();
		pageLogin.enterUser("wolfoneta2022@gmail.com");
		pageLogin.enterPass("pass");
		pageLogin.login();
		pageLogon.assertLogonPage();
			
	    }
	/**
	 * El test "pruebaDos" es para verificar que se loguea de manera correcta
	 */
	@Test
	public void pruebaDos() {
		HomePage pageLogin = new HomePage(driver);
		pageLogin.enterUser("wolfoneta2022@gmail.com");
		pageLogin.enterPass("mercury");
		pageLogin.login();
		
	    }	

}
