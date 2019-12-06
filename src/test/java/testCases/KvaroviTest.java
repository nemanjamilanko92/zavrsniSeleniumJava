package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.AdminPocetnaPageObj;
import pageObjects.KvaroviPageObj;
import pageObjects.LoginPageObj;
import pageObjects.Pregled;
import pageObjects.StanPageObj;
import pageObjects.ZgradaKucniSavetPageObj;
import pageObjects.ZgradePageObj;
import setup.BaseClass;

public class KvaroviTest extends BaseClass{
		LoginPageObj loginPageObj;
		KvaroviPageObj kvaroviPageObj;
		ZgradaKucniSavetPageObj ZgradaKucniSavetPageObj;
		//OVAKAV BEFORE METHOD JE KORISCEN ZBOG PROBLEMA SA STALE ELEMENTIMA
		@BeforeClass
		public void SetUp() throws IOException, InterruptedException {
			driver = initDriver();
			driver.get(props.getProperty("URL"));
			driver.manage().window().maximize();
			 //instanciranje objekata
			kvaroviPageObj = new KvaroviPageObj(driver);
			loginPageObj = new LoginPageObj(driver);
			ZgradaKucniSavetPageObj = new ZgradaKucniSavetPageObj(driver);
			//logujemo se kao predsednik skupstine
			loginPageObj.logIn("predSkup@gmail.com", "Bar5slova");
			//navigujemo na stranicu kvarovi
			driver.get("http://localhost:8080/zgrada/1/kvarovi");
			//ZgradaKucniSavetPageObj.Kvarovi().click();
		}
		
		@Test
		public void dodavanjeKvaraPos() {
		
			//unosimo kvar sa ocekivanim podacima i unosimo odgovorno lice
		    //ocekujemo poruku o uspesnom dodavanju
			ZgradaKucniSavetPageObj.Kvarovi().click();
			kvaroviPageObj.DodajKvar("a", "a", 0);
			assertEquals(kvaroviPageObj.alertObavestenjaMsg(), "Kvar uspesno dodat");
		}
		@Test
		public void dodavanjeKvaraPosBezOdgLica() {
		
			//unosimo kvar sa ocekivanim podacima, ali izostavljamo odgovorno lice
		    //ocekujemo poruku o uspesnom dodavanju
			ZgradaKucniSavetPageObj.Kvarovi().click();
			kvaroviPageObj.DodajKvarBezOdgovornogLica("a", "a", 0);
			assertEquals(kvaroviPageObj.alertObavestenjaMsg(), "Kvar uspesno dodat");
		}
		
		@Test
		public void dodavanjeKvarNegativniTest() {
			
			//podatke za kreiranje kvara ostavljamo praznim
		    //ocekujemo poruku greske za unos kao i da je dugme za potvrdu kreiranja kvara onemoguceno
			ZgradaKucniSavetPageObj.Kvarovi().click();
			kvaroviPageObj.DodajKvar("", "", 0);
			assertEquals(kvaroviPageObj.getMestoErrMsg(), "Ovo polje ne sme biti prazno!");	
			assertEquals(kvaroviPageObj.getOpisErrMsg(), "Ovo polje ne sme biti prazno!");	
		}
		@Test
		public void dodavanjeKvarNegativniTest1() {
			
			//unosimo podatke za kreiranje kvara gde opis kvara otavljamo prazan
		    //ocekujemo poruku greske za unos kao i da je dugme za potvrdu kreiranja kvara onemoguceno
			ZgradaKucniSavetPageObj.Kvarovi().click();
			kvaroviPageObj.DodajKvar("a", "", 0);
			assertFalse(kvaroviPageObj.submit.isEnabled());
			assertEquals(kvaroviPageObj.getOpisErrMsg(), "Ovo polje ne sme biti prazno!");	
		}
		@Test
		public void dodavanjeKvarNegativniTest2() {
			
			//unosimo podatke za kreiranje kvara gde mesto kvara otavljamo prazan
		    //ocekujemo poruku greske za unos kao i da je dugme za potvrdu kreiranja kvara onemoguceno
			ZgradaKucniSavetPageObj.Kvarovi().click();
			kvaroviPageObj.DodajKvar("", "a", 0);
			assertEquals(kvaroviPageObj.getMestoErrMsg(), "Ovo polje ne sme biti prazno!");	
			assertFalse(kvaroviPageObj.submit.isEnabled());
		}
		@Test
		public void obrisiKvar() {
			
			//klickemo na dugme za brisanje kvara
		    //ocekujemo poruku o uspesnom brisanju kvara
			ZgradaKucniSavetPageObj.Kvarovi().click();
			 driver.navigate().refresh();
			kvaroviPageObj.brisi.get(0).click();
			assertEquals(kvaroviPageObj.alertObavestenjaMsg(), "Uspesno izbrisan kvar");	
		
		}
		@AfterClass
		public void tearDown() throws InterruptedException {
			driver.quit();
			driver=null;
		}
		
}
