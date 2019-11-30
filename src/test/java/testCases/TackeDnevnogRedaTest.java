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
		driver.get(props.getProperty("URL"));
		driver.manage().window().maximize();
		zgradaKucniSavetPageObj = new ZgradaKucniSavetPageObj(driver);
		pregled = new Pregled(driver);
		stanPageObj = new StanPageObj(driver);
		zgradePageObj = new ZgradePageObj(driver);
		loginPageObj = new LoginPageObj(driver);
		adminPocetnaPageObj = new AdminPocetnaPageObj(driver);
		loginPageObj.logIn("predSkup@gmail.com", "Bar5slova");
		driver.get("http://localhost:8080/zgrada/1/tacke");
	}
	
	@Test(priority = 1)
	public void dodajTackuDnevnogRedaPozitivan() {
		zgradaKucniSavetPageObj.dodajTackuDnevnogReda("aaaaaaaaaaaaaa");
		assertEquals(zgradaKucniSavetPageObj.getAlertMsgText(), "Predlog tacke dnevnog reda uspesno dodat");
		zgradaKucniSavetPageObj.PredoloziTackeDnevnogReda().click();
		assertEquals(zgradaKucniSavetPageObj.getNovoDodatoOvacestenje(), "aaaaaaaaaaaaaa");	
	}
	
	@Test(priority = 2)
	public void dodajTackuDnevnogRedaNegativan() {
	
		zgradaKucniSavetPageObj.dodajTackuDnevnogReda("");
		assertFalse(zgradaKucniSavetPageObj.potvrdiTackeBtn.isEnabled());
	}
	
	@Test(priority = 3)
	public void izmeniTackuDnevnogRedaPozitivan() {
		zgradaKucniSavetPageObj.PredoloziTackeDnevnogReda().click();
		zgradaKucniSavetPageObj.izmeniTackeDnevnogReda("LOL");		
		assertEquals(zgradaKucniSavetPageObj.getAlertMsgText(), "Tacka uspesno izmenjena");
		assertEquals(zgradaKucniSavetPageObj.getNovoDodatoOvacestenje(), "aaaaaaaaaaaaaaLOL");
	}
	
	@Test(priority = 4)
	public void obrisiObavestenjePozitivan() {
		zgradaKucniSavetPageObj.obrisiObavestenje();
		assertEquals(zgradaKucniSavetPageObj.getAlertMsgText(), "Tacka uspesno izbrisana");
	}
	
	@Test(priority = 5)
	public void dodavanjePredlogaTackeUSkupstinuPozitivan() {
		zgradaKucniSavetPageObj.dodavanjePredlogaTackeUSkupstinu(1,0);
		assertEquals(zgradaKucniSavetPageObj.getAlertMsgText(), "Tacka uspesno dodata u skupstinu");
	}
	
	
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		driver.quit();
		driver=null;
	}
	
}
