package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StanPageObj {
	private WebDriver driver;
	
	public StanPageObj(WebDriver driver) {
		this.driver=driver;	
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
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
	

	
	@FindBy(xpath = "//button[contains(text(),'Dodaj u stanare')]")
	
	public List<WebElement> dodajUStanareDugme;
	
	
	@FindBy(xpath = "//input[@id='filter']")
	
	private WebElement unosImePrezime;
	
	public WebElement UnosImePrezime() {
		return unosImePrezime;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Filtriraj')]")
	
	private WebElement filtrirajDugme;
	
	public WebElement FiltrirajDugme() {
		return filtrirajDugme;
	}
	
	@FindBy(xpath = "//*[@id=\"toast-container\"]/div/div")
    
    private WebElement alertMsg;
    
    public WebElement AlertMsg() {
		
		return alertMsg;
	}
    
    public String getAlertMsg() {
    	
    	return AlertMsg().getText().trim();
    }
    
    @FindBy(xpath = "//div[contains(text(),'Uspesno ste postavili vlasnika!')]")
    
    private WebElement vlasnikPostavljenSuccesMsg;
    
   
    
    public String getVlasnikPostavljenSuccesMsg() {
    
    	return vlasnikPostavljenSuccesMsg.getText().trim();
    }
    
    @FindBy(xpath = "//div[contains(text(),'Uspesno ste uklonili vlasnika!')]")
    
    private WebElement vlasnikUklonjenSuccesMsg;
    
  
    
    public String getVlasnikUklonjenSuccesMsg() {
    	
    	 WebDriverWait wait = new WebDriverWait(driver, 5);
    	    wait.until(ExpectedConditions.visibilityOf(vlasnikUklonjenSuccesMsg));
    	return vlasnikUklonjenSuccesMsg.getText().trim();
    }
    
    @FindBy(xpath = "//div[contains(text(),'Uspesno ste uklonili stanara!')]")
    
    private WebElement stanarUklonjenSuccesMsg;
    
  
    
    public String getStanarUklonjenSuccesMsg() {
    	 
    	return stanarUklonjenSuccesMsg.getText().trim();
    }
    
    @FindBy(xpath = "//div[contains(text(),'Uspesno ste dodali stanara!')]")
    
    private WebElement stanarDodatSuccesMsg;
    
   
    
    public String getStanarDodatSuccesMsg() {
    	
    	return stanarDodatSuccesMsg.getText().trim();
    }
    
    @FindBy(xpath = "//div[contains(text(),'Uspesno ste postavili predsednika zgrade!')]")
    
    private WebElement predsednikDodatSuccesMsg;
    
  
    
    public String getPredsednikDodatSuccesMsg() {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    wait.until(ExpectedConditions.visibilityOf(predsednikDodatSuccesMsg));
    	return predsednikDodatSuccesMsg.getText();
    }
}
