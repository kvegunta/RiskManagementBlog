package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Blogpage {
	
	public WebDriver driver;
	
	By linkName=By.xpath("//div[@class='date']//li[1]");
	By blogLinkscolDriver = By.xpath("//div[@class='date']");
	
	public Blogpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}




	public WebElement linkName()
	{
		return driver.findElement(linkName);
	}
	
	
	public WebElement blogLinkscolDriver()
	{
		return driver.findElement(blogLinkscolDriver);
	}
	

}
