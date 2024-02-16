package smokeTest;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.Actions;
import pageObjects.Assertions;

@Listeners
public class Checkout extends Actions {
	Actions action;
	Assertions assertion;

	@BeforeSuite
	public void initData() {
		assertion = new Assertions();
		action = new Actions();
		action.maximizeBrowser();
		action.visitWebsite();
	}

	@Test
	public void checkoutTest() throws InterruptedException {
		extentTest = extentReport.createTest("Checkout functionality");
		extentTest.log(Status.INFO, "Checkout Test functionality start");
		
		action.typeInSearchInput("Shirt");
		action.clickOnProductCard(1);
		Thread.sleep(1000);
		action.selectProductSize(ProductSizeType.S);
		action.selectProductColor(ProductColorType.Blue);
		action.enterProductQuantity(3);
		action.clickOnAddToCartButton();
		Thread.sleep(3000);
		action.clickOnCartIcon();
		action.clickOnProceedToCheckoutButton();

		String email = action.generateEmail();
		Thread.sleep(5000);
		action.typeInEmailInputField(email);
		action.typeInFirstNameInputField("Raghad");
		action.typeInLastNameInputField("Abu Baker");
		action.typeInCompanyInputField("Palestine Company");
		action.typeInAddress1InputField("Address1");
		action.typeInAddress2InputField("Address2");
		action.typeInAddress3InputField("Address3");
		action.typeInCityInputField("Jenin");
		action.typeInZipCodeInputField("12345");
		action.selectCountry("Brazil");
		action.selectState(2);
		action.typeInPhoneInputField("0599054533");
		action.selectShippingMethods(ShippingMethodsType.ko_unique_2);
		Thread.sleep(5000);
		action.clickOnNextButton();
		Thread.sleep(5000);
		action.clickOnPlaceOrderButton();
		Thread.sleep(5000);
		action.printOrderNumberInConsole();
		assertion.checkThatCheckoutSuccess("Thank you for your purchase!", "We'll email you an order confirmation with details and tracking info.");
	}

	@AfterSuite
	public void afterTest() {
		//driver.close();
	}

}
