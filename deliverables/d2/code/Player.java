public class Player{
  // constructor
  public Player(){
    this.numberOfItems = 0;
    this.hasCoffee = false;
    this.hasCream = false;
    this.hasSugar = false;
  }

  // public methods
  public int showInventory(){
    StringBuilder s = new StringBuilder();
    if(hasCoffee){
      s.append("You have a cup of delicious coffee. \n");
    } else{
      s.append("YOU HAVE NO COFFEE! \n");
    }
    if(hasCream){
      s.append("You have some fresh cream. \n");
    } else{
      s.append("YOU HAVE NO CREAM! \n");
    }
    if(hasSugar){
      s.append("You have some tasty sugar. \n");
    } else{
      s.append("YOU HAVE NO SUGAR! \n");
    }
    System.out.print(s.toString());
    return numberOfItems;
  }

  public boolean drink(){
    boolean win = false;
    StringBuilder s = new StringBuilder();
    if(numberOfItems == 0){
      s.append("You drink the air, as you have no coffee, sugar, or cream. \n");
      s.append("The air is invigorating, but not invigorating enough.  You cannot study. \n");
      s.append("You lose!");
    } else if(numberOfItems == 1){
      if(hasCream){
        s.append("You drink the cream, but without caffeine, you cannot study. \n");
      } else if(hasCoffee){
        s.append("Without cream, you get an ulcer and cannot study. \n");
      } else if(hasSugar){
        s.append("You eat the sugar, but without caffeine, you cannot study. \n");
      }
      s.append("You lose!");
    } else if(numberOfItems == 2){
      if(hasCoffee && hasCream){
        s.append("Without sugar, the coffee is too bitter.  You cannot study. \n");
      } else if(hasCoffee && hasSugar){
        s.append("Without cream, you get an ulcer and cannot study. \n");
      } else if(hasCream && hasSugar){
        s.append("You drink the sweetened cream, but without caffeine, you cannot study. \n");
      }
      s.append("You lose!");
    } else{
      s.append("You drink the beverage and are ready to study! \n");
      s.append("You win!");
      win = true;
    }
    System.out.println(s.toString());
    return win;
  }

  public int addCoffee(){
    duplicateCheck(hasCoffee);
    this.hasCoffee = true;
    System.out.println("There might be something here...");
    System.out.println("You found some caffeinated coffee!");
    return numberOfItems;
  }

  public int addCream(){
    duplicateCheck(hasCream);
    this.hasCream = true;
    System.out.println("There might be something here...");
    System.out.println("You found some creamy cream!");
    return numberOfItems;
  }

  public int addSugar(){
    duplicateCheck(hasSugar);
    this.hasSugar = true;
    System.out.println("There might be something here...");
    System.out.println("You found some sweet sugar!");
    return numberOfItems;
  }

  // private methods
  private void duplicateCheck(boolean alreadyAdded){
    if(!alreadyAdded){
      numberOfItems++;
    }
  }

  // fields
  private int numberOfItems;
  private boolean hasCoffee;
  private boolean hasCream;
  private boolean hasSugar;
}
