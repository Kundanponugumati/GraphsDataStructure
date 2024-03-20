package Part2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// bipartite graph
public class Graph5 {

    static class Edge
    {
        int src;
        int dest;
        public Edge(int src,int dest)
        {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> [] graph)
    {
        for(int i=0;i<graph.length;i++)
        {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));
        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
    }

    public static void bfs(ArrayList<Edge>[] graph)
    {
        boolean [] vis= new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        // add src to the queue.
        queue.add(0);
        while(!queue.isEmpty())
        {
            int curr = queue.remove();
            if(!vis[curr])
            {
                System.out.print(curr+" ");
             vis[curr] = true;
             for(int i=0;i<graph[curr].size();i++)
             {
                 Edge e = graph[curr].get(i);
                 queue.add(e.dest);
             }
            }
        }
    }


    public static boolean isBipartite(ArrayList<Edge>[] graph)
    {
     Queue<Integer> queue = new LinkedList<>();
     // color-0 ->0
     // color-1 ->1
     // no color ->-1
     int [] color = new int[graph.length];
     for(int i=0;i<color.length;i++)
     {
         color[i]=-1; // making array -1 so that there is no color for the vertex
     }

     for(int i=0;i<graph.length;i++)
     {
        if(color[i]== -1)
        {
            queue.add(i);
            color[i] = 1;
            while(!queue.isEmpty())
            {
                int curr = queue.remove();
                for(int j=0;j<graph[curr].size();j++)
                {
                    Edge e = graph[curr].get(j);
                    if(color[e.dest] == -1)
                    {
                        int nextColor = color[curr]==0?1:0; // means if(color[curr]==0) then 1 else 0
                        color[e.dest] = nextColor;
                        queue.add(e.dest);
                    }
                    else if(color[e.dest] == color[curr])
                    {
                        return false;
                    }
                }
            }
        }
     }
        return true;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> [] graph = new ArrayList[V];
        createGraph(graph);
        System.out.println(isBipartite(graph));
    }
}
