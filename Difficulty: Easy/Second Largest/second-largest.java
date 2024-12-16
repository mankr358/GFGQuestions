//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSecondLargest(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSecondLargest(int[] arr) {
        // Code Here
        if(arr.length < 2){
            return -1;
        }
        
        int slargest= -1;
        int largest = -1;
        for(int i = 0; i<arr.length;i++){
            if(arr[i]>largest){
                slargest=largest;
                largest = arr[i];
            }else if(arr[i] >slargest && arr[i] != largest){
                slargest = arr[i];
            }
        }
        return slargest;
    }
}