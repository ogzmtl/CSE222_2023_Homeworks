import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class mergeSort{

    private static final String List = null;
    private myMap originalMap;
    private myMap sortedMap;
    private String[] aux;

    public mergeSort(myMap originalMap) throws CloneNotSupportedException
    {
        this.originalMap = originalMap;
        this.sortedMap = (myMap)originalMap.clone();
    }   
    
    public void MergeSort()
    {
        List<Map.Entry<String, info>> listKeyPair = new ArrayList<>(originalMap.getMap().entrySet());
        aux = new String[originalMap.getMapSize()];
        sort(listKeyPair, 0, originalMap.getMapSize()-1);
    }

    private void sort(List<Map.Entry<String, info>>keyList, int left, int right)
    {
        if(left < right){
            int middle = left + (right - left)/2;

            sort(keyList, left, middle);
            sort(keyList, middle+1, right);
            merge(keyList, left, middle, right);
        }

    }

    private void merge(List<Map.Entry<String, info>> keyList, int left, int middle, int right)
    {
        int sizeOfSubArray1 = middle - left + 1;
        int sizeOfSubArray2 = right - middle;
        
        // List<Map.Entry<String, info>> leftList;
        // List<Map.Entry<String, info>> rightList;
        // keyList = new ArrayList<>(sortedMap.getMap().entrySet());
        
        System.out.println(sizeOfSubArray1 + " " + sizeOfSubArray2);
        System.out.println(left + " " + middle+ " "+ right);
        System.out.println();
        int i = left;
        int j = middle + 1; 
        int k = 0;
        
        k = i;
        
        while(i < sizeOfSubArray1+left && j < sizeOfSubArray2+middle+1)
        {
            if(keyList.get(i).getValue().getCount() < keyList.get(j).getValue().getCount())
            {
                
                sortedMap.getMap().put(keyList.get(i).getKey(),keyList.get(i).getValue());
                aux[k] = keyList.get(i).getKey();
                // aux.set(k, keyList.get(i).getKey());
                i++;
                k++;
            }
            else{
                // aux.set(k, keyList.get(j).getKey());
                sortedMap.getMap().put(keyList.get(j).getKey(),keyList.get(j).getValue());
                aux[k] = keyList.get(j).getKey();
                k++;
                j++;
            }
        }

        while(i < sizeOfSubArray1+left)
        {
            sortedMap.getMap().put(keyList.get(i).getKey(),keyList.get(i).getValue());
            // aux.set(k, keyList.get(j).getKey());
            aux[k] = keyList.get(i).getKey();
            k++;
            i++;
        }
        while(j < sizeOfSubArray2+middle+1)
        {
            // aux.set(k, keyList.get(j).getKey());
            aux[k] = keyList.get(j).getKey();
            k++;
            sortedMap.getMap().put(keyList.get(j).getKey(),keyList.get(j).getValue());
            j++;
        }
    }

    public myMap getSortedMap(){
        return sortedMap;
    }

    public String[] getAux()
    {
        return aux;
    }
    
}
