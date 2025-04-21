//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.fillingBucket(N));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int fillingBucket(int N) {
        // code here
        int[] dp = new int[N + 1];
        int m = (int)(1e8);
        Arrays.fill(dp, -1);
        
        return fillBottles(N, dp, m);
    }
    
    static int fillBottles(int n, int[] dp, int m){
        if(n == 0) return 1;
        if(dp[n] != -1)
            return dp[n];
            
        int oneLitre = fillBottles(n - 1, dp, m)%m;
        int twoLitre = 0;
        if(n - 2 >= 0)
            twoLitre += fillBottles(n - 2, dp, m)%m;
        dp[n] = (oneLitre + twoLitre)%m;
        return dp[n];
        
    }
};