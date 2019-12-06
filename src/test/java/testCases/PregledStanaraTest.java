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
		 //odlazimo na stranicu za logovanje
		driver.get(props.getProperty("URL"));
		driver.manage().window().maximize();
		//instanciranje objekata
		stanariRegistracijaPageObj = new StanariRegistracijaPageObj(driver);
		loginPageObj = new LoginPageObj(driver);
		adminPocetnaPageObj = new AdminPocetnaPageObj(driver);
		pregledStanaraPageObj = new PregledStanaraPageObj(driver);
		 //logujemo se kao admin
		loginPageObj.logIn(props.getProperty("email"), props.getProperty("password"));
		//navigujemo na stranicu pregleda stanara
		adminPocetnaPageObj.Stanari().click();
		stanariRegistracijaPageObj.Pregled().click();
	}
	
	@Test(dataProvider = "dataprovider")
	public void PozitivanTestPretrageStanara1(String ime) {
		//u polje za pretragu stanara unosimo ime i prezime stanara
	    //ocekujemo da ce se stanar pojaviti u filtriranoj listi
		pregledStanaraPageObj.UnosPretrage(ime);
		assertTrue(pregledStanaraPageObj.proveraStanara("Gospodin", "Predsednik", "(predSkup@gmail.com)"));
	}
	
	@Test
	public void PozitivanTestPretrageStanara() {
		
		//u polje za pretragu stanara unosimo nepostojeceg stanara (nasumicni text)
	    //ocekujemo poruku da ni jedan stanar nije pronadjen
		
		pregledStanaraPageObj.UnosPretrage("AAAAAAAAA");
		assertEquals(pregledStanaraPageObj.ErrMessZaNepostojecegStanara(), "Nijedan stanar sa trazenim kriterijumom nije prondajen!");
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
