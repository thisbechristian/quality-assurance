import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class TestPlayer{

  //  Output stream used for testing console output.
  private ByteArrayOutputStream out = new ByteArrayOutputStream();

  @Before
  public void setUp() throws Exception {
    //  Redirect the console output to the output stream.
    System.setOut(new PrintStream(out));
  }

  @After
  public void tearDown() throws Exception {
    //  Remove redirection of the console output.
    System.setOut(null);
  }

  //  Adding coffee to an empty inventory increases its amount by one.
  //  Create a player and store the current number of items in his/her inventory (should be 0).
  //  Then add coffee to his/her inventory.
  //  The new count for the inventory should be one plus the previous count.
  @Test
  public void testAddCoffee() {
    Player p = new Player();
    int itemCount = p.showInventory();
    int newCount = p.addCoffee();
    assertEquals(newCount,(itemCount+1));
  }

  //  Adding cream to an empty inventory increases its amount by one.
  //  Create a player and store the current number of items in his/her inventory (should be 0).
  //  Then add cream to his/her inventory.
  //  The new count for the inventory should be one plus the previous count.
  @Test
  public void testAddCream() {
    Player p = new Player();
    int itemCount = p.showInventory();
    int newCount = p.addCream();
    assertEquals(newCount,(itemCount+1));
  }

  //  Adding sugar to an empty inventory increases its amount by one.
  //  Create a player and store the current number of items in his/her inventory (should be 0).
  //  Then add sugar to his/her inventory.
  //  The new count for the inventory should be one plus the previous count.
  @Test
  public void testAddSugar() {
    Player p = new Player();
    int itemCount = p.showInventory();
    int newCount = p.addSugar();
    assertEquals(newCount,(itemCount+1));
  }

  //  Adding two items to an empty inventory increases its amount by two.
  //  Create a player and store the current number of items in his/her inventory (should be 0).
  //  Then add two items to his/her inventory.
  //  The new count for the inventory should be two plus the original count.
  @Test
  public void testAddTwoItems() {
    Player p = new Player();
    int itemCount = p.showInventory();
    p.addCoffee();
    int newCount = p.addCream();
    assertEquals(newCount,(itemCount+2));
  }

  //  Adding three items to an empty inventory increases its amount by three.
  //  Create a player and store the current number of items in his/her inventory (should be 0).
  //  Then add three items to his/her inventory.
  //  The new count for the inventory should be three plus the original count.
  @Test
  public void testAddThreeItems() {
    Player p = new Player();
    int itemCount = p.showInventory();
    p.addCoffee();
    p.addCream();
    int newCount = p.addSugar();
    assertEquals(newCount,(itemCount+3));
  }

  //  Adding a duplicate coffee to an inventory does not increase its amount by one.
  //  Create a player, add coffee to his/her inventory, and store the current number of items in his/her inventory (should be 1).
  //  Then add coffee to his/her inventory.
  //  The new count for the inventory should equal to the previous count.
  @Test
  public void testDupeAddCoffee() {
    Player p = new Player();
    int itemCount = p.addCoffee();
    int newCount = p.addCoffee();
    assertEquals(newCount,itemCount);
  }

  //  Adding a duplicate cream to an inventory does not increase its amount by one.
  //  Create a player, add cream to his/her inventory, and store the current number of items in his/her inventory (should be 1).
  //  Then add cream to his/her inventory.
  //  The new count for the inventory should equal to the previous count.
  @Test
  public void testDupeAddCream() {
    Player p = new Player();
    int itemCount = p.addCream();
    int newCount = p.addCream();
    assertEquals(newCount,itemCount);
  }

  //  Adding a duplicate sugar to an inventory does not increase its amount by one.
  //  Create a player, add sugar to his/her inventory, and store the current number of items in his/her inventory (should be 1).
  //  Then add sugar to his/her inventory.
  //  The new count for the inventory should equal to the previous count.
  @Test
  public void testDupeAddSugar() {
    Player p = new Player();
    int itemCount = p.addSugar();
    int newCount = p.addSugar();
    assertEquals(newCount,itemCount);
  }

  //  Adding coffee to an inventory should indicate that the player has found coffee.
  //  Create a player then add coffee to his/her inventory.
  //  The console should print out text indicating the player has found caffeinated coffee.
  @Test
  public void testAddCoffeeOutput() {
    Player p = new Player();
    String inventory = "There might be something here...\nYou found some caffeinated coffee!\n";
    p.addCoffee();
    assertEquals(inventory, out.toString());
  }

  //  Adding cream to an inventory should indicate that the player has found cream.
  //  Create a player then add cream to his/her inventory.
  //  The console should print out text indicating the player has found creamy cream.
  @Test
  public void testAddCreamOutput() {
    Player p = new Player();
    String inventory = "There might be something here...\nYou found some creamy cream!\n";
    p.addCream();
    assertEquals(inventory, out.toString());
  }

  //  Adding sugar to an inventory should indicate that the player has found sugar.
  //  Create a player then add sugar to his/her inventory.
  //  The console should print out text indicating the player has found sweet sugar.
  @Test
  public void testAddSugarOutput() {
    Player p = new Player();
    String inventory = "There might be something here...\nYou found some sweet sugar!\n";
    p.addSugar();
    assertEquals(inventory, out.toString());
  }

  //  Attempting to drink with an empty inventory causes the player to lose the game.
  //  Create a player, do not add anything to his/her inventory, and drink.
  //  The return value for the drink method should be false, indicating the player lost.
  @Test
  public void testDrinkNoItems() {
    Player p = new Player();
    assertFalse(p.drink());
  }

  //  Attempting to drink with one item in the inventory causes the player to lose the game.
  //  Create a player, add an item to his/her inventory, and drink.
  //  The return value for the drink method should be false, indicating the player lost.
  @Test
  public void testDrinkOneItem() {
    Player p = new Player();
    p.addCoffee();
    assertFalse(p.drink());
  }

  //  Attempting to drink with two items in the inventory causes the player to lose the game.
  //  Create a player, add two items to his/her inventory, and drink.
  //  The return value for the drink method should be false, indicating the player lost.
  @Test
  public void testDrinkTwoItems() {
    Player p = new Player();
    p.addCoffee();
    p.addCream();
    assertFalse(p.drink());
  }

  //  Attempting to drink with all three items in the inventory causes the player to win the game.
  //  Create a player, add all three items to his/her inventory, and drink.
  //  The return value for the drink method should be true, indicating the player won.
  @Test
  public void testDrinkAllItems() {
    Player p = new Player();
    p.addCoffee();
    p.addCream();
    p.addSugar();
    assertTrue(p.drink());
  }

  //  Attempting to drink with an empty inventory should indicate to the player that he/she has lost the game.
  //  Create a player, do not add anything to his/her inventory, and drink.
  //  The console should print out text indicating the player has lost the game.
  @Test
  public void testDrinkNoItemsOutput() {
    Player p = new Player();
    String result = "You drink the air, as you have no coffee, sugar, or cream. \nThe air is invigorating, but not invigorating enough.  You cannot study. \nYou lose!\n";
    p.drink();
    assertEquals(result, out.toString());
  }

  //  Attempting to drink with all three items in the inventory should indicate to the player that he/she has won the game.
  //  Create a player, add all three items to his/her inventory, and drink.
  //  The console should print out text indicating the player has won the game.
  @Test
  public void testDrinkAllItemsOutput() {
    Player p = new Player();
    String result = "You drink the beverage and are ready to study! \nYou win!\n";
    p.addCoffee();
    p.addCream();
    p.addSugar();
    out.reset();
    p.drink();
    assertEquals(result, out.toString());
  }

  //  Displaying an empty inventory should indicate the player has no items.
  //  Create a player and display his/her inventory.
  //  The console should print out text indicating the player has no coffee, cream, or sugar.
  @Test
  public void testEmptyInventory() {
      Player p = new Player();
      String inventory = "YOU HAVE NO COFFEE! \nYOU HAVE NO CREAM! \nYOU HAVE NO SUGAR! \n";
      p.showInventory();
      assertEquals(inventory, out.toString());
  }

  //  Displaying an inventory after adding coffee should indicate the player has coffee but no cream or sugar.
  //  Create a player, add coffee to his/her inventory, and display the inventory.
  //  The console should print out text indicating the player has coffee but no cream or sugar.
  @Test
  public void testCoffeeInventory() {
      Player p = new Player();
      String inventory = "You have a cup of delicious coffee. \nYOU HAVE NO CREAM! \nYOU HAVE NO SUGAR! \n";
      p.addCoffee();
      out.reset();
      p.showInventory();
      assertEquals(inventory, out.toString());
  }

  //  Displaying an inventory after adding cream should indicate the player has cream but no coffee or sugar.
  //  Create a player, add cream to his/her inventory, and display the inventory.
  //  The console should print out text indicating the player has coffee but no coffee or sugar.
  @Test
  public void testCreamInventory() {
      Player p = new Player();
      String inventory = "YOU HAVE NO COFFEE! \nYou have some fresh cream. \nYOU HAVE NO SUGAR! \n";
      p.addCream();
      out.reset();
      p.showInventory();
      assertEquals(inventory, out.toString());
  }

  //  Displaying an inventory after adding sugar should indicate the player has sugar but no coffee or cream.
  //  Create a player, add sugar to his/her inventory, and display the inventory.
  //  The console should print out text indicating the player has coffee but no coffee or cream.
  @Test
  public void testSugarInventory() {
      Player p = new Player();
      String inventory = "YOU HAVE NO COFFEE! \nYOU HAVE NO CREAM! \nYou have some tasty sugar. \n";
      p.addSugar();
      out.reset();
      p.showInventory();
      assertEquals(inventory, out.toString());
  }

  //  Displaying an inventory after adding coffee, cream, and sugar should indicate the player has all three items.
  //  Create a player, add coffee, cream, and sugar to his/her inventory, and display the inventory.
  //  The console should print out text indicating the player has coffee, cream, and sugar.
  @Test
  public void testFullInventory() {
      Player p = new Player();
      String inventory = "You have a cup of delicious coffee. \nYou have some fresh cream. \nYou have some tasty sugar. \n";
      p.addCoffee();
      p.addCream();
      p.addSugar();
      out.reset();
      p.showInventory();
      assertEquals(inventory, out.toString());
  }

  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("TestPlayer");
  }

}
