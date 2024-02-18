package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public interface Constants {
	public WebDriver driver = new ChromeDriver();
	static public String email = "CypressUser@gmail.com";
	static public String password = "test@123";

	public enum ProductSizeType {
		XS, S, M, L, XL
	}

	public enum ShippingMethodsType {
		ko_unique_1, ko_unique_2
	}

}
