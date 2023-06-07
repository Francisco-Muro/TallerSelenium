package Scripts;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import POMs.TAP;
import POMs.GooglePage;

public class Sesion4 {

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
		Thread.sleep(1000);
		
		gp.typeOnSearchBar("test automation practice");
		Thread.sleep(1000);
		gp.clickResultById(1);
		//Clickear 3 checkbox
		//Value
		Thread.sleep(1000);
		
		System.out.println("DoingStuff");
		tap.clickComboBoxByValue(2);
		Thread.sleep(500);
		tap.clickComboBoxByIndex(3);
		Thread.sleep(500);
		tap.selectCheckBoxByText("TXT file");
		
		
		
	}

}
