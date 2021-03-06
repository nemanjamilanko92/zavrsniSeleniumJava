package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AdminPocetnaPageObj;
import pageObjects.LoginPageObj;
import pageObjects.Pregled;
import pageObjects.PregledStanaraPageObj;
import pageObjects.StanariRegistracijaPageObj;
import pageObjects.ZgradePageObj;
import setup.BaseClass;

public class RegistracijaStanaraTest extends BaseClass{
	AdminPocetnaPageObj adminPocetnaPageObj;
	LoginPageObj loginPageObj;
	ZgradePageObj zgradePageObj;
	StanariRegistracijaPageObj stanariRegistracijaPageObj;
	PregledStanaraPageObj pregledStanaraPageObj;
	
	@BeforeClass
	public void SetUp() throws IOException, InterruptedException {
	
		driver = initDriver();
		//odlazimo na stranicu za logovanje
		driver.get(props.getProperty("URL"));
		driver.manage().window().maximize();
		 //instanciranje objekata
		zgradePageObj = new ZgradePageObj(driver);
		loginPageObj = new LoginPageObj(driver);
		adminPocetnaPageObj = new AdminPocetnaPageObj(driver);
		pregledStanaraPageObj = new PregledStanaraPageObj(driver);
		stanariRegistracijaPageObj = new StanariRegistracijaPageObj(driver);
		//logujemo se kao admin
		loginPageObj.logIn(props.getProperty("email"), props.getProperty("password"));
		//navigujemo na stranicu stanari
		adminPocetnaPageObj.Stanari().click();
		
	}
	
	@Test(priority = 1)
	public void registracijaStanaraPos() {
		
		//unosimo stanara sa ocekivanim kredencijalima
	    //ocekujemo poruku o uspesnom dodavanju
	    //zatim proveravamo da li je stanar stvarno unesen u listu stanara
		
		stanariRegistracijaPageObj.regStanara("nesto12@nesto.com", "Nesto5", "Slavisa1", "slavkovic");
		assertEquals(stanariRegistracijaPageObj.getUspesnoRegStanarMsg(), "Uspesno ste registrovali stanara!");
		stanariRegistracijaPageObj.Pregled().click();
		pregledStanaraPageObj.Prikazi("50");
		assertTrue(pregledStanaraPageObj.proveraStanara("Slavisa1", "slavkovic", "(nesto12@nesto.com)"));
		
	}
	@Test(priority = 2)
	public void registracijaStanaranegativan1 () {
		
		//unosimo vec postojeceg stanara u listu
		  //ocekujemo poruku da je mail adresa stanara vec zauzeta
		driver.navigate().refresh();
		stanariRegistracijaPageObj.registracija.click();
		stanariRegistracijaPageObj.regStanara("nesto12@nesto.com", "Nesto5", "Slavisa1", "slavkovic");
		assertEquals(stanariRegistracijaPageObj.getUspesnoRegStanarMsg(), "E-mail adresa: nesto12@nesto.com je zauzeta!");
		stanariRegistracijaPageObj.Pregled().click();
		pregledStanaraPageObj.Prikazi("50");
		assertTrue(pregledStanaraPageObj.proveraStanara("Slavisa1", "slavkovic", "(nesto12@nesto.com)"));
		
	}
	
	@Test(priority = 3)
	public void PozitivanTestResetDugme(){
		
		//unosimo podatke za kreiranje stanara i zatim klikcemo na reset dugme
	    //ocekujemo da su sve forme za unos prazne
		stanariRegistracijaPageObj.registracija.click();
		stanariRegistracijaPageObj.unosenjeVrednostiStanara("nesto12@nesto.com", "Nesto5", "Slavisa1", "slavkovic");
		stanariRegistracijaPageObj.Resetujte().click();
		assertEquals(stanariRegistracijaPageObj.getEmailInputValue(), "");
		assertEquals(stanariRegistracijaPageObj.getLozinkaInputValue(), "");
		assertEquals(stanariRegistracijaPageObj.getImeInputValue(), "");
		assertEquals(stanariRegistracijaPageObj.getPrezimeInputValue(), "");
	}
	
	@Test(priority = 4)
	public void registracijaStanaraNegativni2 () {
		
		 //unosimo podatke za kreiranje stanara sa losom formom za email
	    //ocekujemo poruku greske za unos email-a
		
		stanariRegistracijaPageObj.regStanara("nesto12", "Nesto5", "Slavisa1", "slavkovic");
		assertEquals(stanariRegistracijaPageObj.getEmailErrorMsg(), "Neispravna email adresa!");	
	}
	
	@Test(priority = 5)
	public void registracijaStanaraNegativni3 () {
		
		//unosimo podatke za kreiranje stanara sa losom formom za lozinku
	    //ocekujemo poruku greske za unos lozinke
		
		stanariRegistracijaPageObj.regStanara("nesto12@nesto.com", "a", "Slavisa1", "slavkovic");
		assertEquals(stanariRegistracijaPageObj.getLozinkaErrorMsg(), "Neispravna lozinka!");	
	}
	
	@Test(priority = 6)
	public void registracijaStanaraNegativni4 () {
		
		 //podatke za kreiranje stanara ostavljamo praznim
	    //ocekujemo da je dugme za potvrdu kreiranja stanara onemoguceno
		
		stanariRegistracijaPageObj.regStanara("", "", "", "");
		assertFalse(stanariRegistracijaPageObj.registrujte.isEnabled());
	}
	
	@AfterClass
	public void tearDown(){
		driver.close();
		driver = null;
	}
	
}