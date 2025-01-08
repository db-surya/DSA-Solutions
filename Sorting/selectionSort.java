import java.util.*;
public class selectionSort {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void selectionSort(int arr[]){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            int min = i;
            for(int j=i;j<n;j++){
                if(arr[j]<arr[min])
                    min=j;
            }
            swap(arr,i,min);
        }
    }
    public static void main(String[] args) {
        int[] arr = {7,6,5,4,3,2,1};
        selectionSort(arr);
        System.out.println("***** The array after selection sort *****");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
