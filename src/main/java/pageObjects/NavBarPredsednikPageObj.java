package pageObjects;

import static org.testng.Assert.expectThrows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavBarPredsednikPageObj {
	private WebDriver driver;
	

	public NavBarPredsednikPageObj(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}
	@FindBy(css = "button.btn.btn-secondary")
    
    private WebElement izlogujteSe;
	
	public WebElement IzlogujteSe() {
		return izlogujteSe;
		
	}
	
	@FindBy(xpath = "//a[contains(text(),'Pocetna')]")
	
	private WebElement pocetna;
	
	public WebElement Pocetna() {
		return pocetna;
		
	}
    
	@FindBy(xpath = "//a[contains(text(),'Promena lozinke')]")
	
	private WebElement promenaLozine;
	
	public WebElement PromenaLozine() {
		return promenaLozine;
		
	}
	
	@FindBy(xpath = "//label[@class='nav-link active']")
	
	private WebElement emailText;
	
	
	
	public String getEmailText() {
		
		return emailText.getText().trim();
	}

	@FindBy(xpath = "//button[@class='btn btn-secondary']")
	
	private WebElement logOutBtn;
	
	public WebElement LogOutBtn() {
		return logOutBtn;
	}
}
