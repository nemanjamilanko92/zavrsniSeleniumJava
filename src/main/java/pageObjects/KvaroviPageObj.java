package pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KvaroviPageObj {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public  KvaroviPageObj(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver,5);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='nav-link active']")
	private WebElement kvarovi;
	
	public WebElement Kvarovi() {
		return wait.until(ExpectedConditions.elementToBeClickable(kvarovi));
	}
	
	@FindBy(xpath = "//button[@class='btn']")
	private WebElement dodaj;
	
	public WebElement Dodaj() {
		return wait.until(ExpectedConditions.elementToBeClickable(dodaj));
	}
	
	@FindBy(css  = "input[class*='ng']")
	private WebElement prikaziZavrseneKvarove;
	
	public WebElement PrikaziZavrseneKvarove() {
		return wait.until(ExpectedConditions.elementToBeClickable(prikaziZavrseneKvarove));
	}
	
	@FindBy(id  = "mesto")
	private WebElement mesto;
	
	public WebElement Mesto() {
		return wait.until(ExpectedConditions.elementToBeClickable(mesto));
	}
	
	@FindBy(xpath   = "/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-kvar/div/form/fieldset/div[1]/div/div")
	private WebElement mestoErrMsg;
	
	public WebElement MestoErrMsg() {
		return wait.until(ExpectedConditions.visibilityOf(mestoErrMsg));
	}
	
	public String getMestoErrMsg() {
		
		return  MestoErrMsg().getText().trim();
	}
	
	@FindBy(id  = "opis")
	private WebElement opis;
	
	public WebElement Opis() {
		return wait.until(ExpectedConditions.elementToBeClickable(opis));
	}
	
	@FindBy(xpath = "/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-kvar/div/form/fieldset/div[2]/div/div")
	private WebElement opisErrMsg;
	
	public WebElement OpisErrMsg() {
		return wait.until(ExpectedConditions.visibilityOf(opisErrMsg));
	}
	
	public String getOpisErrMsg() {
		
		return  OpisErrMsg().getText().trim();
	}
	@FindBy(id  = "odgovorno_lice")
	private WebElement izaberiBtn;
	
	public WebElement IzaberiBtn() {
		return wait.until(ExpectedConditions.elementToBeClickable(izaberiBtn));
	}
	
	@FindBy(xpath   = "//input[@placeholder='Pretraga']")
	private WebElement pretraga;
	
	public WebElement Pretraga() {
		return wait.until(ExpectedConditions.visibilityOf(pretraga));
	}
	
	@FindBy(xpath   = "//table//button")
	private List<WebElement> prihvatiBtn;
	
	@FindBy(xpath   = "//button[@class='btn btn-danger']")
	private WebElement odustani;
	
	public WebElement Odustani() {
		return wait.until(ExpectedConditions.elementToBeClickable(odustani));
	}
	
	@FindBy(css   = "span[class*='low']")
	private WebElement izabraniStanar;
	
	public WebElement IzabraniStanar() {
		return wait.until(ExpectedConditions.visibilityOf(izabraniStanar));
	}
	public String getizabraniStanarImePrezime() {
		return IzabraniStanar().getText().trim();
	}
	
	@FindBy(id   = "submit")
	public WebElement submit;
	
	public WebElement Submit() {
		return wait.until(ExpectedConditions.elementToBeClickable(submit));
	}
	public void DodajKvar(String mesto,String opis,int index) {
		this.Dodaj().click();
		this.Mesto().clear();
		this.Opis().clear();
		this.Mesto().sendKeys(mesto);
		this.Opis().sendKeys(opis);
		this.Opis().sendKeys(Keys.TAB);
		this.IzaberiBtn().click();
		this.prihvatiBtn.get(index).click();
		boolean isEnb = submit.isEnabled();
		if(isEnb=true) {
		this.submit.click();
		}
	}
	
	public void DodajKvarBezOdgovornogLica(String mesto,String opis,int index) {
		this.Dodaj().click();
		this.Mesto().clear();
		this.Opis().clear();
		this.Mesto().sendKeys(mesto);
		this.Opis().sendKeys(opis);
		this.Opis().sendKeys(Keys.TAB);
	
		boolean isEnb = submit.isEnabled();
		if(isEnb=true) {
		this.submit.click();
		}
	}
	
	@FindBy(xpath = "//div[@class='toast-message ng-star-inserted']")
	 
	 private WebElement alertObavestenja;
	 
		public  WebElement alertObavestenja() {
			  return wait.until(ExpectedConditions.visibilityOf(alertObavestenja));
		}
		public  String alertObavestenjaMsg() {
			  
			return alertObavestenja().getText().trim();
		}
		
		@FindBy(xpath = "//span[contains(text(),'brisi')]")

		public List<WebElement> brisi;
		
}
