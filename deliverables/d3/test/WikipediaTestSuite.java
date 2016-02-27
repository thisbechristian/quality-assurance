import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)

// classes to test
@Suite.SuiteClasses(
  { WikipediaNavigationTest.class,
    WikipediaSearchTest.class,
    WikipediaHomeTest.class,
    WikipediaHomeArticleTest.class,
    WikipediaLoginTest.class,
  }
)

public class WikipediaTestSuite {
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("WikipediaTestSuite");
  }
}
