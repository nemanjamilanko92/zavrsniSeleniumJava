package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObj {
	
	private WebDriver driver;
	
	public LoginPageObj(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	
	}
	
	@FindBy(id = "email")
	
	private WebElement email;
	
	@FindBy(id = "lozinka")
	
	private WebElement lozinka;
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	
	private WebElement ulogujSeBtn;
	
	@FindBy(xpath = "//div[@class='alert alert-dismissible alert-danger']")

	private WebElement errorMsg;
	

	public void logIn(String email,String lozinka)   {
		this.email.clear();
		this.lozinka.clear();
		this.email.sendKeys(email);
		this.lozinka.sendKeys(lozinka);
	
		this.ulogujSeBtn.click();
	}
	
	public String getErrMsgText() {
		
		return this.errorMsg.getText();
	}
}
