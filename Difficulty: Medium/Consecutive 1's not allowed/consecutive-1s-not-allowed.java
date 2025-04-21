//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            int ans = new Solution().countStrings(n);

            System.out.println(ans);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int countStrings(int n) {
        // code here
        int[][] dp = new int[n + 1][3];
        for(int[] memo: dp)
            Arrays.fill(memo, -1);
            
        return countDistinctStrings(0, 2, n, dp);
    }
    
    public int countDistinctStrings(int index, int prev, int n, int[][] dp){
        if(index == n)
            return 1;
        if(dp[index][prev] != -1)
            return dp[index][prev];
            
        int prevZero = countDistinctStrings(index + 1, 0, n, dp);
        int prevOne = 0;
        if(prev != 1)
            prevOne = countDistinctStrings(index + 1, 1, n, dp);
        dp[index][prev] = prevOne + prevZero;
        return dp[index][prev];
    }
}