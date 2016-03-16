import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

public class ArraySortTest{

  Random random;
  int MAX_SIZE = 1000;   // Maximum number of elements in an array
  int ARRAYS_TO_TEST = 1000;   // Number of random arrays to test

  @Before
  public void setUp() throws Exception{
    random = new Random();
  }

  // Output (sorted) array must be same size as input (original) array
  @Test
  public void testSize(){
    for(int run = 0; run < ARRAYS_TO_TEST; run++){
      int[] original = randomArray();

      int[] sorted = copyArray(original);
      Arrays.sort(sorted);

      assertEquals(original.length, sorted.length);
    }
  }

  // Values in output (sorted) array are always increasing or staying the same
  @Test
  public void testIncreasing(){
    for(int run = 0; run < ARRAYS_TO_TEST; run++){
      int[] sorted = randomArray();
      Arrays.sort(sorted);

      boolean increasing = true;
      for(int i = 1; (i < sorted.length && increasing); i++){
        if(sorted[i-1] > sorted[i]){
          increasing = false;
        }
      }

      assertTrue(increasing);
    }
  }

  // Reversed values in output (sorted) array are always decreasing or staying the same
  @Test
  public void testDecreasing(){
    for(int run = 0; run < ARRAYS_TO_TEST; run++){
      int[] sorted = randomArray();
      Arrays.sort(sorted);

      boolean decreasing = true;
      for(int i = (sorted.length-1); (i > 0 && decreasing); i--){
        if(sorted[i] < sorted[i-1]){
          decreasing = false;
        }
      }
      
      assertTrue(decreasing);
    }
  }

 // Every element in input (original) array is in the output (sorted) array
  @Test
  public void testIdentical(){
    for(int run = 0; run < ARRAYS_TO_TEST; run++){
      int[] original = randomArray();
      ArrayList<Integer> originals = copyArrayList(original);

      int[] sorted = copyArray(original);
      Arrays.sort(sorted);

      boolean identical = (original.length == sorted.length) ? true : false;
      for(int i = 0; (i < sorted.length && identical); i++){
        int found = originals.indexOf(sorted[i]);
        if(found == -1){
          identical = false;
        } else {
          originals.remove(found);
        }
      }

      assertTrue(identical);
    }
  }

  // Running it again should not change the output (sorted) array
  @Test
  public void testIdempotent(){
    for(int run = 0; run < ARRAYS_TO_TEST; run++){
      int[] sortedFirst = randomArray();
      int[] sortedSecond = copyArray(sortedFirst);

      Arrays.sort(sortedFirst);
      Arrays.sort(sortedSecond);

      assertArrayEquals(sortedFirst, sortedSecond);
    }
  }

  // Running it twice on the same input array should always result in the same output (sorted) array
  @Test
  public void testPure(){
    for(int run = 0; run < ARRAYS_TO_TEST; run++){
      int[] sortedTwice = randomArray();
      Arrays.sort(sortedTwice);

      int[] sortedOnce = copyArray(sortedTwice);
      Arrays.sort(sortedTwice);

      assertArrayEquals(sortedOnce, sortedTwice);
    }
  }

  // Generate a random array of a random size
  private int[] randomArray(){
    int n = random.nextInt(MAX_SIZE);
    int[] a = new int[n];

    for(int i = 0; i < n; i++){
      a[i] = random.nextInt();
    }

    return a;
  }

  // Copy a given array into another array
  private int[] copyArray(int[] a){
    int n = a.length;
    int[] b = new int[n];

    for(int i = 0; i < n; i++){
      b[i] = a[i];
    }

    return b;
  }

  // Copy a given array into an ArrayList
  private ArrayList<Integer> copyArrayList(int[] a){
    int n = a.length;
    ArrayList<Integer> b = new ArrayList<Integer>();

    for(int i = 0; i < n; i++){
      b.add(a[i]);
    }

    return b;
  }

  public static void main(String args[]){
    org.junit.runner.JUnitCore.main("ArraySortTest");
  }

}
