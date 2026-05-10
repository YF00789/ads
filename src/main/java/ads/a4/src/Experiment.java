package ads.a4.src;
public class Experiment{
    private long currentBfsTime;
    private long currentDfsTime;
    private long[] bfsTimes = new long[3];
    private long[] dfsTimes = new long[3];
    public void runTraversals(Graph g){
        long start = System.nanoTime();
        g.bfs(0);
        long end = System.nanoTime();
        currentBfsTime = end-start;
        start = System.nanoTime();
        g.dfs(0);
        end = System.nanoTime();
        currentDfsTime = end-start;
    }
    public void runMultipleTests(){
        Graph small = createGraph(10);
        System.out.println("Small Graph");
        small.printGraph();
        runTraversals(small);
        bfsTimes[0] = currentBfsTime;
        dfsTimes[0] = currentDfsTime;
        Graph medium = createGraph(30);
        runTraversals(medium);
        bfsTimes[1] = currentBfsTime;
        dfsTimes[1] = currentDfsTime;
        Graph large = createGraph(100);
        runTraversals(large);
        bfsTimes[2] = currentBfsTime;
        dfsTimes[2] = currentDfsTime;
    }
    public void printResults(){
        System.out.println("\nExecution Time Results (in nanoseconds):");
        System.out.println("Graph Size\tBFS Time\tDFS Time");
        System.out.println("10 vertices\t"+bfsTimes[0]+"\t\t"+dfsTimes[0]);
        System.out.println("30 vertices\t"+bfsTimes[1]+"\t\t"+dfsTimes[1]);
        System.out.println("100 vertices\t"+bfsTimes[2]+"\t\t"+dfsTimes[2]);
    }
    private Graph createGraph(int size){
        Graph g = new Graph();
        for (int i = 0; i<size; i++){g.addVertex(new Vertex(i));}
        for (int i = 0; i<size-1; i++){g.addEdge(i, i+1);}
        for (int i = 0; i<size; i++){
            int u = (int) (Math.random()*size);
            int v = (int) (Math.random()*size);
            if (u != v){g.addEdge(u, v);}
        }
        return g;
    }
}