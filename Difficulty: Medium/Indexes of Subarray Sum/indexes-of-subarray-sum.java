//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int d = Integer.parseInt(read.readLine().trim());

            Solution ob = new Solution();
            ArrayList<Integer> result = ob.subarraySum(nums, d);
            // Print all elements in the result list
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println(); // Print a new line after the result
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
      int currSum = 0;
    Map<Integer, Integer> mp = new HashMap<>();
    ArrayList<Integer> ans = new ArrayList<>();
    mp.put(0, 0); // Adjusted to 0-based indexing for easier calculation

    for (int i = 0; i < arr.length; i++) {
        currSum += arr[i];

        if (mp.containsKey(currSum - target)) {
            ans.add(mp.get(currSum - target) + 1); // Start index
            ans.add(i + 1); // End index
            return ans;
        }

        // Only add currSum if not already present to avoid overwriting
        mp.putIfAbsent(currSum, i + 1);
    }

    ans.add(-1); // No subarray found
    return ans;
    }
}
