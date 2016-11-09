package asia.sonix.newsampleunittestapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class PrintHogeTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testPrintLowerCase_正常値() throws Exception {
        PrintHoge printHoge = new PrintHoge();
        String hoge = printHoge.printLowerCase("Hoge");
        assertThat(hoge, is("hoge|hoge"));
    }

    @Test(expected = NullPointerException.class)
    public void testPrintLowerCase_Null指定() throws Exception {
        PrintHoge printHoge = new PrintHoge();
        printHoge.printLowerCase(null);
    }

    @Test
    public void testPrintLowerCase_hoo指定() {
        PrintHoge printHoge = new PrintHoge();
        try {
            printHoge.printLowerCase("hoo");
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage(), is("hoo"));
        }
    }

    

}