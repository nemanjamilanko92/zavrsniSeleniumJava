package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AdminPocetnaPageObj;
import pageObjects.LoginPageObj;
import pageObjects.Pregled;
import pageObjects.PregledStanaraPageObj;
import pageObjects.StanariRegistracijaPageObj;
import pageObjects.ZgradePageObj;
import setup.BaseClass;

public class PregledStanaraTest extends BaseClass{
	AdminPocetnaPageObj adminPocetnaPageObj;
	LoginPageObj loginPageObj;
	StanariRegistracijaPageObj stanariRegistracijaPageObj;
	PregledStanaraPageObj pregledStanaraPageObj;
	@BeforeClass
	public void SetUp() throws IOException, InterruptedException {
	
		driver = initDriver();
		driver.get(props.getProperty("URL"));
		driver.manage().window().maximize();
		stanariRegistracijaPageObj = new StanariRegistracijaPageObj(driver);
		loginPageObj = new LoginPageObj(driver);
		adminPocetnaPageObj = new AdminPocetnaPageObj(driver);
		pregledStanaraPageObj = new PregledStanaraPageObj(driver);
		loginPageObj.logIn(props.getProperty("email"), props.getProperty("password"));
		adminPocetnaPageObj.Stanari().click();
		stanariRegistracijaPageObj.Pregled().click();
	}
	
	@Test(dataProvider = "dataprovider")
	public void PozitivanTestPretrageStanara1(String ime) {
		
		pregledStanaraPageObj.UnosPretrage(ime);
		assertTrue(pregledStanaraPageObj.proveraStanara("Gospodin", "Predsednik", "(predSkup@gmail.com)"));
	}
	
	@Test
	public void PozitivanTestPretrageStanara5() {
		pregledStanaraPageObj.UnosPretrage("AAAAAAAAA");
		assertEquals(pregledStanaraPageObj.ErrMessZaNepostojecegStanara().getText().trim(), "Nijedan stanar sa trazenim kriterijumom nije prondajen!");
	}
	@DataProvider
	public Object[][] dataprovider(){
		return new Object[][]  {
			{"Gospodin Predsednik"},
			{"predSkup@gmail.com"},
			{"Gospodin"},
			{"Predsednik"}
		
		};
	}
	@AfterClass
	public void tearDown(){
		driver.close();
		driver = null;
	}
	
}
