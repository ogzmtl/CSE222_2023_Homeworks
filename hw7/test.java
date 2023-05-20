public class test {
    public static void main(String[] args) {

        //'Hush, hush!' whispered the rushing wind.
        //Buzzing bees buzz.
        //'Lorem ipsum dolor sit amet. Est autem ipsa rem animi impedit et dicta eaque et natus molestias et itaque voluptatem. Aut illo totam et accusamus eveniet in fugit molestiae id recusandae culpa sit similique laboriosam in necessitatibus eius id aliquid illum!Aut obcaecati tempore est porro quia aut nisi culpa aut veritatis autem non similique aperiam sit omnis totam et quam nihil! Ut molestias quae aut sunt exercitationem id fugiat harum. Est quia blanditiis ea impedit maxime sed veniam enim hic sint possimus ab eaque dolor et distinctio omnis? Ad odio praesentium et voluptas officiis ut quia laudantium aut praesentium modi in beatae earum ex quis laudantium aut consequatur voluptatem.Eum veniam quia et voluptate repellat ut dignissimos quisquam et ratione dolor? Rem nihil perspiciatis et incidunt recusandae est voluptatum ipsa aut atque voluptas. 
        //'Huasdfghjkl;'qwertyuiop[]zxcvbnm,./zxcvbnm,./asdfghjkl;qwertyuiopsh, hush!' whispered the rushing wind.abcx, asdafh,fgh fgh f, hgljk rte .uy,iuyi.poqw[e [[ p][p[qriouhyh.,j yioa>bmb nz,]]]]
        String word = "Buzzing bees buzz.";        
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


            MergeSort mmm = new MergeSort(lHasMap);
            mmm.sortt();
            myMap sorted = (myMap) mmm.getSortedMap().clone();
            System.out.println();
            System.out.println("The sorted map:");
            System.out.println(mmm.getSortedMap());

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

    public static myMap runtimeAnalysisMergeSort(myMap map) throws CloneNotSupportedException
    {
        MergeSort msort = new MergeSort(map);
        double startTime = System.currentTimeMillis();
        for(int i = 0; i < 1; i++){
                msort = new MergeSort(map);
                msort.sortt();
            }
            double stopTime = System.currentTimeMillis();
            double time = (double) (stopTime - startTime);
            System.out.println("Merge Sort total time : " + time); 
            return msort.getSortedMap();
    }

    public static myMap runtimeAnalysisSelectionSort(myMap map) throws CloneNotSupportedException
    {
        selectionSort ssort = new selectionSort(map);
        // double startTime = System.currentTimeMillis();
        double startTime = System.currentTimeMillis();
        for(int i = 0; i < 1; i++){
            ssort = new selectionSort(map);
            ssort.SelectionSort();
        }
        double stopTime = System.currentTimeMillis();
        double time = (double) (stopTime - startTime);
        System.out.println("Selection Sort total time : " + time); 
        return ssort.getSortedMap();
    }

    public static myMap runtimeAnalysisInsertionSort(myMap map) throws CloneNotSupportedException
    {
        insertionSort isort = new insertionSort(map);
        double startTime = System.currentTimeMillis();
        for(int i = 0; i < 1; i++){
            isort = new insertionSort(map);
            isort.InsertionSort();
        }
        double stopTime = System.currentTimeMillis();
        double time = (double) (stopTime - startTime);
        System.out.println("Insert Sort total time : " + time); 
        return isort.getSortedMap();
    }

    public static myMap runtimeAnalysisQuickSort(myMap map) throws CloneNotSupportedException
    {
        quickSort qsort = new quickSort(map);
        // double startTime = System.currentTimeMillis();
        double startTime = System.currentTimeMillis();
        for(int i = 0; i < 1; i++){
            qsort = new quickSort(map);
            qsort.QuickSort();
        }
        double stopTime = System.currentTimeMillis();
        double time = (double) (stopTime - startTime);
        System.out.println("Quick Sort total time : " + time); 
        return qsort.getSortedMap();
    }

    public static myMap runtimeAnalysisBubbleSort(myMap map) throws CloneNotSupportedException
    {
        bubbleSort msort = new bubbleSort(map);
        double startTime = System.currentTimeMillis();
        for(int i = 0; i < 1; i++){
            msort = new bubbleSort(map);
            msort.BubbleSort();
        }
        double stopTime = System.currentTimeMillis();
        double time = (double) (stopTime - startTime);
        System.out.println("Bubble Sort total time : " + time); 
        return msort.getSortedMap();
    }
}
