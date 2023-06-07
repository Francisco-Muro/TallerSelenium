package POMs ;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage{
	WebDriver driver;
	String searchBarId = "APjFqb";
	String firstResult = "//h3[text()='Wikipedia, la enciclopedia libre']";
	String firstClass = "//h3[@class='LC20lb MBeuO DK0Md']";
	String resultsClass = "//h3[@class='LC20lb MBeuO DKV0Md']";
	String WikipediaParagraph = "//p[b[text()='Nintendo Co., Ltd.']]";
	String WikipediaParagraphClass = "//div/p";
	
	
	public GooglePage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public GooglePage() {
		
	}
	public void typeOnSearchBar(String value) {
		WebElement searchBar = driver.findElement(By.id(searchBarId));
		searchBar.sendKeys(value);
		searchBar.sendKeys(Keys.ENTER);
		
	}
	public void clickFirstResult() {
		WebElement fr = driver.findElement(By.xpath(firstResult));
		fr.click();
	}
	public void clickResultById(int result) {
		List<WebElement> list = driver.findElements(By.xpath(resultsClass));	
		list.get(result).click();
	}
	public void clickResultByXpath(String Result) {
		WebElement fr = driver.findElement(By.xpath(Result));
		fr.click();
	}
	public void printWikipediaFirstp() {
		WebElement fr = driver.findElement(By.xpath(WikipediaParagraph));
		System.out.println(fr.getText());
	}
	public void printWikipedia3pReversed() {
		List<WebElement> list = driver.findElements(By.xpath(WikipediaParagraphClass));
		for(int i=3; i>=0;i--) {
		System.out.println(list.get(i).getText());
		
		}
	}
	
	
}