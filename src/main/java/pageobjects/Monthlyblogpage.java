package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Monthlyblogpage {

	public WebDriver driver;

	By monthlyBlogPagedriver = By.id("internal-page-content");

	public Monthlyblogpage (WebDriver driver) {
			// TODO Auto-generated constructor stub

		this.driver = driver;

		}

	public WebElement monthlyBlogPagedriver() {
		return driver.findElement(monthlyBlogPagedriver);
	}

}