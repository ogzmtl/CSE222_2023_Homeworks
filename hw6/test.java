public class test {
    public static void main(String[] args) {

        String word = "asdasd assd ASD sad <> sad";
        word = word.toLowerCase();
        word = word.replaceAll("[^a-z ]", "");
        try {
            myMap lHasMap = new myMap(word);
            lHasMap.createMap();
            System.out.println(lHasMap);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
