public class bubbleSort extends sort {
    public bubbleSort() {
        // intentionally empty
    }

    public bubbleSort(myMap originalMap) {
        super(originalMap);
    }

    public void BubbleSort() {
        for (int i = 0; i < originalMap.getMapSize()-1; i++) 
        {
            for(int j = 0; j < originalMap.getMapSize()-i- 1; j++ )
            {
                int first = originalMap.getMap().get(aux.get(j)).getCount();
                int second = originalMap.getMap().get(aux.get(j+1)).getCount();
                
                if(first > second)
                {
                    String temp = aux.get(j);
                    aux.set(j, aux.get(j+1));
                    aux.set(j+1, temp);
                }
            }
        }
        buildSortedMap();
    }

}
