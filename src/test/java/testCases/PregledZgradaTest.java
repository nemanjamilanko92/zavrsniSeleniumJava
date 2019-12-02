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
		driver.get(props.getProperty("URL"));
		driver.manage().window().maximize();
		zgradePageObj = new ZgradePageObj(driver);
		loginPageObj = new LoginPageObj(driver);
		adminPocetnaPageObj = new AdminPocetnaPageObj(driver);
		pregled = new Pregled(driver);
		loginPageObj.logIn(props.getProperty("email"), props.getProperty("password"));
		adminPocetnaPageObj.Zgrade().click();
	
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}
	
	@Test
	public void PozitivanTestPretrageZgrade1(){
		pregled.UnosPretrage("Marsala Tita", "Vrbas");
		assertEquals(pregled.AdresaZgrade().getText(), "Marsala Tita 21, Vrbas");
	}
	
	@Test
	public void PozitivanTestPretrageZgrade2() {
		pregled.UnosPretrage("Marsala Tita", "");
		assertEquals(pregled.AdresaZgrade().getText(), "Marsala Tita 21, Vrbas");
	}
	
	@Test
	public void PozitivanTestPretrageZgrade3() {
		pregled.UnosPretrage("", "Vrbas");
		assertEquals(pregled.AdresaZgrade().getText(), "Marsala Tita 21, Vrbas");
	}
	
	@Test
	public void PozitivanTestPretrageZgrade4(){
		pregled.UnosPretrage("AAAAAA", "AAAAAA");
		assertEquals(pregled.ErrMessZaNepostojecuZgradu().getText(), "Nijedna zgrada sa trazenim kriterijumima nije prondajena!");
	}
	
	@Test
	public void PozitivanTestPretrageZgrade5(){
		zgradePageObj.Pregled().click();		
	
		assertTrue(pregled.proveraZgrade("Boska Buhe","42","Novi Sad"));
		
	}
	
	@AfterClass
	public void tearDown(){
		driver.close();
		driver = null;
	}
}
