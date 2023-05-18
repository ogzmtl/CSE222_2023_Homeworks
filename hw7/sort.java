import java.util.ArrayList;
import java.util.List;

public class sort {
    myMap originalMap;
    myMap sortedMap; 
    List<String> aux;
    
    public sort(){
        //intentionally empty;
    }

    public sort(myMap originalMap){
        this.originalMap = originalMap;
        this.aux = new ArrayList<String>(this.originalMap.getMap().keySet());
        this.sortedMap = (myMap) originalMap.clone();
    }

    protected void buildSortedMap(){
        this.sortedMap.getMap().clear();
        for(int i = 0; i < originalMap.getMapSize(); i++){
            this.sortedMap.getMap().put(aux.get(i), originalMap.getMap().get(aux.get(i)));
        }
    }

    public myMap getSortedMap(){
        return sortedMap;
    }





}
