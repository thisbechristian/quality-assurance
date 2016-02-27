import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * As a Wikipedia user,
 * I would like to recieve login error messages
 * and navigate to the password reset page, account creation page, and login help page,
 * So that I can easily diagnose and solve all of my login issues.
 * @author cboni
 *
 */

 public class WikipediaLoginTest{

   static WebDriver driver = new HtmlUnitDriver();

	// Start at the login page of Wikipedia for each test
   @Before
   public void setUp() throws Exception{
     driver.get("https://en.wikipedia.org/w/index.php?title=Special:UserLogin&returnto=Main+Page");
     // disable selenium error messages
     java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF);
   }

   /*
    * Given that I am on the login page
    * When I leave the username blank
    * And click on the login button
    * Then I should recieve a login error.
   */
   @Test
   public void testBlankUsername(){
     // Check if the "Log in" button, and error message exist,
     // if not found then fail the test
     try{
       driver.findElement(By.id("wpLoginAttempt")).click();
       String correctError = "you have not specified a valid user name.";
       String currentError = driver.findElement(By.cssSelector("div.errorbox")).getText();
       assertTrue(currentError.toLowerCase().contains(correctError));
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I am on the login page
    * When I type in a valid username
    * And leave the password blank
    * And click on the login button
    * Then I should recieve a login error.
   */
   @Test
   public void testBlankPassword(){
     // Check if the "Username" box, "Log in" button, and error message exist,
     // if not found then fail the test
     try{
       String validUser = "bob";
       driver.findElement(By.id("wpName1")).sendKeys(validUser);
       driver.findElement(By.id("wpLoginAttempt")).click();

       String correctError = "the password field was empty. please try again.";
       String currentError = driver.findElement(By.cssSelector("div.errorbox")).getText();
       assertTrue(currentError.toLowerCase().contains(correctError));
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I am on the login page
    * When I type in an invalid username
    * And click on the login button
    * Then I should recieve a login error.
   */
   @Test
   public void testInvalidUsername(){
     // Check if the "Username" box, "Log in" button, and error message exist,
     // if not found then fail the test
     try{
       String invalidUser = "chaosmonkey";
       driver.findElement(By.id("wpName1")).sendKeys(invalidUser);
       driver.findElement(By.id("wpLoginAttempt")).click();

       String correctError = "there is no user by the name \"" + invalidUser + "\"";
       String currentError = driver.findElement(By.cssSelector("div.errorbox")).getText();
       assertTrue(currentError.toLowerCase().contains(correctError));
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I am on the login page
    * When I type in a valid username
    * And type in an invalid password
    * And click on the login button
    * Then I should recieve a login error.
   */
   @Test
   public void testInvalidPassword(){
     // Check if the "Username" box, "Password" box, "Log in" button, and error message exist,
     // if not found then fail the test
     try{
       String validUser = "bob";
       String invalidPassword = "billybob";
       driver.findElement(By.id("wpName1")).sendKeys(validUser);
       driver.findElement(By.id("wpPassword1")).sendKeys(invalidPassword);
       driver.findElement(By.id("wpLoginAttempt")).click();

       String correctError = "incorrect password entered. please try again.";
       String currentError = driver.findElement(By.cssSelector("div.errorbox")).getText();
       assertTrue(currentError.toLowerCase().contains(correctError));
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I am on the login page
    * When I click on the "Forgot your password?" link
    * Then I should be redirected to the reset password page.
    */
   @Test
   public void testForgotPassword(){
     // Check if the "Forgot your password?" link exists,
     // if not found then fail the test
     try{
       driver.findElement(By.linkText("Forgot your password?")).click();
       String correctUrl = "https://en.wikipedia.org/wiki/Special:PasswordReset";
       String currentUrl = driver.getCurrentUrl();
       assertEquals(correctUrl,currentUrl);
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I am on the login page
    * When I click on the "Join Wikipedia" link
    * Then I should be redirected to the account creation page.
    */
   @Test
   public void testCreateUsername(){
     // Check if the "Join Wikipedia" button exists,
     // if not found then fail the test
     try{
       driver.findElement(By.id("mw-createaccount-join")).click();
       String correctUrl = "https://en.wikipedia.org/w/index.php?title=Special:UserLogin&type=signup&returnto=Main+Page&campaign=loginCTA";
       String currentUrl = driver.getCurrentUrl();
       assertEquals(correctUrl,currentUrl);
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   /*
    * Given that I am on the login page
    * When I click on the "Help with logging in" link
    * Then I should be redirected to the login help page.
    */
   @Test
   public void testLoginHelp(){
     // Check if the "Help with logging in" link exists,
     // if not found then fail the test
     try{
       driver.findElement(By.linkText("Help with logging in")).click();
       String correctUrl = "https://www.mediawiki.org/wiki/Special:MyLanguage/Help:Logging_in";
       String currentUrl = driver.getCurrentUrl();
       assertEquals(correctUrl,currentUrl);
     }catch(NoSuchElementException nseex){
       fail();
     }
   }

   public static void main(String args[]){
     org.junit.runner.JUnitCore.main("WikipediaLoginTest");
   }
 }
