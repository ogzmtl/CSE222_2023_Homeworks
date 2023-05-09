import java.util.LinkedHashMap;
import java.util.Map;

public class myMap implements Cloneable{
    private LinkedHashMap<String, info> map = new LinkedHashMap<String, info>(); 
    private int mapSize; 
    private String str;

    public myMap(){
        
    }

    public myMap(String str) throws Exception
    {
        if(str == null || str.length() == 0)
        {
            throw new Exception();
        }
        this.str = str;
    }
    public void createMap()
    {
        String[] splitted = str.split(" ");

        for(int i = 0; i < splitted.length; i++)
        {
            for(int j = 0; j < splitted[i].length(); j++)
            {
                String parsedCharacter = (String.valueOf(splitted[i].charAt(j)));
                if(map.containsKey(parsedCharacter))
                {
                    map.get(parsedCharacter).push(splitted[i]);
                }
                else{
                    info createNewKeyValue = new info(splitted[i]);
                    map.put(parsedCharacter, createNewKeyValue );
                    mapSize++;
                }
                
            }
        }
    }

    public LinkedHashMap<String, info> getMap()
    {
        return map;
    }

    public int getMapSize()
    {
        return mapSize;
    }
    
    @Override
    public String toString()
    {
        String str = "";
        for(Map.Entry<String, info> Entry: map.entrySet())
        {
            str += ("Letter: " + Entry.getKey() +" - ");
            str += (Entry.getValue());
            str += "\n";
        }
        return str;
    }

    @Override
    public Object clone() {
        try {
            myMap copy = (myMap) super.clone();
            copy.map = new LinkedHashMap<String, info>(this.map); // Make a shallow copy of the LinkedHashMap
            copy.map.replaceAll((k, v) -> {
                try {
                    return (info) v.clone(); // Make a deep copy of the info objects
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace(); // Handle the exception
                    return v; // Return the original object if cloning fails
                }
            });
            copy.str = new String(this.str); // Make a new copy of the String
            copy.mapSize = this.mapSize;
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }


    
}