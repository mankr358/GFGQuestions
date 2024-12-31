//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.longestConsecutive(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        if(arr.length==0){
            return 0;
        }
        HashSet<Integer> numberSet = new HashSet<>();
        for(int num : arr){
            numberSet.add(num);
        }
        int longestLength = 0;
        for(int num :numberSet){
            if(!numberSet.contains(num-1)){
                int currentLength = 1;
                int currentNum = num;
                while(numberSet.contains(currentNum+1)){
                    currentNum++;
                    currentLength++;
                }
                longestLength= Math.max(longestLength,currentLength);
            }
        }
        return longestLength;
    }
}