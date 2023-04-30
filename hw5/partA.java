import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class partA{
    
    private String[][] txtToArray = new String[5][];
    
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
                if(counter == txtToArray.length-1){
                    txtToArray = reallocate(counter);
                }  
                counter++;           
            }
            for(int i = 0; i < txtToArray.length; i++)
            {
                for(int j = 0; j < txtToArray[i].length; j++){
                    System.out.print(txtToArray[i][j]);
                }
                System.out.print("\n");
            }
        }
        

    }

    private String[][] reallocate(int counter){
        String[][] tempString = new String[5+counter][];

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
}