import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class testMain {
    public static void main(String[] args) throws FileNotFoundException {
        
        String filename = new String("input.txt");
        partA first = new partA(); 
        

        JFrame fa;  
        fa = new JFrame();
        
        first.readFromTxt(filename);
        first.tree();
        
        // first.BFS("CSE2332");
        // first.DFSRecursion("CSE232");
        // first.DFSStack("CSE232");
        // first.PostOrderTraversal("CSE2332");
        first.move("2022,CSE222", "2021");
        DefaultMutableTreeNode temp = first.getTree();
 
        JTree jt=new JTree(temp); 
        fa.add(jt);  
        fa.setSize(200,200);  
        fa.setVisible(true);  
    }
}
