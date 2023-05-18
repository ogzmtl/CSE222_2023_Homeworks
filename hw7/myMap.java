import java.util.LinkedHashMap;
import java.util.Map;

public class myMap implements Cloneable{
    private LinkedHashMap<String, info> map = new LinkedHashMap<String, info>(); 
    private int mapSize; 
    private String str;

    //intentionally empty constructor
    public myMap(){
        
    }

    /**
     * check string is null/empty then returns exception
     * @param str given string by the user
     * @throws Exception throw null exception
     */
    public myMap(String str) throws Exception
    {
        if(str == null || str.length() == 0)
        {
            throw new Exception();
        }
        this.str = str;
    }

    /**
    * /**
    * Parses a given string and creates a map where each character is a key,
    * and the corresponding values are strings from the input that contain the key character.
    * 
    * @param str the string to be parsed and mapped
    */
    public void createMap()
    {
        String[] splitted = str.split(" ");
    /**
     * Iterates over each word in the array.
     */
        for(int i = 0; i < splitted.length; i++)
        {
        /**
        * Iterates over each character in the current word.
        */
            for(int j = 0; j < splitted[i].length(); j++)
            {
                String parsedCharacter = (String.valueOf(splitted[i].charAt(j)));
                if(map.containsKey(parsedCharacter))
                {
                    map.get(parsedCharacter).push(splitted[i]);
                }
                else{
                    info createNewKeyValue = new info(splitted[i]);
                    /**
                    * Adds a new key-value pair to the map, where the key is the parsed character
                    * and the value is the newly created info object.
                    */
                    map.put(parsedCharacter, createNewKeyValue );
                    mapSize++;
                }
                
            }
        }
    }

    /**
     * getter for the map
     * @return map
     */
    public LinkedHashMap<String, info> getMap()
    {
        return map;
    }

    /**
     * getter for map size
     * @return map size
     */
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

    /**
     * this method clones the original myMap class 
     * to the another sorted map, by cloning the info and other fields
     */
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