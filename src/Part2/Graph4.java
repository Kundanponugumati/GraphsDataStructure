package Part2;

import java.util.ArrayList;

// cycle detection in undirected graph.
public class Graph4 {

    static class Edge
    {
        int src;
        int dest;
        int wt;
        public Edge(int src, int dest,int wt)
        {
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }

    public static void createGraph(ArrayList<Edge> [] graph)
    {
        for(int i=0;i<graph.length;i++)
        {
            graph[i] = new ArrayList<>();
        }

         graph[0].add(new Edge(0,1,1));
//         graph[0].add(new Edge(0,2,1));
         graph[1].add(new Edge(1,2,1));
         graph[1].add(new Edge(1,0,1));
//         graph[2].add(new Edge(2,0,1));
         graph[2].add(new Edge(2,1,1));
         graph[2].add(new Edge(2,4,1));
         graph[4].add(new Edge(4,2,1));
         graph[4].add(new Edge(4,3,1));
         graph[3].add(new Edge(3,4,1));
    }

    public static boolean detectCycle(ArrayList<Edge> [] graph)
    {
        boolean [] vis = new boolean[graph.length];
     for(int i=0;i<graph.length;i++)
     {
           if(!vis[i])
           {
               if(detectCycleUtil(graph,vis,i,-1)) {
                   return true;
               }
           }
     }
     return false;

    }

    // to check cycle exist or not we slightly  modify the dfs code.
    public static boolean detectCycleUtil(ArrayList<Edge> [] graph,boolean[] vis,int curr,int par)
    {
//        System.out.print(curr+" ");
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++)
        {
            Edge e = graph[curr].get(i);

            //case-3
            if(!vis[e.dest])
            {
                if(detectCycleUtil(graph,vis,e.dest,curr)) {
                    return true;
                }
            }

            // case-1
            else if(vis[e.dest] && e.dest!=par)
            {
                return true;
            }

            // case-2 do nothing
            // i.e vis[neigh] -> true and e.dest= par then simply continue.
        }
        return false;
    }
    public static void main(String[] args) {
        // int [] arr = new int [size];
        int V = 5;
        ArrayList<Edge> [] graph = new ArrayList[V];
        createGraph(graph);
        System.out.println(detectCycle(graph));
    }
}
