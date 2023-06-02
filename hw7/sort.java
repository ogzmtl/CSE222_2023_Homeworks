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

    public myMap reverseSorted()
    {   
        myMap reverse = new myMap(); 
        reverse = (myMap) originalMap.clone();
        reverse.getMap().clear();
        for(int i = originalMap.getMapSize()-1; i >=0; i--){
            reverse.getMap().put(aux.get(i), sortedMap.getMap().get(aux.get(i)));
        }
        return reverse;
    }
    public myMap getSortedMap(){
        return sortedMap;
    }





}
