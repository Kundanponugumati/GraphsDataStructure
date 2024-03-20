package Part3;

import java.util.ArrayList;

// all path from source to the destination
public class Graphs9 {

    static class Edge
    {
        int src;
        int dest;
        public Edge(int src,int dest)
        {
         this.src=src;
         this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph)
    {
        for(int i=0;i<graph.length;i++)
        {
            graph[i]= new ArrayList<>();
        }

        graph[0].add(new Edge(0,3));
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,1));
        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));
        graph[5].add(new Edge(5,2));
        graph[5].add(new Edge(5,2));
    }

    public static void allPaths(ArrayList<Edge>[] graph)
    {
        String path = "";

    }

    public static void allPathsUtil(ArrayList<Edge>[] graph,int src,int dest,String path)
    {

    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
     }
}
