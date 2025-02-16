//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int first = floor(arr, arr.length, target);
        int last = ceil(arr, arr.length, target);
        if(first == -1) return 0;
        
        
        return (last - first  + 1);
    }
    
    int floor(int[] arr, int n, int target){
        int left = 0, right = n - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr[mid] >= target)
                right = mid - 1;
            else left = mid + 1;
        }
        
        if(right == n - 1 || arr[right + 1] != target)
            return -1;
        return right + 1;
    }
    
    int ceil(int[] arr, int n, int target){
        int left = 0, right = n - 1;
        while(left <= right){
            int mid = (left + (right - left)/2);
            if(arr[mid] > target)
                right = mid - 1;
            else left = mid + 1;
        }
        
        if(left == 0 || arr[left - 1] != target) return  -1;
        return left - 1;
        
    }
}
