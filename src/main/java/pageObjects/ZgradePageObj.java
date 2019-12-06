package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZgradePageObj {
	private WebDriver driver;
	
	public ZgradePageObj(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	
	}

    @FindBy(id = "broj")
    
    private WebElement broj;
    
  

    @FindBy(id = "brojStanova")
    
    private WebElement brojStanova;
    
   
    @FindBy(id = "mesto")
    
    private WebElement mesto;
    
   
    
    @FindBy(css = "button.btn.btn-outline-primary")
    
    private WebElement pregled;
    
    public WebElement Pregled() {
    	return pregled;
    }
    
    @FindBy(css = "button.btn.btn-danger")
    
    private WebElement resetujte;
    
  public WebElement Resetujte() {
	  return resetujte;
  }
    
    @FindBy(id = "ulica")
    
    private WebElement ulica;
    
 
    @FindBy( xpath = "//li[@class='nav-item active']//button[@class='btn btn-primary']")
    
    private WebElement dodavanje;
    
    public WebElement Dodavanje() {
    	return dodavanje;
    }
    
    @FindBy( xpath = "//button[contains(text(),'Dodajte')]")
    
    public WebElement dodajte;
    
  
    @FindBy( xpath = "//div[@class='row justify-content-md-center']//div[1]//div[1]//div[1]")
    
    private WebElement errMessMesto;
    
    @FindBy( xpath = "//div[2]//div[1]//div[1]")
    
    private WebElement errMessUlica;
 
    @FindBy( xpath = "//div[3]//div[1]//div[1]")
    
    private WebElement errMessBroj;
    
    @FindBy( xpath = "//div[4]//div[1]//div[1]") //vraca isti path i za nulu
    
    private WebElement errMessBrojStanova;
    
    @FindBy( xpath = "/html/body/app-root/app-zgrade/div/app-dodaj-zgradu/div/form/fieldset/div[3]/div/div")
    
    private WebElement errMessBrojNula;
    
    public WebElement ErrMessBrojNula(){
    	return errMessBrojNula;
    }
    
    public void dodavanjeZgrade(String mesto, String ulica, String broj, String brojStanova){
    	this.mesto.clear();
    	this.ulica.clear();
    	this.broj.clear();
    	this.brojStanova.clear();
    	this.mesto.sendKeys(mesto);
    	this.ulica.sendKeys(ulica);
    	this.broj.sendKeys(broj);
    	this.brojStanova.sendKeys(brojStanova);
    	this.brojStanova.sendKeys(Keys.TAB); //ovaj korak je potreban kako bi se izazvala poruka na input polju broj stanova
    	boolean isEnabled = dodajte.isEnabled();
    	if(isEnabled=true){
    		this.dodajte.click();
    	}else{
    		System.out.println("Na dugme ne moze da se klikne!");
    	}
    }
    
    public void unosenjeVrednostiZgrade(String mesto, String ulica, String broj, String brojStanova){
    	this.mesto.clear();
    	this.ulica.clear();
    	this.broj.clear();
    	this.brojStanova.clear();
    	this.mesto.sendKeys(mesto);
    	this.ulica.sendKeys(ulica);
    	this.broj.sendKeys(broj);
    	this.brojStanova.sendKeys(brojStanova);
    }
    
    public String getErrMessMesto() {
    	
		return this.errMessMesto.getText();
	}
    
    public String getErrMessUlica() {
    	
		return this.errMessUlica.getText();
	}
    
    public String getErrMessBroj() {
    	
		return this.errMessBroj.getText();
	}
    
    public String getErrMessBrojStanova() {
    	
    		return	this.errMessBrojStanova.getText();
	} 
    
    public String getErrMessBrojNula() {
		return this.ErrMessBrojNula().getText();
	}
    
    @FindBy(xpath = "//*[@id=\"toast-container\"]/div/div")
    
    private WebElement successMess;
    
   
    public String getUspesnoDodataZgradaMessage() {
    	WebDriverWait wait = new WebDriverWait(this.driver, 5);
    	wait.until(ExpectedConditions.visibilityOf(successMess));
		return successMess.getText();
	}
    
    public String getUlicaInputValue(){
    	String vrednost = this.ulica.getAttribute("value");
    	return vrednost;
    }
    
    public String getBrojStanovaInputValue(){
    	String vrednost = this.brojStanova.getAttribute("value");
    	return vrednost;
    }
    
    public String getBrojInputValue(){
    	String vrednost = this.broj.getAttribute("value");
    	return vrednost;
    }
    
    public String getMestoInputValue(){
    	String vrednost = this.mesto.getAttribute("value");
    	return vrednost;
    }
    
    @FindBy(xpath = "//*[@id='toast-container']/div/div")
    
    private WebElement sameAddressMess;
    
   
    
    public String getZgradaSaIstomAdresomMessage() {
    
		return this.sameAddressMess.getText();
	}
}
