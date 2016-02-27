import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * As a Wikipedia user,
 * I would like to see a range of today's featured articles
 * So that I can learn new facts and information.
 * @author cboni
 *
 */

 public class WikipediaHomeArticleTest{

   static WebDriver driver = new HtmlUnitDriver();

	// Start at the home page of Wikipedia for each test
   @Before
   public void setUp() throws Exception{
     driver.get("https://en.wikipedia.org/wiki/Main_Page");
     // disable selenium error messages
     java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF);
   }

   /*
    * Given that I am on the main page
    * When I view the page
    * Then I should see the "From today's featured article" section
   */
   @Test
   public void testTodayFeaturedArticle(){
     // Check if the heading for the "From today's featured article" section exists, if not found then fail the test
     try{
       WebElement heading = driver.findElement(By.id("From_today.27s_featured_article"));
       String correctHeading = "From today's featured article";
       String currentHeading = heading.getText();
       assertEquals(correctHeading,currentHeading);
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I am on the main page
    * When I view the page
    * Then I should see the "In the news" section
   */
   @Test
   public void testInTheNews(){
     // Check if the heading for the "In the news" section exists, if not found then fail the test
     try{
       WebElement heading = driver.findElement(By.id("In_the_news"));
       String correctHeading = "In the news";
       String currentHeading = heading.getText();
       assertEquals(correctHeading,currentHeading);
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I am on the main page
    * When I view the page
    * Then I should see the "Did you know..." section
   */
   @Test
   public void testDidYouKnow(){
     // Check if the heading for the "Did you know..." section exists, if not found then fail the test
     try{
       WebElement heading = driver.findElement(By.id("Did_you_know..."));
       String correctHeading = "Did you know...";
       String currentHeading = heading.getText();
       assertEquals(correctHeading,currentHeading);
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I am on the main page
    * When I view the page
    * Then I should see the "On this day..." section
   */
   @Test
   public void testOnThisDay(){
     // Check if the heading for the "On this day..." section exists, if not found then fail the test
     try{
       WebElement heading = driver.findElement(By.id("On_this_day..."));
       String correctHeading = "On this day...";
       String currentHeading = heading.getText();
       assertEquals(correctHeading,currentHeading);
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I am on the main page
    * When I view the page
    * Then I should see the "From today's featured list" section
   */
   @Test
   public void testTodayFeaturedList(){
     // Check if the heading for the "From today's featured list" section exists, if not found then fail the test
     try{
       WebElement heading = driver.findElement(By.id("From_today.27s_featured_list"));
       String correctHeading = "From today's featured list";
       String currentHeading = heading.getText();
       assertEquals(correctHeading,currentHeading);
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I am on the main page
    * When I view the page
    * Then I should see the "Today's featured picture" section
   */
   @Test
   public void testTodayFeaturedPicture(){
     // Check if the heading for the "Today's featured picture" section exists, if not found then fail the test
     try{
       WebElement heading = driver.findElement(By.id("Today.27s_featured_picture"));
       String correctHeading = "Today's featured picture";
       String currentHeading = heading.getText();
       assertEquals(correctHeading,currentHeading);
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   public static void main(String args[]){
     org.junit.runner.JUnitCore.main("WikipediaHomeArticleTest");
   }

 }
