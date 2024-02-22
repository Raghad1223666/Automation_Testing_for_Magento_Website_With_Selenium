package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

public class Assertions extends Actions {
	public void checkPageTitleContainValue(String successMessagePageTitle) {
		Assert.assertEquals(driver.findElement(By.className("page-title-wrapper")).getText(), successMessagePageTitle);
	}

	public void checkCheckoutMessageContainValue(String checkoutSuccessMessage) {
		Assert.assertEquals(driver.findElement(By.cssSelector(".checkout-success p:nth-child(2)")).getText(),
				checkoutSuccessMessage);
	}
}
