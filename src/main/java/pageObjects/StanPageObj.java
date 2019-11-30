package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StanPageObj {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public StanPageObj(WebDriver driver) {
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
	
	@FindBy(xpath = "//button[contains(text(),'Postavi za predsednika')]") //alertovi vezani za dugmad!!!
	
	public List<WebElement> postaviZaPredsednikaDugme;
	
	
	
	@FindBy(xpath = "//button[contains(text(),'Postavi za vlasnika')]")
	
	public List<WebElement> postaviZaVlasnikaDugme;
	
	
	@FindBy(xpath =  "//button[contains(text(),'Ukloni')]")
	
	
	
	public List<WebElement> ukloniStanaraDugme;
	
	public WebElement UkloniStanaraDugme(){
		WebElement dugme = ukloniStanaraDugme.get(0);
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(postaviZaVlasnikaDugme));
			
		}catch (StaleElementReferenceException e) {
			 dugme =  driver.findElement(By.xpath("//button[contains(text(),'Ukloni')]"));
		}
		
		return	dugme;
	
		
	}
	
	@FindBy(xpath = "//button[contains(text(),'Dodaj u stanare')]")
	
	public List<WebElement> dodajUStanareDugme;
	
	
	
	@FindBy(xpath = "//input[@id='filter']")
	
	private WebElement unosImePrezime;
	
	public WebElement UnosImePrezime() {
		return wait.until(ExpectedConditions.visibilityOf(unosImePrezime));
	}
	
	@FindBy(xpath = "//button[contains(text(),'Filtriraj')]")
	
	private WebElement filtrirajDugme;
	
	public WebElement FiltrirajDugme() {
		return wait.until(ExpectedConditions.elementToBeClickable(filtrirajDugme));
	}
	
	@FindBy(xpath = "//*[@id=\"toast-container\"]/div/div")
    
    private WebElement alertMsg;
    
    public WebElement AlertMsg() {
		
		return wait.until(ExpectedConditions.visibilityOf(alertMsg));
	}
    
    public String getAlertMsg() {
    	
    	return AlertMsg().getText().trim();
    }
    
    @FindBy(xpath = "//div[contains(text(),'Uspesno ste postavili vlasnika!')]")
    
    private WebElement vlasnikPostavljenSuccesMsg;
    
    public WebElement VlasnikPostavljenSuccesMsg() {
		
		return wait.until(ExpectedConditions.visibilityOf(vlasnikPostavljenSuccesMsg));
	}
    
    public String getVlasnikPostavljenSuccesMsg() {
    	
    	return VlasnikPostavljenSuccesMsg().getText().trim();
    }
    
    @FindBy(xpath = "//div[contains(text(),'Uspesno ste uklonili vlasnika!')]")
    
    private WebElement vlasnikUklonjenSuccesMsg;
    
    public WebElement VlasnikUklonjenSuccesMsg() {
		
		return wait.until(ExpectedConditions.visibilityOf(vlasnikUklonjenSuccesMsg));
	}
    
    public String getVlasnikUklonjenSuccesMsg() {
    	
    	return VlasnikUklonjenSuccesMsg().getText().trim();
    }
    
    @FindBy(xpath = "//div[contains(text(),'Uspesno ste uklonili stanara!')]")
    
    private WebElement stanarUklonjenSuccesMsg;
    
    public WebElement StanarUklonjenSuccesMsg() {
		
		return wait.until(ExpectedConditions.visibilityOf(stanarUklonjenSuccesMsg));
	}
    
    public String getStanarUklonjenSuccesMsg() {
    	
    	return StanarUklonjenSuccesMsg().getText().trim();
    }
    
    @FindBy(xpath = "//div[contains(text(),'Uspesno ste dodali stanara!')]")
    
    private WebElement stanarDodatSuccesMsg;
    
    public WebElement StanarDodatSuccesMsg() {
		
		return wait.until(ExpectedConditions.visibilityOf(stanarDodatSuccesMsg));
	}
    
    public String getStanarDodatSuccesMsg() {
    	
    	return StanarDodatSuccesMsg().getText().trim();
    }
    
    @FindBy(xpath = "//div[contains(text(),'Uspesno ste postavili predsednika zgrade!')]")
    
    private WebElement predsednikDodatSuccesMsg;
    
    public WebElement PredsednikDodatSuccesMsg() {
		
		return wait.until(ExpectedConditions.visibilityOf(predsednikDodatSuccesMsg));
	}
    
    public String getPredsednikDodatSuccesMsg() {
    	
    	return PredsednikDodatSuccesMsg().getText().trim();
    }
}
