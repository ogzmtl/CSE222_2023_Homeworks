public class test {
    public static void main(String[] args) {

        //'Hush, hush!' whispered the rushing wind.
        //Buzzing bees buzz.
        //'Lorem ipsum dolor sit amet. Est autem ipsa rem animi impedit et dicta eaque et natus molestias et itaque voluptatem. Aut illo totam et accusamus eveniet in fugit molestiae id recusandae culpa sit similique laboriosam in necessitatibus eius id aliquid illum!Aut obcaecati tempore est porro quia aut nisi culpa aut veritatis autem non similique aperiam sit omnis totam et quam nihil! Ut molestias quae aut sunt exercitationem id fugiat harum. Est quia blanditiis ea impedit maxime sed veniam enim hic sint possimus ab eaque dolor et distinctio omnis? Ad odio praesentium et voluptas officiis ut quia laudantium aut praesentium modi in beatae earum ex quis laudantium aut consequatur voluptatem.Eum veniam quia et voluptate repellat ut dignissimos quisquam et ratione dolor? Rem nihil perspiciatis et incidunt recusandae est voluptatum ipsa aut atque voluptas. 
        //'Huasdfghjkl;'qwertyuiop[]zxcvbnm,./zxcvbnm,./asdfghjkl;qwertyuiopsh, hush!' whispered the rushing wind.abcx, asdafh,fgh fgh f, hgljk rte .uy,iuyi.poqw[e [[ p][p[qriouhyh.,j yioa>bmb nz,]]]]
        String word = "'aasdfghjk asdfghjkl;'zxcvbnm, zxcvbnm qwrtyuio qwertyuiop asdfghjkl zxcvbnm,.Hush, hush!' whispered the rushing wind.";        
        // String word2 = "Buzzing bees buzz.";
        // String word3 = "'Hush, hush!' whispered the rushing wind.";
        // String word4 = "asdaskjg aksj kldj irtop i am,mcmnvx a ]a [p adf igofg ]";
        try {
            System.out.println("\nOriginal String: "+word);
            word = word.toLowerCase();
            word = word.replaceAll("[^a-z ]", "");
            System.out.println("PreProcessed String: "+ word+"\n\n");
            // System.out.println("\nOriginal String: "+word2);
            // word2 = word2.toLowerCase();
            // word2 = word2.replaceAll("[^a-z ]", "");
            // word3 = word3.toLowerCase();
            // word3 = word3.replaceAll("[^a-z ]", "");
            // word4 = word4.toLowerCase();
            // word4 = word4.replaceAll("[^a-z ]", "");
            myMap lHasMap = new myMap(word);
            lHasMap.createMap();
            // myMap lHasMap2 = new myMap(word2);
            // lHasMap2.createMap();
            // myMap lHasMap3 = new myMap(word3);
            // lHasMap3.createMap();
            // myMap lHasMap4 = new myMap(word4);
            // lHasMap4.createMap();
            System.out.println("The original (unsorted) map:");
            // System.out.println(lHasMap);
            System.out.println("\n");

            
            double startTime = System.currentTimeMillis();
            // for(int i = 0; i < 1; i++){
                // myMap newClone = (myMap)lHasMap.clone();
                // runtimeAnalysisMergeSort(lHasMap);
                // runtimeAnalysisMergeSort(lHasMap2);
                // runtimeAnalysisMergeSort(lHasMap3);
                // runtimeAnalysisMergeSort(lHasMap4); // 31818

                // runtimeAnalysisInsertionSort(lHasMap);
                // runtimeAnalysisInsertionSort(lHasMap2);
                // runtimeAnalysisInsertionSort(lHasMap3);
                // runtimeAnalysisInsertionSort(lHasMap4); 
                // runtimeAnalysisQuickSort(newClone); //3977
                // runtimeAnalysisInsertionSort(newClone); //3575
                // runtimeAnalysisSelectionSort(lHasMap); //3364
                // runtimeAnalysisBubbleSort(lHasMap); //5290
                // System.out.println(lHasMap);
            // }
            double stopTime = System.currentTimeMillis();
            double time = (double) (stopTime - startTime);
            System.out.println("Quick Sort total time : " + time); 
            


            // MergeSort mmm = new MergeSort(lHasMap);
            // mmm.sortt();
            // System.out.println();
            // // mergeSort msort = new mergeSort(lHasMap);
            // // msort.MergeSort();
            // System.out.println("The sorted map:");
            // System.out.println(mmm.getSortedMap());

            // System.out.println("SELECTION SORT");
            // selectionSort sSort = new selectionSort(lHasMap);
            // sSort.SelectionSort();
            // System.out.println(sSort.getSortedMap());
            
            // System.out.println("\nINSERTION SORT");
            // insertionSort iSort = new insertionSort(lHasMap);
            // iSort.InsertionSort();
            // System.out.println(iSort.getSortedMap());

            // System.out.println("\nBUBBLE SORT");
            // bubbleSort bSort = new bubbleSort(lHasMap);
            // bSort.BubbleSort();
            // System.out.println(bSort.getSortedMap());

            // System.out.println("\nQUICK SORT");
            // quickSort qSort = new quickSort(lHasMap);
            // qSort.QuickSort();
            // System.out.println(qSort.getSortedMap());


        }catch (CloneNotSupportedException e) {
            System.out.println("CloneNotSupportedException when creating a clone of original map to sorted map");
            e.printStackTrace();
        }catch (Exception e) {
            System.out.println("String is empty or null");
            e.printStackTrace();
        }

    }

    public static void runtimeAnalysisMergeSort(myMap map) throws CloneNotSupportedException
    {
 
            MergeSort msort = new MergeSort(map);
            msort.sortt();
            // System.out.println("The sorted map:");
            // System.out.println(msort.getSortedMap());


    }
    public static void runtimeAnalysisSelectionSort(myMap map) throws CloneNotSupportedException
    {
        // double startTime = System.currentTimeMillis();
  
            selectionSort ssort = new selectionSort(map);
            ssort.SelectionSort();
            // System.out.println("The sorted map:");
            // System.out.println(msort.getSortedMap());
        // double stopTime = System.currentTimeMillis();
        // double time = (double) (stopTime - startTime);
        // System.out.println("Selection sort total time: "+ time); 
    }
    public static void runtimeAnalysisInsertionSort(myMap map) throws CloneNotSupportedException
    {
 
            insertionSort isort = new insertionSort(map);
            isort.InsertionSort();
            // System.out.println("The sorted map:");
            // System.out.println(msort.getSortedMap());

        // double stopTime = System.currentTimeMillis();
        // double time = (double) (stopTime - startTime);
        // System.out.println("Insertion sort total time: " + time); 
    }
    public static void runtimeAnalysisQuickSort(myMap map) throws CloneNotSupportedException
    {
        // double startTime = System.currentTimeMillis();
 
            quickSort qsort = new quickSort(map);
            qsort.QuickSort();
            // System.out.println("The sorted map:");
            // System.out.println(msort.getSortedMap());
        // double stopTime = System.currentTimeMillis();
        // double time = (double) (stopTime - startTime);
        // System.out.println("Quick sort total time: " + time); 
    }
    public static void runtimeAnalysisBubbleSort(myMap map) throws CloneNotSupportedException
    {
 
            bubbleSort msort = new bubbleSort(map);
            msort.BubbleSort();
            // System.out.println("The sorted map:");
            // System.out.println(msort.getSortedMap());


    }
}
