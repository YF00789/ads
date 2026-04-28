package ads.a3.src;
import java.util.Random;
public class Sorter{
    public void basicSort(int[] arr){
        int n = arr.length;
        for (int i=0; i<n-1; i++){
            for (int j=0; j<n-i-1; j++){
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public void advancedSort(int[] arr, int low, int high){
        if (low<high){
            int pi = partition(arr, low, high);
            advancedSort(arr, low, pi-1);
            advancedSort(arr, pi+1, high);
        }
    }
    private int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = (low-1);
        for (int j=low; j<high; j++){
            if (arr[j]<pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
    public void printArray(int[] arr){
        for (int j : arr){System.out.print(j+' ');}
        System.out.println();
    }
    public int[] generateRandomArray(int size){
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i=0; i<size; i++){arr[i] = rand.nextInt(10000);}
        return arr;
    }
}