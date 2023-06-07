package Scripts;



import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import POMs.GooglePage;
import POMs.AmazonPage;

public class Sesion5 {
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
		driver.get("https:/www.google.com");
		GooglePage GP = new GooglePage(driver);
		Thread.sleep(300);
		AmazonPage AP = new AmazonPage(driver);
		GP.typeOnSearchBar("Amazon");
		Thread.sleep(300);
		GP.clickResultById(1);
		Thread.sleep(300);
		AP.typeOnSearchBar("celulares");
		Thread.sleep(300);
		AP.clickFilterById(11);
		Thread.sleep(300);
		int[] priceList = AP.obtainPricesProducts();
		int smallestPrice = AP.findSmallestNumber(priceList);
		System.out.println("the smallest is: "+ smallestPrice);
		System.out.println("its name is: " + AP.findNameOfPrice(smallestPrice));
		
	}
}