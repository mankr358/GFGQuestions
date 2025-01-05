//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
class Solution {
    int countPairs(int arr[], int target) {
        // Your code here
        
        int count = 0;
        Arrays.sort(arr); // Sort the array
        int i = 0, j = arr.length - 1;

        while (i < j) {
            if (arr[i] + arr[j] < target) {
                // If the sum is less than the target, all pairs (arr[i], arr[k]) where k ranges from i+1 to j are valid
                count += (j - i);
                i++; // Move the left pointer
            } else {
                // If the sum is greater than or equal to the target, move the right pointer
                j--;
            }
        }
        return count;
    }
}

//{ Driver Code Starts.

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine());

            Solution obj = new Solution();

            System.out.println(obj.countPairs(nums, target));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends