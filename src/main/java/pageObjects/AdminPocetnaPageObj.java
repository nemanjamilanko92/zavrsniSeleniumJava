package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPocetnaPageObj {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public  AdminPocetnaPageObj(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver,5);
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath = "//a[contains(text(),'Pocetna')]")
	@CacheLookup
	private WebElement pocetnaNav;
	
	public WebElement Pocetna() {
		return wait.until(ExpectedConditions.visibilityOf(pocetnaNav));
	}
	
	@FindBy(xpath = "//a[@class='nav-link'][contains(text(),'Zgrade')]")
	@CacheLookup
	private WebElement zgradeNav;
	
	public WebElement Zgrade() {
		return wait.until(ExpectedConditions.visibilityOf(zgradeNav));
	}
	
	@FindBy(xpath = "//a[@class='nav-link'][contains(text(),'Stanari')]")
	@CacheLookup
	private WebElement stanariNav;
	
	public WebElement Stanari() {
		return wait.until(ExpectedConditions.visibilityOf(stanariNav));
	}
	
	@FindBy(xpath = "//a[@class='nav-link'][contains(text(),'Institucije')]")
	@CacheLookup
	private WebElement institucijeNav;
	
	public WebElement Institucije() {
		return wait.until(ExpectedConditions.visibilityOf(institucijeNav));
	}
	
	@FindBy(xpath = "//a[@class='nav-link'][contains(text(),'Firme')]")
	@CacheLookup
	private WebElement firmeNav;
	
	public WebElement Firme() {
		return wait.until(ExpectedConditions.visibilityOf(firmeNav));
	}
	
	@FindBy(xpath = "//button[@class='btn btn-secondary']")
	@CacheLookup
	private WebElement logOutBtn;
	
	public WebElement LogOutBtn() {
		return wait.until(ExpectedConditions.elementToBeClickable(logOutBtn));
	}
	
	@FindBy(xpath = "//ul[@id='opcije']//a[contains(text(),'Zgrade')]")
	@CacheLookup
	private WebElement zgradeLink;
	
	public WebElement ZgradeLink() {
		return wait.until(ExpectedConditions.elementToBeClickable(zgradeLink));
	}
	
	@FindBy(xpath = "//ul[@id='opcije']//a[contains(text(),'Stanari')]")
	@CacheLookup
	private WebElement stanariLink;
	
	public WebElement StanariLink() {
		return wait.until(ExpectedConditions.elementToBeClickable(stanariLink));
	}

	@FindBy(xpath = "//label[@class='nav-link active']")
	@CacheLookup
	private WebElement adminEmail;
	
	public WebElement AdminEmail() {
		return wait.until(ExpectedConditions.visibilityOf(adminEmail));
	}
	
	public String getAdminEmailText() {
		return AdminEmail().getText().trim();
	}
}
