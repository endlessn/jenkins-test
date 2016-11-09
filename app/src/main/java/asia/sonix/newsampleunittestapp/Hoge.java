package asia.sonix.newsampleunittestapp;


import java.util.ArrayList;
import java.util.List;

public class Hoge {

    private List<String> nameList = new ArrayList<String>();

    public void doSomething() {
        nameList.addAll(getDatabaseValues());
        System.out.println(nameList);
    }

    private List<String> getDatabaseValues() {
        // 実際はいろいろ処理する

        List<String> list = new ArrayList<String>();
        list.add("Taro");
        list.add("Jiro");
        list.add("Saburo");

        return list;
    }
}
