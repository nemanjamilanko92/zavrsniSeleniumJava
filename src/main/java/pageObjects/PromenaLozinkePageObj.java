package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PromenaLozinkePageObj {
	private WebDriver driver;
	private WebDriverWait wait;

	public PromenaLozinkePageObj(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(id = "novaLozinka")
    
    private WebElement novaLozinka;
	
	public WebElement NovaLozinka() {
		
		return wait.until(ExpectedConditions.visibilityOf(novaLozinka));
	}
    @FindBy(id = "potvrdaNoveLozinke")
    
    private WebElement potvrdaNoveLozinke;
    
    public WebElement PotvrdaNoveLozinke() {
		
		return wait.until(ExpectedConditions.visibilityOf(potvrdaNoveLozinke));
	}
    
    @FindBy(css = "button.btn.btn-primary")
    
    public WebElement promeniteLozinku;
    
    public WebElement PromeniteLozinku() {
		
		return wait.until(ExpectedConditions.elementToBeClickable(promeniteLozinku));
	}
    
    
    @FindBy(id = "staraLozinka")
    
    private WebElement staraLozinka;
    
    public WebElement StaraLozinka() {
		
		return wait.until(ExpectedConditions.visibilityOf(staraLozinka));
	}
    
    @FindBy(xpath = "//*[@id=\"toast-container\"]/div/div")
    
    private WebElement alertMsg;
    
    public WebElement AlertMsg() {
		
		return wait.until(ExpectedConditions.visibilityOf(alertMsg));
	}
    
    
    public String getAlertMsg() {
		
		return AlertMsg().getText().trim();
	}
    
    @FindBy(xpath  = "/html/body/app-root/app-promena-lozinke/div/form/fieldset/div[1]/div")
    
    private WebElement staraLozinkaErrMsg;
    
    public WebElement staraLozinkaErrMsg() {
    	
    	return  wait.until(ExpectedConditions.visibilityOf(staraLozinkaErrMsg));
   
	}
    
    public String getstaraLozinkaErrMsg() {
		
		return staraLozinkaErrMsg().getText().trim();
	}
    
    @FindBy(xpath  = "/html/body/app-root/app-promena-lozinke/div/form/fieldset/div[2]/div[1]/div")
    
    private WebElement novaLozinkaErrMsg;
    
    public WebElement novaLozinkaErrMsg() {
		
		return wait.until(ExpectedConditions.visibilityOf(novaLozinkaErrMsg));
	}
    
    public String getnovaLozinkaErrMsg() {
		
		return novaLozinkaErrMsg().getText().trim();
	}
    
    @FindBy(xpath  = "/html/body/app-root/app-promena-lozinke/div/form/fieldset/div[2]/div[2]/div")
    
    private WebElement potvrdaNoveLozinkaErrMsg;
    
    public WebElement potvrdaNoveLozinkaErrMsg() {
		
		return wait.until(ExpectedConditions.visibilityOf(potvrdaNoveLozinkaErrMsg));
	}
        
    public String getpotvrdaNoveLozinkaErrMsg() {
		
		return potvrdaNoveLozinkaErrMsg().getText();
	}
    
    public void unosLozinke(String staraLozinka,String novaLozinka,String potvrdaNoveLozinke) {
    	this.StaraLozinka().clear();
    	this.NovaLozinka().clear();
    	this.PotvrdaNoveLozinke().clear();
    	this.StaraLozinka().sendKeys(staraLozinka);
    	this.NovaLozinka().sendKeys(novaLozinka);
    	this.PotvrdaNoveLozinke().sendKeys(potvrdaNoveLozinke);
    	@SuppressWarnings("unused")
		boolean isEnabled = promeniteLozinku.isEnabled();
    	if(isEnabled=true) {
    	this.promeniteLozinku.click();
    	}
    }  
}
