public class test {
    public static void main(String[] args) {

        //'Hush, hush!' whispered the rushing wind.
        //Buzzing bees buzz.
        String word = "'Hush, hush!' whispered the rushing wind.";        
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
            System.out.println("The sorted map:");
            System.out.println(msort.getSortedMap());

            System.out.println("SELECTION SORT");
            selectionSort sSort = new selectionSort(lHasMap);
            sSort.SelectionSort();
            System.out.println(sSort.getSortedMap());
            
            System.out.println("\nINSERTION SORT");
            insertionSort iSort = new insertionSort(lHasMap);
            iSort.InsertionSort();
            System.out.println(iSort.getSortedMap());

            System.out.println("\nBUBBLE SORT");
            bubbleSort bSort = new bubbleSort(lHasMap);
            bSort.BubbleSort();
            System.out.println(bSort.getSortedMap());

            System.out.println("\nQUICK SORT");
            quickSort qSort = new quickSort(lHasMap);
            qSort.QuickSort();
            System.out.println(qSort.getSortedMap());


        }catch (CloneNotSupportedException e) {
            System.out.println("CloneNotSupportedException when creating a clone of original map to sorted map");
            e.printStackTrace();
        }catch (Exception e) {
            System.out.println("String is empty or null");
            e.printStackTrace();
        }

    }
}
