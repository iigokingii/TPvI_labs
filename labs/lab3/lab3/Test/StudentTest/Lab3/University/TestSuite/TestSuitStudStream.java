package Lab3.University.TestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import Lab3.University.StreamTE.StreamTest;
import Lab3.University.StudentTE.StudentTest;

@RunWith(value=Suite.class)
@Suite.SuiteClasses(value={StudentTest.class, StreamTest.class})
public class TestSuitStudStream {

}
