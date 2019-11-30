package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObj {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public LoginPageObj(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver,5);
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(id = "email")
	
	private WebElement email;
	
	public WebElement Email() {
		
		return wait.until(ExpectedConditions.visibilityOf(email));
	};
	
	
	@FindBy(id = "lozinka")
	
	private WebElement lozinka;
	
	public WebElement Lozinka() {
		
		return wait.until(ExpectedConditions.visibilityOf(lozinka));
	};
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	
	private WebElement ulogujSeBtn;
	
	public WebElement UlogujSeBtn() {
		
		return wait.until(ExpectedConditions.elementToBeClickable(ulogujSeBtn));
	};
	
	@FindBy(xpath = "/html/body/app-root/app-logovanje/div/form/fieldset/div[1]")

	private WebElement errorMsg;
	
	public WebElement ErrorMsg() {
		
		return wait.until(ExpectedConditions.visibilityOf(errorMsg));
	};
	public void logIn(String email,String lozinka) throws InterruptedException  {
		this.Email().clear();
		this.Lozinka().clear();
		this.Email().sendKeys(email);
		this.Lozinka().sendKeys(lozinka);
		Thread.sleep(1000);
		this.UlogujSeBtn().click();
	}
	
	public String getErrMsgText() {
		return this.ErrorMsg().getText();
	}
}
