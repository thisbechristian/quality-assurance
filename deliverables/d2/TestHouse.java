import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.mockito.*;

import java.io.*;

public class TestHouse{

  @SuppressWarnings("unchecked")

  @Mock
  //  Declare the test doubles.
  Player mockedPlayer = Mockito.mock(Player.class);
  Room mockedRoom = Mockito.mock(Room.class);

  //  Output stream used for testing console output.
  private ByteArrayOutputStream out = new ByteArrayOutputStream();

  @Before
  public void setUp() throws Exception {
    //  Initialize the test doubles.
    MockitoAnnotations.initMocks(mockedPlayer);
    MockitoAnnotations.initMocks(mockedRoom);

    //  Redirect the console output to the output stream.
    System.setOut(new PrintStream(out));
  }

  @After
  public void tearDown() throws Exception {
    //  Remove redirection of the console output.
    System.setOut(null);
  }

  //  Test the "moveNorth" function for a house, given a room with a door facing North.
  //  Create a new house and create a stub for mockedRoom's "canMoveNorth" function to always return true.
  //  Then call the house's "moveNorth" function with mockedRoom. Assuming the house begins at room zero...
  //  Store the initial room number. Store the final room number as the return value from the function.
  //  The final room number should be equal to one plus the initial room number.
  //  This indicates a room exists to the North.
  @Test
  public void testValidMoveNorth() {
    House h = new House();
    Mockito.when(mockedRoom.canMoveNorth()).thenReturn(true);
    int initialRoom = 0;
    int finalRoom = h.moveNorth(mockedRoom);
    assertEquals(finalRoom, initialRoom+1);
  }

  //  Test the "moveNorth" function for a house, given a room without a door facing North.
  //  Create a new house and create a stub for mockedRoom's "canMoveNorth" function to always return false.
  //  Then call the house's "moveNorth" function with mockedRoom. Assuming the house begins at room zero...
  //  Store the initial room number. Store the final room number as the return value from the function.
  //  The final room number should be equal to the initial room number.
  //  This indicates a room does not exist to the North.
  @Test
  public void testInvalidMoveNorth() {
    House h = new House();
    Mockito.when(mockedRoom.canMoveNorth()).thenReturn(false);
    int initialRoom = 0;
    int finalRoom = h.moveNorth(mockedRoom);
    assertEquals(finalRoom, initialRoom);
  }

  //  Test the "moveNorth" function for a house, given two rooms both with a door facing North.
  //  Create a new house and create a stub for mockedRoom's "canMoveNorth" function to always return true.
  //  Then call the house's "moveNorth" function twice with mockedRoom. Assuming the house begins at room zero...
  //  Store the initial room number. Store the final room number as the return value from the second function.
  //  The final room number should be equal to two plus the initial room number.
  //  This indicates that two consecutive rooms exist to the North.
  @Test
  public void testDoubleValidMoveNorth() {
    House h = new House();
    Mockito.when(mockedRoom.canMoveNorth()).thenReturn(true);
    int initialRoom = 0;
    h.moveNorth(mockedRoom);
    int finalRoom = h.moveNorth(mockedRoom);
    assertEquals(finalRoom, initialRoom+2);
  }

  //  Test the "moveSouth" function for a house, given a room with a door facing South.
  //  Create a new house and create a stub for mockedRoom's "canMoveSouth" function to always return true.
  //  Then call the house's "moveSouth" function with mockedRoom. Assuming the house begins at room zero...
  //  Store the initial room number. Store the final room number as the return value from the function.
  //  The final room number should be equal to one minus the initial room number.
  //  This indicates a room exists to the South.
  @Test
  public void testValidMoveSouth() {
    House h = new House();
    Mockito.when(mockedRoom.canMoveSouth()).thenReturn(true);
    int initialRoom = 0;
    int finalRoom = h.moveSouth(mockedRoom);
    assertEquals(finalRoom, initialRoom-1);
  }

  //  Test the "moveSouth" function for a house, given a room without a door facing South.
  //  Create a new house and create a stub for mockedRoom's "canMoveSouth" function to always return false.
  //  Then call the house's "moveSouth" function with mockedRoom. Assuming the house begins at room zero...
  //  Store the initial room number. Store the final room number as the return value from the function.
  //  The final room number should be equal to the initial room number.
  //  This indicates a room does not exist to the South.
  @Test
  public void testInvalidMoveSouth() {
    House h = new House();
    Mockito.when(mockedRoom.canMoveSouth()).thenReturn(false);
    int initialRoom = 0;
    int finalRoom = h.moveSouth(mockedRoom);
    assertEquals(finalRoom, initialRoom);
  }

  //  Test the "moveSouth" function for a house, given two rooms both with a door facing South.
  //  Create a new house and create a stub for mockedRoom's "canMoveSouth" function to always return true.
  //  Then call the house's "moveSouth" function twice with mockedRoom. Assuming the house begins at room zero...
  //  Store the initial room number. Store the final room number as the return value from the second function.
  //  The final room number should be equal to two minus the initial room number.
  //  This indicates that two consecutive rooms exist to the South.
  @Test
  public void testDoubleValidMoveSouth() {
    House h = new House();
    Mockito.when(mockedRoom.canMoveSouth()).thenReturn(true);
    int initialRoom = 0;
    h.moveSouth(mockedRoom);
    int finalRoom = h.moveSouth(mockedRoom);
    assertEquals(finalRoom, initialRoom-2);
  }

  //  Test the "look" function for a house, given a room that contains coffee.
  //  Create a new house and create stubs for mockedRoom's methods "hasCoffee", "hasCream", and "hasSugar".
  //  "hasCoffee" will always return true. "hasCream" and "hasSugar" will always return false;
  //  Then call the house's "look" function with mockedPlayer and mockedRoom.
  //  Store the number of items found as the return value from the function.
  //  The final number of items should be equal one.
  //  This indicates that coffee was the only item found in the room.
  @Test
  public void testFoundCoffee() {
    House h = new House();
    Mockito.when(mockedRoom.hasCoffee()).thenReturn(true);
    Mockito.when(mockedRoom.hasCream()).thenReturn(false);
    Mockito.when(mockedRoom.hasSugar()).thenReturn(false);
    int found = h.look(mockedPlayer,mockedRoom);
    assertEquals(found,1);
  }

  //  Test the "look" function for a house, given a room that does not contain coffee.
  //  Create a new house and create stubs for mockedRoom's methods "hasCoffee", "hasCream", and "hasSugar".
  //  "hasCoffee" will always return false. "hasCream" and "hasSugar" will always return true;
  //  Then call the house's "look" function with mockedPlayer and mockedRoom.
  //  Store the number of items found as the return value from the function.
  //  The final number of items should be equal two.
  //  This indicates that coffee was not found in the room.
  @Test
  public void testDidNotFindCoffee() {
    House h = new House();
    Mockito.when(mockedRoom.hasCoffee()).thenReturn(false);
    Mockito.when(mockedRoom.hasCream()).thenReturn(true);
    Mockito.when(mockedRoom.hasSugar()).thenReturn(true);
    int found = h.look(mockedPlayer,mockedRoom);
    assertEquals(found,2);
  }

  //  Test the "look" function for a house, given a room that contains cream.
  //  Create a new house and create stubs for mockedRoom's methods "hasCoffee", "hasCream", and "hasSugar".
  //  "hasCream" will always return true. "hasCoffee" and "hasSugar" will always return false;
  //  Then call the house's "look" function with mockedPlayer and mockedRoom.
  //  Store the number of items found as the return value from the function.
  //  The final number of items should be equal one.
  //  This indicates that cream was the only item found in the room.
  @Test
  public void testFoundCream() {
    House h = new House();
    Mockito.when(mockedRoom.hasCoffee()).thenReturn(false);
    Mockito.when(mockedRoom.hasCream()).thenReturn(true);
    Mockito.when(mockedRoom.hasSugar()).thenReturn(false);
    int found = h.look(mockedPlayer,mockedRoom);
    assertEquals(found,1);
  }

  //  Test the "look" function for a house, given a room that does not contain cream.
  //  Create a new house and create stubs for mockedRoom's methods "hasCoffee", "hasCream", and "hasSugar".
  //  "hasCream" will always return false. "hasCoffee" and "hasSugar" will always return true;
  //  Then call the house's "look" function with mockedPlayer and mockedRoom.
  //  Store the number of items found as the return value from the function.
  //  The final number of items should be equal two.
  //  This indicates that cream was not found in the room.
  @Test
  public void testDidNotFindCream() {
    House h = new House();
    Mockito.when(mockedRoom.hasCoffee()).thenReturn(true);
    Mockito.when(mockedRoom.hasCream()).thenReturn(false);
    Mockito.when(mockedRoom.hasSugar()).thenReturn(true);
    int found = h.look(mockedPlayer,mockedRoom);
    assertEquals(found,2);
  }

  //  Test the "look" function for a house, given a room that contains sugar.
  //  Create a new house and create stubs for mockedRoom's methods "hasCoffee", "hasCream", and "hasSugar".
  //  "hasSugar" will always return true. "hasCoffee" and "hasCream" will always return false;
  //  Then call the house's "look" function with mockedPlayer and mockedRoom.
  //  Store the number of items found as the return value from the function.
  //  The final number of items should be equal one.
  //  This indicates that sugar was the only item found in the room.
  @Test
  public void testFoundSugar() {
    House h = new House();
    Mockito.when(mockedRoom.hasCoffee()).thenReturn(false);
    Mockito.when(mockedRoom.hasCream()).thenReturn(false);
    Mockito.when(mockedRoom.hasSugar()).thenReturn(true);
    int found = h.look(mockedPlayer,mockedRoom);
    assertEquals(found,1);
  }

  //  Test the "look" function for a house, given a room that does not contain sugar.
  //  Create a new house and create stubs for mockedRoom's methods "hasCoffee", "hasCream", and "hasSugar".
  //  "hasSugar" will always return false. "hasCoffee" and "hasCream" will always return true;
  //  Then call the house's "look" function with mockedPlayer and mockedRoom.
  //  Store the number of items found as the return value from the function.
  //  The final number of items should be equal two.
  //  This indicates that sugar was not found in the room.
  @Test
  public void testDidNotFindSugar() {
    House h = new House();
    Mockito.when(mockedRoom.hasCoffee()).thenReturn(true);
    Mockito.when(mockedRoom.hasCream()).thenReturn(true);
    Mockito.when(mockedRoom.hasSugar()).thenReturn(false);
    int found = h.look(mockedPlayer,mockedRoom);
    assertEquals(found,2);
  }

  //  Test the "look" function for a house, given a room that contains coffee, cream, and sugar.
  //  Create a new house and create stubs for mockedRoom's methods "hasCoffee", "hasCream", and "hasSugar".
  //  "hasCoffee", "hasCream", "hasCream" and will always return true;
  //  Then call the house's "look" function with mockedPlayer and mockedRoom.
  //  Store the number of items found as the return value from the function.
  //  The final number of items should be equal three.
  //  This indicates that coffee, cream, and sugar were all found in the room.
  @Test
  public void testFoundAllItems() {
    House h = new House();
    Mockito.when(mockedRoom.hasCoffee()).thenReturn(true);
    Mockito.when(mockedRoom.hasCream()).thenReturn(true);
    Mockito.when(mockedRoom.hasSugar()).thenReturn(true);
    int found = h.look(mockedPlayer,mockedRoom);
    assertEquals(found,3);
  }

  //  Test the "look" function for a house, given a room that does not contain coffee, cream, or sugar.
  //  Create a new house and create stubs for mockedRoom's methods "hasCoffee", "hasCream", and "hasSugar".
  //  "hasCoffee", "hasCream", "hasCream" and will always return false;
  //  Then call the house's "look" function with mockedPlayer and mockedRoom.
  //  Store the number of items found as the return value from the function.
  //  The final number of items should be equal 0.
  //  This indicates that coffee, cream, and sugar were not found in the room.
  @Test
  public void testFoundNoItems() {
    House h = new House();
    Mockito.when(mockedRoom.hasCoffee()).thenReturn(false);
    Mockito.when(mockedRoom.hasCream()).thenReturn(false);
    Mockito.when(mockedRoom.hasSugar()).thenReturn(false);
    int found = h.look(mockedPlayer,mockedRoom);
    assertEquals(found,0);
  }

  //  Test the output for the "look" function for a house, given a room that does not contain coffee, cream, or sugar.
  //  Create a new house and create stubs for mockedRoom's methods "hasCoffee", "hasCream", and "hasSugar".
  //  "hasCoffee", "hasCream", "hasCream" and will always return false;
  //  Then call the house's "look" function with mockedPlayer and mockedRoom.
  //  The console should print out text indicating the player does not see anything out of the ordinary.
  @Test
  public void testFindNoItemsOutput() {
    House h = new House();
    Mockito.when(mockedRoom.hasCoffee()).thenReturn(false);
    Mockito.when(mockedRoom.hasCream()).thenReturn(false);
    Mockito.when(mockedRoom.hasSugar()).thenReturn(false);
    String notFound = "You don't see anything out of the ordinary.\n";
    h.look(mockedPlayer,mockedRoom);
    assertEquals(notFound, out.toString());
  }

  //  Test the "getCurrentRoom" function does not return null.
  //  Create a new house and call the house's "getCurrentRoom" function.
  //  Store the current room as the return value from the function.
  //  The current room should not be equal to null.
  @Test
  public void testCurrentRoomNotNull() {
    House h = new House();
    Room r = h.getCurrentRoom();
    assertNotNull(r);
  }

  //  Test the "getCurrentRoom" function does not return equal rooms after a valid move North.
  //  Create a new house and create a stub for mockedRoom's "canMoveNorth" function to always return true.
  //  Then call the house's "getCurrentRoom" function.
  //  Store the initial room as the return value from the function.
  //  Next call the house's "moveNorth" function with mockedRoom.
  //  Finally call the house's "getCurrentRoom" function again.
  //  Store the final room as the return value from the function.
  //  The initial room should not be equal to the final room.
  @Test
  public void testValidMoveRoomsNotEqual() {
    House h = new House();
    Mockito.when(mockedRoom.canMoveNorth()).thenReturn(true);
    Room initialRoom = h.getCurrentRoom();
    h.moveNorth(mockedRoom);
    Room finalRoom = h.getCurrentRoom();
    assertNotEquals(initialRoom, finalRoom);
  }

  //  Test the "getCurrentRoom" function returns equal rooms after an invalid move North.
  //  Create a new house and create a stub for mockedRoom's "canMoveNorth" function to always return false.
  //  Then call the house's "getCurrentRoom" function.
  //  Store the initial room as the return value from the function.
  //  Next call the house's "moveNorth" function with mockedRoom.
  //  Finally call the house's "getCurrentRoom" function again.
  //  Store the final room as the return value from the function.
  //  The initial room should be equal to the final room.
  @Test
  public void testInvalidMoveRoomsEqual() {
    House h = new House();
    Mockito.when(mockedRoom.canMoveNorth()).thenReturn(false);
    Room initialRoom = h.getCurrentRoom();
    h.moveNorth(mockedRoom);
    Room finalRoom = h.getCurrentRoom();
    assertEquals(initialRoom, finalRoom);
  }

  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("TestHouse");
  }

}
