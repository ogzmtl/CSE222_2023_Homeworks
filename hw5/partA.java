import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.*;  
import javax.swing.tree.DefaultMutableTreeNode;  



public class partA{
    
    private String[][] txtToArray = new String[1][];
    private DefaultMutableTreeNode tree = new DefaultMutableTreeNode("Root");
    private int stepCounter = 0;

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
        DefaultMutableTreeNode temp = tree;

        JFrame fa;  

        fa = new JFrame();
        for(int i = 0; i < txtToArray.length; i++){

            temp = tree;
            for(int j = 0; j < txtToArray[i].length; j++){

                DefaultMutableTreeNode lecture = new DefaultMutableTreeNode(txtToArray[i][j]);

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

    public boolean BFS(String userInput){
        
        DefaultMutableTreeNode temp =(DefaultMutableTreeNode) tree.getRoot();
        Queue<DefaultMutableTreeNode>queueNode = new LinkedList<DefaultMutableTreeNode>();
        System.out.println("Using BFS to find "+ userInput + " in the tree...");

        queueNode.add((DefaultMutableTreeNode)temp.getRoot());
        int counter = 1; 
        while(!queueNode.isEmpty())
        {
            DefaultMutableTreeNode printedNode = (DefaultMutableTreeNode) queueNode.poll();
            
            if(printedNode.getUserObject().equals(userInput))
            {
                System.out.println("Step "+ (counter++) +" -> " +printedNode + "(Found!)");
                return true;
            }
            else{
                System.out.println("Step "+ (counter++) +" -> " +printedNode);
            }
            int childCount = printedNode.getChildCount();
            if(childCount != 0)
            {
                for(int i = 0; i < childCount; i++)
                {
                    DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) printedNode.getChildAt(i);
                    queueNode.add(childNode);
                }
            }
        }
        System.out.println("Not found.");
        return false;
    }

    public void DFSRecursion(String userInput)
    {
        if(!helperDFSRecursion(userInput, tree)){
            System.out.println("Not found.");
        }
    }

    public boolean DFSStack(String userInput)   
    {
        Stack<DefaultMutableTreeNode> stackNode = new Stack<DefaultMutableTreeNode>();
        DefaultMutableTreeNode temp = tree; 

        int counter =0; 
        stackNode.push(temp);

        while(!stackNode.isEmpty())
        {
            counter++;
            DefaultMutableTreeNode node = stackNode.pop();
            
            if(node.getUserObject().equals(userInput))
            {
                System.out.println("Step " + counter +" -> " + node.getUserObject() + "(Found!)");
                return true;
            }
            else {
                System.out.println("Step " + counter +" -> " + node.getUserObject());
            }

            int childCount = node.getChildCount();

            for(int i = 0; i < childCount; i++) {
                stackNode.push((DefaultMutableTreeNode)node.getChildAt(i));
            }
        }
        System.out.println("Not found.");
        return false;
    }
    
    private boolean helperDFSRecursion(String userInput, DefaultMutableTreeNode node)
    {
        stepCounter++;
        if(node == null){
            return false;
        } 
        
        if(node.getUserObject().equals(userInput)){
            System.out.println("Step "+ (stepCounter) +" -> " +node + "(Found!)");
            return true;
        }
        else{
            System.out.println("Step "+ (stepCounter) +" -> " +node);
        }
            
        int childCount = node.getChildCount(); 
        if(childCount != 0){   
            for(int i = childCount-1; i >= 0; i--){
                DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) node.getChildAt(i);
                if(helperDFSRecursion(userInput, childNode)){
                    return true;
                }
            }
        }
        return false;
    }

    public void PostOrderTraversal(String userInput){
        stepCounter = 0;
        if(!helperPostOrderTraversal(userInput, tree)){
            System.out.println("Not found.");
        }

    }

    private boolean helperPostOrderTraversal(String userInput, DefaultMutableTreeNode node ){
        
        int childCount = node.getChildCount();
        if(childCount != 0 ){
            for(int i = 0; i < childCount; i++)
            {
                if(helperPostOrderTraversal(userInput, (DefaultMutableTreeNode)node.getChildAt(i)))
                {
                    return true;
                }
            }
            // stepCounter++;
        }
        stepCounter++;
        if(node.getUserObject().equals(userInput)){
            System.out.println("Step "+ (stepCounter) +" -> " +node + "(Found!)");
            return true;
        }
        else{
            System.out.println("Step "+ (stepCounter) +" -> " +node);
            return false;
        }       
        
    }

}

