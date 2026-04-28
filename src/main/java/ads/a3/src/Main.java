package ads.a3.src;
public class Main {
    public static void main(String[] args) {
        System.out.println("Sorting and Searching Performance Analysis");
        Sorter sorter = new Sorter();
        Searcher searcher = new Searcher();
        Experiment experiment = new Experiment();
        experiment.runAllExperiments();
        System.out.println("Experiments Completed");
    }
}