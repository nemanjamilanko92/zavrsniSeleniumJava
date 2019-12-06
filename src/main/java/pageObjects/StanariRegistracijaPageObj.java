package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StanariRegistracijaPageObj {
	private WebDriver driver;

	public StanariRegistracijaPageObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "ime")
	private WebElement ime;

	@FindBy(id = "lozinka")
	private WebElement lozinka;
	
	@FindBy(css = "button.btn.btn-outline-primary")
	private WebElement pregled;
	public WebElement Pregled() {
		return pregled;
	}
	@FindBy(id = "prezime")
	private WebElement prezime;

	@FindBy(css = "button.btn.btn-danger")    
	private WebElement resetujte;
	public WebElement Resetujte() {
		return resetujte;
	}
	 
	@FindBy(xpath = "//b[contains(text(),'Registracija')]")   
	public WebElement registracija;
	 
	
	@FindBy(xpath  = "//button[contains(text(),'Registrujte')]")
	public WebElement registrujte;
	 
	@FindBy(xpath = "//div[@class='row justify-content-md-center']//div[1]//div[1]//div[1]")
	 
	private WebElement emailErrorMsg;

	public String getEmailErrorMsg() {
	return emailErrorMsg.getText().trim();	
	}
	
	@FindBy(xpath = "//div[contains(text(),'Neispravna lozinka!')]")
	 	private WebElement lozinkaErrorMsg;
	 
	public String getLozinkaErrorMsg() {
		return lozinkaErrorMsg.getText().trim();	
		}
	
	@FindBy(xpath = "//div[3]//div[1]//div[1]")
	 
	private WebElement imeErrorMsg;

	@FindBy(xpath = "//div[4]//div[1]//div[1]")
	 
	private WebElement prezimeErrorMsg;
	 
	public void regStanara(String email,String lozinka,String ime,String prezime) {	
		this.email.clear();
		this.lozinka.clear();
		this.ime.clear();
		this.prezime.clear();
		this.email.sendKeys(email);
		this.lozinka.sendKeys(lozinka);
		this.ime.sendKeys(ime);
		this.prezime.sendKeys(prezime);
		this.prezime.sendKeys(Keys.TAB); //ovaj korak je potreban kako bi se izazvala poruka na input polju broj stanova
	    boolean isEnabled = registrujte.isEnabled();
	    if(isEnabled=true){
	    	this.registrujte.click();
	    }else{
	    	System.out.println("Na dugme ne moze da se klikne!");
	    }
			
	}
		
	public void unosenjeVrednostiStanara(String email,String lozinka,String ime,String prezime) {		
		this.email.clear();
		this.lozinka.clear();
		this.ime.clear();
		this.prezime.clear();
		this.email.sendKeys(email);
		this.lozinka.sendKeys(lozinka);
		this.ime.sendKeys(ime);
		this.prezime.sendKeys(prezime);		
		}
		
	@FindBy(xpath = "//*[@id=\"toast-container\"]/div/div")
		 
	private WebElement uspesnoRegStanar;
		 
	
	public  String getUspesnoRegStanarMsg() {	
		WebDriverWait wait = new WebDriverWait(this.driver,5);
		wait.until(ExpectedConditions.visibilityOf(uspesnoRegStanar));
		return uspesnoRegStanar.getText();
			}
			
	public String getEmailInputValue(){
	   	String vrednost = this.email.getAttribute("value");
	   	return vrednost;
		    }
		    
	public String getLozinkaInputValue(){
	   	String vrednost = this.lozinka.getAttribute("value");
	   	return vrednost;
		    }
		    
	public String getImeInputValue(){
	   	String vrednost = this.ime.getAttribute("value");
	   	return vrednost;
		    }
		    
	public String getPrezimeInputValue(){
	   	String vrednost = this.prezime.getAttribute("value");
	   	return vrednost;
		    }
}
