import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;

public class testMain {
    public static void main(String[] args) throws FileNotFoundException {
        
        String filename = new String("input.txt");
        partA first = new partA(); 
        int userInput = 0;

        JFrame fa;  
              
        first.readFromTxt(filename);
        first.tree(); 
        Scanner scanner = new Scanner(System.in);
        Scanner bfsScanner = new Scanner(System.in);
        while(userInput != -1)
        {
            System.out.println("-------HW 5------");
            System.out.println("-----------------");
            System.out.println("1.Show the tree");
            System.out.println("2.BFS");
            System.out.println("3.DFS");
            System.out.println("4.PostOrderTraversal");
            System.out.println("5.Move");
                String newUserInput = new String();
                userInput = scanner.nextInt();   
                switch(userInput)
                {

                    case 1:
                        fa = new JFrame();
                        JTree jt=new JTree(first.getTree());
                        fa.add(jt);  
                        fa.setSize(200,200);  
                        fa.setVisible(true);  
                        break; 
                    case 2:
                       
                        System.out.println("Enter an input to search with BFS.");
                        
                        newUserInput = bfsScanner.nextLine();
                        first.BFS(newUserInput);
                        break;


                    case 3:
                        System.out.println("Enter an input to search with DFS.");
                        newUserInput = bfsScanner.nextLine();
                        first.DFSStack(newUserInput);
                        break;
                    
                    case 4:
                        System.out.println("Enter an input to search with BFS.");
                        newUserInput = bfsScanner.nextLine();
                        first.PostOrderTraversal(newUserInput);
                        break;
                    
                    case 5:
                        System.out.println("Enter source of object (at least 2 source and divided by comma) : " );
                        String source = bfsScanner.nextLine();
                        System.out.println("Enter destination of object : (year target)" );
                        String target = bfsScanner.nextLine();
                        if(isCorrectInput(source, target)){
                            first.move(source, target);
                        }
                }
        }
        bfsScanner.close();
        scanner.close();
        // first.readFromTxt(filename);
        // first.tree();
        
        // first.BFS("CSE2332");
        // first.DFSRecursion("CSE232");
        // first.DFSStack("CSE232");
        // first.PostOrderTraversal("CSE2332");
        // first.move("2023,CSE102", "2022");
        // DefaultMutableTreeNode temp = first.getTree();
 
        // JTree jt=new JTree(temp); 
        // fa.add(jt);  
        // fa.setSize(200,200);  
        // fa.setVisible(true);  
    }

    private static boolean isCorrectInput(String source, String target) {
        String[] splitted = source.split(",");

        if(splitted.length >= 2 )
        {
            if(target == null){
                return false;
            }
    
            try{
                double d = Double.parseDouble(target);
            }catch(Exception e){
                return false;
            }
            return true;
        }
        else{
            return false;
        }


    }
}
