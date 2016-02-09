import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestRoom{

  @Before
  public void setUp() throws Exception {
    // There is nothing to set up for this test case.
  }

  @After
  public void tearDown() throws Exception {
    // There is nothing to tear down for this test case.
  }

  //  Test the setter and getter for the "Room Adjective" property.
  //  Create a new room with two doors and no items.
  //  Then set its "Room Adjective" to a valid adjective string.
  //  The value recieved from the getter should be equal to the value supplied to the setter.
  @Test
  public void testRoomAdjective() {
    Room r = new Room(true,true,false,false,false);
    r.setRoomAdjective("Happy");
    assertEquals("Happy",r.getRoomAdjective());
  }

  //  Test the "Room Adjective" property's setter for an empty string parameter.
  //  Create a new room with two doors and no items.
  //  Then attempt to set its "Room Adjective" to an empty string.
  //  This behavior should result in an IllegalArgumentException.
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyRoomAdjective() {
    Room r = new Room(true,true,false,false,false);
    r.setRoomAdjective("");
  }

  //  Test the "Room Adjective" property's setter for a null parameter.
  //  Create a new room with two doors and no items.
  //  Then attempt to set its "Room Adjective" to null.
  //  This behavior should result in an IllegalArgumentException.
  @Test(expected = IllegalArgumentException.class)
  public void testNullRoomAdjective() {
    Room r = new Room(true,true,false,false,false);
    r.setRoomAdjective(null);
  }

  //  Test the setter and getter for the "Room Object" property.
  //  Create a new room with two doors and no items.
  //  Then set its "Room Object" to a valid noun string.
  //  The value recieved from the getter should be equal to the value supplied to the setter.
  @Test
  public void testRoomObject() {
    Room r = new Room(true,true,false,false,false);
    r.setRoomObject("Chair");
    assertEquals("Chair",r.getRoomObject());
  }

  //  Test the "Room Object" property's setter for an empty string parameter.
  //  Create a new room with two doors and no items.
  //  Then attempt to set its "Room Object" to an empty string.
  //  This behavior should result in an IllegalArgumentException.
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyRoomObject() {
    Room r = new Room(true,true,false,false,false);
    r.setRoomObject("");
  }

  //  Test the "Room Object" property's setter for a null parameter.
  //  Create a new room with two doors and no items.
  //  Then attempt to set its "Room Object" to null.
  //  This behavior should result in an IllegalArgumentException.
  @Test(expected = IllegalArgumentException.class)
  public void testNullRoomObject() {
    Room r = new Room(true,true,false,false,false);
    r.setRoomObject(null);
  }

  //  Test the setter and getter for the "Room Object Adjective" property.
  //  Create a new room with two doors and no items.
  //  Then set its "Room Object Adjective" to a valid adjective string.
  //  The value recieved from the getter should be equal to the value supplied to the setter.
  @Test
  public void testRoomObjectAdjective() {
    Room r = new Room(true,true,false,false,false);
    r.setRoomObjectAdjective("Scary");
    assertEquals("Scary",r.getRoomObjectAdjective());
  }

  //  Test the "Room Object Adjective" property's setter for an empty string parameter.
  //  Create a new room with two doors and no items.
  //  Then attempt to set its "Room Object Adjective" to an empty string.
  //  This behavior should result in an IllegalArgumentException.
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyRoomObjectAdjective() {
    Room r = new Room(true,true,false,false,false);
    r.setRoomObjectAdjective("");
  }

  //  Test the "Room Object Adjective" property's setter for a null parameter.
  //  Create a new room with two doors and no items.
  //  Then attempt to set its "Room Object Adjective" to null.
  //  This behavior should result in an IllegalArgumentException.
  @Test(expected = IllegalArgumentException.class)
  public void testNullRoomObjectAdjective() {
    Room r = new Room(true,true,false,false,false);
    r.setRoomObjectAdjective(null);
  }

  //  Test the setter and getter for the "North Door Adjective" property.
  //  Create a new room with two doors and no items.
  //  Then set its "North Door Adjective" to a valid adjective string.
  //  The value recieved from the getter should be equal to the value supplied to the setter.
  @Test
  public void testNorthDoorAdjective() {
    Room r = new Room(true,true,false,false,false);
    r.setNorthDoorAdjective("Large");
    assertEquals("Large",r.getNorthDoorAdjective());
  }

  //  Test the "North Door Adjective" property's setter for an empty string parameter.
  //  Create a new room with two doors and no items.
  //  Then attempt to set its "North Door Adjective" to an empty string.
  //  This behavior should result in an IllegalArgumentException.
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyNorthDoorAdjective() {
    Room r = new Room(true,true,false,false,false);
    r.setNorthDoorAdjective("");
  }

  //  Test the "North Door Adjective" property's setter for a null parameter.
  //  Create a new room with two doors and no items.
  //  Then attempt to set its "North Door Adjective" to null.
  //  This behavior should result in an IllegalArgumentException.
  @Test(expected = IllegalArgumentException.class)
  public void testNullNorthDoorAdjective() {
    Room r = new Room(true,true,false,false,false);
    r.setNorthDoorAdjective(null);
  }

  //  Test the setter and getter for the "South Door Adjective" property.
  //  Create a new room with two doors and no items.
  //  Then set its "South Door Adjective" to a valid adjective string.
  //  The value recieved from the getter should be equal to the value supplied to the setter.
  @Test
  public void testSouthDoorAdjective() {
    Room r = new Room(true,true,false,false,false);
    r.setSouthDoorAdjective("Tiny");
    assertEquals("Tiny",r.getSouthDoorAdjective());
  }

  //  Test the "South Door Adjective" property's setter for an empty string parameter.
  //  Create a new room with two doors and no items.
  //  Then attempt to set its "South Door Adjective" to an empty string.
  //  This behavior should result in an IllegalArgumentException.
  @Test(expected = IllegalArgumentException.class)
  public void testEmptySouthDoorAdjective() {
    Room r = new Room(true,true,false,false,false);
    r.setSouthDoorAdjective("");
  }

  //  Test the "South Door Adjective" property's setter for a null parameter.
  //  Create a new room with two doors and no items.
  //  Then attempt to set its "South Door Adjective" to null.
  //  This behavior should result in an IllegalArgumentException.
  @Test(expected = IllegalArgumentException.class)
  public void testNullSouthDoorAdjective() {
    Room r = new Room(true,true,false,false,false);
    r.setSouthDoorAdjective(null);
  }

  //  Test the "canMoveNorth" function for a room only with a door facing North.
  //  Create a new room with no items and only a North door.
  //  Then call its "canMoveNorth" function.
  //  The return value from the function should be true.
  //  This indicates the room has a door facing North.
  @Test
  public void testCanMoveNorth() {
    boolean doorNorth = true;
    boolean doorSouth = false;
    Room r = new Room(doorNorth,doorSouth,false,false,false);
    assertTrue(r.canMoveNorth());
  }

  //  Test the "canMoveNorth" function for a room only with a door facing South.
  //  Create a new room with no items and only a South door.
  //  Then call its "canMoveNorth" function.
  //  The return value from the function should be false.
  //  This indicates the room does not have a door facing North.
  @Test
  public void testCannotMoveNorth() {
    boolean doorNorth = false;
    boolean doorSouth = true;
    Room r = new Room(doorNorth,doorSouth,false,false,false);
    assertFalse(r.canMoveNorth());
  }

  //  Test the "canMoveSouth" function for a room only with a door facing South.
  //  Create a new room with no items and only a South door.
  //  Then call its "canMoveSouth" function.
  //  The return value from the function should be true.
  //  This indicates the room has a door facing South.
  @Test
  public void testCanMoveSouth() {
    boolean doorNorth = false;
    boolean doorSouth = true;
    Room r = new Room(doorNorth,doorSouth,false,false,false);
    assertTrue(r.canMoveSouth());
  }

  //  Test the "canMoveSouth" function for a room only with a door facing North.
  //  Create a new room with no items and only a North door.
  //  Then call its "canMoveSouth" function.
  //  The return value from the function should be false.
  //  This indicates the room does not have a door facing South.
  @Test
  public void testCannotMoveSouth() {
    boolean doorNorth = true;
    boolean doorSouth = false;
    Room r = new Room(doorNorth,doorSouth,false,false,false);
    assertFalse(r.canMoveSouth());
  }

  //  Test the "hasCoffee" function for a room only containing coffee.
  //  Create a new room with two doors and only coffee.
  //  Then call its "hasCoffee" function.
  //  The return value from the function should be true.
  //  This indicates the room contains coffee.
  @Test
  public void testHasCoffee() {
    boolean hasCoffee = true;
    boolean hasCream = false;
    boolean hasSugar = false;
    Room r = new Room(true,true,hasCoffee,hasCream,hasSugar);
    assertTrue(r.hasCoffee());
  }

  //  Test the "hasCoffee" function for a room which does not contain coffee.
  //  Create a new room with two doors, cream, and sugar.
  //  Then call its "hasCoffee" function.
  //  The return value from the function should be false.
  //  This indicates the room does not contain coffee.
  @Test
  public void testNoCoffee() {
    boolean hasCoffee = false;
    boolean hasCream = true;
    boolean hasSugar = true;
    Room r = new Room(true,true,hasCoffee,hasCream,hasSugar);
    assertFalse(r.hasCoffee());
  }

  //  Test the "hasCream" function for a room only containing cream.
  //  Create a new room with two doors and only cream.
  //  Then call its "hasCream" function.
  //  The return value from the function should be true.
  //  This indicates the room contains cream.
  @Test
  public void testHasCream() {
    boolean hasCoffee = false;
    boolean hasCream = true;
    boolean hasSugar = false;
    Room r = new Room(true,true,hasCoffee,hasCream,hasSugar);
    assertTrue(r.hasCream());
  }

  //  Test the "hasCream" function for a room which does not contain cream.
  //  Create a new room with two doors, coffee, and sugar.
  //  Then call its "hasCream" function.
  //  The return value from the function should be false.
  //  This indicates the room does not contain cream.
  @Test
  public void testNoCream() {
    boolean hasCoffee = true;
    boolean hasCream = false;
    boolean hasSugar = true;
    Room r = new Room(true,true,hasCoffee,hasCream,hasSugar);
    assertFalse(r.hasCream());
  }

  //  Test the "hasSugar" function for a room only containing sugar.
  //  Create a new room with two doors and only sugar.
  //  Then call its "hasSugar" function.
  //  The return value from the function should be true.
  //  This indicates the room contains sugar.
  @Test
  public void testHasSugar() {
    boolean hasCoffee = false;
    boolean hasCream = false;
    boolean hasSugar = true;
    Room r = new Room(true,true,hasCoffee,hasCream,hasSugar);
    assertTrue(r.hasSugar());
  }

  //  Test the "hasSugar" function for a room which does not contain sugar.
  //  Create a new room with two doors, coffee, and cream.
  //  Then call its "hasSugar" function.
  //  The return value from the function should be false.
  //  This indicates the room does not contain sugar.
  @Test
  public void testNoSugar() {
    boolean hasCoffee = true;
    boolean hasCream = true;
    boolean hasSugar = false;
    Room r = new Room(true,true,hasCoffee,hasCream,hasSugar);
    assertFalse(r.hasSugar());
  }

  //  Test the "getRoomDescription" function for a room with two doors.
  //  Create a new room with two doors and no items.
  //  Set its "Room Adjective", "Room Object", "Room Object Adjective",
  //  "North Door Adjective", and "South Door Adjective" properites each to a valid string.
  //  Then call its "getRoomDescription" function.
  //  The return value for this function should be equal to the expected room description
  //  created with the nouns and adjectives supplied for the room's properites.
  @Test
  public void testTwoDoorRoomDescription() {
    boolean doorNorth = true;
    boolean doorSouth = true;
    Room r = new Room(doorNorth,doorSouth,false,false,false);
    r.setRoomAdjective("Quiet");
    r.setRoomObject("baseball");
    r.setRoomObjectAdjective("Smelly");
    r.setNorthDoorAdjective("Dark");
    r.setSouthDoorAdjective("Yellow");
    String description = "You see a Quiet room. \nIt has a Smelly baseball.\nA Dark door leads North.\nA Yellow door leads South.\n";
    assertEquals(description,r.getRoomDescription());
  }

  //  Test the "getRoomDescription" function for a room only a North door.
  //  Create a new room with no items and only a North door.
  //  Set its "Room Adjective", "Room Object", "Room Object Adjective",
  //  "North Door Adjective", and "South Door Adjective" properites each to a valid string.
  //  Then call its "getRoomDescription" function.
  //  The return value for this function should be equal to the expected room description
  //  created with the nouns and adjectives supplied for the room's properites excluding the South door.
  @Test
  public void testOneNorthDoorRoomDescription() {
    boolean doorNorth = true;
    boolean doorSouth = false;
    Room r = new Room(doorNorth,doorSouth,false,false,false);
    r.setRoomAdjective("Cheesy");
    r.setRoomObject("hockey puck");
    r.setRoomObjectAdjective("Brittle");
    r.setNorthDoorAdjective("Orange");
    r.setSouthDoorAdjective("Fresh");
    String description = "You see a Cheesy room. \nIt has a Brittle hockey puck.\nA Orange door leads North.\n";
    assertEquals(description,r.getRoomDescription());
  }

  //  Test the "getRoomDescription" function for a room only a South door.
  //  Create a new room with no items and only a South door.
  //  Set its "Room Adjective", "Room Object", "Room Object Adjective",
  //  "North Door Adjective", and "South Door Adjective" properites each to a valid string.
  //  Then call its "getRoomDescription" function.
  //  The return value for this function should be equal to the expected room description
  //  created with the nouns and adjectives supplied for the room's properites excluding the North door.
  @Test
  public void testOneSouthDoorRoomDescription() {
    boolean doorNorth = false;
    boolean doorSouth = true;
    Room r = new Room(doorNorth,doorSouth,false,false,false);
    r.setRoomAdjective("Beautiful");
    r.setRoomObject("garage");
    r.setRoomObjectAdjective("Moldly");
    r.setNorthDoorAdjective("Giant");
    r.setSouthDoorAdjective("Blue");
    String description = "You see a Beautiful room. \nIt has a Moldly garage.\nA Blue door leads South.\n";
    assertEquals(description,r.getRoomDescription());
  }

  //  Test the "getRoomDescription" function for a room with two doors.
  //  Create a new room with two doors and no items.
  //  Set its "Room Adjective", "Room Object", "Room Object Adjective",
  //  "North Door Adjective", and "South Door Adjective" properites each to a valid string.
  //  Then call its "getRoomDescription" function.
  //  The return value for this function should not be equal to the unexpected room description
  //  created with the opposite case of the nouns and adjectives supplied for the room's properites.
  @Test
  public void testIncorrectCaseRoomDescription() {
    boolean doorNorth = true;
    boolean doorSouth = true;
    Room r = new Room(doorNorth,doorSouth,false,false,false);
    r.setRoomAdjective("Slick");
    r.setRoomObject("puppy");
    r.setRoomObjectAdjective("Cute");
    r.setNorthDoorAdjective("Wooden");
    r.setSouthDoorAdjective("Shiny");
    String incorrectDescription = "You see a slick room. \nIt has a cute Puppy.\nA wooden door leads North.\nA shiny door leads South.\n";
    assertNotEquals(incorrectDescription,r.getRoomDescription());
  }

  //  Test the "getRoomDescription" function for a room only a North door.
  //  Create a new room with no items and only a North door.
  //  Set its "Room Adjective", "Room Object", "Room Object Adjective",
  //  "North Door Adjective", and "South Door Adjective" properites each to a valid string.
  //  Then call its "getRoomDescription" function.
  //  The return value for this function should be equal to the unexpected room description
  //  created with the nouns and adjectives supplied for the room's properites including the South door.
  @Test
  public void testIncorrectDoorRoomDescription() {
    boolean doorNorth = true;
    boolean doorSouth = false;
    Room r = new Room(doorNorth,doorSouth,false,false,false);
    r.setRoomAdjective("Slimy");
    r.setRoomObject("desk");
    r.setRoomObjectAdjective("Unstable");
    r.setNorthDoorAdjective("Brown");
    r.setSouthDoorAdjective("Invisible");
    String incorrectDescription = "You see a Slimy room. \nIt has a Unstable desk.\nA Brown door leads North.\nA Invisible door leads South.\n";
    assertNotEquals(incorrectDescription,r.getRoomDescription());
  }

  //  Check that creating two rooms with identical properites are equal.
  //  Create two new rooms both with two doors, coffee, and no other items.
  //  Set their "Room Adjective", "Room Object", "Room Object Adjective",
  //  "North Door Adjective", and "South Door Adjective" properites each to an identical valid string.
  //  The resulting rooms should be equal since they have identical properites.
  @Test
  public void testEqualRooms(){
    boolean doorNorth = true;
    boolean doorSouth = true;
    boolean hasCoffee = true;
    boolean hasCream = false;
    boolean hasSugar = false;
    Room r1 = new Room(doorNorth,doorSouth,hasCoffee,hasCream,hasSugar);
    Room r2 = new Room(doorNorth,doorSouth,hasCoffee,hasCream,hasSugar);
    r1.setRoomAdjective("Green");
    r2.setRoomAdjective("Green");
    r1.setRoomObject("boat");
    r2.setRoomObject("boat");
    r1.setRoomObjectAdjective("Heavy");
    r2.setRoomObjectAdjective("Heavy");
    r1.setNorthDoorAdjective("Maroon");
    r2.setNorthDoorAdjective("Maroon");
    r1.setSouthDoorAdjective("Weird");
    r2.setSouthDoorAdjective("Weird");
    assertEquals(r1,r2);
  }

  //  Check that creating two rooms with a different adjective property are not equal.
  //  Create two new rooms both with two doors, coffee, and no other items.
  //  Set their "Room Object", "Room Object Adjective", "North Door Adjective",
  //  and "South Door Adjective" properites each to an identical valid string.
  //  Now for each room set a distinct valid string for its "Room Adjective" property.
  //  The resulting rooms should not be equal since their "Room Adjective" properties are different.
  @Test
  public void testRoomsNotEqualAdjectives(){
    boolean doorNorth = true;
    boolean doorSouth = true;
    boolean hasCoffee = true;
    boolean hasCream = false;
    boolean hasSugar = false;
    Room r1 = new Room(doorNorth,doorSouth,hasCoffee,hasCream,hasSugar);
    Room r2 = new Room(doorNorth,doorSouth,hasCoffee,hasCream,hasSugar);
    r1.setRoomAdjective("Green");
    r2.setRoomAdjective("Lime Green");
    r1.setRoomObject("boat");
    r2.setRoomObject("boat");
    r1.setRoomObjectAdjective("Heavy");
    r2.setRoomObjectAdjective("Heavy");
    r1.setNorthDoorAdjective("Maroon");
    r2.setNorthDoorAdjective("Maroon");
    r1.setSouthDoorAdjective("Weird");
    r2.setSouthDoorAdjective("Weird");
    assertNotEquals(r1,r2);
  }

  //  Check that creating two rooms with a different combination of doors are not equal.
  //  Create a first room with two doors, coffee, and no other items.
  //  Create a second room with a North door, coffee, and no other items.
  //  Set their "Room Adjective", "Room Object", "Room Object Adjective",
  //  "North Door Adjective", and "South Door Adjective" properites each to an identical valid string.
  //  The resulting rooms should not be equal since they have a different combination of doors.
  @Test
  public void testRoomsNotEqualDoors(){
    boolean doorNorth = true;
    boolean doorSouth = true;
    boolean hasCoffee = true;
    boolean hasCream = false;
    boolean hasSugar = false;
    Room r1 = new Room(doorNorth,doorSouth,hasCoffee,hasCream,hasSugar);
    Room r2 = new Room(doorNorth,!doorSouth,hasCoffee,hasCream,hasSugar);
    r1.setRoomAdjective("Green");
    r2.setRoomAdjective("Green");
    r1.setRoomObject("boat");
    r2.setRoomObject("boat");
    r1.setRoomObjectAdjective("Heavy");
    r2.setRoomObjectAdjective("Heavy");
    r1.setNorthDoorAdjective("Maroon");
    r2.setNorthDoorAdjective("Maroon");
    r1.setSouthDoorAdjective("Weird");
    r2.setSouthDoorAdjective("Weird");
    assertNotEquals(r1,r2);
  }

  //  Check that creating two rooms with a different combination of items are not equal.
  //  Create a first room with two doors and no other items.
  //  Create a second room with two doors, sugar, and no other items.
  //  Set their "Room Adjective", "Room Object", "Room Object Adjective",
  //  "North Door Adjective", and "South Door Adjective" properites each to an identical valid string.
  //  The resulting rooms should not be equal since they have a different combination of items.
  @Test
  public void testRoomsNotEqualItems(){
    boolean doorNorth = true;
    boolean doorSouth = true;
    boolean hasCoffee = false;
    boolean hasCream = false;
    boolean hasSugar = false;
    Room r1 = new Room(doorNorth,doorSouth,hasCoffee,hasCream,hasSugar);
    Room r2 = new Room(doorNorth,doorSouth,hasCoffee,hasCream,!hasSugar);
    r1.setRoomAdjective("Green");
    r2.setRoomAdjective("Green");
    r1.setRoomObject("boat");
    r2.setRoomObject("boat");
    r1.setRoomObjectAdjective("Heavy");
    r2.setRoomObjectAdjective("Heavy");
    r1.setNorthDoorAdjective("Maroon");
    r2.setNorthDoorAdjective("Maroon");
    r1.setSouthDoorAdjective("Weird");
    r2.setSouthDoorAdjective("Weird");
    assertNotEquals(r1,r2);
  }

  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("TestRoom");
  }

}
