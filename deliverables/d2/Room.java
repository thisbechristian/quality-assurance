public class Room{

  // constructor
  public Room(boolean north, boolean south, boolean coffee, boolean cream, boolean sugar){
    this.doorNorth = north;
    this.doorSouth = south;
    this.coffee = coffee;
    this.cream = cream;
    this.sugar = sugar;
  }

  // methods
  public void setRoomAdjective(String name){
    if(name == null || name.equals("")){
      throw new IllegalArgumentException("Parameter cannot be empty or null!");
    }
    this.roomAdjective = name;
  }

  public String getRoomAdjective(){
    return this.roomAdjective;
  }

  public void setRoomObject(String object){
    if(object == null || object.equals("")){
      throw new IllegalArgumentException("Parameter cannot be empty or null!");
    }
    this.roomObject = object;
  }

  public String getRoomObject(){
    return this.roomObject;
  }

  public void setRoomObjectAdjective(String name){
    if(name == null || name.equals("")){
      throw new IllegalArgumentException("Parameter cannot be empty or null!");
    }
    this.roomObjectAdjective = name;
  }

  public String getRoomObjectAdjective(){
    return this.roomObjectAdjective;
  }

  public void setNorthDoorAdjective(String name){
    if(name == null || name.equals("")){
      throw new IllegalArgumentException("Parameter cannot be empty or null!");
    } else{
      this.northDoorAdjective = name;
    }
  }

  public String getNorthDoorAdjective(){
      return this.northDoorAdjective;
  }

  public void setSouthDoorAdjective(String name){
    if(name == null || name.equals("")){
      throw new IllegalArgumentException("Parameter cannot be empty or null!");
    } else{
      this.southDoorAdjective = name;
    }
  }

  public String getSouthDoorAdjective(){
      return this.southDoorAdjective;
  }

  public boolean canMoveNorth(){
    return this.doorNorth;
  }

  public boolean canMoveSouth(){
    return this.doorSouth;
  }

  public boolean hasCoffee(){
    return this.coffee;
  }

  public boolean hasCream(){
    return this.cream;
  }

  public boolean hasSugar(){
    return this.sugar;
  }

  public String getRoomDescription(){
    StringBuilder s = new StringBuilder();
    s.append("You see a ");
    s.append(roomAdjective);
    s.append(" room. \n");
    s.append("It has a ");
    s.append(roomObjectAdjective);
    s.append(" ");
    s.append(roomObject);
    s.append(".\n");
    if(doorNorth){
      s.append("A ");
      s.append(northDoorAdjective);
      s.append(" door leads North.\n");
    }
    if(doorSouth){
      s.append("A ");
      s.append(southDoorAdjective);
      s.append(" door leads South.\n");
    }
    return s.toString();
  }

  public boolean equals(Object o){
    if(o instanceof Room){
      Room other = (Room) o;
      boolean equality = true;
      equality &= other.getRoomAdjective().equalsIgnoreCase(roomAdjective);
      equality &= other.getRoomObject().equalsIgnoreCase(roomObject);
      equality &= other.getRoomObjectAdjective().equalsIgnoreCase(roomObjectAdjective);
      equality &= other.getNorthDoorAdjective().equalsIgnoreCase(northDoorAdjective);
      equality &= other.getSouthDoorAdjective().equalsIgnoreCase(southDoorAdjective);
      equality &= (other.canMoveNorth() == doorNorth);
      equality &= (other.canMoveSouth() == doorSouth);
      equality &= (other.hasCoffee() == coffee);
      equality &= (other.hasCream() == cream);
      equality &= (other.hasSugar() == sugar);
      return equality;
    } else{
      return false;
    }
  }

  // fields
  private String roomAdjective;
  private String roomObject;
  private String roomObjectAdjective;
  private String northDoorAdjective;
  private String southDoorAdjective;
  private boolean coffee;
  private boolean cream;
  private boolean sugar;
  private boolean doorNorth;
  private boolean doorSouth;
}
