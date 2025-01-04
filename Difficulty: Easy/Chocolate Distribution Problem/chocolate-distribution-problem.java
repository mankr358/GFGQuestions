//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> arr = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                arr.add(Integer.parseInt(token));
            }

            int m = Integer.parseInt(br.readLine());
            Solution ob = new Solution();

            System.out.println(ob.findMinDiff(arr, m));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        // your code here
        
          // Sort the array
        Collections.sort(arr);

        // Initialize the minimum difference to the largest possible value
        int res = Integer.MAX_VALUE;

        // Iterate through the array and find the minimum difference
        for (int i = 0; i <= arr.size() - m; i++) {
            int minElement = arr.get(i);
            int maxElement = arr.get(i + m - 1);

            // Calculate the difference and update the result
            res = Math.min(res, maxElement - minElement);
        }

        return res;
    }
}