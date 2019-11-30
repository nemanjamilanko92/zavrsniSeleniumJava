package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AnketaPageObj {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public  AnketaPageObj(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver,5);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "button.btn.btn-info.dodaj")
    
    private WebElement dodajPitanje;
	
	public WebElement DodajPitanje() {
		return wait.until(ExpectedConditions.elementToBeClickable(dodajPitanje));
	}
	
	@FindBy(css = "button.btn.btn-info.vidiGlasove")
    
    private WebElement vidiGlasove;

	public WebElement VidiGlasove() {
		return wait.until(ExpectedConditions.elementToBeClickable(vidiGlasove));
	}

	@FindBy(css ="[class*='izmenitiPitanje']" )
    
    private WebElement izmenitiPitanje;

	public WebElement IzmenitiPitanje() {
		return wait.until(ExpectedConditions.elementToBeClickable(izmenitiPitanje));
	}
	
	@FindBy(css ="[class*='izbrisatiPitanje']" )
    
    private WebElement izbrisatiPitanje;

	public WebElement IzbrisatiPitanje() {
		return wait.until(ExpectedConditions.elementToBeClickable(izbrisatiPitanje));
	}
	
	
}


