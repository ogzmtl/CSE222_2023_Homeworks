import java.util.ArrayList;

public class info {
    private int count = 0;
    private ArrayList<String> words = new ArrayList<String>();

    public info()
    {
        //intentionlly empty 
    }
    public info(String word)
    {
        this.push(word);
    }

    public void push(String word)
    {
        words.add(word);
        count++;
    }

    public ArrayList<String> getWords(){
        return words;
    }

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


}
