package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AdminPocetnaPageObj;
import pageObjects.LoginPageObj;
import pageObjects.Pregled;
import pageObjects.PregledStanaraPageObj;
import pageObjects.StanariRegistracijaPageObj;
import pageObjects.ZgradePageObj;
import setup.BaseClass;

public class PregledStanaraTest extends BaseClass{
	AdminPocetnaPageObj adminPocetnaPageObj;
	LoginPageObj loginPageObj;
	StanariRegistracijaPageObj stanariRegistracijaPageObj;
	PregledStanaraPageObj pregledStanaraPageObj;
	@BeforeClass
	public void SetUp() throws IOException, InterruptedException {
	
		driver = initDriver();
		driver.get(props.getProperty("URL"));
		driver.manage().window().maximize();
		stanariRegistracijaPageObj = new StanariRegistracijaPageObj(driver);
		loginPageObj = new LoginPageObj(driver);
		adminPocetnaPageObj = new AdminPocetnaPageObj(driver);
		pregledStanaraPageObj = new PregledStanaraPageObj(driver);
		loginPageObj.logIn(props.getProperty("email"), props.getProperty("password"));
		adminPocetnaPageObj.Stanari().click();
		stanariRegistracijaPageObj.Pregled().click();
	}
	
	@Test
	public void PozitivanTestPretrageZgrade1() {
		pregledStanaraPageObj.UnosPretrage("Gospodin Predsednik");
		assertEquals(pregledStanaraPageObj.ImeIPrezime().getText().trim(), "Gospodin Predsednik");
	}
	

	@Test
	public void PozitivanTestPretrageZgrade2() {
		pregledStanaraPageObj.UnosPretrage("predSkup@gmail.com");
		assertEquals(pregledStanaraPageObj.ImeIPrezime().getText().trim(), "Gospodin Predsednik");
	}
	
	@Test
	public void PozitivanTestPretrageZgrade3() {
		pregledStanaraPageObj.UnosPretrage("AAAAAAAAA");
		assertEquals(pregledStanaraPageObj.ErrMessZaNepostojecegStanara().getText().trim(), "Nijedan stanar sa trazenim kriterijumom nije prondajen!");
	}
	
	@AfterClass
	public void tearDown(){
		driver.close();
		driver = null;
	}
	
}
