package asia.sonix.newsampleunittestapp;





public class PrintHoge {
    public String printLowerCase(String hoge) throws Exception {
        if (hoge.equals("hoo")) {
            throw new Exception("hoo");
        }
        return "hoge|" + hoge.toLowerCase();
    }
}
