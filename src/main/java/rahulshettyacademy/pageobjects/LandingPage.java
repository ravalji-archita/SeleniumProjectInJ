package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

	
		WebDriver driver;
		
		public LandingPage(WebDriver driver) {
			//initialization
			super(driver);
			this.driver=driver;//this. represent local class variable
			PageFactory.initElements(driver, this);
		
		}
		//WebElement userEmail=driver.findElement(By.id("userEmail"));
		//PageFactory
		@FindBy(id="userEmail")
		private WebElement userEmail;
		
		//driver.findElement(By.id("userPassword"))
		@FindBy(id="userPassword")
		private WebElement userPassword;
		

		//driver.findElement(By.id("login"))
		@FindBy(id="login")
		private WebElement submit;
		
		//.ng-tns-c4-16.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
		
		@FindBy(css="[class*='flyInOut']")
		private WebElement errorMessage;
		
		public ProductCatalogue loginApplication(String email,String password)
		{
			userEmail.sendKeys(email);
			userPassword.sendKeys(password);
			submit.click();
			ProductCatalogue productCatalogue=new ProductCatalogue(driver);
			return productCatalogue;
		}
		
		public String getErrorMessage()
		{
			waitForWebElementToAppear(errorMessage);
			
			return errorMessage.getText();
		}
		public void goTo()
		{
			driver.get("https://rahulshettyacademy.com/client");
		}
		
}
