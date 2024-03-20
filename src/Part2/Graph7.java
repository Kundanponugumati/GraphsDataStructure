package Part2;

import java.util.ArrayList;
import java.util.Stack;

// topological sorting
public class Graph7 {

    static class Edge
    {
        int src;
        int dest;
        public Edge(int src,int dest)
        {
            this.src= src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph)
    {
        for(int i=0;i<graph.length;i++)
        {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,1));
        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));
        graph[5].add(new Edge(5,2));
        graph[5].add(new Edge(5,2));
    }

    public static void topologicalSorting(ArrayList<Edge>[] graph)
    {
        boolean [] vis = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<graph.length;i++)
        {
            if(!vis[i])
                topologicalSortingUtil(graph,i,vis,stack);
        }
        while(!stack.isEmpty())
        {
            System.out.println(stack.pop());
        }
    }

    public static void topologicalSortingUtil(ArrayList<Edge>[] graph,int curr, boolean[] vis,Stack<Integer> stack)
    {
        vis[curr]= true;
        for(int i=0;i<graph[curr].size();i++)
        {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest])
            {
                topologicalSortingUtil(graph,e.dest,vis,stack);
            }
        }
        stack.add(curr);
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        topologicalSorting(graph);
    }
}
