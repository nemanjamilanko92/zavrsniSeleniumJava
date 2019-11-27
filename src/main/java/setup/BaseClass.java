package setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public  static  WebDriver driver;
	public  Properties props;

	public WebDriver initDriver () throws IOException {
		props = new Properties();

		FileInputStream fajl = new FileInputStream("resorsi\\file.properties");
		props.load(fajl);
		
		if(props.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resorsi\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(props.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","./resorsi/chromedriver.exe");
			  driver = new ChromeDriver();
		}else if(props.getProperty("browser").equalsIgnoreCase("IE")) {
			System.out.println("NaN");
		}
		
		//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		return driver;
		
	 }
		public void getScreenShot(String res) throws IOException {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./screenshots/"+res+"screenshot.png"));
		}
		
		
}
