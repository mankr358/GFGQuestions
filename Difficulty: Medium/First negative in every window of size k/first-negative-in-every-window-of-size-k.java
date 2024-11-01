//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends
class Solution {

    // Function to find the first negative integer in every window of size k
    static List<Integer> printFirstNegativeInteger(int arr[], int k) {
        LinkedList<Integer> deque = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        // Traverse the array
        while (j < arr.length) {
            // Add current element to deque if it is negative
            if (arr[j] < 0) {
                deque.add(arr[j]);
            }

            // Check if we have reached the window size
            if (j - i + 1 == k) {
                // If deque is empty, no negative number in this window, add 0
                if (deque.isEmpty()) {
                    result.add(0);
                } else {
                    // Add the first negative integer of the current window
                    result.add(deque.peekFirst());
                }

                // Slide the window forward: remove the first element if it's negative
                if (arr[i] < 0 && !deque.isEmpty()) {
                    deque.pollFirst();
                }
                
                // Move the start of the window
                i++;
            }

            // Move the end of the window
            j++;
        }

        return result;
    }

}

//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
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

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            List<Integer> ans = ob.printFirstNegativeInteger(arr, k);

            // Print the result as a space-separated string
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println(); // New line after printing the results
            System.out.println("~");
        }
    }
}

// } Driver Code Ends