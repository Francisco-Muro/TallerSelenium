package POMs;

import java.io.Console;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonPage {
	WebDriver driver;
	String searchBarId = "twotabsearchtextbox";
	String FilterClass = "//a[@class='a-link-normal s-navigation-item']";
	String PriceClass = "//span[@class = 'a-price-whole']";
	String NameClass  = "//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']";
	
	public AmazonPage(WebDriver driver) {
		
		super();
		this.driver = driver;

	}
	public void typeOnSearchBar(String value) {
		WebElement searchBar = driver.findElement(By.id(searchBarId));
		searchBar.sendKeys(value);
		searchBar.sendKeys(Keys.ENTER);
}
	public void clickFilterById(int result) {
		List<WebElement> list = driver.findElements(By.xpath(FilterClass));	
		list.get(result).click();
	}
	
	public int[] obtainPricesProducts() { //hace una lista de ints de todos los precios
	    List<WebElement> list = driver.findElements(By.xpath(PriceClass));
	    int[] Results = new int[list.size()];
	    System.out.println(list.size() + " results found");
	    for (int i = 0; i < list.size(); i++) {
	        String priceString = list.get(i).getText().replaceAll(",", "");
	        Results[i] = Integer.parseInt(priceString);
	    }
	    return Results;
	}
	
	public int findSmallestNumber(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("The array must not be null or empty.");
        }
        
        int smallest = arr[0]; // Assume the first element is the smallest
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
                
                System.out.println("new smallest is: " +smallest);
            }
        }
        
        return smallest;
    }
	public String findNameOfPrice(int price) {
		int idProducto = 0;
		List<WebElement> list = driver.findElements(By.xpath(NameClass));
		int[] productosPrecio= obtainPricesProducts();
		for(int i = 0; i<productosPrecio.length;i++ ) {
			if(price == productosPrecio[i]) {
				idProducto = i;
				break;
			}
		}
		String nameProduct = list.get(idProducto).getText();
		return nameProduct;
	}
	
}
