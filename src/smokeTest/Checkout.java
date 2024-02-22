package smokeTest;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.Actions;
import pageObjects.Assertions;
import support.extentReportClass;

@Listeners
public class Checkout extends extentReportClass {
	Actions action;
	Assertions assertion;

	@BeforeSuite
	public void initData() {
		assertion = new Assertions();
		action = new Actions();

		action.selectBrowser();
		action.maximizeBrowser();
		action.visitWebsite();
	}

	@Test
	public void checkoutTest() throws InterruptedException {
		extentTest = extentReport.createTest("Checkout functionality");
		extentTest.log(Status.INFO, "Checkout Test functionality start");

		extentTest.log(Status.INFO, "Search for product \"Shirt\"");
		action.typeInSearchInput("Shirt");
		Thread.sleep(1000);
		extentTest.log(Status.INFO, "Select a Random product");
		int productNumber = action.getRandomProduct();
		Thread.sleep(500);
		action.clickOnProductCard(productNumber);

		Thread.sleep(3000);
		extentTest.log(Status.INFO, "Select product details");
		action.selectProductSize(ProductSizeType.S);
		action.selectProductColor();
		action.enterProductQuantity(3);
		extentTest.log(Status.INFO, "Add product to the Cart");
		action.clickOnAddToCartButton();
		Thread.sleep(3000);
		action.clickOnCartIcon();
		extentTest.log(Status.INFO, "Click on Proceed To Checkout Button");
		action.clickOnProceedToCheckoutButton();

		extentTest.log(Status.INFO, "Fill out the shipping Info");
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

		extentTest.log(Status.INFO, "Select Shipping Methods");
		action.selectShippingMethods(ShippingMethodsType.ko_unique_2);
		Thread.sleep(5000);
		action.clickOnNextButton();

		extentTest.log(Status.INFO, "Review & Confirm Payments ");
		Thread.sleep(5000);
		action.clickOnPlaceOrderButton();

		Thread.sleep(5000);
		action.printOrderNumberInConsole();

		extentTest.log(Status.INFO, "Make assertion in the checkout result");
		assertion.checkPageTitleContainValue("Thank you for your purchase!");
		assertion.checkCheckoutMessageContainValue(
				"We'll email you an order confirmation with details and tracking info.");
		extentTest.log(Status.INFO, "Checkout Test functionality Success & End");
	}

	@AfterSuite
	public void afterTest() {
		driver.close();
	}

}
