package rahulshettyacademy.Tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class SubmitAloneOrderTest extends BaseTest {
	String productName="ZARA COAT 3";
	@Test(dataProvider="getData", groups= {"Purchase"})
	public void SubmitAloneOrder(HashMap<String,String> input) throws IOException, InterruptedException
	 {
		// TODO Auto-generated method stub
		
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));		
		ProductCatalogue productCatalogue=landingPage.loginApplication(input.get("email"),input.get("password"));
		List<WebElement> products=productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("productName"));
		CartPage cartPage=productCatalogue.goToCartPage();	
		
		Boolean match=cartPage.verifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);
		
		CheckoutPage checkoutPage=cartPage.goToCheckOut();
		checkoutPage.selectCountry("India");
		ConfirmationPage confirmationPage=checkoutPage.submitOrder();
		String confirmMessage=confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		
		
	}
	@Test(dependsOnMethods= {"SubmitAloneOrder"})
	
	public void OrderHistory()
	{
		//"ZARA COAT 3"
		ProductCatalogue productCatalogue=landingPage.loginApplication("testar@mailinator.com", "Test@123");
		OrderPage orderpage=productCatalogue.goToOrderPage();
		Assert.assertTrue(orderpage.verifyOrderDisplay(productName));
	}
	


	@DataProvider
	public Object[][] getData() throws IOException
	{
	/*	HashMap<String,String> map=new HashMap<String,String>();
		map.put("email", "testar@mailinator.com");
		map.put("password", "Test@123");
		map.put("productName", "ZARA COAT 3");
		//return new Object[][] {{"testar@mailinator.com", "Test@123"},{"testrahu@malinator.com","Test@123"}};
		HashMap<String,String> map1=new HashMap<String,String>();
		map1.put("email", "testrahu@malinator.com");
		map1.put("password", "Test@123");
		map1.put("productName", "ADIDAS ORIGINAL");*/
		List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//rahulshettyacademy//data//PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1) }};
	}
}
