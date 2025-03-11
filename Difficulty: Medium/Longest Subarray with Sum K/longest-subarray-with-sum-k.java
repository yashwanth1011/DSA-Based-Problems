//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int k = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution();
            int ans = ob.longestSubarray(nums, k); // Call the function and store result
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        int longest = 0;
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        
        for(int right = 0; right < n; right++){
            preSum += arr[right];
            if(preSum == k){
                longest = Math.max(right + 1, longest);
            }
            
            if(map.containsKey(preSum - k)){
                longest = Math.max(right - map.get(preSum - k), longest);
            }
            
            if(!map.containsKey(preSum))    map.put(preSum, right);
        }
        
        return longest;
    }
}
