package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AdminPocetnaPageObj;
import pageObjects.LoginPageObj;
import pageObjects.NavBarPredsednikPageObj;
import pageObjects.PregledStanaraPageObj;
import pageObjects.PromenaLozinkePageObj;
import pageObjects.StanariRegistracijaPageObj;
import pageObjects.ZgradePageObj;
import setup.BaseClass;

public class PromenaLozinkeTest extends BaseClass {
	AdminPocetnaPageObj adminPocetnaPageObj;
	LoginPageObj loginPageObj;
	ZgradePageObj zgradePageObj;
	StanariRegistracijaPageObj stanariRegistracijaPageObj;
	PregledStanaraPageObj pregledStanaraPageObj;
	NavBarPredsednikPageObj navBarPredsednikPageObj;
	PromenaLozinkePageObj promenaLozinkePageObj;
	@BeforeClass
	public void SetUp() throws IOException {
	
		driver = initDriver();
		driver.get(props.getProperty("URL"));
		driver.manage().window().maximize();
		zgradePageObj = new ZgradePageObj(driver);
		loginPageObj = new LoginPageObj(driver);
		adminPocetnaPageObj = new AdminPocetnaPageObj(driver);
		pregledStanaraPageObj = new PregledStanaraPageObj(driver);
		stanariRegistracijaPageObj = new StanariRegistracijaPageObj(driver);
		navBarPredsednikPageObj = new NavBarPredsednikPageObj(driver);
		promenaLozinkePageObj = new PromenaLozinkePageObj(driver);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		//loginPageObj.logIn("predSkup@gmail.com","Bar6slova");
		//navBarPredsednikPageObj.PromenaLozine().click();
		
	}
	
	@Test(priority = 1)
	public void promenaLozinkePos()  {
		loginPageObj.logIn("predSkup@gmail.com","Bar5slova");
		navBarPredsednikPageObj.PromenaLozine().click();
		promenaLozinkePageObj.unosLozinke("Bar5slova", "Bar6slova", "Bar6slova");
		assertEquals(promenaLozinkePageObj.getAlertMsg(), "Lozinka uspesno izmenjena!");
		assertEquals(driver.getCurrentUrl(), "http://localhost:8080/logovanje");
	}
	@Test(priority = 2)
	public void potvrdaDaJeLozinkaPromenjena() throws InterruptedException {
		loginPageObj.logIn("predSkup@gmail.com","Bar6slova");
		assertEquals(navBarPredsednikPageObj.getEmailText(), "predSkup@gmail.com");
		

	}
	
	@Test(priority = 3)
	public void negativniTestovi1() {
		
		promenaLozinkePageObj.unosLozinke("","","");
		
		assertEquals(promenaLozinkePageObj.getstaraLozinkaErrMsg(), "Ovo polje je obavezno!");
		
		assertEquals(promenaLozinkePageObj.getnovaLozinkaErrMsg(), "Ovo polje je obavezno!");

	}
	
	@Test(priority = 4)
	public void negativniTestovi2() {
		promenaLozinkePageObj.unosLozinke("a","grb","");
		
		assertEquals(promenaLozinkePageObj.getnovaLozinkaErrMsg(), "Neispravna lozinka! Pogledajte napomenu.");
		
		assertEquals(promenaLozinkePageObj.getpotvrdaNoveLozinkaErrMsg(), "Lozinke se ne poklapaju!");

	}
	
	@Test(priority = 5)
	public void negativniTestovi3() {
		promenaLozinkePageObj.unosLozinke("Bar6slova","Bar5slova","Bar6slova");
		
		assertEquals(promenaLozinkePageObj.getpotvrdaNoveLozinkaErrMsg(), "Lozinke se ne poklapaju!");

	}
	
	@Test(priority = 6)
	public void negativniTestovi4() {
		promenaLozinkePageObj.unosLozinke("a","bar5slova","bar5slova");
		
		assertEquals(promenaLozinkePageObj.getnovaLozinkaErrMsg(), "Neispravna lozinka! Pogledajte napomenu.");
	}
	
	@Test(priority = 7)
	public void negativniTestovi5() {
		promenaLozinkePageObj.unosLozinke("a","Bar5slova","Bar5slova");
		promenaLozinkePageObj.promeniteLozinku.click();
		assertEquals(promenaLozinkePageObj.getAlertMsg(), "Lozinka nije validnog formata (Mora biti bar jedno veliko slovo, veliko malo slovo i broj i minimalne duzine 6)!");
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		
		driver.quit();
		driver=null;
	}
	
}
