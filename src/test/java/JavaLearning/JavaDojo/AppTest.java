package JavaLearning.JavaDojo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        App app = new App();
        String str = app.output("default");
    	assertTrue( "tluafed".equals(str) );
    	str = app.output("");
    	assertTrue("".equals(str));
    	str = app.output(null);
    	assertTrue("".equals(str));
    	str = app.output("default app for starter");
    	assertTrue("tluafed ppa rof retrats".equals(str));
    }
}
