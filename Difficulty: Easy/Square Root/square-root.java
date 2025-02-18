//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int a = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
    }
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution {
    int floorSqrt(int n) {
        // Your code here
        int left= 0, right = n;
        while(left <= right){
            int mid = left + (right-left)/2;
            int square = mid*mid;
            if(square == n) return mid;
            else if(square > n) right = mid - 1;
            else left = mid + 1;
        }
        return right;
    }
}
