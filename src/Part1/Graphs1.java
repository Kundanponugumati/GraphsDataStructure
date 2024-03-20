package Part1;

import java.util.ArrayList;

// Create a Graph
public class Graphs1 {

    static class Edge
    {
        int src;
        int dest;
        int wt;
        public Edge(int src,int dest,int wt)
        {
            this.src = src;
            this.dest=dest;
            this.wt = wt;
        }
    }
    public static void main(String[] args) {
//        int [] arr = new int[size]
        int V = 5;
        ArrayList<Edge> [] graph = new ArrayList[V];
        for(int i=0; i<graph.length;i++)
        {
            graph[i] = new ArrayList<>();
        }

        // 0-vertex
        graph[0].add(new Edge(0,1,5));

        // 1-vertex
        graph[1].add(new Edge(1,0,5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));

        // 2-vertex
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,2));

        // 3-vertex
        graph[3].add(new Edge(3,1,3));
        graph[3].add(new Edge(3,2,1));

        // 4-vertex
        graph[4].add(new Edge(4,2,2));

        // to get neighbour nodes
        for(int j=0; j<5;j++) {
            for (int i = 0; i < graph[j].size(); i++) {
                Edge e = graph[j].get(i);
                System.out.print(e.dest+" ");
            }
            System.out.println();
        }

        // to get neighbour nodes of 2
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.print(e.dest+" ");
        }




    }
}
