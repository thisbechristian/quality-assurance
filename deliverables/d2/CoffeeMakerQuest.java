// imports
import java.util.Scanner;

public class CoffeeMakerQuest{
  public static void main(String arg[]){
    System.out.println("Coffee Maker Quest 1.0");
    System.out.println("");
    initialize();
    while(run){
      System.out.println(room.getRoomDescription());
      System.out.println("INSTRUCTIONS (N,S,L,I,D,H) > ");
      String command = input.nextLine().toLowerCase();
      run = execute(command);
      room = house.getCurrentRoom();
      System.out.println("");
    }
  }

  //functions
  private static void initialize(){
    input = new Scanner(System.in);
    player = new Player();
    house = new House();
    room = house.getCurrentRoom();
  }

  private static boolean execute(String cmd){
    if(cmd.equals("n")){
      house.moveNorth(room);
    } else if(cmd.equals("s")){
      house.moveSouth(room);
    } else if(cmd.equals("l")){
      house.look(player, room);
    } else if(cmd.equals("i")){
      player.showInventory();
    } else if(cmd.equals("d")){
      player.drink();
      return false;
    } else if(cmd.equals("h")){
      System.out.println("Command 'N' will move the player through the door facing North (only if a door exists going North).");
      System.out.println("Command 'S' will move the player through the door facing South (only if a door exists going South).");
      System.out.println("Command 'L' will cause the player to collect any items in the room and those items will be added to the player's inventory.");
      System.out.println("Command 'I' will inform the player of the items that he/she has collected (consisting of Coffee, Sugar, and Cream).");
      System.out.println("Command 'D' will cause the player to drink using only the items that have been collected by the player");
      System.out.println("Command 'H' will inform the player of a listing of all possible commands and what their effects are.");
    } else {
      System.out.println(error);
    }
    return true;
  }

  // globals
  private static Scanner input;
  private static Player player;
  private static House house;
  private static Room room;
  private static boolean run = true;
  private final static String error = "What?";
}
