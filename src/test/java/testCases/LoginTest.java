package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AdminPocetnaPageObj;
import pageObjects.LoginPageObj;

import setup.BaseClass;

public class LoginTest extends BaseClass{
	AdminPocetnaPageObj adminPocetnaPageObj;
	LoginPageObj loginPageObj;
	@BeforeClass
	public void proba() throws IOException {
	
		driver = initDriver();
		  //odlazimo na stranicu za logovanje
		driver.get(props.getProperty("URL"));
		driver.manage().window().maximize();
		//instanciranje objekata
		loginPageObj = new LoginPageObj(driver);
		adminPocetnaPageObj = new AdminPocetnaPageObj(driver);
	}
	@Test
	public void loginPositivniTest()  {
		
		//unosimo ocekivane podatke za logovanje
	    //ocekujemo da cemo na pocetnoj stranici procitati mail ulogovanog korsinika
		
		loginPageObj.logIn(props.getProperty("email"),props.getProperty("password"));
		assertEquals(adminPocetnaPageObj.getAdminEmailText(), "admin@gmail.com");
		adminPocetnaPageObj.LogOutBtn().click();
		
		
	}
	//za ove testove koristimo data provider (../DataProvider/data)
	@Test(dataProvider ="data-provider" )
	public void loginNegativniTestovi(String email,String lozinka,String rez)   {
		
		 //unosimo pogresne podatke za logovanje
	    //ocekujemo razlicite poruke za neuspesno logovanje u zavisnosti od prosledjenih podataka
		
		loginPageObj.logIn(email,lozinka);
		assertEquals(loginPageObj.getErrMsgText(),rez);
		System.out.println(loginPageObj.getErrMsgText());
	}
	
	@AfterClass
	public void tearDown()  {
		
		driver.quit();
		driver=null;
	}
	@DataProvider(name = "data-provider")
	public Object[][] dataProviderMethod() {
        return new Object[][] { 
        	{"","","Email nije validnog formata!"}, 
        	{"admin@gmail.com","","Lozinka nije validnog formata (Mora biti bar jedno veliko slovo, veliko malo slovo i broj i minimalne duzine 6)!"},
        	{"nesto@nesto.com","Bar5slova","Pogresan email ili lozinka!"},
        	{"admin@gmail.com","sad23A2","Pogresan email ili lozinka!"}
        	
        };
    }
}
