//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            // int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[0]);

            String line = br.readLine();
            String[] tokens = line.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            boolean ans = new Solution().twoSum(arr, x);
            System.out.println(ans ? "true" : "false");
            // System.out.println("~");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean twoSum(int arr[], int target) {
        // code here
        // 
         
        // for(long i =0;i< arr.length;i++){
           
        //   for(long j =1;j< arr.length;j++){
        //     //int rem = target-sum;
        //     if(arr[i] + arr[j] == target){
        //         return true;
        //     }
        //   }
        // }
        // return false;
        
        // Map<Integer,Integer> map = new HashMap<>();
        // for(int num : arr){
        //     int rem = target - num;
        //     if(map.containskey(rem)){
        //         return true;
        //     }
        //     map.put(num,1);
        // }
        // return false;
        
        
         Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            int rem = target - num; // Calculate the complement
            if (map.containsKey(rem)) { // Check if the complement exists in the map
                return true;
            }
            map.put(num, 1); // Add the current number to the map
        }
        return false;
        
    }
}