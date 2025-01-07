//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    int countPairs(int arr[], int target) {
       int ans = 0;                      // Variable to store the count of pairs
    int start = 0;                    // Pointer starting from the beginning
    int end = arr.length - 1;         // Pointer starting from the end

    while (start < end) {             // Iterate while start pointer is less than end pointer
        int currSum = arr[start] + arr[end]; // Calculate the current sum of the pair

        if (currSum > target) {
            end--;                    // Decrease end pointer if the sum is too large
        } else if (currSum < target) {
            start++;                  // Increase start pointer if the sum is too small
        } else {                      // If the sum matches the target
            int e1 = arr[start], e2 = arr[end]; // Store the current elements at start and end
            int c1 = 0, c2 = 0;       // Counters for duplicate elements

            // Count duplicates of element at start pointer
            while (start <= end && arr[start] == e1) {
                start++;
                c1++;
            }

            // Count duplicates of element at end pointer
            while (start <= end && arr[end] == e2) {
                end--;
                c2++;
            }

            // If the elements are the same, calculate combinations: c1 choose 2
            if (e1 == e2) {
                ans += (c1 * (c1 - 1)) / 2; // nC2 = n * (n-1) / 2
            } else {
                ans += c1 * c2;        // Otherwise, multiply counts of c1 and c2
            }
        }
    }
    return ans;   
    }
}


//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int target = Integer.parseInt(inputLine[0]);

            Solution obj = new Solution();
            int res = obj.countPairs(arr, target);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends