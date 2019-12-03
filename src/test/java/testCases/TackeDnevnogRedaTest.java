package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AdminPocetnaPageObj;
import pageObjects.LoginPageObj;
import pageObjects.Pregled;
import pageObjects.StanPageObj;
import pageObjects.ZgradaKucniSavetPageObj;
import pageObjects.ZgradePageObj;
import setup.BaseClass;

public class TackeDnevnogRedaTest  extends BaseClass {
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
		  //navigujemo na stranicu tacaka dnevnog reda
		driver.get("http://localhost:8080/zgrada/1/tacke");
	}
	
	@Test(priority = 1)
	public void dodajTackuDnevnogRedaPozitivan() {
		
		//unosimo tacku dnevog reda sa ocekivanim podacima
	    //ocekujemo poruku o uspesnom dodavanju
	    //zatim proveravamo da li je tacka dnevog reda stvarno unesena u listu
		
		zgradaKucniSavetPageObj.dodajTackuDnevnogReda("aaaaaaaaaaaaaa");
		assertEquals(zgradaKucniSavetPageObj.getAlertMsgText(), "Predlog tacke dnevnog reda uspesno dodat");
		zgradaKucniSavetPageObj.PredoloziTackeDnevnogReda().click();
		assertEquals(zgradaKucniSavetPageObj.getNovoDodatoOvacestenje(), "aaaaaaaaaaaaaa");	
	}
	
	@Test(priority = 2)
	public void dodajTackuDnevnogRedaNegativan() {
		
		//pri kreiranju nove tacke dnevnog reda formu za unos ostavljamo prazno
	    //ocekujemo da je dugme za kreiranje tacke neaktivno
		zgradaKucniSavetPageObj.dodajTackuDnevnogReda("");
		assertFalse(zgradaKucniSavetPageObj.potvrdiTackeBtn.isEnabled());
	}
	
	@Test(priority = 3)
	public void izmeniTackuDnevnogRedaPozitivan() {
		
		  //klikcemo na dugme za izmenu tacke dnevnog reda
	    //dodajemo izmenu u tacku dnevnog reda
	    //ocekujemo poruku o uspesnoj promeni tacke dnevnog reda i proveravamo da je text stvarno izmenjen
		
		zgradaKucniSavetPageObj.PredoloziTackeDnevnogReda().click();
		zgradaKucniSavetPageObj.izmeniTackeDnevnogReda("LOL");		
		assertEquals(zgradaKucniSavetPageObj.getAlertMsgText(), "Tacka uspesno izmenjena");
		assertEquals(zgradaKucniSavetPageObj.getNovoDodatoOvacestenje(), "aaaaaaaaaaaaaaLOL");
	}
	
	@Test(priority = 4)
	public void obrisiObavestenjePozitivan() {
		
		//klickemo na dugme za brisanje kvara
	    //ocekujemo poruku o uspesnom brisanju kvara
		
		zgradaKucniSavetPageObj.obrisiObavestenje();
		assertEquals(zgradaKucniSavetPageObj.getAlertMsgText(), "Tacka uspesno izbrisana");
	}
	
	@Test(priority = 5)
	public void dodavanjePredlogaTackeUSkupstinuPozitivan() {
		
		//na dropdown listi biramo skupstinu u koju zelimo da prosledimo tacku
	    //klikcemo na dugme za dodavanje tacke u skupstinu
		
		zgradaKucniSavetPageObj.dodavanjePredlogaTackeUSkupstinu(1,0);
		assertEquals(zgradaKucniSavetPageObj.getAlertMsgText(), "Tacka uspesno dodata u skupstinu");
	}
	
	
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		driver.quit();
		driver=null;
	}
	
}
