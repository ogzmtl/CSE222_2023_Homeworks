import java.io.FileNotFoundException;

public class testMain {
    public static void main(String[] args) throws FileNotFoundException {
        
        String filename = new String("input.txt");
        partA first = new partA(); 


        first.readFromTxt(filename);
        first.tree();
        first.BFS("CSE2332");
        first.DFS("CSE232");
    }
}