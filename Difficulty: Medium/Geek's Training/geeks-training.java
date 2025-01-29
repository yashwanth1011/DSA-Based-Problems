//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.maximumPoints(arr);
            System.out.println(res);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maximumPoints(int arr[][]) {
        // code here
        int days = arr.length;
        int[][] dp = new int[days][4];
        for(int[] day : dp)
            Arrays.fill(day, -1);
            
        return helper(arr, days - 1, 3, dp);
    }
    
    public int helper(int[][] arr, int day, int task, int[][] dp){
        int result = 0;
        if(day == 0){
            for(int each = 0; each < 3; each++){
                if(each != task){
                    result = Math.max(result, arr[day][each]);
                }
            }
            
            return result;
        }
        
        if(dp[day][task] != -1)
            return dp[day][task];
            
        

        
        
        
        for(int each = 0; each < 3; each++){
            if(each != task){
                result = Math.max(result, arr[day][each] + helper(arr, day - 1, each, dp));
            }
        }
        
        dp[day][task] = result;
        return dp[day][task];
    }
}