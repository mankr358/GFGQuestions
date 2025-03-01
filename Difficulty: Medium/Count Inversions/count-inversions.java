//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        
        // Your Code Here
           int temp[] = new int[arr.length];
        return mergeSort(arr, temp, 0, arr.length - 1);
    }

    private static int mergeSort(int arr[], int temp[], int left, int right) {
        int mid, invCount = 0;
        if (left < right) {
            mid = (left + right) / 2;

            invCount += mergeSort(arr, temp, left, mid);       // Count left inversions
            invCount += mergeSort(arr, temp, mid + 1, right);  // Count right inversions
            invCount += merge(arr, temp, left, mid, right);    // Count split inversions
        }
        return invCount;
    }
        
         private static int merge(int arr[], int temp[], int left, int mid, int right) {
        int i = left, j = mid + 1, k = left, invCount = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid - i + 1); // Elements remaining in left array are greater
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        // Copy sorted elements back to original array
        for (i = left; i <= right; i++) arr[i] = temp[i];

        return invCount;
    }
    
}