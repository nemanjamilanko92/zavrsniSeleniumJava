package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AdminPocetnaPageObj;
import pageObjects.LoginPageObj;
import pageObjects.Pregled;
import pageObjects.PregledStanaraPageObj;
import pageObjects.StanPageObj;
import pageObjects.StanariRegistracijaPageObj;
import pageObjects.ZgradaKucniSavetPageObj;
import pageObjects.ZgradePageObj;
import setup.BaseClass;

public class StanTest extends BaseClass {
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
		//logujemo se kao admin
		loginPageObj.logIn(props.getProperty("email"), props.getProperty("password"));
		//navigujemo na stranicu stana
		driver.get("http://localhost:8080/stan/1");
		
	}
	//DA BI OVAJ TEST FUNKCIONISAO POTREBNO JE DA SU SVI VLASNICI I STANRI UKLONJENI IZ LISTE STANARA I VLASNIKA
	@Test(priority = 1)
	public void postavljanjeVlasnikaTest() {
		
		//klikcemo na dugme za postavljanje vlasnika stana
	    //ocekujemo poruku o uspesnom dodavanju vlasnika
		
		stanPageObj.postaviZaVlasnikaDugme.get(0).click();
		assertEquals(stanPageObj.getVlasnikPostavljenSuccesMsg(), "Uspesno ste postavili vlasnika!");
	}
	
	@Test(priority = 2)
	public void uklanjanjeVlasnikaTest() {
		
		//klikcemo na dugme za brisanje vlasnika stana
	    //ocekujemo poruku o uspesnom brisanju vlasnika
		
		stanPageObj.ukloniStanaraDugme.get(0).click();
		
		assertEquals(stanPageObj.getVlasnikUklonjenSuccesMsg(), "Uspesno ste uklonili vlasnika!");
	}
	
	@Test(priority = 3)
	public void dodavanjeStanaraTest() {
		
		//klikcemo na dugme za dodavanje stanara
	    //ocekujemo poruku o uspesnom dodavanja stanara
		
		stanPageObj.dodajUStanareDugme.get(0).click();
		assertEquals(stanPageObj.getStanarDodatSuccesMsg(), "Uspesno ste dodali stanara!");
	}
	
	@Test(priority = 5)
	public void uklanjanjeStanaraTest()  {
		
		//klikcemo na dugme za uklanjanje stanara
	    //ocekujemo poruku o uspesnom uklanjanju stanara
		
		stanPageObj.ukloniStanaraDugme.get(0).click();
	
		assertEquals(stanPageObj.getStanarUklonjenSuccesMsg(), "Uspesno ste uklonili stanara!");
	}
	
	@Test(priority = 4)
	public void postaviZaPredsednika()  {
		
		//klikcemo na dugme za dodavanje predsednika zgrade
	    //ocekujemo poruku o uspesnom dodavanja predsednika
	
		stanPageObj.postaviZaPredsednikaDugme.get(0).click();
		assertEquals(stanPageObj.getPredsednikDodatSuccesMsg(), "Uspesno ste postavili predsednika zgrade!");
	}
	
	
	@AfterClass
	public void tearDown()  {
		
		driver.quit();
		driver=null;
	}
}
