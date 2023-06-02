import java.io.IOException;

public class TestMain {
    
    public static void main(String[] args)
    {
        try {
            CSE222Map map = new CSE222Map("TextFiles/mymap.txt");
            // System.out.println("Testing :" + map.getMap()[499][392]);
            CSE222Graph graph = new CSE222Graph(map);
            // System.out.println("Testing :" + graph);
            CSE222Dijkstra dijkstra = new CSE222Dijkstra(graph,
                                                         map.getStartPoint_x(),
                                                         map.getStartPoint_y() ,
                                                         map.getEndPoint_x(),
                                                         map.getEndPoint_y());
            
            // for(int i = 0; i < dijkstra.getDistance().length; i++)
            // {
            //     System.out.println(dijkstra.getDistance()[i]);
                
            // }
        } catch (IOException e) {
            e.printStackTrace();
        } 

    }
}
