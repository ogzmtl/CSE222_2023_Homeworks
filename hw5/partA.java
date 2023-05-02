import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;  
import javax.swing.tree.DefaultMutableTreeNode;  



public class partA{
    
    private String[][] txtToArray = new String[1][];

    public void readFromTxt(String filename) throws FileNotFoundException{
        File file = new File(filename);
        String line;
        int counter = 0; 
        String[] splitted; 

        try (Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine())
            {
                line = scanner.nextLine();
                splitted = line.split(";");

                if(txtToArray[counter] == null)
                {
                    txtToArray[counter] = new String[splitted.length];
                }

                for(int i = 0; i < splitted.length; i++){
                    txtToArray[counter][i] = splitted[i];
                }
                if(counter == txtToArray.length-1 && (scanner.hasNextLine())){
                    txtToArray = reallocate(counter+1);
                }  
                counter++;           
            }
            // for(int i = 0; i < txtToArray.length; i++)
            // {
            //     for(int j = 0; j < txtToArray[i].length; j++){
            //         System.out.print(txtToArray[i][j] + " ");
            //     }
            //     System.out.print("\n");
            // }
        }
    }

    private String[][] reallocate(int counter){
        String[][] tempString = new String[1+counter][];

        for(int i = 0; i < txtToArray.length; i++)
        {
            if(tempString[i] == null ){
                tempString[i] = new String[txtToArray[i].length];
            }
            for(int j = 0; j < tempString[i].length; j++)
            {
                tempString[i][j] = txtToArray[i][j];
            }
        }
        return tempString;
    }

    public void tree(){
        DefaultMutableTreeNode tree = new DefaultMutableTreeNode("root");
        DefaultMutableTreeNode temp = tree;

        JFrame fa;  

        fa = new JFrame();
        for(int i = 0; i < txtToArray.length; i++){
            // DefaultMutableTreeNode year = new DefaultMutableTreeNode(txtToArray[i][0]);
            // tree.add(year);
            // temp = traverseAllTree(tree);
            // System.out.println(tree.getUserObject());
            // insertToTree(tree, year);
            temp = tree;
            for(int j = 0; j < txtToArray[i].length; j++){

                DefaultMutableTreeNode lecture = new DefaultMutableTreeNode(txtToArray[i][j]);
                // System.out.println(year.getUserObject());
                // System.out.println(lecture.getUserObject());
                // insertToTree(year, lecture);

                if(insertToTree(temp, lecture)){
                    temp.add(lecture);
                    temp = lecture;
                }
                else{
                    temp = moveTreeObject(temp, lecture);
                }   
            }
            System.out.println("------------");
        }
        // insertToTree(tree, null);
        JTree jt=new JTree(tree);  
        fa.add(jt);  
        fa.setSize(200,200);  
        fa.setVisible(true);  
    }

    public boolean insertToTree(DefaultMutableTreeNode tree,DefaultMutableTreeNode node){
        if(tree.isLeaf()){
        System.out.println("LeafinsertToTree " + tree.getUserObject() + " node: " + node.getUserObject()); 
            return true;
        }
        else{
            if(!isInclude(tree, node)){
                System.out.println("insertToTree " + tree.getUserObject() + " node: " + node.getUserObject()); 
                return true;
            }

        }
        System.out.println("false");
        return false;
    }
    
    private boolean isInclude(DefaultMutableTreeNode tree,DefaultMutableTreeNode node){
        if (tree == null || node == null) {
            return false;
        }   
        int childCount = tree.getChildCount();
        System.out.println("tree : " + tree.getUserObject() +" "+childCount);
        for(int i=0;i<childCount;i++){
     
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) tree.getChildAt(i);
            if(child == null) {
                return true;
            }
            if(node.getUserObject().equals(child.getUserObject())){
                return true;
            }
        }
        return false;
    }

    private DefaultMutableTreeNode moveTreeObject(DefaultMutableTreeNode tree,DefaultMutableTreeNode node){

        int childCount = tree.getChildCount();
        System.out.println("tree : " + tree.getUserObject() +" "+childCount);
        for(int i=0;i<childCount;i++){
     
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) tree.getChildAt(i);

            if(node.getUserObject().equals(child.getUserObject())){
                return child;
            }
        }
        return null;
    }
}

