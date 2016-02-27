import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * As a Wikipedia user,
 * I would like to navigate to the about page, contact page, Wikipedia store,
 * and a range of Wikipedia's sister projects,
 * So that I can access a variety of Wikipedia's resources.
 * @author cboni
 *
 */

 public class WikipediaNavigationTest{

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
    * When I click on the "About Wikipedia" link
    * Then I should be redirected to the about page.
    */
   @Test
   public void testAbout(){
      // Check if the "About Wikipedia" link exists, if not found then fail the test
     try{
       driver.findElement(By.linkText("About Wikipedia")).click();
       String correctUrl = "https://en.wikipedia.org/wiki/Wikipedia:About";
       String currentUrl = driver.getCurrentUrl();
       assertEquals(correctUrl,currentUrl);
     } catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I am on the main page
    * When I click on the "Contact page" link
    * Then I should be redirected to the contact page.
    */
   @Test
   public void testContact(){
     // Check if the "Contact page" link exists, if not found then fail the test
     try{
       driver.findElement(By.linkText("Contact page")).click();
       String correctUrl = "https://en.wikipedia.org/wiki/Wikipedia:Contact_us";
       String currentUrl = driver.getCurrentUrl();
       assertEquals(correctUrl,currentUrl);
     } catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I am on the main page
    * When I click on the "Wikipedia Store" link
    * Then I should be redirected to the Wikipedia store.
   */
   @Test
   public void testStore(){
     // Check if the "Wikipedia store" link exists, if not found then fail the test
     try{
       driver.findElement(By.linkText("Wikipedia store")).click();
       String correctUrl = "https://store.wikimedia.org/";
       String currentUrl = driver.getCurrentUrl();
       assertEquals(correctUrl,currentUrl);
     } catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I am on the main page
    * When I click on the "Commons" link
    * Then I should be redirected to Commons page.
   */
   @Test
   public void testCommons(){
     // Check if the "Commons" link exists, if not found then fail the test
     try{
       driver.findElement(By.linkText("Commons")).click();
       String correctUrl = "https://commons.wikimedia.org/wiki/Main_Page";
       String currentUrl = driver.getCurrentUrl();
       assertEquals(correctUrl,currentUrl);
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I am on the main page
    * When I click on the "Wikibooks" link
    * Then I should be redirected to Wikibooks page.
   */
   @Test
   public void testWikibooks(){
     // Check if the "Wikibooks" link exists, if not found then fail the test
     try{
       driver.findElement(By.linkText("Wikibooks")).click();
       String correctUrl = "https://en.wikibooks.org/wiki/Main_Page";
       String currentUrl = driver.getCurrentUrl();
       assertEquals(correctUrl,currentUrl);
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I am on the main page
    * When I click on the "Wikiquote" link
    * Then I should be redirected to Wikiquote page.
   */
   @Test
   public void testWikiquote(){
     // Check if the "Wikiquote" link exists, if not found then fail the test
     try{
       driver.findElement(By.linkText("Wikiquote")).click();
       String correctUrl = "https://en.wikiquote.org/wiki/Main_Page";
       String currentUrl = driver.getCurrentUrl();
       assertEquals(correctUrl,currentUrl);
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I am on the main page
    * When I click on the "Wikiversity" link
    * Then I should be redirected to Wikiversity page.
   */
   @Test
   public void testWikiversity(){
     // Check if the "Wikiversity" link exists, if not found then fail the test
     try{
       driver.findElement(By.linkText("Wikiversity")).click();
       String correctUrl = "https://en.wikiversity.org/wiki/Wikiversity:Main_Page";
       String currentUrl = driver.getCurrentUrl();
       assertEquals(correctUrl,currentUrl);
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I am on the main page
    * When I click on the "MediaWiki" link
    * Then I should be redirected to MediaWiki page.
   */
   @Test
   public void testMediaWiki(){
     // Check if the "MediaWiki" link exists, if not found then fail the test
     try{
       driver.findElement(By.linkText("MediaWiki")).click();
       String correctUrl = "https://www.mediawiki.org/wiki/MediaWiki";
       String currentUrl = driver.getCurrentUrl();
       assertEquals(correctUrl,currentUrl);
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I am on the main page
    * When I click on the "Wikidata" link
    * Then I should be redirected to Wikidata page.
   */
   @Test
   public void testWikidata(){
     // Check if the "Wikidata" link exists, if not found then fail the test
     try{
       driver.findElement(By.linkText("Wikidata")).click();
       String correctUrl = "https://www.wikidata.org/wiki/Wikidata:Main_Page";
       String currentUrl = driver.getCurrentUrl();
       assertEquals(correctUrl,currentUrl);
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I am on the main page
    * When I click on the "Wikisource" link
    * Then I should be redirected to Wikisource page.
   */
   @Test
   public void testWikisource(){
     // Check if the "Wikisource" link exists, if not found then fail the test
     try{
       driver.findElement(By.linkText("Wikisource")).click();
       String correctUrl = "https://en.wikisource.org/wiki/Main_Page";
       String currentUrl = driver.getCurrentUrl();
       assertEquals(correctUrl,currentUrl);
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I am on the main page
    * When I click on the "Wikivoyage" link
    * Then I should be redirected to Wikivoyage page.
   */
   @Test
   public void testWikivoyage(){
     // Check if the "Wikivoyage" link exists, if not found then fail the test
     try{
       driver.findElement(By.linkText("Wikivoyage")).click();
       String correctUrl = "https://en.wikivoyage.org/wiki/Main_Page";
       String currentUrl = driver.getCurrentUrl();
       assertEquals(correctUrl,currentUrl);
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I am on the main page
    * When I click on the "Meta-Wiki" link
    * Then I should be redirected to Meta-Wiki page.
   */
   @Test
   public void testMetaWiki(){
     // Check if the "Meta-Wiki" link exists, if not found then fail the test
     try{
       driver.findElement(By.linkText("Meta-Wiki")).click();
       String correctUrl = "https://meta.wikimedia.org/wiki/Main_Page";
       String currentUrl = driver.getCurrentUrl();
       assertEquals(correctUrl,currentUrl);
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I am on the main page
    * When I click on the "Wikinews" link
    * Then I should be redirected to Wikinews page.
   */
   @Test
   public void testWikinews(){
     // Check if the "Wikinews" link exists, if not found then fail the test
     try{
       driver.findElement(By.linkText("Wikinews")).click();
       String correctUrl = "https://en.wikinews.org/wiki/Main_Page";
       String currentUrl = driver.getCurrentUrl();
       assertEquals(correctUrl,currentUrl);
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I am on the main page
    * When I click on the "Wikispecies" link
    * Then I should be redirected to Wikispecies page.
   */
   @Test
   public void testWikispecies(){
     // Check if the "Wikispecies" link exists, if not found then fail the test
     try{
       driver.findElement(By.linkText("Wikispecies")).click();
       String correctUrl = "https://species.wikimedia.org/wiki/Main_Page";
       String currentUrl = driver.getCurrentUrl();
       assertEquals(correctUrl,currentUrl);
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I am on the main page
    * When I click on the "Wiktionary" link
    * Then I should be redirected to Wiktionary page.
   */
   @Test
   public void testWiktionary(){
     // Check if the "Wiktionary" link exists, if not found then fail the test
     try{
       driver.findElement(By.linkText("Wiktionary")).click();
       String correctUrl = "https://en.wiktionary.org/wiki/Wiktionary:Main_Page";
       String currentUrl = driver.getCurrentUrl();
       assertEquals(correctUrl,currentUrl);
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I begin on the main page for Wikipedia
    * When I find and click on a link for each Wikipedia sister project
    * Then I should be redirected to each individual link and eventually back to the main page
   */
   @Test
   public void testFullNavigation(){
     String[] links = {
       "Commons",
       "Wikibooks",
       "Wikiquote",
       "Wikiversity",
       "MediaWiki",
       "Wikidata",
       "Wikisource",
       "Wikivoyage",
       "Meta-Wiki",
       "Wikinews",
       "Wikispecies",
       "Wiktionary",
       "Wikipedia"
     };

     String[] correctUrls = {
       "https://commons.wikimedia.org/wiki/Main_Page",
       "https://en.wikibooks.org/wiki/Main_Page",
       "https://en.wikiquote.org/wiki/Main_Page",
       "https://en.wikiversity.org/wiki/Wikiversity:Main_Page",
       "https://www.mediawiki.org/wiki/MediaWiki",
       "https://www.wikidata.org/wiki/Wikidata:Main_Page",
       "https://en.wikisource.org/wiki/Main_Page",
       "https://en.wikivoyage.org/wiki/Main_Page",
       "https://meta.wikimedia.org/wiki/Main_Page",
       "https://en.wikinews.org/wiki/Main_Page",
       "https://species.wikimedia.org/wiki/Main_Page",
       "https://en.wiktionary.org/wiki/Wiktionary:Main_Page",
       "https://en.wikipedia.org/wiki/Main_Page"
     };

     for(int i = 0; i < 13; i++){
       try{
         driver.findElement(By.linkText(links[i])).click();
         String correctUrl = correctUrls[i];
         String currentUrl = driver.getCurrentUrl();
         assertEquals(correctUrl,currentUrl);
       }catch(NoSuchElementException nseex){
         fail(links[i] + " link not found!");
       }
     }

   }

   public static void main(String args[]){
     org.junit.runner.JUnitCore.main("WikipediaNavigationTest");
   }

 }
