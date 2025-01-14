//{ Driver Code Starts
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        while (t-- > 0) {
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");
            List<Integer> nums = new ArrayList<>();
            for (String token : tokens) {
                nums.add(Integer.parseInt(token));
            }
            int[] arr = new int[nums.size()];
            int idx = 0;
            for (int i : nums) arr[idx++] = i;
            Solution solution = new Solution();
            System.out.println(solution.pairWithMaxSum(arr));

            System.out.println("~");
        }

        scanner.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find pair with maximum sum
    public int pairWithMaxSum(int arr[]) {
        // Your code goes here
        if(arr.length<2){
            return 0;
        }
        
          int maxSum = Integer.MIN_VALUE; // Initialize maxSum to the smallest possible integer

        // Iterate through the array and calculate the sum of adjacent pairs
        for (int i = 0; i < arr.length - 1; i++) {
            int pairSum = arr[i] + arr[i + 1]; // Sum of the current pair
            maxSum = Math.max(maxSum, pairSum); // Update maxSum if the current pair's sum is larger
        }

        return maxSum;
    }
}