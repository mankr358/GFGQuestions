//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends




class GfG
{
    int maxLen(int arr[], int n)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int prefixSum = 0;
        
        // Initialize the map with the base case
        map.put(0, -1);
        
        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // Calculate the prefix sum
            prefixSum += arr[i];
            
            // Check if the prefix sum is already in the map
            if (map.containsKey(prefixSum)) {
                // Update the max length if we find a subarray with zero sum
                maxLen = Math.max(maxLen, i - map.get(prefixSum));
            } else {
                // Otherwise, store the prefix sum and its index
                map.put(prefixSum, i);
            }
        }
        
        return maxLen;
    }
}
    