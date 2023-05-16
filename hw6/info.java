import java.util.ArrayList;

public class info implements Cloneable{
    private int count = 0;
    private ArrayList<String> words = new ArrayList<String>();

    /**
     * intentionally empty constructor
     */
    public info()
    {
        //intentionlly empty 
    }

    /**
     * pushes the given splitted word into info arraylist
     * @param word
     */
    public info(String word)
    {
        this.push(word);
    }

    /**
     * pushes the given splitted word into info arraylist
     * increments the count 
     * @param word given splitted word
     */
    public void push(String word)
    {
        words.add(word);
        count++;
    }

    /**
     * getter for words arraylist
     * @return
     */
    public ArrayList<String> getWords(){
        return words;
    }

    /**
     * getter for count
     * @return count number
     */
    public int getCount(){
        return count;
    }

    @Override
    public String toString(){
        String str = "";
        str += "Count: "+ String.valueOf(count);
        str += " - Words: [";

        for(int i = 0; i < words.size(); i++)
        {
            if(i != words.size()-1)str += words.get(i) + ", ";
            else 
                str += words.get(i) + "]";
        }
        return str;

    }

    /**
     * clones the info array fields 
     * does deep copy of the class 
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        info copy = (info) super.clone();
        copy.words = new ArrayList<String>(this.words); // Make a new copy of the ArrayList
        return copy;
    }


}
