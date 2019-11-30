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
	
	private WebElement prikazi;
	
	public Select Prikazi(){
		
		Select Prikazi = new Select((WebElement) prikazi);
		return Prikazi;
	}
	
	@FindBy(xpath = "//input[@id='ulicaBroj']")
	
	private WebElement ulicaBroj;
	
	public WebElement UlicaBroj(){
		
		
		return wait.until(ExpectedConditions.visibilityOf(ulicaBroj));
	}
	
	
	@FindBy(xpath = "//input[@id='mesto']")
	
	private WebElement mesto;
	
	public WebElement Mesto(){
		
		
		return wait.until(ExpectedConditions.visibilityOf(mesto));
	}
	
	
	@FindBy(xpath = "//button[contains(text(),'Pretraga')]")
	
	private WebElement pretraga;
	
	public WebElement Pretraga(){
		
		return wait.until(ExpectedConditions.elementToBeClickable(pretraga));
	}
	
	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-zgrade[1]/div[1]/app-izlistaj-zgrade[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/a[1]")
	
	private WebElement adresaZgrade;
	
	public WebElement AdresaZgrade(){
		
		return wait.until(ExpectedConditions.visibilityOf(adresaZgrade));
	}
	
	@FindBy(xpath = "//h2[contains(text(),'Nijedna zgrada sa trazenim kriterijumima nije')]")
	
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
	
	
	
	
	//metoda za potvrdu da li je stanar/zgrada uneta u bazu
	public boolean proveraZgrade (String ulica,String broj,String mesto){
	List<String>provera= new ArrayList<String>();
		provera.add(ulica+" "+broj+","+ " " + mesto);
	System.out.println(provera);
		List<String> adrese = new ArrayList<String>();

		WebElement tbody = driver.findElement(By.xpath("//table[@class='table table-hover']//tbody"));
		List<WebElement> tableRow = tbody.findElements(By.tagName("tr"));
		
		int table_rowSize = tableRow.size();
		for(int i = 0;i<table_rowSize;i++){
			
			 List < WebElement > Columns_row = tableRow.get(i).findElements(By.cssSelector("td:nth-of-type(1)"));
			 int columns_count = Columns_row.size();
			 for (int column = 0; column < columns_count; column++) {

					adrese.add(Columns_row.get(column).getText());
				
			 }
			 
		}
		return adrese.containsAll(provera);
		
		
	}
}
