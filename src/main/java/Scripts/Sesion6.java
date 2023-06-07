package Scripts;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import POMs.TAP;
import POMs.GooglePage;

public class Sesion6 {

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
		GooglePage gp = new GooglePage(driver);
		TAP tap = new TAP(driver);
		driver.get("https://www.google.com");
		Thread.sleep(200);
		
		gp.typeOnSearchBar("test automation practice");
		Thread.sleep(200);
		gp.clickResultById(1);
		
		
		System.out.println(driver.getTitle());
		//click wikipedia logo
		tap.clickWikipediaIcon();
		tap.clickWikipediaIcon();
		tap.clickWikipediaIcon();
		tap.clickWikipediaIcon();
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		System.out.println(driver.getTitle());
		driver.get("https://www.google.com");
		driver.switchTo().window(tabs2.get(2));
		System.out.println(driver.getTitle());
		driver.get("https://www.youtube.com");
		driver.switchTo().window(tabs2.get(3));
		System.out.println(driver.getTitle());
		driver.get("https://www.Amazon.com");
		driver.switchTo().window(tabs2.get(4));
		System.out.println(driver.getTitle());
		driver.get("https://www.mercadolibre.com.mx/");
		System.out.print(tap.switchToName("YouTube"));
		
		
	}

}
