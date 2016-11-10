package asia.sonix.newsampleunittestapp;

import org.junit.Test;

import static org.junit.Assert.*;

public class SampleTest {

    @Test
    public void testNum() throws Exception {
        assertEquals(10, Sample.num());
        assertEquals("10じゃない",10, Sample.num());
    }
}