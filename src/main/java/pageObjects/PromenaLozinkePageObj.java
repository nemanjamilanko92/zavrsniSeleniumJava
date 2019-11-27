package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PromenaLozinkePageObj {
	private WebDriver driver;
	private WebDriverWait wait;

	public PromenaLozinkePageObj(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(id = "novaLozinka")
    @CacheLookup
    private WebElement novaLozinka;
	

    @FindBy(id = "potvrdaNoveLozinke")
    @CacheLookup
    private WebElement potvrdaNoveLozinke;
    
    @FindBy(css = "button.btn.btn-primary")
    @CacheLookup
    private WebElement promeniteLozinku;
    
    @FindBy(id = "staraLozinka")
    @CacheLookup
    private WebElement staraLozinka;
    
    @FindBy(xpath = "//*[@id=\"toast-container\"]/div/div")
    @CacheLookup
    private WebElement alertErrorMsg;
}
