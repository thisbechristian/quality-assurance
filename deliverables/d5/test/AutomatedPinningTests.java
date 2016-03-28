import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.lang.reflect.*;

public class AutomatedPinningTests{

  int SIZE = 10; // size of the NxN matrix for Conway's Game of Life

  @Before
  public void setUp() throws Exception{
  }

  // toString Pinning Tests
  // *****************************************************************************************************
  @Test
  public void toStringTestMutatorDead(){
    Cell cell = new Cell();
    cell.setAlive(false);
    String result = cell.toString();
    assertEquals(result,".");
  }

  @Test
  public void toStringTestMutatorAlive(){
    Cell cell = new Cell();
    cell.setAlive(true);
    String result = cell.toString();
    assertEquals(result,"X");
  }

  @Test
  public void toStringTestConstructorDead(){
    Cell cell = new Cell(false);
    String result = cell.toString();
    assertEquals(result,".");
  }

  @Test
  public void toStringTestConstructorAlive(){
    Cell cell = new Cell(true);
    String result = cell.toString();
    assertEquals(result,"X");
  }
  // *****************************************************************************************************

  // convertToInt Pinning Tests
  // *****************************************************************************************************
  @Test
  public void convertToIntTestPositive(){
    try{
      Random random = new Random();
      int input = Math.abs(random.nextInt(Integer.MAX_VALUE));
      MainPanel mainPanel = new MainPanel(SIZE);
      Method convertToInt = MainPanel.class.getDeclaredMethod("convertToInt", int.class);
      convertToInt.setAccessible(true);
      int output = (int) convertToInt.invoke(mainPanel, input);
      assertEquals(output,input);
    } catch(Exception ex){
      fail();
    }
  }

  @Test
  public void convertToIntTestZero(){
    try{
      int input = 0;
      MainPanel mainPanel = new MainPanel(SIZE);
      Method convertToInt = MainPanel.class.getDeclaredMethod("convertToInt", int.class);
      convertToInt.setAccessible(true);
      int output = (int) convertToInt.invoke(mainPanel, input);
      assertEquals(output,input);
    } catch(Exception ex){
      fail();
    }
  }

  @Test
  public void convertToIntTestNegative(){
    try{
      Random random = new Random();
      int input = Math.abs(random.nextInt(Integer.MAX_VALUE))*-1;
      MainPanel mainPanel = new MainPanel(SIZE);
      Method convertToInt = MainPanel.class.getDeclaredMethod("convertToInt", int.class);
      convertToInt.setAccessible(true);
      int output = (int) convertToInt.invoke(mainPanel, input);
      assertEquals(output,input);
    } catch(Exception ex){
      fail();
    }
  }
  // *****************************************************************************************************

  public static void main(String args[]){
    org.junit.runner.JUnitCore.main("AutomatedPinningTests");
  }

}
