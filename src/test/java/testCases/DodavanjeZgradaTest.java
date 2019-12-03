package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AdminPocetnaPageObj;
import pageObjects.LoginPageObj;
import pageObjects.Pregled;
import pageObjects.ZgradePageObj;
import setup.BaseClass;

public class DodavanjeZgradaTest extends BaseClass{
	AdminPocetnaPageObj adminPocetnaPageObj;
	LoginPageObj loginPageObj;
	ZgradePageObj zgradePageObj;
	Pregled pregled;
	@BeforeClass
	public void SetUp() throws IOException, InterruptedException {
	
		driver = initDriver();
		//instanciranje objekata
		zgradePageObj = new ZgradePageObj(driver);
		loginPageObj = new LoginPageObj(driver);
		adminPocetnaPageObj = new AdminPocetnaPageObj(driver);
		pregled = new Pregled(driver);
		//odlazimo na stranicu za logovanje
		driver.get(props.getProperty("URL"));
		driver.manage().window().maximize();
		loginPageObj.logIn(props.getProperty("email"), props.getProperty("password"));
		//navigujemo na stranicu zgrade
		adminPocetnaPageObj.Zgrade().click();
	}

	@Test()
	public void PozitivanTestDodavanjaZgrade(){
		
		//unosimo zgradu sa ocekivanim podacima
	    //ocekujemo poruku o uspesnom dodavanju
	    //zatim proveravamo da li je zgrada stvarno unesena u listu zgrada
		
		zgradePageObj.dodavanjeZgrade("Vrbas", "Marsala Tita", "21", "1");
		assertEquals(zgradePageObj.getUspesnoDodataZgradaMessage(), "Uspesno ste dodali zgradu!");
		zgradePageObj.Pregled().click();
		assertEquals(pregled.AdresaZgrade().getText(), "Marsala Tita 21, Vrbas");
		//ISPRAVITI STATICKE PROVERE ZGRADE
	}
	
	@Test()
	public void PozitivanTestResetDugme(){
		
		 //unosimo podatke za kreiranje zgrade i zatim klikcemo na reset dugme
	    //ocekujemo da su sve forme za unos prazne
		
		zgradePageObj.unosenjeVrednostiZgrade("a", "a", "1", "1");
		zgradePageObj.Resetujte().click();
		assertEquals(zgradePageObj.getBrojInputValue(), "");
		assertEquals(zgradePageObj.getMestoInputValue(), "");
		assertEquals(zgradePageObj.getBrojStanovaInputValue(), "");
		assertEquals(zgradePageObj.getUlicaInputValue(), "");
	}
	
	@Test
	public void negativanTestIstaAdresaZgrade(){
		
		  //unosimo vec postojecu zgradu u listu
	    //ocekujemo poruku da je mail adresa stanara vec zauzeta
		
		zgradePageObj.dodavanjeZgrade("Vrbas", "Marsala Tita", "21", "1");
		assertEquals(zgradePageObj.getZgradaSaIstomAdresomMessage(), "Vec postoji zgrada na toj adresi!");
	}
	
	@Test
	public void NegativanTestDodavanjaZgrade1(){
		
		 //podatke za kreiranje zgrade ostavljamo praznim
	    //ocekujemo da je dugme za potvrdu kreiranja zgrade onemoguceno
		
		zgradePageObj.dodavanjeZgrade("","","","");
		assertFalse(zgradePageObj.dodajte.isEnabled());	
	}
	
	@Test()
	public void NegativanTestDodavanjaZgrade2(){
		
		//unosimo podatke za kreiranje stanara sa stringom umesto intidzera za broj zgrade i stanova
	    //ocekujemo poruku greske za unos
		
		zgradePageObj.dodavanjeZgrade("a","a","a","a");
		assertEquals(zgradePageObj.getErrMessBroj(), "Ovo polje ne sme biti prazno!");
		assertEquals(zgradePageObj.getErrMessBrojStanova(), "Ovo polje ne sme biti prazno!");
	}
	
	@Test
	public void NegativanTestDodavanjaZgrade3(){
		
		 //unosimo podatke za kreiranje zgrade sa nulom za broj zgrade i stanova
	    //ocekujemo poruku greske za unos
		
		zgradePageObj.dodavanjeZgrade("a","a","0","0");
		assertEquals(zgradePageObj.getErrMessBrojNula(), "Broj mora biti pozitivan!");
		assertEquals(zgradePageObj.getErrMessBrojStanova(), "Broj mora biti pozitivan!");
	}
	
	
	@AfterClass
	public void tearDown(){
		driver.close();
		driver = null;
	}
}
