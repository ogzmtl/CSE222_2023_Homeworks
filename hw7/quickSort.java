public class quickSort extends sort {
    
    public quickSort(){
        //intentionally empty
    }

    public quickSort(myMap originalMap)
    {
        super(originalMap);
    }


    public void QuickSort()
    {
        quickSortHelper(0, originalMap.getMapSize()-1);
        buildSortedMap();
    }

    private void quickSortHelper(int left, int rigth)
    {
        if(left < rigth)
        {
            int pivotIndex = partition(left, rigth);
            quickSortHelper(left, pivotIndex-1);
            quickSortHelper(pivotIndex+1, rigth);
        }
    }

    private int partition(int left, int rigth)
    {

        String pivot = aux.get(0);
        int up = left;
        int down = rigth; 

        do{
            while(originalMap.getMap().get(pivot).getCount() >= originalMap.getMap().get(aux.get(up)).getCount()&& up < rigth)
            {
                up++;
            }
            while(originalMap.getMap().get(pivot).getCount() < originalMap.getMap().get(aux.get(down)).getCount())
            {
                down--;
            }    
            if(up < down)
            {
                swap(up, down);
            }
        }while(up<down);
        swap(left, down);
        return down;
    }

    private void swap(int left, int right)
    {
        String temp = aux.get(left);
        aux.set(left, aux.get(right));
        aux.set(right, temp);
    }
}
