public class selectionSort extends sort {
    // myMap originalMap; 
    // myMap sortedMap; 
    // List<String> aux; 
    

    public selectionSort(){
        //intentionally empty
    }

    public selectionSort(myMap originalMap){

        super(originalMap);
        // this.originalMap = originalMap;
        // this.aux = new ArrayList<String>(this.originalMap.getMap().keySet());
        // this.sortedMap = (myMap)originalMap.clone();
    }

/**

    Performs selection sort on the originalMap based on the count of elements.
    The sorting is done in ascending order.
    This method iterates through the elements of originalMap using the auxiliary list 'aux'.
    For each iteration, it selects the element with the minimum count and swaps it with the current element.
    The resulting sorted elements are stored in the auxiliary list 'aux'.
    @throws IndexOutOfBoundsException if the index is out of range (i.e., negative or greater than or equal to originalMap size).
    */
    public void SelectionSort(){
        int first, second, tempIndex; 

        for(int i = 0; i < originalMap.getMapSize()-1; i++){
            first = originalMap.getMap().get(aux.get(i)).getCount();
            tempIndex = i;  
            
            for(int j = i+1; j < originalMap.getMapSize(); j++){
                second = originalMap.getMap().get(aux.get(j)).getCount();
                if(first > second){
                    tempIndex = j;
                    first = second;
                }
            }
            String temp = aux.get(i);
            aux.set(i, aux.get(tempIndex));
            aux.set(tempIndex, temp);
        }

        buildSortedMap();
    }
    // private void buildSortedMap(){
    //     this.sortedMap.getMap().clear();
    //     for(int i = 0; i < originalMap.getMapSize(); i++){
    //         this.sortedMap.getMap().put(aux.get(i), originalMap.getMap().get(aux.get(i)));
    //     }
    // }

    // public myMap getSortedMap(){
    //     return this.sortedMap;
    // }
}
