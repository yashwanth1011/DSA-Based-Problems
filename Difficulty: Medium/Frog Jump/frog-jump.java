//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize BufferedReader for efficient input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of test cases
        String str = br.readLine();
        int t = Integer.parseInt(str.trim());

        // Process each test case
        while (t-- > 0) {
            // Read the next line containing the array elements
            str = br.readLine();
            String[] tokens = str.trim().split("\\s+");

            // Convert the input strings to integers and store in an array
            ArrayList<Integer> list = new ArrayList<>();
            for (String token : tokens) {
                if (!token.isEmpty()) { // Ensure that the token is not empty
                    list.add(Integer.parseInt(token));
                }
            }

            // Convert ArrayList to int[] for processing
            int[] arr = list.stream().mapToInt(Integer::intValue).toArray();

            // Create an instance of Solution and compute the minimum energy
            Solution ob = new Solution();
            int result = ob.minCost(arr);

            // Output the result followed by a tilde as per the original C++ code
            System.out.println(result);
            System.out.println("~");
        }
    }
}


// } Driver Code Ends
// User function Template for Java
// User function Template for Java


class Solution {
    int minCost(int[] height) {
        // code here
        int n = height.length;
        int[] dp = new int[n];

        int prev2 = 0, prev1 = 0;
        
        for(int i = 1; i < n; i++){
            int left = Math.abs(height[i] - height[i - 1]) + prev1;
            int right = Integer.MAX_VALUE;
            if(i > 1)
                right = Math.abs(height[i] - height[i - 2]) + prev2;
            int current = Math.min(left, right);
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
    
    int helper(int n, int[] height, int[] dp){
        if(n == 0)
            return 0;
        if(dp[n] != -1) return dp[n];
        
        int left = Math.abs(height[n] - height[n - 1]) + helper(n - 1, height, dp);
        int right = Integer.MAX_VALUE;
        if(n > 1)
            right = Math.abs(height[n] - height[n - 2]) + helper(n - 2, height, dp);
        
        dp[n] = Math.min(left, right);
        return dp[n];
        
    }
}

//{ Driver Code Starts.

// } Driver Code Ends