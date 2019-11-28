package pageObjects;

import java.util.ArrayList;
import java.util.List;

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

public class Pregled {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public Pregled(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver,5);
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(id = "prikaz")
	@CacheLookup
	private WebElement prikazi;
	
	public Select Prikazi(){
		
		Select Prikazi = new Select((WebElement) prikazi);
		return Prikazi;
	}
	
	@FindBy(xpath = "//input[@id='ulicaBroj']")
	@CacheLookup
	private WebElement ulicaBroj;
	
	public WebElement UlicaBroj(){
		
		
		return wait.until(ExpectedConditions.visibilityOf(ulicaBroj));
	}
	
	
	
	@FindBy(xpath = "//input[@id='mesto']")
	@CacheLookup
	private WebElement mesto;
	
	public WebElement Mesto(){
		
		
		return wait.until(ExpectedConditions.visibilityOf(mesto));
	}
	
	
	@FindBy(xpath = "//button[contains(text(),'Pretraga')]")
	@CacheLookup
	private WebElement pretraga;
	
	public WebElement Pretraga(){
		
		
		return wait.until(ExpectedConditions.elementToBeClickable(pretraga));
	}
	
	@FindBy(xpath = "//a[contains(text(),'Marsala Tita 21, Vrbas')]")
	@CacheLookup
	private WebElement adresaZgrade;
	
	public WebElement AdresaZgrade(){
		WebElement adresaZgrade = driver.findElement(By.xpath("//a[contains(text(),'Marsala Tita 21, Vrbas')]"));
		try {
			wait.until(ExpectedConditions.visibilityOf(this.adresaZgrade));
		}catch (StaleElementReferenceException e) {
			adresaZgrade = driver.findElement(By.xpath("//a[contains(text(),'Marsala Tita 21, Vrbas')]"));
		}
		return wait.until(ExpectedConditions.visibilityOf(adresaZgrade));
	}
	
	@FindBy(xpath = "//h2[contains(text(),'Nijedna zgrada sa trazenim kriterijumima nije')]")
	@CacheLookup
	private WebElement errMessZaNepostojecuZgradu;
	
	public WebElement ErrMessZaNepostojecuZgradu(){
		
		
		return wait.until(ExpectedConditions.visibilityOf(errMessZaNepostojecuZgradu));
	}
	
	public void UnosPretrage(String ulicaBroj, String mesto) {
		this.ulicaBroj.clear();
		this.mesto.clear();
		this.ulicaBroj.sendKeys(ulicaBroj);
		this.mesto.sendKeys(mesto);
		this.pretraga.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<String> Adresa (){
		
		List<String> adrese = new ArrayList<String>();
		//List <String> filterValidation = new ArrayList<String>();

		WebElement tbody = driver.findElement(By.xpath("//table[@class='table table-hover']//tbody"));
		List<WebElement> tableRow = driver.findElements(By.tagName("tr"));
		
		int table_rowSize = tableRow.size();
		for(int i = 0;i<table_rowSize;i++){
			
			 List < WebElement > Columns_row = tableRow.get(i).findElements(By.tagName("td"));
			 int columns_count = Columns_row.size();
			 for (int column = 0; column < columns_count; column++) {
				 
				List<WebElement> tdtext = Columns_row.get(i).findElements(By.tagName("a"));
				for(int indexNmb = 0; indexNmb< tdtext.size();indexNmb++){
					adrese.add(tdtext.get(indexNmb).getText());
				
				}

				
			 }
			 
		}

		
		return adrese;
	
	}
}
