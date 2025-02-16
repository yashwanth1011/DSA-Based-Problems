//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            int[] ans = ob.getFloorAndCeil(x, arr);
            System.out.println(ans[0] + " " + ans[1]);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        // code here
        int n = arr.length;
        
        int left = 0, right = n - 1;
        Arrays.sort(arr);
        
        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr[mid] == x) return new int[]{arr[mid], arr[mid]};
            
            else if(arr[mid] > x) right = mid - 1;
            else left = mid + 1;
        }
        
        int floor = right == -1 ? right : arr[right];
        int ceil = left == n ? -1 : arr[left];
        
        return new int[]{floor, ceil};
        
    }
}
