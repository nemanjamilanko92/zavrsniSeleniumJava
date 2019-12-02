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
		
		//OVAKAV BEFORE METHOD JE KORISCEN ZBOG PROBLEMA SA STALE ELEMENTIMA
		@BeforeMethod
		public void SetUp() throws IOException, InterruptedException {
			driver = initDriver();
			driver.get(props.getProperty("URL"));
			driver.manage().window().maximize();
			kvaroviPageObj = new KvaroviPageObj(driver);
			loginPageObj = new LoginPageObj(driver);
			loginPageObj.logIn("predSkup@gmail.com", "Bar5slova");
			driver.get("http://localhost:8080/zgrada/1/kvarovi");
		}
		
		@Test
		public void dodavanjeKvaraPos() {
		
			
			kvaroviPageObj.DodajKvar("a", "a", 0);
			assertEquals(kvaroviPageObj.alertObavestenjaMsg(), "Kvar uspesno dodat");
		}
		@Test
		public void dodavanjeKvaraPosBezOdgLica() {
		
			
			kvaroviPageObj.DodajKvarBezOdgovornogLica("a", "a", 0);
			assertEquals(kvaroviPageObj.alertObavestenjaMsg(), "Kvar uspesno dodat");
		}
		
		@Test
		public void dodavanjeKvarNegativniTest() {
			kvaroviPageObj.DodajKvar("", "", 0);
			assertEquals(kvaroviPageObj.getMestoErrMsg(), "Ovo polje ne sme biti prazno!");	
			assertEquals(kvaroviPageObj.getOpisErrMsg(), "Ovo polje ne sme biti prazno!");	
		}
		@Test
		public void dodavanjeKvarNegativniTest1() {
			kvaroviPageObj.DodajKvar("a", "", 0);
			assertFalse(kvaroviPageObj.submit.isEnabled());
			assertEquals(kvaroviPageObj.getOpisErrMsg(), "Ovo polje ne sme biti prazno!");	
		}
		@Test
		public void dodavanjeKvarNegativniTest2() {
			kvaroviPageObj.DodajKvar("", "a", 0);
			assertEquals(kvaroviPageObj.getMestoErrMsg(), "Ovo polje ne sme biti prazno!");	
			assertFalse(kvaroviPageObj.submit.isEnabled());
		}
		@Test
		public void obrisiKvar() {
			 
			kvaroviPageObj.brisi.get(0).click();
			assertEquals(kvaroviPageObj.alertObavestenjaMsg(), "Uspesno izbrisan kvar");	
		
		}
		@AfterMethod
		public void tearDown() throws InterruptedException {
			driver.quit();
			driver=null;
		}
		
}
