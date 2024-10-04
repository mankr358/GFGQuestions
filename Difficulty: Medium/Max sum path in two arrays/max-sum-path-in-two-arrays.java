//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the remaining newline

        for (int k = 0; k < t; k++) {
            List<Integer> arr1 = new ArrayList<>();
            String input = sc.nextLine();
            Scanner lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr1.add(lineScanner.nextInt());
            }
            lineScanner.close();

            List<Integer> arr2 = new ArrayList<>();
            input = sc.nextLine();
            lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr2.add(lineScanner.nextInt());
            }
            lineScanner.close();

            Solution ob = new Solution();
            int ans = ob.maxPathSum(arr1, arr2);
            System.out.println(ans);
        }

        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public int maxPathSum(List<Integer> arr1, List<Integer> arr2) {
        int s1 = 0, s2 = 0; // Sum accumulators for arr1 and arr2
        int ans = 0;         // This will store the result
        int i = 0, j = 0;    // Pointers for arr1 and arr2
        int m = arr1.size(); // Length of arr1
        int n = arr2.size(); // Length of arr2

        // Traverse both arrays until one of them is exhausted
        while (i < m && j < n) {
            if (arr1.get(i).equals(arr2.get(j))) {
                // Add the maximum of the two sums up to this point, plus the common element
                ans += Math.max(s1, s2) + arr1.get(i);
                // Move both pointers forward
                i++;
                j++;
                // Reset both sums
                s1 = 0;
                s2 = 0;
            } else if (arr1.get(i) < arr2.get(j)) {
                // Add arr1's element to s1 and move pointer i forward
                s1 += arr1.get(i++);
            } else {
                // Add arr2's element to s2 and move pointer j forward
                s2 += arr2.get(j++);
            }
        }

        // Add remaining elements of arr1 (if any) to s1
        while (i < m) {
            s1 += arr1.get(i++);
        }

        // Add remaining elements of arr2 (if any) to s2
        while (j < n) {
            s2 += arr2.get(j++);
        }

        // Add the maximum of the two remaining sums to the answer
        ans += Math.max(s1, s2);

        // Return the final answer
        return ans;
    }
}
