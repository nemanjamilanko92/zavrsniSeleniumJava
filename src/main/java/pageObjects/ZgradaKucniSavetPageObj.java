package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZgradaKucniSavetPageObj {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public  ZgradaKucniSavetPageObj(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver,5);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//select[@id='prikaz']")
	@CacheLookup
	private WebElement prikazi;
	
	public void Prikazi(String value){
		
		Select Prikazi = new Select((WebElement) prikazi);
		Prikazi.selectByVisibleText(value);
		
	}
	
	@FindBy(xpath = "//a[contains(text(),'Gospodin Predsednik')]")
	@CacheLookup
	private WebElement gospPredLink;
	
	public WebElement gospPredLink() {
		return wait.until(ExpectedConditions.visibilityOf(gospPredLink));
	}
	
	@FindBy(xpath = "//a[@class='nav-link active']")
	@CacheLookup
	private WebElement stanovi;
	
	public WebElement Stanovi() {
		return wait.until(ExpectedConditions.visibilityOf(stanovi));
	}
	
	@FindBy(xpath = "//tr[1]//td[2]//a[1]")
	@CacheLookup
	private WebElement vlasnikIstanari;
	
	public WebElement VlasnikIstanari() {
		return wait.until(ExpectedConditions.visibilityOf(vlasnikIstanari));
	}
	
	@FindBy(xpath = "//a[contains(text(),'Obavestenja')]")
	@CacheLookup
	private WebElement obavestenja;
	
	public WebElement Obavestenja() {
		return wait.until(ExpectedConditions.visibilityOf(obavestenja));
	}
	
	@FindBy(id = "izmeniObavestenje")
	@CacheLookup
	private List<WebElement> izmeniObavestenje;
	
	public WebElement IzmeniObavestenje() {
		return wait.until(ExpectedConditions.visibilityOf((WebElement) izmeniObavestenje));
	}
	
	@FindBy(xpath = "//div[@class='container']//div[1]//div[1]//table[1]//tbody[1]//tr[3]//td[1]//span[1]//a[4]")
	@CacheLookup
	private WebElement brisi;
	
	public WebElement Brisi() {
		return wait.until(ExpectedConditions.visibilityOf(brisi));
	}
	
	@FindBy(xpath = "//div[@class='container']//div[1]//div[1]//table[1]//tbody[1]//tr[3]//td[1]//span[1]//a[2]//span[1]")
	@CacheLookup
	private WebElement potvrdi;
	
	public WebElement Potvrdi() {
		return wait.until(ExpectedConditions.visibilityOf(potvrdi));
	}
	
	@FindBy(xpath = "//div[@class='container']//div[1]//div[1]//table[1]//tbody[1]//tr[3]//td[1]//span[1]//a[3]")
	@CacheLookup
	private WebElement odustani;
	
	public WebElement Odustani() {
		return wait.until(ExpectedConditions.visibilityOf(odustani));
	}
	
	@FindBy(id = "dodajObavestenje")
	@CacheLookup
	private WebElement dodaj;
	
	public WebElement Dodaj() {
		return wait.until(ExpectedConditions.elementToBeClickable(dodaj));
	}
	
	@FindBy(xpath = "//*[@id=\"noviTekst\"]")
	@CacheLookup
	private WebElement unosIzmeneTeksta;
	
	public WebElement unosIzmeneTeksta() {
		return wait.until(ExpectedConditions.visibilityOf(unosIzmeneTeksta));
	}
	
	 @FindBy(xpath = "//*[@id=\"toast-container\"]/div/div")
	 @CacheLookup
	 private WebElement alertObavestenja;
	 
		public  WebElement alertObavestenja() {
			  return wait.until(ExpectedConditions.visibilityOf(alertObavestenja));
		}
		public  String alertObavestenjaMsg() {
			  
			return alertObavestenja().getText().trim();
		}
		
		@FindBy(id = "tekstObavestenja")
		@CacheLookup
		private WebElement novoObavestenje;
		
		public WebElement novoObavestenje() {
			return wait.until(ExpectedConditions.visibilityOf(novoObavestenje));
		}
		
		public void unostnovoObavestenje(String value) {
			novoObavestenje().sendKeys(value);
		}
		
		@FindBy(id = "dodajObavestenje")
		@CacheLookup
		private WebElement potvrdiBtn;
		
		public WebElement potvrdiBtn() {
			return wait.until(ExpectedConditions.elementToBeClickable(potvrdiBtn));
		}
}
