import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * As a Wikipedia user,
 * I would like to see the Wikipedia title, Wikipedia logo,
 * So that I can confirm that I am on the correct website.
 * @author cboni
 *
 */

 public class WikipediaHomeTest{

   static HtmlUnitDriver driver = new HtmlUnitDriver();

	// Start at the home page of Wikipedia for each test
   @Before
   public void setUp() throws Exception{
     driver.get("https://en.wikipedia.org/wiki/Main_Page");
     // enable JavaScript on driver
     driver.setJavascriptEnabled(true);
     // disable selenium error messages
     java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF);
   }

   /*
    * Given that I am on the main page
    * When I view the title
    * Then I should see that it contains the word "Wikipedia"
   */
   @Test
   public void testTitle(){
     // Check if the title for the home page exists and contains "Wikipedia", if not found then fail the test
     try{
       String title = driver.getTitle();
       assertTrue(title.toLowerCase().contains("wikipedia"));
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I am on the main page
    * When I view the page
    * Then I should see the Wikipedia logo
   */
   @Test
   public void testLogo(){
     // Check if the logo for the home page exists, if not found then fail the test
     try{
       WebElement logo = driver.findElement(By.cssSelector("a.mw-wiki-logo"));
       String image = logo.getCssValue("background-image");
       assertTrue(image.toLowerCase().matches(".*enwiki.*\\.png.*"));
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   public static void main(String args[]){
     org.junit.runner.JUnitCore.main("WikipediaHomeTest");
   }

 }
