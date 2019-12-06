package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PromenaLozinkePageObj {
	private WebDriver driver;

	public PromenaLozinkePageObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);

	}
	
	@FindBy(id = "novaLozinka")
    
    private WebElement novaLozinka;
	
    @FindBy(id = "potvrdaNoveLozinke")
    
    private WebElement potvrdaNoveLozinke;
    
    
    @FindBy(css = "button.btn.btn-primary")
    
    public WebElement promeniteLozinku;
      
    @FindBy(id = "staraLozinka")
    
    private WebElement staraLozinka;
        
    @FindBy(xpath = "//*[@id=\"toast-container\"]/div/div")
    
    private WebElement alertMsg;
    
    public String getAlertMsg() {
    	
		return alertMsg.getText().trim();
	}
    
    @FindBy(xpath  = "/html/body/app-root/app-promena-lozinke/div/form/fieldset/div[1]/div")
    
    private WebElement staraLozinkaErrMsg;
    
   
    
    public String getstaraLozinkaErrMsg() {
		return staraLozinkaErrMsg.getText().trim();
	}
    
    @FindBy(xpath  = "/html/body/app-root/app-promena-lozinke/div/form/fieldset/div[2]/div[1]/div")
    
    private WebElement novaLozinkaErrMsg;
    
   
    
    public String getnovaLozinkaErrMsg() {
		return novaLozinkaErrMsg.getText().trim();
	}
    
    @FindBy(xpath  = "/html/body/app-root/app-promena-lozinke/div/form/fieldset/div[2]/div[2]/div")
    
    private WebElement potvrdaNoveLozinkaErrMsg;
    
    public String getpotvrdaNoveLozinkaErrMsg() {
		return potvrdaNoveLozinkaErrMsg.getText();
	}
    
    public void unosLozinke(String staraLozinka,String novaLozinka,String potvrdaNoveLozinke) {
    	this.staraLozinka.clear();
    	this.novaLozinka.clear();
    	this.potvrdaNoveLozinke.clear();
    	this.staraLozinka.sendKeys(staraLozinka);
    	this.novaLozinka.sendKeys(novaLozinka);
    	this.potvrdaNoveLozinke.sendKeys(potvrdaNoveLozinke);
    	@SuppressWarnings("unused")
		boolean isEnabled = promeniteLozinku.isEnabled();
    	if(isEnabled=true) {
    	this.promeniteLozinku.click();
    	}
    }  
}
