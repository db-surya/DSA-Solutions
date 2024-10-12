import java.util.*; 

public class Solution {
    public static int merge(long[] arr, int low, int mid, int high, int count){
        List<Long> temp = new ArrayList<>();
        int l = low, r = mid + 1; // Fix the initialization of r

        // Merge process with inversion counting
        while (l <= mid && r <= high) {
            if (arr[l] <= arr[r]) {
                temp.add(arr[l]);
                l++;
            } else {
                temp.add(arr[r]);
                count += (mid - l + 1); // Count inversions
                r++;
            }
        }

        // Collect remaining elements from the left half
        while (l <= mid) {
            temp.add(arr[l]);
            l++;
        }

        // Collect remaining elements from the right half
        while (r <= high) {
            temp.add(arr[r]);
            r++;
        }

        // Copy the sorted elements back to the original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }

        return count;
    }

    public static int mergeSort(long[] arr, int low, int high) {
        if (low >= high) return 0; // Base case: Single element or invalid range
        
        int mid = (low + high) / 2;
        int count = 0;

        // Recursively sort both halves and count inversions
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        
        // Merge the two halves and count split inversions
        count = merge(arr, low, mid, high, count);
        
        return count;
    }

    public static long getInversions(long[] arr, int n) {
        return mergeSort(arr, 0, n - 1);
    }
}
