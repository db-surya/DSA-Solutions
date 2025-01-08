import java.util.* ;
import java.io.*; 
public class Solution {
    public static void swap(List<Integer> arr, int i, int j){
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
    public static int findPartition(List<Integer>arr, int low, int high){
        int pivot = arr.get(low);
        int i = low;
        int j = high;
        while(i<j){
            while(arr.get(i)<=pivot && i<=high-1) i++;
            while(arr.get(j)>pivot && j>=low+1) j--;
            if(i<j) swap(arr,i,j);
        }
        swap(arr,low,j);
        return j;
    }
    public static void quickSortAlgorithm(List<Integer>arr, int low, int high){
        if(low<high){
            int partitionIndex = findPartition(arr, low, high);
            quickSortAlgorithm(arr, low, partitionIndex-1);
            quickSortAlgorithm(arr, partitionIndex+1, high);
        }
    }
    public static List<Integer> quickSort(List<Integer> arr){
        // Write your code here.
        quickSortAlgorithm(arr,0,arr.size()-1);
        return arr;
    }
}