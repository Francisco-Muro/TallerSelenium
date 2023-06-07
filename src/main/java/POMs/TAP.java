package POMs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


public class TAP {
	WebDriver driver;
	String alertButtonXpath=  "//button[text()='Click Me']";
	String AcceptTextAlertXpath= "//*[@id='demo']";
	String WikipediaLogoXpath= "//img[@class = 'wikipedia-icon']";
	String ComboBoxClickValue = "//select/option[@value='";
	String ComboBoxClickIndex = "//select[@name='files']/option";
	String ComboBoxClickText = "//option[text()='";
public TAP(WebDriver driver) {
		
		super();
		this.driver = driver;

}
	public void clickAlertButton() {
		WebElement button = this.driver.findElement(By.xpath(this.alertButtonXpath));
		button.click();
	}
	
	public void acceptAlert() {
		this.driver.switchTo().alert().accept();
	}
	public void dismissAlert() {
		this.driver.switchTo().alert().dismiss();
	}
	public void printDismissAlert() {
		WebElement fr = driver.findElement(By.xpath(AcceptTextAlertXpath));
		System.out.println(fr.getText());
	}
	public void printAcceptAlert() {
		WebElement fr = driver.findElement(By.xpath(AcceptTextAlertXpath));
		System.out.println(fr.getText());
	}
	public void clickWikipediaIcon() {
		WebElement button = this.driver.findElement(By.xpath(this.WikipediaLogoXpath));
		button.click();
	}
	public String switchToName(String name) {
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		for(int i = 0; i< tabs2.size(); i++) {
			
			driver.switchTo().window(tabs2.get(i));
			if(driver.getTitle().equals(name)) {
				System.out.println(tabs2.get(i));
				return "Found";
			} else {
				System.out.println(driver.getTitle() + " no coincide con " + name);
			}
			
			
		}
		return "Not Found";
	}
	
	public void clickComboBoxByValue(int value) {
		WebElement fr = driver.findElement(By.xpath(ComboBoxClickValue + value + "']"));
		
		
		fr.click();
		
	}
	public void clickComboBoxByText(String text) {
		System.out.println(ComboBoxClickText + text + "']");
		WebElement Tr = driver.findElement(By.xpath("//select[@name='files']"));
		Tr.click();
		WebElement fr = driver.findElement(By.xpath(ComboBoxClickText + text + "']"));
		
		
		fr.click();
	}
	public void clickComboBoxByIndex(int Index) {
		List<WebElement> list = driver.findElements(By.xpath(ComboBoxClickIndex));	
		list.get(Index).click();
	}
	
	public String selectCheckBoxByText(String option) {
		String value = "";
		Select cb = new Select(this.driver.findElement(By.xpath("//select[@name='files']")));
		cb.selectByVisibleText(option);
		return value;
	}
	
}
