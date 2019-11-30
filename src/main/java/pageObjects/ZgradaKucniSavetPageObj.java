package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
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

	private WebElement prikazi;
	
	public void Prikazi(String value){
		
		Select Prikazi = new Select((WebElement) prikazi);
		Prikazi.selectByVisibleText(value);
		
	}
	
	@FindBy(xpath = "//a[contains(text(),'Gospodin Predsednik')]")

	private WebElement gospPredLink;
	
	public WebElement gospPredLink() {
		return wait.until(ExpectedConditions.visibilityOf(gospPredLink));
	}
	
	@FindBy(xpath = "//a[@class='nav-link active']")

	private WebElement stanovi;
	
	public WebElement Stanovi() {
		return wait.until(ExpectedConditions.visibilityOf(stanovi));
	}
	
	@FindBy(xpath = "//tr[1]//td[2]//a[1]")

	private WebElement vlasnikIstanari;
	
	public WebElement VlasnikIstanari() {
		return wait.until(ExpectedConditions.visibilityOf(vlasnikIstanari));
	}
	
	@FindBy(xpath = "//a[contains(text(),'Obavestenja')]")

	private WebElement obavestenja;
	
	public WebElement Obavestenja() {
		return wait.until(ExpectedConditions.visibilityOf(obavestenja));
	}
	
	@FindBy(id = "izmeniObavestenje")

	public List<WebElement> izmeniObavestenje;
	
	
	@FindBy(xpath = "//span[contains(text(),'brisi')]")

	public List<WebElement> brisi;
		
	
	@FindBy(xpath = "//span[contains(text(),'potvrdi')]")

	private WebElement potvrdi;
	
	public WebElement Potvrdi() {
		return wait.until(ExpectedConditions.visibilityOf(potvrdi));
	}
	
	@FindBy(xpath = "//div[@class='container']//div[1]//div[1]//table[1]//tbody[1]//tr[3]//td[1]//span[1]//a[3]")
	
	private WebElement odustani;
	
	public WebElement Odustani() {
		return wait.until(ExpectedConditions.visibilityOf(odustani));
	}
	
	@FindBy(id = "dodajObavestenje")
	private WebElement dodaj;
	
	public WebElement Dodaj() {
		return wait.until(ExpectedConditions.elementToBeClickable(dodaj));
	}
	
	@FindBy(xpath = "//*[@id=\"noviTekst\"]")
	
	private WebElement unosIzmeneTeksta;
	
	public WebElement unosIzmeneTeksta() {
		return wait.until(ExpectedConditions.visibilityOf(unosIzmeneTeksta));
	}
	
	 @FindBy(xpath = "//*[@id=\"toast-container\"]/div/div")
	 
	 private WebElement alertObavestenja;
	 
		public  WebElement alertObavestenja() {
			  return wait.until(ExpectedConditions.visibilityOf(alertObavestenja));
		}
		public  String alertObavestenjaMsg() {
			  
			return alertObavestenja().getText().trim();
		}
		
		@FindBy(id = "tekstObavestenja")
		
		private WebElement novoObavestenje;
		
		public WebElement novoObavestenje() {
			return wait.until(ExpectedConditions.visibilityOf(novoObavestenje));
		}
		
		public void unosNovoObavestenje(String value) {
			novoObavestenje().sendKeys(value);
		}
		
		@FindBy(id = "dodajObavestenje")
		
		public WebElement potvrdiBtn;
		
		public WebElement potvrdiBtn() {
			return wait.until(ExpectedConditions.elementToBeClickable(potvrdiBtn));
		}
		
		@FindBy(xpath = "//a[contains(text(),'Predlozi tacke dnevnog reda')]")
	
		private WebElement predoloziTackeDnevnogReda;
		
		public WebElement PredoloziTackeDnevnogReda() {
			return wait.until(ExpectedConditions.elementToBeClickable(predoloziTackeDnevnogReda));
		}
		
		@FindBy(xpath = "//a[contains(text(),'Sastanci skupstine')]")
		
		private WebElement sastanciSkupstine;
		
		public WebElement SastanciSkupstine() {
			return wait.until(ExpectedConditions.elementToBeClickable(sastanciSkupstine));
		}
		
		@FindBy(xpath = "//select[@class='custom-select ng-untouched ng-pristine ng-valid']")
	
		private WebElement dropDownSastanci;
		
		public void DropDownSastanci(String value){
			
			Select DropDownSastanci = new Select((WebElement) dropDownSastanci);
			DropDownSastanci.selectByVisibleText(value);
			
		}
		
		@FindBy(css  = "[class*='custom']")
		
		private WebElement dropDownSkupstina;
		
		public void DropDownSkupstina(int value){
			
			Select DropDownSkupstina = new Select((WebElement) dropDownSkupstina);
			DropDownSkupstina.selectByIndex(value);
			
		}
		
		@FindBy(xpath = "//button[contains(text(),'Dodaj predlog tacke u izabranu skupstinu')]")
		
		public List<WebElement> dodajPredlogTackeDugme;
		
		public void dodavanjePredlogaTackeUSkupstinu(int value, int index) {
			this.DropDownSkupstina(value);
			this.dodajPredlogTackeDugme.get(index).click();
		}
		

		@FindBy(xpath = "//span[contains(text(),'Pregledaj tacke')]")
		
		public List<WebElement> pregledajTackeDnevnogReda;
		
	

		@FindBy(xpath = "//span[contains(text(),'Pregledaj zapisnik')]")
	
		public List<WebElement> pregledajZapisnikDnevnogReda;
		
		
		
		@FindBy(xpath = "//a[contains(text(),'Kvarovi')]")
	
		private WebElement kvarovi;
		
		public WebElement Kvarovi() {
			return wait.until(ExpectedConditions.elementToBeClickable(kvarovi));
		}
		
		@FindBy(xpath = "//input[contains(text(),'Prikazi zavrsene kvarove')]")
		
		private WebElement checkboxKvarovi;
		
		public WebElement CheckboxKvarovi() {
			return wait.until(ExpectedConditions.elementToBeClickable(checkboxKvarovi));
		}
		
		@FindBy(xpath = "//span[contains(text(),'ukloni')]")
		
		public List<WebElement> ukloni;
		
		
		
		@FindBy(xpath = "//span[contains(text(),'Pregledaj anketu')]")
	
		public List<WebElement> pregledajAnketu;
		
		public void dodajObavestenje(String text) {
			this.Dodaj().click();
			this.novoObavestenje().clear();
			this.novoObavestenje().sendKeys(text);
			Boolean isEn = this.potvrdiBtn.isEnabled();
			if(isEn=true) {
				this.potvrdiBtn.click();
			}
		}
		
		@FindBy(xpath = "//*[@id=\"toast-container\"]/div")
	
		private WebElement alertMsg;
		
		public WebElement AlertMsg() {
			return wait.until(ExpectedConditions.visibilityOf(alertMsg));
		}
		
		public String getAlertMsgText() {
			return AlertMsg().getText().trim();
		}
		
		@FindBy(xpath = "//div[@class='container']//div[1]//div[1]//table[1]//tbody[1]//tr[2]//td[1]//span[1]")
	
		private WebElement novoDodatoOvacestenje;
		
		public WebElement NovoDodatoOvacestenje() {
			return wait.until(ExpectedConditions.visibilityOf(novoDodatoOvacestenje));
		}
		
		public String getNovoDodatoOvacestenje() {
			return NovoDodatoOvacestenje().getText().trim();
		}
		
		public void izmeniObavestenje(String text) {
			this.izmeniObavestenje.get(0).click();
			this.unosIzmeneTeksta().sendKeys(text);
			this.Potvrdi().click();
		}
		
		public void obrisiObavestenje() {
			this.brisi.get(0).click();
		}
		
		@FindBy(xpath = "//button[@class='btn']")
		
		private WebElement dodajTackuDnevnogRedaDugme;
		
		public WebElement DodajTackuDnevnogRedaDugme() {
			return wait.until(ExpectedConditions.visibilityOf(dodajTackuDnevnogRedaDugme));
		}
		
		@FindBy(xpath = "//textarea[@id='tekstPtdr']")
		
		private WebElement novaTackaDnevnogReda;
		
		public WebElement NovaTackaDnevnogReda() {
			return wait.until(ExpectedConditions.visibilityOf(novaTackaDnevnogReda));
		}
		
		@FindBy(xpath =  "//button[@class='btn btn-primary']")
		
		public WebElement potvrdiTackeBtn;
		
		public WebElement PotvrdiTackeBtn() {
			return wait.until(ExpectedConditions.elementToBeClickable(potvrdiTackeBtn));
		}
		
		public void dodajTackuDnevnogReda(String text) {
			this.DodajTackuDnevnogRedaDugme().click();
			this.NovaTackaDnevnogReda().clear();
			this.NovaTackaDnevnogReda().sendKeys(text);
			Boolean isEn = this.potvrdiTackeBtn.isEnabled();
			if(isEn=true) {
				this.potvrdiTackeBtn.click();
			}
		}
		
		@FindBy(xpath = "//span[contains(text(),'izmeni')]")

		public List<WebElement> izmeniTackeDnevnogReda;
		
		public void izmeniTackeDnevnogReda(String text) {
			this.izmeniTackeDnevnogReda.get(0).click();
			this.unosIzmeneTeksta().sendKeys(text);
			this.Potvrdi().click();
		}
}
