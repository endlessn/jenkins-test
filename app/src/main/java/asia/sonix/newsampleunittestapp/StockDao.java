package asia.sonix.newsampleunittestapp;

import java.util.List;

public interface StockDao {
    /**
     * データベースに商品を登録します
     *
     * @param stock
     *              商品
     */
    void add(Stock stock);

    /**
     * データベースに登録している商品から、商品名が部分一致する商品を返却します
     *
     * @param name
     *              商品名
     * @return 一致した商品のリスト
     */
    List<Stock> findByName(String name);
}