package asia.sonix.newsampleunittestapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Settings;
import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;

public class SQLiteStockDaoTest extends AndroidTestCase {

    private SQLiteDatabase mDatabase;

    @Before
    public void setUp() throws Exception {
        super.setUp();

        Context context = new RenamingDelegatingContext(getContext(), "test_");
        AppOpenHelper helper = new AppOpenHelper(context);
        mDatabase = helper.getWritableDatabase();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();

        mDatabase.close();
    }

    // テストデータ登録メソッド
    private void prepareData() {
        final String SQL = "insert into stock(name, price, createdAt) values(?,?,?)";
        mDatabase.execSQL(
                SQL,
                new String[] { "Google Nexus One", "5000", String.valueOf(System.currentTimeMillis()) });
        mDatabase.execSQL(
                SQL,
                new String[] { "Google Nexus S", "10000", String.valueOf(System.currentTimeMillis()) });
        mDatabase.execSQL(
                SQL,
                new String[] { "Google Galaxy S3", "20000", String.valueOf(System.currentTimeMillis()) });
    }

    @Test
    public void testデータベースにデータを追加する() {
        prepareData();

        StockDao dao = new SQLiteStockDao(mDatabase);
        Stock stock = new Stock();
        stock.setName("Galaxy Nexus");
        stock.setPrice(Integer.valueOf(2000));

        long now = System.currentTimeMillis();
        stock.setCreatedAt(new Date(now));

        dao.add(stock);

        Cursor cursor = mDatabase.rawQuery("select * from stock where name='Galaxy Nexus'", null);
        if (!cursor.moveToNext()) {
            fail("追加できていればレコードは存在する");
        }

        assertEquals("IDはインクリメントされている", 4, cursor.getInt(0));
        assertEquals("名前が登録されている", "Galaxy Nexus", cursor.getString(1));
        assertEquals("価格が登録されている", 2000, cursor.getInt(2));
        assertEquals("作成日時が登録されている", now, cursor.getLong(3));
    }

    @Test
    public void testAdd() throws Exception {

    }

    @Test
    public void testFindByName() throws Exception {
        prepareData();

        StockDao dao = new SQLiteStockDao(mDatabase);
        List<Stock> stocks = dao.findByName("Nexus");
        assertEquals("検索結果数を取得する", 2, stocks.size());

        Stock first = stocks.get(0);
        assertEquals("IDがNexus One", 1, first.getId().intValue());
        assertTrue("名前にNexusが含まれている", first.getName().contains("Nexus"));
        assertEquals("価格がNexus One", 5000, first.getPrice().intValue());

        Stock second = stocks.get(1);
        assertEquals("IDがNexus S", 2, second.getId().intValue());
        assertTrue("名前にNexusが含まれている", second.getName().contains("Nexus"));
        assertEquals("価格がNexus S", 10000, second.getPrice().intValue());
    }

    @Test
    public void testToStock() throws Exception {

    }
}