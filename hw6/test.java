public class test {
    public static void main(String[] args) {

        String word = "'Hush, hush!' whispered the rushing wind.";
        System.out.println("\nOriginal String: "+word);
        word = word.toLowerCase();
        word = word.replaceAll("[^a-z ]", "");
        System.out.println("PreProcessed String: "+ word+"\n\n");
        
        try {
            myMap lHasMap = new myMap(word);
            lHasMap.createMap();
            System.out.println("The original (unsorted) map:");
            System.out.println(lHasMap);
            System.out.println("\n");
            mergeSort msort = new mergeSort(lHasMap);
            msort.MergeSort();
            System.out.println(msort.getSortedMap());
            System.out.println(msort.getAux());

            for(int i = 0; i < msort.getAux().length; i++) {
                System.out.println(msort.getAux()[i]);
            }
            // System.out.println("\n");
            // System.out.println(lHasMap);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
