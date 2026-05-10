package ads.a4.src;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
public class Graph{
    private Map<Integer, Vertex> vertices;
    private Map<Integer, List<Edge>> adjList;
    public Graph(){
        this.vertices = new HashMap<>();
        this.adjList = new HashMap<>();
    }
    public void addVertex(Vertex v){
        vertices.put(v.getId(), v);
        adjList.putIfAbsent(v.getId(), new ArrayList<>());
    }
    public void addEdge(int from, int to){
        Vertex source = vertices.get(from);
        Vertex destination = vertices.get(to);
        if (source != null && destination != null){
            adjList.get(from).add(new Edge(source, destination));
            adjList.get(to).add(new Edge(destination, source));
        }
    }
    public void printGraph(){
        for (int id : adjList.keySet()){
            System.out.print(id+": ");
            for (Edge e : adjList.get(id)){
                System.out.print(e.getDestination().getId()+" ");
            }
            System.out.println();
        }
    }
    public void bfs(int start){
        if (!vertices.containsKey(start)) return;
        boolean print = vertices.size()<=10;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);
        if (print) System.out.print("BFS Order: ");
        while (!queue.isEmpty()){
            int curr = queue.poll();
            if (print) System.out.print(curr+" ");
            for (Edge e : adjList.get(curr)){
                int dest = e.getDestination().getId();
                if (!visited.contains(dest)){
                    visited.add(dest);
                    queue.add(dest);
                }
            }
        }
        if (print) System.out.println();
    }
    public void dfs(int start){
        if (!vertices.containsKey(start)) return;
        boolean print = vertices.size()<=10;
        Set<Integer> visited = new HashSet<>();
        if (print) System.out.print("DFS Order: ");
        dfsHelper(start, visited, print);
        if (print) System.out.println();
    }
    private void dfsHelper(int curr, Set<Integer> visited, boolean print){
        visited.add(curr);
        if (print) System.out.print(curr+" ");
        for (Edge e : adjList.get(curr)){
            int dest = e.getDestination().getId();
            if (!visited.contains(dest)){
                dfsHelper(dest, visited, print);
            }
        }
    }
}