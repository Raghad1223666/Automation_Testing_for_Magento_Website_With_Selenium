package pageObjects;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import support.Constants;

public class Actions implements Constants {
	static public WebDriver driver;
	public int browserSelected;

	public void selectBrowser() {
		System.out.println("Please enter the browser you want to run the code on");
		System.out.println("1 Chrome browser");
		System.out.println("2 Edge browser");
		System.out.println("3 Firefox browser");
		System.out.println("Type 1 if you want chrome or 2 for Edge or 3 for Firefox , please");

		try (Scanner input = new Scanner(System.in)) {
			String browserSelected = input.next();

			switch (browserSelected) {
			case "2":
				driver = new EdgeDriver();
				break;

			case "3":
				driver = new FirefoxDriver();
				break;
			default:
				driver = new ChromeDriver();
				break;
			}

			if (browserSelected == "2") {
				System.out.println("Running code in the: Edge browser");
			} else if (browserSelected == "3") {
				System.out.println("Running code in the: Firefox browser");
			} else {
				System.out.println("Running code in the: Chrome browser");
			}

		}
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public void visitWebsite() {
		driver.get("https://magento.softwaretestingboard.com/");
	}

	public void typeInSearchInput(String text) {
		driver.findElement(By.id("search")).sendKeys(text + Keys.ENTER);
	}

	public int getRandomProduct() {
		List<WebElement> products = driver.findElements(By.className("product-item"));
		Random random = new Random();
		int productIndex = random.nextInt(products.size());
		return productIndex + 1;
	}

	public void clickOnProductCard(int productNumber) {
		driver.findElement(By.cssSelector(".product-item:nth-child(" + productNumber + ")")).click();
	}

	public void selectProductSize(ProductSizeType productSize) {
		driver.findElement(By.cssSelector("[option-label=" + productSize + "]")).click();
	}

	public void selectProductColor() {
		driver.findElements(By.cssSelector(".swatch-option.color")).get(0).click();
	}

	public void enterProductQuantity(int productQuantity) {
		WebElement element = driver.findElement(By.id("qty"));
		element.clear();
		element.sendKeys(productQuantity + "");
	}

	public void clickOnAddToCartButton() {
		driver.findElement(By.id("product-addtocart-button")).click();
	}

	public void clickOnCartIcon() {
		driver.findElement(By.className("showcart")).click();
	}

	public void clickOnProceedToCheckoutButton() {
		driver.findElement(By.id("top-cart-btn-checkout")).click();
	}

	public String generateEmail() {
		Random random = new Random();
		int number = random.nextInt(1000);
		return "Raghad" + String.format("%03d", number) + "@gmail.com";
	}

	public void typeInEmailInputField(String email) {
		WebElement element = driver.findElement(By.id("customer-email"));
		element.clear();
		element.sendKeys(email);
	}

	public void typeInFirstNameInputField(String firstName) {
		WebElement element = driver.findElement(By.name("firstname"));
		element.clear();
		element.sendKeys(firstName);
	}

	public void typeInLastNameInputField(String lastname) {
		WebElement element = driver.findElement(By.name("lastname"));
		element.clear();
		element.sendKeys(lastname);
	}

	public void typeInCompanyInputField(String company) {
		WebElement element = driver.findElement(By.name("company"));
		element.clear();
		element.sendKeys(company);
	}

	public void typeInAddress1InputField(String address1) {
		WebElement element = driver.findElement(By.name("street[0]"));
		element.clear();
		element.sendKeys(address1);
	}

	public void typeInAddress2InputField(String address2) {
		WebElement element = driver.findElement(By.name("street[1]"));
		element.clear();
		element.sendKeys(address2);
	}

	public void typeInAddress3InputField(String address3) {
		WebElement element = driver.findElement(By.name("street[2]"));
		element.clear();
		element.sendKeys(address3);
	}

	public void typeInCityInputField(String city) {
		WebElement element = driver.findElement(By.name("city"));
		element.clear();
		element.sendKeys(city);
	}

	public void selectState(int stateIndex) {
		Select dropDown = new Select(driver.findElement(By.name("region_id")));
		dropDown.selectByIndex(stateIndex);
	}

	public void typeInZipCodeInputField(String zipCode) {
		WebElement element = driver.findElement(By.name("postcode"));
		element.clear();
		element.sendKeys(zipCode);
	}

	public void selectCountry(String countryName) {
		Select dropDown = new Select(driver.findElement(By.name("country_id")));
		dropDown.selectByVisibleText(countryName);
	}

	public void typeInPhoneInputField(String telephone) {
		WebElement element = driver.findElement(By.name("telephone"));
		element.clear();
		element.sendKeys(telephone);
	}

	public void selectShippingMethods(ShippingMethodsType shippingMethods) {
		driver.findElement(By.name(shippingMethods.toString())).click();
	}

	public void clickOnNextButton() {
		driver.findElement(By.className("continue")).click();
	}

	public void clickOnPlaceOrderButton() {
		driver.findElement(By.className("checkout")).click();
	}

	public void clickOnContinueShoppingButton() {
		driver.findElement(By.className("continue")).click();
	}

	public void printOrderNumberInConsole() {
		System.out.println(
				"Order number: " + driver.findElement(By.cssSelector(".checkout-success > p  span")).getText());
	}
}
