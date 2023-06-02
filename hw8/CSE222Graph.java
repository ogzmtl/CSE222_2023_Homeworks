import java.util.LinkedList; 
import java.util.HashMap; 
public class CSE222Graph {

    private final int COL_NUM = 100;
    private final int ROW_NUM = 10;
    private int[][] mapMatrix = new int[ROW_NUM][COL_NUM];
    private int numVertices = 0;
    

    private HashMap<Integer, LinkedList<Integer>> verticesList;

    public CSE222Graph() {
        //intentionally empty
    }

    public CSE222Graph(CSE222Map map)
    {
        createMap(map);
    }

    private void createMap(CSE222Map map) {
        mapMatrix = map.getMap(); 
        this.verticesList = new HashMap<>();
        for(int i = 0; i < mapMatrix.length; i++)
        {
            
            for(int j = 0; j < mapMatrix[i].length; j++)
            {
                LinkedList<Integer> vertexOfNode = new LinkedList<Integer>();
                if(mapMatrix[i][j] == 0) {
                    // if(i == 0 && j == 104) System.out.println("jaaaaa" +mapMatrix[i][j] );
                    insert(i, j, vertexOfNode);
                }
            }
        }
    }

    public void insert(int i, int j, LinkedList<Integer> vertexList)
    {
        int vertex = i*COL_NUM + j;
        // if(vertex == 886) System.out.println("AAAA : " + mapMatrix[i][j]);
        if(i-1 >= 0 && j-1 >= 0 && mapMatrix[i-1][j-1] == 0 )
        {
            int temp = (i-1) * COL_NUM + j-1;
            vertexList.add(temp);
        }
        if(i-1 >= 0 && mapMatrix[i-1][j] == 0 )
        {
            int temp = (i-1) * COL_NUM + j;
            vertexList.add(temp);
        }
        if(i-1 >= 0 && j+1 <COL_NUM && mapMatrix[i-1][j+1] == 0 )
        {
            int temp = (i-1) * COL_NUM + j+1;
            vertexList.add(temp);
        }
        if(j-1 >= 0 && mapMatrix[i][j-1] == 0 )
        {
            int temp = i * COL_NUM + j-1;
            // if(i == 0 && j == 104) System.out.println("AAAA : " + mapMatrix[i][j-1] + " i: " + i + " j : " + j);
            vertexList.add(temp);
        }
        if(j+1 < COL_NUM && mapMatrix[i][j+1] == 0 )
        {
            int temp = i * COL_NUM + j+1;
            vertexList.add(temp);
        }
        if(i+1 < ROW_NUM && j-1 >= 0 && mapMatrix[i+1][j-1] == 0)
        {
            int temp = (i+1) * COL_NUM + j-1;
            vertexList.add(temp);
        }
        if(i+1 < ROW_NUM && mapMatrix[i+1][j] == 0)
        {
            int temp = (i+1) * COL_NUM + j;
            vertexList.add(temp);
        }
        if(i+1 < ROW_NUM && j+1 < COL_NUM && mapMatrix[i+1][j+1] == 0)
        {
            int temp = (i+1) * COL_NUM + j+1;
            vertexList.add(temp);
        }
        verticesList.put(vertex, vertexList);

        
        // mapMatrix[source][destination] = 1;
        // mapMatrix[destination][source] = 1;
        numVertices++;
    }

    public boolean isVertex(int source, int dest)
    {
        if(mapMatrix[source][dest] == 0){
            return true;
        }
        else 
            return false;
    }

    public boolean isEdge(int source, int dest)
    {
        for(int i = 0; i < verticesList.get(source).size(); i++)
        {
            if(verticesList.get(source).get(i) == dest) return true;
        }
        return false;
        // if(mapMatrix[source][dest] == 0 && mapMatrix[dest][source] == 0){
        //     return true;
        // }
        // else
        // {
        //     return false;
        // }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 1; i++)
        {
            sb.append(i + ": ");
            for(int j : verticesList.get(604)){
                sb.append(j + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int getNumVertices()
    {
        return numVertices;
    }

    public HashMap<Integer, LinkedList<Integer>> getVertices()
    {
        return verticesList;
    }
    
}
