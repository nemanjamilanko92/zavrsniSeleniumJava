package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZgradePageObj {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public ZgradePageObj(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver,5);
		PageFactory.initElements(driver, this);
	
	}
	

    @FindBy(id = "broj")
    
    private WebElement broj;
    
    public WebElement Broj() {
    	return wait.until(ExpectedConditions.visibilityOf(broj));
    }

    @FindBy(id = "brojStanova")
    
    private WebElement brojStanova;
    
    public WebElement BrojStanova() {
    	return wait.until(ExpectedConditions.visibilityOf(brojStanova));
    }
    @FindBy(id = "mesto")
    
    private WebElement mesto;
    
    public WebElement Mesto() {
    	return wait.until(ExpectedConditions.visibilityOf(mesto));
    }
    
    @FindBy(css = "button.btn.btn-outline-primary")
    
    private WebElement pregled;
    
    public WebElement Pregled() {
    	return wait.until(ExpectedConditions.elementToBeClickable(pregled));
    }
    
    @FindBy(css = "button.btn.btn-danger")
    
    private WebElement resetujte;
    
    public WebElement Resetujte() {
    	return wait.until(ExpectedConditions.elementToBeClickable(resetujte));
    }
    
    @FindBy(id = "ulica")
    
    private WebElement ulica;
    
    public WebElement Ulica() {
    	return wait.until(ExpectedConditions.visibilityOf(ulica));
    }
    
    @FindBy( xpath = "//li[@class='nav-item active']//button[@class='btn btn-primary']")
    
    private WebElement dodavanje;
    
    public WebElement Dodavanje() {
    	return wait.until(ExpectedConditions.elementToBeClickable(dodavanje));
    }
    
    @FindBy( xpath = "//button[contains(text(),'Dodajte')]")
    
    public WebElement dodajte;
    
    public WebElement Dodajte() {
    	return wait.until(ExpectedConditions.elementToBeClickable(dodajte));
    }
    
    @FindBy( xpath = "//div[@class='row justify-content-md-center']//div[1]//div[1]//div[1]")
    
    private WebElement errMessMesto;
    
    public WebElement ErrMessMesto(){
    	return wait.until(ExpectedConditions.visibilityOf(errMessMesto));
    }
    
    @FindBy( xpath = "//div[2]//div[1]//div[1]")
    
    private WebElement errMessUlica;
    
    public WebElement ErrMessUlica(){
    	return wait.until(ExpectedConditions.visibilityOf(errMessUlica));
    }
    
    @FindBy( xpath = "//div[3]//div[1]//div[1]")
    
    private WebElement errMessBroj;
    
    public WebElement ErrMessBroj(){
    	return wait.until(ExpectedConditions.visibilityOf(errMessBroj));
    }
    
    @FindBy( xpath = "//div[4]//div[1]//div[1]") //vraca isti path i za nulu
    
     private WebElement errMessBrojStanova;
    
    public WebElement ErrMessBrojStanova(){
    
    	return wait.until(ExpectedConditions.visibilityOf(errMessBrojStanova));
    }
    
    @FindBy( xpath = "/html/body/app-root/app-zgrade/div/app-dodaj-zgradu/div/form/fieldset/div[3]/div/div")
    
    private WebElement errMessBrojNula;
    
    public WebElement ErrMessBrojNula(){
    	return wait.until(ExpectedConditions.visibilityOf(errMessBrojNula));
    }
    
    
    public void dodavanjeZgrade(String mesto, String ulica, String broj, String brojStanova){
    	this.Mesto().clear();
    	this.Ulica().clear();
    	this.Broj().clear();
    	this.BrojStanova().clear();
    	this.Mesto().sendKeys(mesto);
    	this.Ulica().sendKeys(ulica);
    	this.Broj().sendKeys(broj);
    	this.BrojStanova().sendKeys(brojStanova);
    	this.BrojStanova().sendKeys(Keys.TAB); //ovaj korak je potreban kako bi se izazvala poruka na input polju broj stanova
    	boolean isEnabled = dodajte.isEnabled();
    	if(isEnabled=true){
    		this.dodajte.click();
    	}else{
    		System.out.println("Na dugme ne moze da se klikne!");
    	}
    		
    	
    }
    
    public void unosenjeVrednostiZgrade(String mesto, String ulica, String broj, String brojStanova){
    	this.Mesto().clear();
    	this.Ulica().clear();
    	this.Broj().clear();
    	this.BrojStanova().clear();
    	this.Mesto().sendKeys(mesto);
    	this.Ulica().sendKeys(ulica);
    	this.Broj().sendKeys(broj);
    	this.BrojStanova().sendKeys(brojStanova);
    }
    
    public String getErrMessMesto() {
		return this.ErrMessMesto().getText();
	}
    
    public String getErrMessUlica() {
		return this.ErrMessUlica().getText();
	}
    
    public String getErrMessBroj() {
		return this.ErrMessBroj().getText();
	}
    
    public String getErrMessBrojStanova() {
    	WebElement text =  driver.findElement(By.xpath("//div[4]//div[1]//div[1]"));
    	try {
    			this.ErrMessBrojStanova().getText();
    	}
  
    	catch (StaleElementReferenceException e) {
    		 text =  driver.findElement(By.xpath("//div[4]//div[1]//div[1]"));
    		
    		
		}
    	return text.getText();
	} 
    
    public String getErrMessBrojNula() {
		return this.ErrMessBrojNula().getText();
	}
    
    @FindBy(xpath = "//*[@id=\"toast-container\"]/div/div")
    
    
    private WebElement successMess;
    
    public WebElement UspesnoDodataZgradaMessage(){
    	return wait.until(ExpectedConditions.visibilityOf(successMess));
    }
    
    public String getUspesnoDodataZgradaMessage() {
		return this.UspesnoDodataZgradaMessage().getText();
	}
    
    public String getUlicaInputValue(){
    	String vrednost = this.Ulica().getAttribute("value");
    	return vrednost;
    }
    
    public String getBrojStanovaInputValue(){
    	String vrednost = this.BrojStanova().getAttribute("value");
    	return vrednost;
    }
    
    public String getBrojInputValue(){
    	String vrednost = this.Broj().getAttribute("value");
    	return vrednost;
    }
    
    public String getMestoInputValue(){
    	String vrednost = this.Mesto().getAttribute("value");
    	return vrednost;
    }
    
    @FindBy(xpath = "//*[@id='toast-container']/div/div")
    
    private WebElement sameAddressMess;
    
    public WebElement ZgradaSaIstomAdresomMessage(){
    	return wait.until(ExpectedConditions.visibilityOf(sameAddressMess));
    }
    
    public String getZgradaSaIstomAdresomMessage() {
		return this.ZgradaSaIstomAdresomMessage().getText().trim();
	}
}
