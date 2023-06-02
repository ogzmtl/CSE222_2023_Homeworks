import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class CSE222Dijkstra {

    private int startPoint_x, startPoint_y;
    private int endPoint_x, endPoint_y;
    private final int COL_NUM = 100;
    private final int ROW_NUM = 10;
    private int[] dist = new int[COL_NUM*ROW_NUM] ; 
    private int[] pred = new int[COL_NUM*ROW_NUM]; 
    private HashMap<Integer, LinkedList<Integer>> graph;
    
    
    public CSE222Dijkstra() {
        //intentionally empty
    }

    public CSE222Dijkstra(CSE222Graph graph, int startPoint_x, int startPoint_y, int endPoint_x, int endPoint_y)
    {
        this.startPoint_x = startPoint_x;
        this.startPoint_y = startPoint_y;
        this.endPoint_x = endPoint_x;
        this.endPoint_y = endPoint_y;

        // visited = new int [graph.getNumVertices()];
        this.graph = graph.getVertices();

        dijkstra(graph);
    }

    public void dijkstra(CSE222Graph helperGraph)
    {
        
        if(graph.get(startPoint_x*COL_NUM + startPoint_y) == null)
        {
            System.out.println("Map start point is not valid ");
            return; 
        }
        if(graph.get(endPoint_x*COL_NUM + endPoint_y) == null)
        {
            System.out.println("Map end point is not valid ");
            return; 
        }
        // System.out.println("aa ");
        int numV = graph.size();
        int start = startPoint_x*COL_NUM+startPoint_y;
        // Set<Integer> keySet = graph.keySet();
        // HashSet <Integer> vMinus = new HashSet<Integer>(keySet);
        List<Integer> keyset = new ArrayList<>(graph.keySet());
        List<List<Integer>> dijkstraTable = new ArrayList<>();
        HashSet < Integer > vMinusS = new HashSet < Integer > (numV);

        dijkstraTable.add(keyset);

        // int[] pred = new int[500*500];
        // int[] dist = new int[500*500];

        // System.out.println(dijkstraTable.get(0).get(1));
        for (int i = 0; i < numV; i++) {
            if (keyset.get(i) != start) {
              vMinusS.add(keyset.get(i));
            }
        }

        for (int v : vMinusS) {
            pred[v] = start;
            dist[v] = helperGraph.isEdge(start, v)? 1:0;
        }
        // System.out.println("aa " + vMinusS.size());
        while (vMinusS.size() != 0) {
            // Find the value u in VS with the smallest dist[u].
            double minDist = Double.POSITIVE_INFINITY;
            int u = -1;
            for (int v : vMinusS) {
              if (dist[v] < minDist) {
                minDist = dist[v];
                u = v;
              }
            }
            // Remove u from vMinusS.
            vMinusS.remove(u);
            // Update the distances.
            for (int v : vMinusS) {
              if (helperGraph.isEdge(u, v)) {
                int weight = 1;
                if (dist[u] + weight < dist[v]) {
                  dist[v] = dist[u] + weight;
                  pred[v] = u;
                }
              }
            }
            // System.out.println("aa " + vMinusS.size());
          }
    }

    public int[] getDistance()
    {
        return dist;
    }

    public int[] getPred()
    {
        return pred;
    }

}

