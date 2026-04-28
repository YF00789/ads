package ads.a3.src;
import java.util.Arrays;
public class Experiment{
    private Sorter sorter = new Sorter();
    private Searcher searcher = new Searcher();
    public long measureSortTime(int[] arr, String type){
        int[] copy = Arrays.copyOf(arr, arr.length);
        long start = System.nanoTime();
        if(type.equals("basic")){sorter.basicSort(copy);
        }else if (type.equals("advanced")){sorter.advancedSort(copy);}
        return System.nanoTime()-start;
    }
    public long measureSearchTime(int[] arr, int target){
        long start = System.nanoTime();
        searcher.search(arr, target);
        return System.nanoTime()-start;
    }
    public void runAllExperiments() {
        int[] sizes = {10, 100, 1000};
        for (int size : sizes){
            System.out.println("Array Size: " + size);
            int[] randomArr = sorter.generateRandomArray(size);
            int[] sortedArr = Arrays.copyOf(randomArr, randomArr.length);
            sorter.advancedSort(sortedArr);
            long basicRand = measureSortTime(randomArr, "basic");
            long advRand = measureSortTime(randomArr, "advanced");
            long basicSort = measureSortTime(sortedArr, "basic");
            long advSort = measureSortTime(sortedArr, "advanced");
            int target = sortedArr[size/2];
            long searchTime = measureSearchTime(sortedArr, target);
            System.out.println("Random Data - Basic Sort: "+basicRand+" ns");
            System.out.println("Random Data - Adv Sort: "+advRand+" ns");
            System.out.println("Sorted Data - Basic Sort: "+basicSort+" ns");
            System.out.println("Sorted Data - Adv Sort: "+advSort+" ns");
            System.out.println("Sorted Data - Search: "+searchTime+" ns\n");
        }
    }
}