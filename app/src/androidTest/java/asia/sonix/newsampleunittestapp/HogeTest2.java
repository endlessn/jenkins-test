package asia.sonix.newsampleunittestapp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class HogeTest2 {

    @Mock(name = "nameList")
    private List list;

    @InjectMocks
    private Hoge hoge = new Hoge();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testDoSomething() throws Exception {

    }
}