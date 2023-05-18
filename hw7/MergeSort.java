import java.util.List;
import java.util.Map;

public class MergeSort extends sort{


	public MergeSort(myMap originalMap) {
		super(originalMap);
	}

	public void merge(int l, int m, int r){
		int n1 = m - l + 1;
	    int n2 = r - m;

	    int L[] = new int[n1];
	    String Left[] = new String[n1];
	    int R[] = new int[n2];
	    String Right[] = new String[n2];

	    for (int i = 0; i < n1; ++i) {
	       L[i] = originalMap.getMap().get(((List<String>) this.aux).get(l + i)).getCount() ;
	       Left[i] = this.aux.get(l + i);
	    }
	    for (int j = 0; j < n2; ++j) {
	    	R[j] = originalMap.getMap().get(((List<String>) this.aux).get(m + 1 + j)).getCount() ;
	    	Right[j] = this.aux.get(m + 1 + j);
	    }

	 
	    int i = 0, j = 0;
	    int k = l;
	    while (i < n1 && j < n2) {
	    	if (L[i] <= R[j]) {
	    		aux.set(k, Left[i]);
	    		i++; 	    		
	        }
	    	
	        else {
	    		aux.set(k, Right[j]);
	        	j++;
	        }
	    	
	    	k++;
	    }
	 
	    while (i < n1) {
    		aux.set(k, Left[i]);
	    	i++;
	    	k++;
	    }
	 
	    while (j < n2) {
    		aux.set(k, Right[j]);
	    	j++;
	        k++;
	    }
	}

	private void sortHelper (int l, int r) {
		if (l < r) {
	        int m = l + (r - l) / 2;
	        sortHelper(l, m);
	        sortHelper(m + 1, r);
	        merge(l, m, r);
		}
	    
	}
	public void sortt(){		
	    sortHelper (0, this.originalMap.getMapSize() - 1);
	    buildSortedMap();
	}
	
	public void printSortedArray(){
	    for (Map.Entry<String, info> e : sortedMap.getMap().entrySet())
            System.out.println("Letter: " + e.getKey() + " - Count: "
                               + e.getValue().getCount()  + " - Words: " + e.getValue().getCount() );
	}

	public void printOriginalArray(){
	    for (Map.Entry<String, info> e : originalMap.getMap().entrySet())
            System.out.println("Letter: " + e.getKey() + " - Count: "
                               + e.getValue().getCount() + " - Words: " + e.getValue().getWords());
	}
}