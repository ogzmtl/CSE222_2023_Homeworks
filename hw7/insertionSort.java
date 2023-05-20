public class insertionSort extends sort{
    
    public insertionSort(){
        //intentionally empty;
    }

    public insertionSort(myMap originalMap){
        super(originalMap);
    }
/**
    Performs insertion sort on the originalMap based on the count of elements.
    The sorting is done in ascending order.
    This method iterates through the elements of originalMap using the auxiliary list 'aux'.
    For each iteration, it selects an element and compares it with the previous elements.
    If the count of the selected element is smaller, it shifts the previous elements to make space for the selected element.
    The resulting sorted elements are stored in the auxiliary list 'aux'.
    @throws IndexOutOfBoundsException if the index is out of range (i.e., negative or greater than or equal to originalMap size).
    */
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
