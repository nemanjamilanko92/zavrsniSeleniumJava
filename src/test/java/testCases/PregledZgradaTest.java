package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AdminPocetnaPageObj;
import pageObjects.LoginPageObj;
import pageObjects.Pregled;
import pageObjects.ZgradePageObj;
import setup.BaseClass;

public class PregledZgradaTest extends BaseClass{
	AdminPocetnaPageObj adminPocetnaPageObj;
	LoginPageObj loginPageObj;
	ZgradePageObj zgradePageObj;
	Pregled pregled;
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
		pregled = new Pregled(driver);
		 //logujemo se kao admin
		loginPageObj.logIn(props.getProperty("email"), props.getProperty("password"));
		 //navigujemo na stranicu pregleda zgrada
		adminPocetnaPageObj.Zgrade().click();
		zgradePageObj.Pregled().click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}
	//ISKORISTI METDO ZA PRELGED ZGRADE
	@Test
	public void PozitivanTestPretrageZgrade1(){
		
		//u polja za pretragu zgrada unosimo adresu i mesto zgrade
	    //ocekujemo da ce se zgrada pojaviti u filtriranoj listi
		
		pregled.UnosPretrage("Marsala Tita", "Vrbas");
		assertTrue(pregled.proveraZgrade("Marsala Tita","21","Vrbas"));
	}
	
	@Test
	public void PozitivanTestPretrageZgrade2() {
		
		 //u polje za pretragu zgrada unosimo samo adresu zgrade
	    //ocekujemo da ce se zgrada pojaviti u filtriranoj listi

		pregled.UnosPretrage("Marsala Tita", "");
		assertTrue(pregled.proveraZgrade("Marsala Tita","21","Vrbas"));
	}
	
	@Test
	public void PozitivanTestPretrageZgrade3() {
		
		//u polje za pretragu zgrada unosimo samo mesto zgrade
	    //ocekujemo da ce se zgrada pojaviti u filtriranoj listi
		
		pregled.UnosPretrage("", "Vrbas");
		assertTrue(pregled.proveraZgrade("Marsala Tita","21","Vrbas"));

	}
	
	@Test
	public void PozitivanTestPretrageZgrade4(){
		
		//u polje za pretragu zgrade unosimo nepostojecu zgradu (nasumicni text)
	    //ocekujemo poruku da ni jedna zgrada nije pronadjena
		
		pregled.UnosPretrage("AAAAAA", "AAAAAA");
		assertEquals(pregled.ErrMessZaNepostojecuZgradu().getText(), "Nijedna zgrada sa trazenim kriterijumima nije prondajena!");
	}
	

	
	@AfterClass
	public void tearDown(){
		driver.close();
		driver = null;
	}
}
