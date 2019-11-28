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
import pageObjects.PregledStanaraPageObj;
import pageObjects.StanariRegistracijaPageObj;
import pageObjects.ZgradePageObj;
import setup.BaseClass;

public class RegistracijaStanaraTest extends BaseClass{
	AdminPocetnaPageObj adminPocetnaPageObj;
	LoginPageObj loginPageObj;
	ZgradePageObj zgradePageObj;
	StanariRegistracijaPageObj stanariRegistracijaPageObj;
	PregledStanaraPageObj pregledStanaraPageObj;
	
	@BeforeClass
	public void SetUp() throws IOException, InterruptedException {
	
		driver = initDriver();
		driver.get(props.getProperty("URL"));
		driver.manage().window().maximize();
		zgradePageObj = new ZgradePageObj(driver);
		loginPageObj = new LoginPageObj(driver);
		adminPocetnaPageObj = new AdminPocetnaPageObj(driver);
		pregledStanaraPageObj = new PregledStanaraPageObj(driver);
		stanariRegistracijaPageObj = new StanariRegistracijaPageObj(driver);
		loginPageObj.logIn(props.getProperty("email"), props.getProperty("password"));
		adminPocetnaPageObj.Stanari().click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}
	
	@Test(enabled = false)
	public void registracijaStanaraPos() {
		stanariRegistracijaPageObj.regStanara("nesto12@nesto.com", "Nesto5", "Slavisa1", "slavkovic");
		assertEquals(stanariRegistracijaPageObj.getUspesnoRegStanarMsg(), "Uspesno ste registrovali stanara!");
		stanariRegistracijaPageObj.Pregled().click();
		pregledStanaraPageObj.Prikazi("50");
		assertEquals(pregledStanaraPageObj.ImePrezimeStanar().getText().trim(), "Slavisa1 slavkovic");
	}
	@Test
	public void registracijaStanaraPos2 () {
		stanariRegistracijaPageObj.regStanara("nesto12@nesto.com", "Nesto5", "Slavisa1", "slavkovic");
		assertEquals(stanariRegistracijaPageObj.getUspesnoRegStanarMsg(), "E-mail adresa: nesto12@nesto.com je zauzeta!");
		stanariRegistracijaPageObj.Pregled().click();
		pregledStanaraPageObj.Prikazi("50");
		assertEquals(pregledStanaraPageObj.ImePrezimeStanar().getText().trim(), "Slavisa1 slavkovic");
		
	}
	
	@Test
	public void PozitivanTestResetDugme(){
		stanariRegistracijaPageObj.unosenjeVrednostiStanara("nesto12@nesto.com", "Nesto5", "Slavisa1", "slavkovic");
		stanariRegistracijaPageObj.Resetujte().click();
		assertEquals(stanariRegistracijaPageObj.getEmailInputValue(), "");
		assertEquals(stanariRegistracijaPageObj.getLozinkaInputValue(), "");
		assertEquals(stanariRegistracijaPageObj.getImeInputValue(), "");
		assertEquals(stanariRegistracijaPageObj.getPrezimeInputValue(), "");
	}
	
	@Test
	public void registracijaStanaraNegativni1 () {
		stanariRegistracijaPageObj.regStanara("nesto12", "Nesto5", "Slavisa1", "slavkovic");
		assertEquals(stanariRegistracijaPageObj.emailErrorMsg().getText(), "Neispravna email adresa!");	
	}
	
	@Test
	public void registracijaStanaraNegativni2 () {
		stanariRegistracijaPageObj.regStanara("nesto12@nesto.com", "a", "Slavisa1", "slavkovic");
		assertEquals(stanariRegistracijaPageObj.lozinkaErrorMsg().getText(), "Neispravna lozinka!");	
	}
	
	@Test
	public void registracijaStanaraNegativni3 () {
		stanariRegistracijaPageObj.regStanara("", "", "", "");
		assertFalse(stanariRegistracijaPageObj.registrujte.isEnabled());
	}
	
	@AfterClass
	public void tearDown(){
		driver.close();
		driver = null;
	}
	
}