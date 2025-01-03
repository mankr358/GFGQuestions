//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");
            int arr[] = new int[s.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int k = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayXor(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
   public long subarrayXor(int arr[], int k) {
    int xor = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1); // Initialize with 0 to handle cases where the subarray itself equals `k`
    long count = 0;
    
    for (int i = 0; i < arr.length; i++) {
        xor = xor ^ arr[i]; // Calculate prefix XOR
        
        // Check if the XOR difference exists in the map
        int x = xor ^ k;
        count += map.getOrDefault(x, 0);
        
        // Add the current XOR to the map
        map.put(xor, map.getOrDefault(xor, 0) + 1);
    }
    
    return count;
    }
}