public class insertionSort extends sort{
    
    public insertionSort(){
        //intentionally empty;
    }

    public insertionSort(myMap originalMap){
        super(originalMap);
    }

    public void InsertionSort(){
        int first, tempIndex;
        int j = 0;
        for(int i = 1; i < originalMap.getMapSize(); i++){
            first = originalMap.getMap().get(aux.get(i)).getCount();
            tempIndex = i;
            j = i-1; 
            while(j >= 0 && originalMap.getMap().get(aux.get(j)).getCount() > first)
            {
                String temp = aux.get(tempIndex);
                aux.set(tempIndex, aux.get(j));
                aux.set(j, temp);
                tempIndex = j;
                j--;
            }
        }
        buildSortedMap();
    }
}
