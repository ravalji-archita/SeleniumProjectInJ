package rahulshettyacademy.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.TestComponents.Retry;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups= {"ErrorHandling"}, retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException
	 {
		// TODO Auto-generated method stub
	
		
		String productName="ZARA COAT 3";
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));		
		ProductCatalogue productCatalogue=landingPage.loginApplication("testar123@mailinator.com", "Test2@123");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		
		
	}
	
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException
	 {
		// TODO Auto-generated method stub
		String productName="ZARA COAT 3";
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));		
		ProductCatalogue productCatalogue=landingPage.loginApplication("testar@mailinator.com", "Test@123");
		List<WebElement> products=productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage=productCatalogue.goToCartPage();	
		
		Boolean match=cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		
		
		
	}


}
