//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int target = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            List<Integer> res = ob.sumClosest(arr, target);
            if (res.isEmpty()) {
                System.out.print("[]");
            } else {
                for (Integer num : res) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
   
public List<Integer> sumClosest(int[] arr, int target) {
    
       if (arr == null || arr.length < 2) {
        return new ArrayList<>();
    }
    // Sort the array
    Arrays.sort(arr);

    int left = 0;
    int right = arr.length - 1;

    int closestSum = Integer.MAX_VALUE;
    int closestPairLeft = 0;
    int closestPairRight = 0;

    while (left < right) {
        int currentSum = arr[left] + arr[right];

        // Update closest sum and pair if closer to the target
        if (Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
            closestSum = currentSum;
            closestPairLeft = arr[left];
            closestPairRight = arr[right];
        }

        // Move pointers based on comparison with the target
        if (currentSum < target) {
            left++;
        } else {
            right--;
        }
    }

    // Return a List instead of an array
    return Arrays.asList(closestPairLeft, closestPairRight);
}
}