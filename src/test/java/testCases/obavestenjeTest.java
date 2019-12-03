package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.AdminPocetnaPageObj;
import pageObjects.LoginPageObj;
import pageObjects.Pregled;
import pageObjects.StanPageObj;
import pageObjects.ZgradaKucniSavetPageObj;
import pageObjects.ZgradePageObj;
import setup.BaseClass;

public class obavestenjeTest  extends BaseClass{
	AdminPocetnaPageObj adminPocetnaPageObj;
	LoginPageObj loginPageObj;
	ZgradePageObj zgradePageObj;
	StanPageObj stanPageObj;
	Pregled pregled;
	ZgradaKucniSavetPageObj zgradaKucniSavetPageObj;
	
	@BeforeClass
	public void SetUp() throws IOException, InterruptedException {
	
		driver = initDriver();
		 //odlazimo na stranicu za logovanje
		driver.get(props.getProperty("URL"));
		driver.manage().window().maximize();
		 //instanciranje objekata
		zgradaKucniSavetPageObj = new ZgradaKucniSavetPageObj(driver);
		pregled = new Pregled(driver);
		stanPageObj = new StanPageObj(driver);
		zgradePageObj = new ZgradePageObj(driver);
		loginPageObj = new LoginPageObj(driver);
		adminPocetnaPageObj = new AdminPocetnaPageObj(driver);
		//logujemo se kao predsednik skupstine
		loginPageObj.logIn("predSkup@gmail.com", "Bar5slova");
		//navigujemo na stranicu obavestenja
		driver.get("http://localhost:8080/zgrada/1/obavestenja");
		
	}
	
	@Test(priority = 1)
	public void dodajObavestenjePozitivan() {
		
		 //unosimo obavestenje sa ocekivanim podacima
	    //ocekujemo poruku o uspesnom dodavanju
	    //zatim proveravamo da li je obavestenje stvarno uneseno u listu obavestenja
		
		zgradaKucniSavetPageObj.dodajObavestenje("aaaaaaaaaaaaaa");
		assertEquals(zgradaKucniSavetPageObj.getAlertMsgText(), "Obavestenje uspesno dodato!");
		zgradaKucniSavetPageObj.Obavestenja().click();
		assertEquals(zgradaKucniSavetPageObj.getNovoDodatoOvacestenje(), "aaaaaaaaaaaaaa");	
	}
	
	@Test(priority = 2)
	public void dodajObavestenjeNegativan() {
		
		//formu za unos novog obavestenja ostavljamo praznim
	    //ocekujemo da je dugme za potvrdu pravljenja obavestenja onemoguceno
		
		zgradaKucniSavetPageObj.dodajObavestenje("");
		assertFalse(zgradaKucniSavetPageObj.potvrdiBtn.isEnabled());
	}
	
	@Test(priority = 3)
	public void izmeniObavestenjePozitivan() {
		
		//klikcemo na dugme za izmenu obavestenja
	    //dodajemo izmenu u obavestenje
	    //ocekujemo poruku o uspesnoj promeni obavestenja i proveravamo da je text stvarno izmenjen
		
		zgradaKucniSavetPageObj.Obavestenja().click();
		zgradaKucniSavetPageObj.izmeniObavestenje("LOL");		
		assertEquals(zgradaKucniSavetPageObj.getAlertMsgText(), "Uspesno izmenjeno obavestenje");
		assertEquals(zgradaKucniSavetPageObj.getNovoDodatoOvacestenje(), "aaaaaaaaaaaaaaLOL");
	}
	
	@Test(priority = 4)
	public void obrisiObavestenjePozitivan() {
		
		 //klikcemo na dugme za brisanje obavestenja
	    //ocekujemo poruku o uspesnom brisanju obavestenja
		
		zgradaKucniSavetPageObj.obrisiObavestenje();
		assertEquals(zgradaKucniSavetPageObj.getAlertMsgText(), "Uspesno izbrisano obavestenje");
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		
		driver.quit();
		driver=null;
	}
}
