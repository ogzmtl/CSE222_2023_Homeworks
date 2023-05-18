import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class mergeSort{

    private myMap originalMap;
    private myMap sortedMap;
    private String[] aux;

    /**
     * Clones the original map to the sorted map 
     * @param originalMap
     * @throws CloneNotSupportedException
     */
    public mergeSort(myMap originalMap) throws CloneNotSupportedException
    {
        this.originalMap = originalMap;
        this.sortedMap = (myMap)originalMap.clone();
    }   
    
    /**
     * This constructor is used for creating a sorted map from the original map 
     * Invokes sort method with key-value pairs
     * then build a sorted map with these key-value pairs
     */
    public void MergeSort()
    {
        List<Map.Entry<String, info>> listKeyPair = new ArrayList<>(originalMap.getMap().entrySet());
        aux = new String[originalMap.getMapSize()];
        sort(listKeyPair, 0, originalMap.getMapSize()-1);
        buildSortedMap(listKeyPair);
        // System.out.println(listKeyPair);
    }

    /**
     * common sort algorithm we divide both left and right end into two pieces 
     * we keep doing that until rigth and left is equal
     * @param keyList key-value pair in list 
     * @param left left border
     * @param right right border
     */
    private void sort(List<Map.Entry<String, info>>keyList, int left, int right)
    {
        if(left < right){
            int middle = left + (right - left)/2;

            sort(keyList, left, middle);
            sort(keyList, middle+1, right);
            merge(keyList, left, middle, right);
        }

    }

    /**
     * builds the sorted map from given key-value pairs entry list
     * @param keyList key-value pairs
     */
    private void buildSortedMap(List<Map.Entry<String, info>>keyList){
        sortedMap.getMap().clear();
        for(int i=0; i<keyList.size(); i++) {
            sortedMap.getMap().put(keyList.get(i).getKey(), keyList.get(i).getValue());
        }
    }

    /**
     * Based on the value of the count field in the corresponding Info object. This method is used in 
     * the merge sort algorithm implemented in the SortMap class.
     * This method merges two subarrays of the given keyList array.
     * The first subarray is from left to middle,
     * and the second subarray is from middle+1 to right.
     * The method assumes that these two subarrays are already sorted.
     * @param keyList
     * @param left
     * @param middle
     * @param right
     */
    private void merge(List<Map.Entry<String, info>> keyList, int left, int middle, int right)
    {
        int sizeOfSubArray1 = middle - left + 1;
        int sizeOfSubArray2 = right - middle;
        
        List<Map.Entry<String, info>> leftList = new ArrayList<Map.Entry<String, info>>();
        List<Map.Entry<String, info>> rightList = new ArrayList<Map.Entry<String, info>>();
        // keyList = new ArrayList<>(sortedMap.getMap().entrySet());

        for(int i = 0; i < sizeOfSubArray1; i++){
            leftList.add(keyList.get(left+ i));
        }
        for(int j = 0; j < sizeOfSubArray2; j++){
            rightList.add(keyList.get(middle+1+j));
        }
    
        int i = 0;
        int j = 0; 
        int k = left;
        
        while(i < sizeOfSubArray1 && j < sizeOfSubArray2)
        {
            // System.out.println("keyList i = " + keyList.get(i).getValue().getCount() + " i = " + i);
            // System.out.println("keyList j = " +sizeOfSubArray1+"key j = " +keyList.get(j).getKey()  +" j = " + j);
            // System.out.println(k +"\n");
            // System.out.println(middle);
            if(leftList.get(i).getValue().getCount() <= rightList.get(j).getValue().getCount())
            {
                // Entry<String, info> temp = keyList.get(k);
                keyList.set(k, leftList.get(i));
                // keyList.set(i, temp);
                // sortedMap.getMap().put(keyList.get(i).getKey(),keyList.get(i).getValue());
                // aux[k] = keyList.get(i).getKey();
                // aux.set(k, keyList.get(i).getKey());
                i++;
            }
            else{
                // aux.set(k, keyList.get(j).getKey());
                // Entry<String, info> temp = keyList.get(k);
                keyList.set(k, rightList.get(j));
                // keyList.set(j, temp);
                // sortedMap.getMap().put(keyList.get(j).getKey(),keyList.get(j).getValue());
                // aux[k] = keyList.get(j).getKey();
                j++;
            }
            k++;
        }

        while(i < sizeOfSubArray1)
        {
            // Entry<String, info> temp = keyList.get(k);
            keyList.set(k, leftList.get(i));
            // keyList.set(i, temp);
            // sortedMap.getMap().put(keyList.get(i).getKey(),keyList.get(i).getValue());
            // aux.set(k, keyList.get(j).getKey());
            // aux[k] = keyList.get(i).getKey();
            k++;
            i++;
        }
        while(j < sizeOfSubArray2)
        {
            // Entry<String, info> temp = keyList.get(k);
            keyList.set(k, rightList.get(j));
            // keyList.set(j, temp);
            // aux.set(k, keyList.get(j).getKey());
            // aux[k] = keyList.get(j).getKey();
            k++;
            // sortedMap.getMap().put(keyList.get(j).getKey(),keyList.get(j).getValue());
            j++;
        }
    }
/**
 * getter for sorted map 
 * @return sorted map
 */
    public myMap getSortedMap(){
        return sortedMap;
    }
    public myMap getOriginalMap(){
        return originalMap;
    }

    /**
     * getter for aux map for debugging 
     * @return aux map
     */
    public String[] getAux()
    {
        return aux;
    }
    
}
