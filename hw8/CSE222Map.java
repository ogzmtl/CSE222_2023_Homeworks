import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSE222Map
{
    private String filename; 
    private final int COL_NUM = 100;
    private final int ROW_NUM = 10;

    private int startPoint_x;
    private int startPoint_y;
    
    private int endPoint_x;
    private int endPoint_y;

    private int[][] matrix = new int[ROW_NUM][COL_NUM];

    public CSE222Map()
    {
        //intentionally empty
    }

    public CSE222Map(String textFile) throws IOException,FileNotFoundException
    {
        this.filename = textFile;
        readTextFile();
    }

    public void readTextFile() throws IOException, FileNotFoundException
    {
        File file = new File(this.filename);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        int i = 0;

        while((line = br.readLine()) != null)
        {
            String[] splitted = new String[COL_NUM];
            splitted = line.split(",");
            // if(i == 2 )System.out.println("Length : " + splitted[104]);
            if(i == 0)
            {
                startPoint_x = Integer.parseInt(splitted[0]);
                startPoint_y = Integer.parseInt(splitted[1]);
            }
            else if(i == 1)
            {
                endPoint_x = Integer.parseInt(splitted[0]);
                endPoint_y = Integer.parseInt(splitted[1]);
            }
            else
            {
                for(int j = 0; j < splitted.length; j++)
                {
                    matrix[i-2][j] = Integer.parseInt(splitted[j]);
                    // if(matrix[i-2][j] == 0 && i == 2) System.out.println(" VALUE :"+j);
                }
            }
            i++;            
        }
        br.close();
        // System.out.println("BBB : "  + matrix[0][103]);
    }

    public final int[][] getMap()
    {
        return matrix;
    }

    public final int getStartPoint_x()
    {
        return startPoint_x;
    }
    public final int getStartPoint_y()
    {
        return startPoint_y;
    }
    public final int getEndPoint_x()
    {
        return endPoint_x;
    }

    public final int getEndPoint_y()
    {
        return endPoint_y;
    }



}