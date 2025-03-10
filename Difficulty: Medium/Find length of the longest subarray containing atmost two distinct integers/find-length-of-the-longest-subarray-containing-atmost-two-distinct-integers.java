//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            // Convert ArrayList to array
            Integer[] arr = new Integer[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call totalFruits method and print result
            Integer ans = ob.totalElements(arr);
            System.out.println(ans);

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalElements(Integer[] arr) {
        // code here
        int n = arr.length, left = 0, right = 0;
        int longest = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        while(right < n){
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            while(map.size() > 2){
                int value = map.get(arr[left]) - 1;
                if(value == 0)
                    map.remove(arr[left]);
                else map.put(arr[left], value);
                left++;
            }
            
            longest = Math.max(longest, right - left + 1);
            right++;
        }
        
        return longest;
    }
}