package asia.sonix.newsampleunittestapp;


import org.mockito.Mockito;

import java.util.Calendar;
import java.util.TimeZone;

public class Example2243 {
    Calendar mCurrentCalender = Calendar.getInstance();

    //　現在日時をミリ秒で返す
    public long getNow() {
        return mCurrentCalender.getTimeInMillis();
    }

    // 保持時刻を１時間進める
    public void inclementHour() {
        mCurrentCalender.add(Calendar.HOUR_OF_DAY, 1);
    }

    // 時刻を日本時間の00:00:00にセットする
    public void setTo0OclockJst() {
        mCurrentCalender.setTimeZone(TimeZone.getTimeZone("JST"));
        mCurrentCalender.set(Calendar.HOUR_OF_DAY, 0);
        mCurrentCalender.set(Calendar.MINUTE, 0);
        mCurrentCalender.set(Calendar.SECOND, 0);
        mCurrentCalender.set(Calendar.MILLISECOND, 0);
    }
}
