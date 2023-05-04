import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// import javax.swing.*;  
import javax.swing.tree.DefaultMutableTreeNode;  



public class partA{
    
    private String[][] txtToArray = new String[1][];
    private DefaultMutableTreeNode tree = new DefaultMutableTreeNode("Root");
    private int stepCounter = 0;
    // private Stack<DefaultMutableTreeNode> newNodeStackRemove = new Stack<DefaultMutableTreeNode>(); 
    // private Stack<DefaultMutableTreeNode> newNodeStackAdd = new Stack<DefaultMutableTreeNode>();
    // private Queue<DefaultMutableTreeNode> newNodeQueueRemove = new LinkedList<DefaultMutableTreeNode>(); 
    private DefaultMutableTreeNode nn = new DefaultMutableTreeNode();

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
            // System.out.println("------------");
        }
        // insertToTree(tree, null);
    }

    public boolean insertToTree(DefaultMutableTreeNode tree,DefaultMutableTreeNode node){
        if(tree.isLeaf()){
        // System.out.println("LeafinsertToTree " + tree.getUserObject() + " node: " + node.getUserObject()); 
            return true;
        }
        else{
            if(!isInclude(tree, node)){
                // System.out.println("insertToTree " + tree.getUserObject() + " node: " + node.getUserObject()); 
                return true;
            }

        }
        // System.out.println("false");
        return false;
    }
    
    private boolean isInclude(DefaultMutableTreeNode tree,DefaultMutableTreeNode node){
        if (tree == null || node == null) {
            return false;
        }   
        int childCount = tree.getChildCount();
        // System.out.println("tree : " + tree.getUserObject() +" "+childCount);
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
        // System.out.println("tree : " + tree.getUserObject() +" "+childCount);
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

    public void move(String source, String destination)
    {
        // DefaultMutableTreeNode sourceNode = isExists(source); 
        // DefaultMutableTreeNode destinationNode = isExists(destination);
    
        // System.out.println(sourceNode);
        if(createNode(tree, source) == null){
            return;
        }

        // System.out.println("aaaa" + nn);
        // System.out.println("aaaa" + nn.getChildAt(0) + "bbbb" + nn.getChildAt(0));
        add(nn, destination, source);
        // remove(tree);
        
        // add(destinationNode)

        // if(addToDest(destination)){
        //     System.out.println("true");
        // }
        //remove new queue;
    }

    public void add(DefaultMutableTreeNode sourceNode, String dest, String src)
    {
        DefaultMutableTreeNode temp = tree;
        temp = iterateRoot(temp, dest);
        // System.out.println(sourceNode);
        // System.out.println(sourceNode.getChildCount());
        temp.add((DefaultMutableTreeNode)sourceNode.getChildAt(0));

    }

    private DefaultMutableTreeNode iterateRoot(DefaultMutableTreeNode root, String dest)
    {
        String[] splitted = dest.split(",");
        int counter = 0;
        System.out.println(splitted.length);

        
        for(int i =0; i < splitted.length; i++) 
        {
            int childCount = root.getChildCount();

            for(int j = 0; j < childCount; j++)
            {
                // System.out.println(dest)
                if(((DefaultMutableTreeNode)root.getChildAt(i)).getUserObject().equals(splitted[i])){
                    root = (DefaultMutableTreeNode)root.getChildAt(i);
                    counter++;
                    break;
                }
            } 
            
            if(i == 0 && counter != 1)
            {
                // System.out.println(splitted[i]);
                if(insertToTree(tree, new DefaultMutableTreeNode(splitted[i]))){
                    DefaultMutableTreeNode childNew = new DefaultMutableTreeNode(splitted[i]);
                    root.add(childNew);
                    // System.out.println(root.getChildCount());
                    root = childNew;
                }
                break;
            }
        }
        if(counter == splitted.length){
            return root;
        }
        else{
            return null;
        }
    }
    private DefaultMutableTreeNode createNode(DefaultMutableTreeNode root, String source)
    {
        DefaultMutableTreeNode temp = root;
        DefaultMutableTreeNode nnTemp = nn;
        String[] splitted = source.split(",");
        int counter = 0;
        
        for(int i =0; i < splitted.length; i++) 
        {
            int childCount = temp.getChildCount();
            for(int j = 0; j < childCount; j++)
            {
                DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) temp.getChildAt(j);
                // System.out.println(childNode);
                if(childNode.getUserObject().equals(splitted[i]))
                {
                    counter++;
                    if(i == splitted.length -1)
                    {
                        if(nnTemp == null)
                        {
                            nnTemp = new DefaultMutableTreeNode(((DefaultMutableTreeNode) temp.getChildAt(j)).getUserObject());
                        }
                        else{
                            nnTemp.add(childNode);
                        }                        
                    }
                    else if(i != 0){
                        // if(nnTemp == null)
                        // {
                        //     nnTemp = new DefaultMutableTreeNode(((DefaultMutableTreeNode) temp.getChildAt(j)).getUserObject());
                        // }
                        // else
                        // {
                            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(((DefaultMutableTreeNode) temp.getChildAt(j)).getUserObject());
                            nnTemp.add(newNode);
                            nnTemp = (DefaultMutableTreeNode)nnTemp.getChildAt(0);
                    //     }
                    //     // System.out.println("ovvvvv"+ nn);
                    //     temp = childNode;
                        temp = childNode;
                    }
                    else if(i == 0)
                    {
                        temp = childNode;
                    }
                    // else{
                        
                    // }
                    
                    break;
                }
            } 
        }
        if(counter != splitted.length ){
            System.out.print("Cannot move ");
            for(int k = 0; k < splitted.length; k++){
                
                if(k != splitted.length-1) System.out.print( splitted[k] + " -> ");
                else 
                {
                    System.out.print( splitted[k] + " because it doesn't exist in the tree.\n");
                    return null;
                }
            }

        }
        return temp;
    }

    public DefaultMutableTreeNode getTree()
    {
        return tree;
    }

}

