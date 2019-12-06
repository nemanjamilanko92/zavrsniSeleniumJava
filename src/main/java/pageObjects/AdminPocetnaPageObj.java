package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPocetnaPageObj {
	private WebDriver driver;

	public  AdminPocetnaPageObj(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	
	}
	
	@FindBy(xpath = "//a[contains(text(),'Pocetna')]")
	
	private WebElement pocetnaNav;
	
	public WebElement Pocetna() {
		return pocetnaNav;
	}
	
	@FindBy(xpath = "//a[@class='nav-link'][contains(text(),'Zgrade')]")
	
	private WebElement zgradeNav;
	
	public WebElement Zgrade() {
		return zgradeNav;
	}
	
	@FindBy(xpath = "//a[@class='nav-link'][contains(text(),'Stanari')]")
	
	private WebElement stanariNav;
	
	public WebElement Stanari() {
		return stanariNav;
	}
	
	@FindBy(xpath = "//a[@class='nav-link'][contains(text(),'Institucije')]")
	
	private WebElement institucijeNav;
	
	public WebElement Institucije() {
		return institucijeNav;
	}
	
	@FindBy(xpath = "//a[@class='nav-link'][contains(text(),'Firme')]")
	
	private WebElement firmeNav;
	
	public WebElement Firme() {
		return firmeNav;
	}
	
	@FindBy(xpath = "//button[@class='btn btn-secondary']")
	
	private WebElement logOutBtn;
	
	public WebElement LogOutBtn() {
		return logOutBtn;
	}
	
	@FindBy(xpath = "//ul[@id='opcije']//a[contains(text(),'Zgrade')]")
	
	private WebElement zgradeLink;
	
	public WebElement ZgradeLink() {
		return zgradeLink;
	}
	
	@FindBy(xpath = "//ul[@id='opcije']//a[contains(text(),'Stanari')]")
	
	private WebElement stanariLink;
	
	public WebElement StanariLink() {
		return stanariLink;
	}

	@FindBy(xpath = "//label[@class='nav-link active']")
	
	private WebElement adminEmail;
	
	
	public String getAdminEmailText() {
	
		return adminEmail.getText().trim();
	}
}
