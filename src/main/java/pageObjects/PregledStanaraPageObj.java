package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PregledStanaraPageObj {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public PregledStanaraPageObj(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver,5);
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath = "//select[@id='prikaz']")
	
	private WebElement prikazi;
	
	public void Prikazi(String value){
		
		Select Prikazi = new Select((WebElement) prikazi);
		Prikazi.selectByVisibleText(value);
		
	}
	
	
	
	@FindBy(xpath = "//input[@id='filter']")
	
	private WebElement filterZaPretragu;
	
	public WebElement FilterZaPretragu(){
		
		
		return wait.until(ExpectedConditions.visibilityOf(filterZaPretragu));
	}
	
	@FindBy(xpath = "//button[contains(text(),'Pretraga')]")
	
	private WebElement pretraga;
	
	public WebElement Pretraga(){
		
		
		return wait.until(ExpectedConditions.elementToBeClickable(pretraga));
	}
	
	@FindBy(xpath = "//a[contains(text(),'Gospodin Predsednik')]")
	
	private WebElement imeIPrezime;
	
	public WebElement ImeIPrezime(){
	WebElement	imeIprezime = driver.findElement(By.xpath("//a[contains(text(),'Gospodin Predsednik')]"));
		try {
		 wait.until(ExpectedConditions.visibilityOf(this.imeIPrezime));
		}catch (StaleElementReferenceException e) {
			imeIprezime = driver.findElement(By.xpath("//a[contains(text(),'Gospodin Predsednik')]"));
		}
		return  wait.until(ExpectedConditions.visibilityOf(imeIprezime));
	}
	
	@FindBy(xpath = "//h2[contains(text(),'Nijedan stanar sa trazenim kriterijumom nije')]")
	
	private WebElement errMessZaNepostojecegStanara;
	
	public WebElement ErrMessZaNepostojecegStanara(){
		
		
		return wait.until(ExpectedConditions.visibilityOf(errMessZaNepostojecegStanara));
	}
	
	public void UnosPretrage(String imeIPrezime) {
		this.filterZaPretragu.clear();
		this.filterZaPretragu.sendKeys(imeIPrezime);
		this.pretraga.click();
	}
	
	@FindBy(xpath = "//tr[9]//td[1]//a[1]")
	
	private WebElement ImePrezimeStanar;
	
	public WebElement ImePrezimeStanar() {
		return wait.until(ExpectedConditions.visibilityOf(ImePrezimeStanar));
	}
	
	
}