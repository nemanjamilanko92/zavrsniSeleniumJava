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
		driver.get(props.getProperty("URL"));
		driver.manage().window().maximize();
		zgradaKucniSavetPageObj = new ZgradaKucniSavetPageObj(driver);
		pregled = new Pregled(driver);
		stanPageObj = new StanPageObj(driver);
		zgradePageObj = new ZgradePageObj(driver);
		loginPageObj = new LoginPageObj(driver);
		adminPocetnaPageObj = new AdminPocetnaPageObj(driver);
		loginPageObj.logIn("predSkup@gmail.com", "Bar5slova");
		driver.get("http://localhost:8080/zgrada/1/obavestenja");
		
	}
	
	@Test(priority = 1)
	public void dodajObavestenjePozitivan() {
		zgradaKucniSavetPageObj.dodajObavestenje("aaaaaaaaaaaaaa");
		assertEquals(zgradaKucniSavetPageObj.getAlertMsgText(), "Obavestenje uspesno dodato!");
		zgradaKucniSavetPageObj.Obavestenja().click();
		assertEquals(zgradaKucniSavetPageObj.getNovoDodatoOvacestenje(), "aaaaaaaaaaaaaa");	
	}
	
	@Test(priority = 2)
	public void dodajObavestenjeNegativan() {
	
		zgradaKucniSavetPageObj.dodajObavestenje("");
		assertFalse(zgradaKucniSavetPageObj.potvrdiBtn.isEnabled());
	}
	
	@Test(priority = 3)
	public void izmeniObavestenjePozitivan() {
		zgradaKucniSavetPageObj.Obavestenja().click();
		zgradaKucniSavetPageObj.izmeniObavestenje("LOL");		
		assertEquals(zgradaKucniSavetPageObj.getAlertMsgText(), "Uspesno izmenjeno obavestenje");
		assertEquals(zgradaKucniSavetPageObj.getNovoDodatoOvacestenje(), "aaaaaaaaaaaaaaLOL");
	}
	
	@Test(priority = 4)
	public void obrisiObavestenjePozitivan() {
		zgradaKucniSavetPageObj.obrisiObavestenje();
		assertEquals(zgradaKucniSavetPageObj.getAlertMsgText(), "Uspesno izbrisano obavestenje");
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		
		driver.quit();
		driver=null;
	}
}
