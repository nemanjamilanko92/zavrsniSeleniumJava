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
		driver.get(props.getProperty("URL"));
		driver.manage().window().maximize();
		zgradePageObj = new ZgradePageObj(driver);
		loginPageObj = new LoginPageObj(driver);
		adminPocetnaPageObj = new AdminPocetnaPageObj(driver);
		pregled = new Pregled(driver);
		loginPageObj.logIn(props.getProperty("email"), props.getProperty("password"));
		adminPocetnaPageObj.Zgrade().click();
		
	}

	
	@Test(enabled=false)
	public void PozitivanTestDodavanjaZgrade(){
		zgradePageObj.dodavanjeZgrade("Vrbas", "Marsala Tita", "21", "1");
		assertEquals(zgradePageObj.getUspesnoDodataZgradaMessage(), "Uspesno ste dodali zgradu!");
		zgradePageObj.Pregled().click();
		assertEquals(pregled.AdresaZgrade().getText(), "Marsala Tita 21, Vrbas");
	}
	
	@Test(enabled=false)
	public void PozitivanTestResetDugme(){
		zgradePageObj.unosenjeVrednostiZgrade("a", "a", "1", "1");
		zgradePageObj.Resetujte().click();
		assertEquals(zgradePageObj.getBrojInputValue(), "");
		assertEquals(zgradePageObj.getMestoInputValue(), "");
		assertEquals(zgradePageObj.getBrojStanovaInputValue(), "");
		assertEquals(zgradePageObj.getUlicaInputValue(), "");
	}
	
	@Test
	public void PozitivanTestIstaAdresaZgrade(){
		zgradePageObj.dodavanjeZgrade("Vrbas", "Marsala Tita", "21", "1");
		assertEquals(zgradePageObj.getZgradaSaIstomAdresomMessage(), "Vec postoji zgrada na toj adresi!");
		
	}
	
	@Test
	public void NegativanTestDodavanjaZgrade1(){
		zgradePageObj.dodavanjeZgrade("","","","");
		assertFalse(zgradePageObj.dodajte.isEnabled());
		
	}
	
	@Test(enabled=false)
	public void NegativanTestDodavanjaZgrade2(){
		zgradePageObj.dodavanjeZgrade("a","a","a","a");
		assertEquals(zgradePageObj.getErrMessBroj(), "Ovo polje ne sme biti prazno!");
		assertEquals(zgradePageObj.getErrMessBrojStanova(), "Ovo polje ne sme biti prazno!");
	}
	
	@Test
	public void NegativanTestDodavanjaZgrade3(){
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
