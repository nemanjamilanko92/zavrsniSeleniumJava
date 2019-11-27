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
import pageObjects.Zgrade;
import setup.BaseClass;

public class test1 extends BaseClass{
	AdminPocetnaPageObj adminPocetnaPageObj;
	LoginPageObj loginPageObj;
	@BeforeClass
	public void proba() throws IOException {
	
		driver = initDriver();
		driver.get(props.getProperty("URL"));
		driver.manage().window().maximize();
		loginPageObj = new LoginPageObj(driver);
		adminPocetnaPageObj = new AdminPocetnaPageObj(driver);
	}
	@Test(enabled = false)
	public void loginPositivniTest() throws InterruptedException {
		loginPageObj.logIn(props.getProperty("email"),props.getProperty("password"));
		assertEquals(adminPocetnaPageObj.getAdminEmailText(), "admin@gmail.com");
	
		
		
	}
	@Test(dataProvider ="data-provider" )
	public void loginNegativniTestovi(String email,String lozinka,String rez) throws InterruptedException {
		loginPageObj.logIn(email,lozinka);
		assertEquals(loginPageObj.getErrMsgText(),rez);
		System.out.println(loginPageObj.getErrMsgText());
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		
		driver.quit();
		driver=null;
	}
	@DataProvider(name = "data-provider")
	public Object[][] dataProviderMethod() {
        return new Object[][] { 
        	{ "","","Email nije validnog formata!" }, 
        	{ "admin@gmail.com","","Lozinka nije validnog formata (Mora biti bar jedno veliko slovo, veliko malo slovo i broj i minimalne duzine 6)!" },
        	
        	{"nesto@nesto.com","Bar5slova","Pogresan email ili lozinka!"},
        	{"admin@gmail.com","sad23A2","Pogresan email ili lozinka!"}
        	
        };
    }
}
