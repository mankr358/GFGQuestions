//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int minJumps(int[] arr) {
        // code here
          int n = arr.length;
        if (n == 1) return 0; // Already at the end
        if (arr[0] == 0) return -1; // Cannot move from the start

        int jumps = 0;
        int pos = 0, des = 0;

        for (int i = 0; i < n - 1; i++) {
            des = Math.max(des, i + arr[i]);

            if (pos == i) { // Need to jump
                if (pos == des) return -1; // Stuck, cannot proceed further
                pos = des;
                jumps++;
            }

            if (pos >= n - 1) return jumps; // Reached the last index
        }
        return -1; // If loop exits without reaching the end
    }
}