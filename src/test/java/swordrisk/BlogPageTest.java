package swordrisk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.Blogpage;
import pageobjects.Monthlyblogpage;

	public class BlogPageTest extends Testbase {

		public static Logger log =LogManager.getLogger(Testbase.class.getName());

		@BeforeTest
		public void initialize() throws IOException {

			driver = initializeDriver();
			log.info("driver initialized");

		}

		@Test

		public void blogPostsNo() throws InterruptedException

		{
			//Navigate to URL
			driver.get(prop.getProperty("url"));

			Assert.assertEquals(driver.getTitle(), "Blog");
			
			log.info("Navigated to blog page");
			
			//create an object of Blogpage class
			
			Blogpage bp=new Blogpage(driver);
			

			// get blog link text

			String linkText = bp.linkName().getText(); 

			// get the number next to link text - that is count of blog posts
			String blogPostsNumberstring = linkText.substring(linkText.indexOf("(") + 1, linkText.indexOf(")"));

			int blogPostsNumber = Integer.parseInt(blogPostsNumberstring);

			//System.out.println(blogPostsNumber);

			// get the list into a webelement
			List<WebElement> blogList = bp.blogLinkscolDriver().findElements(By.tagName("a"));
			
			ArrayList<String> hrefs = new ArrayList<String>();

			for (WebElement blogListItem : blogList) {

				// System.out.println(var.getAttribute("href"));//
				hrefs.add(blogListItem.getAttribute("href"));
			
			}

			for (String href : hrefs) {

				// Navigate to link by clicking on href

				driver.navigate().to(href);
				
				log.info("navigated to month blog page");
				
				break;

			}

			// first 3 characters of month name
			String monthNamesmall = linkText.substring(0, 3);
			//System.out.println(monthNamesmall);

			// navigate to posts section on the particular month blog
			//WebElement monthlyBlogPagedriver = driver.findElement(By.id("internal-page-content"));
			
			//create an object of Monthlyblogpage class
			Monthlyblogpage mbp=new Monthlyblogpage(driver);

			// Get the count of links in the section - by passing month name
			int linksOnBlogPage =mbp.monthlyBlogPagedriver().findElements(By.xpath("//time[contains(text(), '" + monthNamesmall + "')]")).size();
			

			if (blogPostsNumber == linksOnBlogPage) {
				Assert.assertTrue(true);
				System.out.println("Test passed");
				log.info("The blog posts count matches with the number of blogs on the page");
			} else {

				Assert.assertFalse(false);
				log.info("The blog posts count does not match with the number of blogs");
			}

		}

		@AfterTest
		public void teardown() {

			driver.close();
			driver = null;

		}
}
