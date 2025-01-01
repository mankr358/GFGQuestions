//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
         // Initialize a map to group anagrams
        Map<String, List<String>> map = new HashMap<>();
        
        // Iterate through each string in the array
        for (String str : arr) {
            // Sort the characters of the string
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            
            // Group strings by their sorted representation
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(str);
        }
        
        // Convert map values to the required type
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for (List<String> group : map.values()) {
            ans.add(new ArrayList<>(group));
        }
        
        return ans;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline after the test case input
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            result.sort(Comparator.comparing(a -> a.get(0)));
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends