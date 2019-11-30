package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zgrade {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public Zgrade(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver,20);
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
    
    private WebElement dodajte;
    
    public WebElement Dodajte() {
    	return wait.until(ExpectedConditions.elementToBeClickable(dodajte));
    }
    
    
}
