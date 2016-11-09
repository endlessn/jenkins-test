package asia.sonix.newsampleunittestapp;

import android.test.AndroidTestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Calendar;
import java.util.TimeZone;

import static org.junit.Assert.*;

public class Example2243Test extends AndroidTestCase {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    Calendar mockCalendar;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetNow() throws Exception {

    }

    @Test
    public void testGetNow_モックを使用して時刻を得るテスト() {
        // Calendar#getTimeInMillis()が返す時刻
        final long EXPECTED_TIME = 100L;

        // Calendarのスタブを作成
        Calendar stubCalendar = Mockito.mock(Calendar.class);

        // スタブのgetTimeInMills()が常に100を返すように定義する
        Mockito.when(stubCalendar.getTimeInMillis()).thenReturn(EXPECTED_TIME);

        // テスト対象にスタブをセット
        Example2243 sut = new Example2243();
        sut.mCurrentCalender = stubCalendar;

        // getNow()から、スタブが返すのと同じ時刻が返されることを検証
        assertEquals(EXPECTED_TIME, sut.getNow());
    }

    @Test
    public void testInclementHour_関節出力を検証するテスト() {
        // Calendarのモックオブジェクトを作成
        //Calendar mockCalendar = Mockito.mock(Calendar.class);

        // テスト対象にモックをセット
        Example2243 sut = new Example2243();
        sut.mCurrentCalender = mockCalendar;

        // テスト対象メソッドの呼び出し
        sut.inclementHour();

        // 関節出力を検証
        Mockito.verify(mockCalendar).add(Calendar.HOUR_OF_DAY, 1);

        Calendar IAmMockCalendar = Mockito.mock(Calendar.class);
        Example2243 example2243 = new Example2243();
        example2243.mCurrentCalender = IAmMockCalendar;
        example2243.inclementHour();
        Mockito.verify(IAmMockCalendar).add(Calendar.HOUR_OF_DAY, 1);
    }

    @Test
    public void testSetTo0OclockJst_メソッド呼び出し順を検証() {
        // Calendarのモックオブジェクトを作成
        // Calendar mockCalendar = Mockito.mock(Calendar.class);

        // テスト対象にモックをセット
        Example2243 sut = new Example2243();
        sut.mCurrentCalender = mockCalendar;

        // テスト対象メソッドの呼び出し
        sut.setTo0OclockJst();

        // メソッド呼び出し順を検証
        InOrder inOrder = Mockito.inOrder(mockCalendar);
        inOrder.verify(mockCalendar).setTimeZone(TimeZone.getTimeZone("JST"));
        inOrder.verify(mockCalendar).set(Calendar.HOUR_OF_DAY, 0);
        inOrder.verify(mockCalendar).set(Calendar.MINUTE, 0);
        inOrder.verify(mockCalendar).set(Calendar.SECOND, 0);
        inOrder.verify(mockCalendar).set(Calendar.MILLISECOND, 0);
    }

}