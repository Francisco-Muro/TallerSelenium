package Scripts;



import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import POMs.GooglePage;

public class Sesion1 {
	WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(options);
		
	}
	@Test
	public void test() throws InterruptedException{
		System.out.println("testing");
		driver.get("https:/www.google.com");
		GooglePage RP = new GooglePage(driver);
		Thread.sleep(500);
		
		RP.typeOnSearchBar("Wikipedia");
		
		Thread.sleep(500);
		
		RP.clickFirstResult();
		
		
	}
}
