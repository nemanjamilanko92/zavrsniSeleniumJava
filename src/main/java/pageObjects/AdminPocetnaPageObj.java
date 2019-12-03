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
	
	private WebElement pocetnaNav;
	
	public WebElement Pocetna() {
		return wait.until(ExpectedConditions.visibilityOf(pocetnaNav));
	}
	
	@FindBy(xpath = "//a[@class='nav-link'][contains(text(),'Zgrade')]")
	
	private WebElement zgradeNav;
	
	public WebElement Zgrade() {
		return wait.until(ExpectedConditions.visibilityOf(zgradeNav));
	}
	
	@FindBy(xpath = "//a[@class='nav-link'][contains(text(),'Stanari')]")
	
	private WebElement stanariNav;
	
	public WebElement Stanari() {
		return wait.until(ExpectedConditions.visibilityOf(stanariNav));
	}
	
	@FindBy(xpath = "//a[@class='nav-link'][contains(text(),'Institucije')]")
	
	private WebElement institucijeNav;
	
	public WebElement Institucije() {
		return wait.until(ExpectedConditions.visibilityOf(institucijeNav));
	}
	
	@FindBy(xpath = "//a[@class='nav-link'][contains(text(),'Firme')]")
	
	private WebElement firmeNav;
	
	public WebElement Firme() {
		return wait.until(ExpectedConditions.visibilityOf(firmeNav));
	}
	
	@FindBy(xpath = "//button[@class='btn btn-secondary']")
	
	private WebElement logOutBtn;
	
	public WebElement LogOutBtn() {
		return wait.until(ExpectedConditions.elementToBeClickable(logOutBtn));
	}
	
	@FindBy(xpath = "//ul[@id='opcije']//a[contains(text(),'Zgrade')]")
	
	private WebElement zgradeLink;
	
	public WebElement ZgradeLink() {
		return wait.until(ExpectedConditions.elementToBeClickable(zgradeLink));
	}
	
	@FindBy(xpath = "//ul[@id='opcije']//a[contains(text(),'Stanari')]")
	
	private WebElement stanariLink;
	
	public WebElement StanariLink() {
		return wait.until(ExpectedConditions.elementToBeClickable(stanariLink));
	}

	@FindBy(xpath = "//label[@class='nav-link active']")
	
	private WebElement adminEmail;
	
	
	public String getAdminEmailText() {
		wait.until(ExpectedConditions.visibilityOf(adminEmail));
		return adminEmail.getText().trim();
	}
}
