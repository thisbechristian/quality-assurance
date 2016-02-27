import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * As a Wikipedia user,
 * I would like to search for both random and specific articles,
 * So that I can quickly find and read these articles.
 * @author cboni
 *
 */

 public class WikipediaSearchTest{

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
    * When I click on the "Random article" link
    * And click on the "Main page" link
    * And click on the "Random article" link a second time
    * Then I should be redirected to two different random articles
   */
   @Test
   public void testRandomArticle(){
     // Check if the "Random article" and "Main page" links exist, if not found then fail the test
     try{
       driver.findElement(By.linkText("Random article")).click();
       String randomTitle1 = driver.getTitle();

       driver.findElement(By.linkText("Main page")).click();

       driver.findElement(By.linkText("Random article")).click();
       String randomTitle2 = driver.getTitle();

       // Check that the titles for each random page are not equal
       assertNotEquals(randomTitle1,randomTitle2);
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I am on the main page
    * When I type "Ben & Jerry" in the search box
    * And click on the search button
    * Then I should be redirected to the "Ben & Jerry's" article
   */
   @Test
   public void testBenAndJerry(){
     // Check if the search box and search button exist, if not found then fail the test
     try{
       driver.findElement(By.id("searchInput")).sendKeys("Ben & Jerry");
       driver.findElement(By.id("searchButton")).click();
       String title = driver.getTitle();
       String content = driver.findElement(By.cssSelector("p")).getText();

       // Check if the title of the page contains "ben & jerry"
       assertTrue(title.toLowerCase().contains("ben & jerry"));

       // Check if the content on the page contains:
       // "ben & jerry", "ice cream", "frozen yogurt", and "sorbet"
       assertTrue(content.toLowerCase().contains("ben & jerry"));
       assertTrue(content.toLowerCase().contains("ice cream"));
       assertTrue(content.toLowerCase().contains("frozen yogurt"));
       assertTrue(content.toLowerCase().contains("sorbet"));
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I am on the main page
    * When I type "Toy Story" in the search box
    * And click on the search button
    * Then I should be redirected to the "Toy Story" article
   */
   @Test
   public void testToyStory(){
     // Check if the search box and search button exist, if not found then fail the test
     try{
       driver.findElement(By.id("searchInput")).sendKeys("Toy Story");
       driver.findElement(By.id("searchButton")).click();
       String title = driver.getTitle();
       String content = driver.findElement(By.cssSelector("p")).getText();

       // Check if the title of the page contains "toy story"
       assertTrue(title.toLowerCase().contains("toy story"));

       // Check if the content on the page contains:
       // "toy story", "pixar", "disney", "woody", and "buzz lightyear"
       assertTrue(content.toLowerCase().contains("toy story"));
       assertTrue(content.toLowerCase().contains("pixar"));
       assertTrue(content.toLowerCase().contains("disney"));
       assertTrue(content.toLowerCase().contains("woody"));
       assertTrue(content.toLowerCase().contains("buzz lightyear"));
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I am on the main page
    * When I type "Dr. Seuss" in the search box
    * And click on the search button
    * Then I should be redirected to the "Dr. Seuss" article
   */
   @Test
   public void testDrSeuss(){
     // Check if the search box and search button exist, if not found then fail the test
     try{
       driver.findElement(By.id("searchInput")).sendKeys("Dr. Seuss");
       driver.findElement(By.id("searchButton")).click();
       String title = driver.getTitle();
       String content = driver.findElement(By.cssSelector("p")).getText();

       // Check if the title of the page contains "dr. seuss"
       assertTrue(title.toLowerCase().contains("dr. seuss"));

       // Check if the content on the page contains:
       // "dr. seuss", "theodor", "seuss", "geisel", "writer", and "illustrator"
       assertTrue(content.toLowerCase().contains("dr. seuss"));
       assertTrue(content.toLowerCase().contains("theodor"));
       assertTrue(content.toLowerCase().contains("seuss"));
       assertTrue(content.toLowerCase().contains("geisel"));
       assertTrue(content.toLowerCase().contains("writer"));
       assertTrue(content.toLowerCase().contains("illustrator"));
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I am on the main page
    * When I type "Einstein" in the search box
    * And click on the search button
    * Then I should be redirected to the "Albert Einstein" article
   */
   @Test
   public void testEinstein(){
     // Check if the search box and search button exist, if not found then fail the test
     try{
       driver.findElement(By.id("searchInput")).sendKeys("Einstein");
       driver.findElement(By.id("searchButton")).click();
       String title = driver.getTitle();
       String content = driver.findElement(By.cssSelector("p")).getText();

       // Check if the title of the page contains "albert einstein"
       assertTrue(title.toLowerCase().contains("albert einstein"));

       // Check if the content on the page contains:
       // "albert", "einstein", "german", "physicist", "quantum", "mechanics", and "relativity"
       assertTrue(content.toLowerCase().contains("albert"));
       assertTrue(content.toLowerCase().contains("einstein"));
       assertTrue(content.toLowerCase().contains("german"));
       assertTrue(content.toLowerCase().contains("physicist"));
       assertTrue(content.toLowerCase().contains("quantum"));
       assertTrue(content.toLowerCase().contains("mechanics"));
       assertTrue(content.toLowerCase().contains("relativity"));
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I am on the main page
    * When I type "Bob Marley" in the search box
    * And click on the search button
    * Then I should be redirected to the "Bob Marley" article
   */
   @Test
   public void testBobMarley(){
     // Check if the search box and search button exist, if not found then fail the test
     try{
       driver.findElement(By.id("searchInput")).sendKeys("Bob Marley");
       driver.findElement(By.id("searchButton")).click();
       String title = driver.getTitle();
       String content = driver.findElement(By.cssSelector("#mw-content-text > p")).getText();

       // Check if the title of the page contains "bob marley"
       assertTrue(title.toLowerCase().contains("bob marley"));

       // Check if the content on the page contains:
       // "robert", "nesta", "marley", "reggae", "singer", "musician", and "jamaican"
       assertTrue(content.toLowerCase().contains("robert"));
       assertTrue(content.toLowerCase().contains("nesta"));
       assertTrue(content.toLowerCase().contains("marley"));
       assertTrue(content.toLowerCase().contains("reggae"));
       assertTrue(content.toLowerCase().contains("singer"));
       assertTrue(content.toLowerCase().contains("musician"));
       assertTrue(content.toLowerCase().contains("jamaican"));
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   public static void main(String args[]){
     org.junit.runner.JUnitCore.main("WikipediaSearchTest");
   }

   }
