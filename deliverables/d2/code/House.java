public class House{

  // constructor
  public House(){
    this.currentRoomNumber = 0;
    for(int i = 0; i < numberRooms; i++){
      boolean doorNorth = true;
      boolean doorSouth = true;
      boolean coffee = false;
      boolean cream = false;
      boolean sugar = false;
      if(i == 0){
        doorSouth = false;
        cream = true;
      } else if(i == (numberRooms-1)){
        doorNorth = false;
        sugar = true;
      } else if(i == 2){
        coffee = true;
      }
      Room r = new Room(doorNorth,doorSouth,coffee,cream,sugar);
      r.setRoomAdjective(roomAdjectives[i]);
      r.setRoomObject(roomObjects[i]);
      r.setRoomObjectAdjective(roomObjectAdjectives[i]);
      r.setNorthDoorAdjective(doorAdjectives[i][0]);
      r.setSouthDoorAdjective(doorAdjectives[i][1]);
      rooms[i] = r;
    }
  }

  // methods
  public int moveNorth(Room currentRoom){
    if(currentRoom.canMoveNorth()){
      currentRoomNumber++;
    } else {
      System.out.println("There is no door leading North!");
    }
    return currentRoomNumber;
  }

  public int moveSouth(Room currentRoom){
    if(currentRoom.canMoveSouth()){
      currentRoomNumber--;
    } else {
      System.out.println("There is no door leading South!");
    }
    return currentRoomNumber;
  }

  public int look(Player player, Room currentRoom){
    int found = 0;
    if(currentRoom.hasCoffee()){
      player.addCoffee();
      found++;
    }
    if(currentRoom.hasCream()){
      player.addCream();
      found++;
    }
    if(currentRoom.hasSugar()){
      player.addSugar();
      found++;
    }
    if(found == 0){
      System.out.println("You don't see anything out of the ordinary.");
    }
    return found;
  }

  public Room getCurrentRoom(){
    return rooms[currentRoomNumber];
  }

  private int currentRoomNumber;
  private final int numberRooms = 6;
  private Room[] rooms = new Room[numberRooms];
  private final String[] roomAdjectives = {"Small","Funny","Refinanced","Dumb","Bloodthirsty","Rough"};
  private final String[] roomObjects = {"sofa","record player","pizza","energy drink","bag of money","air hockey table"};
  private final String[] roomObjectAdjectives = {"Quaint","Sad","Tight","Flat","Beautiful","Perfect"};
  private final String[][] doorAdjectives = { {"Magenta", "Orange"}, {"Beige","Massive"}, {"Dead","Smart"}, {"Vivacious","Slim"}, {"Purple","Sandy"}, {"Fat","Slim"} };
}
