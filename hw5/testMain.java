import java.io.FileNotFoundException;

public class testMain {
    public static void main(String[] args) throws FileNotFoundException {
        
        String filename = new String("input.txt");
        partA first = new partA(); 


        first.readFromTxt(filename);
        first.tree();
        // first.BFS("CSE2332");
        // first.DFSRecursion("CSE232");
        // first.DFSStack("CSE232");
        // first.PostOrderTraversal("CSE2332");
        first.move("2023,CSE232,LECTURE1", "2020");
    }
}
