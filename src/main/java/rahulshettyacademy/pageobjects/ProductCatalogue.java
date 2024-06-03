package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;



public class ProductCatalogue extends AbstractComponents {

	
		WebDriver driver;
		
		public ProductCatalogue(WebDriver driver) {
			//initialization
			super(driver);
			this.driver=driver;//this. represent local class variable
			PageFactory.initElements(driver, this);
		}
		
		

		//PageFactory
		@FindBy(css=".mb-3")
		List<WebElement> listofproducts;
		
		//driver.findElement(By.cssSelector(".ng-animating"))
		@FindBy(css=".ng-animating")
		WebElement spinner;
		
		
		By productsBy=By.cssSelector(".mb-3");
		By addToCartBy=By.cssSelector(".card-body button:last-of-type");
		By toastMessageBy=By.cssSelector("#toast-container");
		
		public List<WebElement> getProductList()
		{
			waitForElementToAppear(productsBy);
			return listofproducts;
			
		}
	
		
		public WebElement getProductByName(String productName)
		{
			WebElement prod=getProductList().stream().filter(product->
			product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
			return prod;
		}
		public void addProductToCart(String productName) throws InterruptedException
		{
			        WebElement prod=getProductByName(productName);
					prod.findElement(addToCartBy).click();
					waitForElementToAppear(toastMessageBy);
					waitForElementToDisappear(spinner);
		}
		
		
}
