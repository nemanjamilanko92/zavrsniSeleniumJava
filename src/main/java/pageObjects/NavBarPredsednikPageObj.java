package pageObjects;

import static org.testng.Assert.expectThrows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavBarPredsednikPageObj {
	private WebDriver driver;
	private WebDriverWait wait;

	public NavBarPredsednikPageObj(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
		PageFactory.initElements(driver, this);

	}
	@FindBy(css = "button.btn.btn-secondary")
    
    private WebElement izlogujteSe;
	
	public WebElement IzlogujteSe() {
		return wait.until(ExpectedConditions.elementToBeClickable(izlogujteSe));
		
	}
	
	@FindBy(xpath = "//a[contains(text(),'Pocetna')]")
	
	private WebElement pocetna;
	
	public WebElement Pocetna() {
		return wait.until(ExpectedConditions.elementToBeClickable(pocetna));
		
	}
    
	@FindBy(xpath = "//a[contains(text(),'Promena lozinke')]")
	
	private WebElement promenaLozine;
	
	public WebElement PromenaLozine() {
		return wait.until(ExpectedConditions.elementToBeClickable(promenaLozine));
		
	}
	
	@FindBy(xpath = "//label[@class='nav-link active']")
	
	private WebElement emailText;
	
	public WebElement EmailText() {
		return wait.until(ExpectedConditions.elementToBeClickable(emailText));
		
	}
	
	public String getEmailText() {
		return EmailText().getText().trim();
	}

	@FindBy(xpath = "//button[@class='btn btn-secondary']")
	
	private WebElement logOutBtn;
	
	public WebElement LogOutBtn() {
		return wait.until(ExpectedConditions.elementToBeClickable(logOutBtn));
	}
}
