public class test {
    public static void main(String[] args) {

        //'Hush, hush!' whispered the rushing wind.
        //Buzzing bees buzz.
        String word = "";        
        try {
            System.out.println("\nOriginal String: "+word);
            word = word.toLowerCase();
            word = word.replaceAll("[^a-z ]", "");
            System.out.println("PreProcessed String: "+ word+"\n\n");
            myMap lHasMap = new myMap(word);
            lHasMap.createMap();
            System.out.println("The original (unsorted) map:");
            System.out.println(lHasMap);
            System.out.println("\n");
            mergeSort msort = new mergeSort(lHasMap);
            msort.MergeSort();
            System.out.println(msort.getSortedMap());

        }catch (CloneNotSupportedException e) {
            System.out.println("CloneNotSupportedException when creating a clone of original map to sorted map");
            e.printStackTrace();
        }catch (Exception e) {
            System.out.println("String is empty or null");
            e.printStackTrace();
        }

    }
}
