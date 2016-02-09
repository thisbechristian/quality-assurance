import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)

// classes to test
@Suite.SuiteClasses(
  { TestPlayer.class,
    TestRoom.class,
    TestHouse.class
  }
)

public class TestSuite {
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("TestSuite");
  }
}
