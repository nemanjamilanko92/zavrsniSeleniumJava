package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Stanari {
	private WebDriver driver;
	private WebDriverWait wait;

	public Stanari(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "email")
	@CacheLookup
	private WebElement email;
	
	public  WebElement Email() {
	  return wait.until(ExpectedConditions.visibilityOf(email));
	}

	@FindBy(id = "ime")
	@CacheLookup
	private WebElement ime;

	public  WebElement Ime() {
		  return wait.until(ExpectedConditions.visibilityOf(ime));
		}

	@FindBy(id = "lozinka")
	@CacheLookup
	private WebElement lozinka;
	
	public  WebElement Lozinka() {
		  return wait.until(ExpectedConditions.visibilityOf(lozinka));
		}

	@FindBy(css = "button.btn.btn-outline-primary")
	@CacheLookup
	private WebElement pregled;
	
	public  WebElement Pregled() {
		  return wait.until(ExpectedConditions.elementToBeClickable(pregled));
		}

	@FindBy(id = "prezime")
	@CacheLookup
	private WebElement prezime;

	public  WebElement Prezime() {
		  return wait.until(ExpectedConditions.visibilityOf(prezime));
		}
	
	 @FindBy(css = "button.btn.btn-danger")
	    @CacheLookup
	    private WebElement resetujte;
	 
	 public  WebElement Resetujte() {
		  return wait.until(ExpectedConditions.elementToBeClickable(resetujte));
		}
	 
	 
	 @FindBy(xpath = "//b[contains(text(),'Registracija')]")
	    @CacheLookup
	    private WebElement registracija;
	 
	 public  WebElement registracija() {
		  return wait.until(ExpectedConditions.elementToBeClickable(registracija));
		}
	 
	 
	 
	 @FindBy(xpath  = "//button[contains(text(),'Registrujte')]")
	    @CacheLookup
	    private WebElement registrujte;
	 
	 public  WebElement Registrujte() {
		  return wait.until(ExpectedConditions.elementToBeClickable(registrujte));
		}
	 
	 
	 @FindBy(xpath = "//div[@class='row justify-content-md-center']//div[1]//div[1]//div[1]")
	 @CacheLookup
	 private WebElement emailErrorMsg;

		public  WebElement emailErrorMsg() {
			  return wait.until(ExpectedConditions.visibilityOf(emailErrorMsg));
		}
	 
	 @FindBy(xpath = "//div[contains(text(),'Neispravna lozinka!')]")
	 @CacheLookup
	 private WebElement lozinkaErrorMsg;
	 
		public  WebElement lozinkaErrorMsg() {
			  return wait.until(ExpectedConditions.visibilityOf(lozinkaErrorMsg));
		}
	 
	 @FindBy(xpath = "//div[3]//div[1]//div[1]")
	 @CacheLookup
	 private WebElement imeErrorMsg;
	 
		public  WebElement imeErrorMsg() {
			  return wait.until(ExpectedConditions.visibilityOf(imeErrorMsg));
		}
	 
	 
	 @FindBy(xpath = "//div[4]//div[1]//div[1]")
	 @CacheLookup
	 private WebElement prezimeErrorMsg;
	 
		public  WebElement prezimeErrorMsg() {
			  return wait.until(ExpectedConditions.visibilityOf(prezimeErrorMsg));
		}
	 
}
