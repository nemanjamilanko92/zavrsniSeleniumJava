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
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PregledStanaraPageObj {
	private WebDriver driver;

	public PregledStanaraPageObj(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	
	}
	
	@FindBy(xpath = "//select[@id='prikaz']")
	
	private WebElement prikazi;
	
	public void Prikazi(String value){
		
		Select Prikazi = new Select((WebElement) prikazi);
		Prikazi.selectByVisibleText(value);
		
	}
	
	
	@FindBy(xpath = "//input[@id='filter']")
	
	private WebElement filterZaPretragu;
	
	
	
	@FindBy(xpath = "//button[contains(text(),'Pretraga')]")
	
	private WebElement pretraga;
	
	
	
	@FindBy(xpath = "//a[contains(text(),'Gospodin Predsednik')]")
	
	private WebElement imeIPrezime;
	
	
	
	@FindBy(xpath = "//h2[contains(text(),'Nijedan stanar sa trazenim kriterijumom nije')]")
	
	private WebElement errMessZaNepostojecegStanara;
	
	public String ErrMessZaNepostojecegStanara(){
		return errMessZaNepostojecegStanara.getText();
	}
	
	public void UnosPretrage(String imeIPrezime) {
		this.filterZaPretragu.clear();
		this.filterZaPretragu.sendKeys(imeIPrezime);
		this.pretraga.click();
	}
	
	@FindBy(xpath = "//tr[9]//td[1]//a[1]")
	
	private WebElement ImePrezimeStanar;
	
	public WebElement ImePrezimeStanar() {
		return ImePrezimeStanar;
	}
	
	@FindBy(tagName = "tbody")private WebElement tbody;
	//metoda za potvrdu da li je stanar/zgrada uneta u bazu
	public boolean proveraStanara (String Ime,String Prezime,String Email){
	List<String>provera= new ArrayList<String>();
		provera.add(Ime+" "+Prezime+" "+ Email);
		System.out.println(provera);
		List<String> stanari = new ArrayList<String>();
		
		List<WebElement> tableRow = tbody.findElements(By.tagName("tr"));
		
		int table_rowSize = tableRow.size();
		for(int i = 0;i<table_rowSize;i++){
			
			 List < WebElement > Columns_row = tableRow.get(i).findElements(By.cssSelector("td:nth-of-type(1)"));
			 int columns_count = Columns_row.size();
			 for (int column = 0; column < columns_count; column++) {
				 try {
				 stanari.add(Columns_row.get(column).getText());
				 }catch (StaleElementReferenceException e) {
					 stanari.add(Columns_row.get(column).getText());
				}
			 } 
		}
		System.out.println(stanari);
		return stanari.containsAll(provera);
	}	
}