import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class rough1 {
    static class Edge
    {
       int src;
       int dest;
       int wt;
       public Edge(int src,int dest,int wt)
       {
           this.src= src;
           this.dest = dest;
           this.wt= wt;
       }
    }

    public static void createGraph(ArrayList<Edge> [] graph)
    {
        for(int i=0;i<graph.length;i++)
        {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));
        //1-vertex
        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));

        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        graph[6].add(new Edge(6,5,1));

    }
    public static void bfs(ArrayList<Edge>[] graph, int src)
    {
        Queue<Integer> queue = new LinkedList<>();
        boolean [] visit = new boolean[graph.length];
        queue.add(src);
        while(!queue.isEmpty())
        {
            int curr = queue.remove();
            if(!visit[curr])
            {
                System.out.print(curr+" ");
                visit[curr]= true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    queue.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge> [] graph,int src,boolean [] visit)
    {
        System.out.print(src+" ");
        visit[src]= true;
        for(int i=0;i<graph[src].size();i++)
        {
           Edge e =  graph[src].get(i);
           if(!visit[e.dest])
           {
               dfs(graph, e.dest, visit);
           }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        // int [] arr = new int[size]
        ArrayList<Edge> [] graph = new ArrayList[V];
        createGraph(graph);
        bfs(graph,0);
        dfs(graph,0,new boolean[V]);

    }
}
