package Part1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// BFS - Breadth First Search
public class Graphs2 {

    static class Edge
    {
        int src;
        int dest;
        int wt;
        public Edge(int src, int dest, int wt)
        {
            this.src=src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for(int i=0;i< graph.length;i++)
        {
            graph[i]= new ArrayList<>();
        }
        //0-vertex
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));
        //1-vertex
        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));

        //2-vertex
        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        //3-vertex
        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));
        //4-vertex
        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));
        //5-vertex
        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));
        //6-vertex
        graph[6].add(new Edge(6,5,1));

    }

    public static void bfs(ArrayList<Edge>[] graph) {
        boolean [] visted = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0); // 0-> src

        while(!queue.isEmpty()) {
            int Currnt = queue.remove();
            if (!visted[Currnt]) {
                visted[Currnt] = true;
                System.out.print(Currnt + " ");

                for (int i = 0; i < graph[Currnt].size(); i++) {
                    Edge e = graph[Currnt].get(i);
                    queue.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge> [] graphs, int curr,boolean [] visit)
    {
        System.out.print(curr+" ");
        visit[curr]= true;
        for(int i=0;i<graphs[curr].size();i++)
        {
            Edge e = graphs[curr].get(i);
            if(! visit[e.dest])
            {
                dfs(graphs, e.dest,visit);
            }
        }

    }
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        bfs(graph);
        System.out.println();
        dfs(graph,0,new boolean[graph.length]);

    }
}
