package asia.sonix.newsampleunittestapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class SQLiteStockDao implements StockDao {

    private SQLiteDatabase mDatabase;

    public SQLiteStockDao(SQLiteDatabase database) {
        this.mDatabase = database;
    }

    @Override
    public void add(Stock stock) {
        if (stock == null) {
            throw new NullPointerException("stock must not be null");
        }

        ContentValues values = new ContentValues();
        values.put("name", stock.getName());
        values.put("price", stock.getPrice());
        values.put("createdAt", stock.getCreatedAt().getTime());
        // SQLiteには日付型がないのでミリ秒(long)で登録

        mDatabase.insert("stock", "", values);
    }

    @Override
    public List<Stock> findByName(String name) {
        if (name == null) {
            throw new NullPointerException("name must not be null");
        }

        List<Stock> stocks = new ArrayList<Stock>();
        // 記号が含まれていても部分検索を行えるようにエスケープ処理を行う
        Cursor cursor = mDatabase.rawQuery( "select _id, name, price, createdAt from stock where name like ? escape '$' order by _id",
                new String[] { "%" + name.replaceAll("[$_%]", "\\$$0") + "%" });
        try {
            // 取得できるデータをすべてオブジェクトに変換する
            while (cursor.moveToNext()) {
                Stock stock = toStock(cursor);
                stocks.add(stock);
            }
            return stocks;

        } finally {
            cursor.close();
        }
    }

    protected Stock toStock(Cursor cursor) {
        int col = 0;
        Stock stock = new Stock();
        stock.setId(cursor.getInt(col++));
        stock.setName(cursor.getString(col++));
        stock.setPrice(cursor.getInt(col++));
        stock.setCreatedAt(new Date(cursor.getLong(col++)));

        return stock;
    }
}

