//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            int[] ans = ob.getFloorAndCeil(x, arr);
            System.out.println(ans[0] + " " + ans[1]);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        // code here
        
         int floor = Integer.MIN_VALUE;
        int ceil = Integer.MAX_VALUE;

        for (int num : arr) {
            // Update floor if the number is less than or equal to x and greater than the current floor
            if (num <= x && num > floor) {
                floor = num;
            }
            // Update ceil if the number is greater than or equal to x and less than the current ceil
            if (num >= x && num < ceil) {
                ceil = num;
            }
        }

        // Handle cases where floor or ceil is not found
        floor = (floor == Integer.MIN_VALUE) ? -1 : floor;
        ceil = (ceil == Integer.MAX_VALUE) ? -1 : ceil;

        return new int[] { floor, ceil };
    }
}
