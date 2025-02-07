//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++) list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        int[] indegree = new int[V];
        for(int i = 0; i < V; i++){
            for(int neigh: adj.get(i))
                indegree[neigh]++;
                
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =0; i < V; i++){
            if(indegree[i] == 0)
                q.add(i);
                
        }
        
        while(!q.isEmpty()){
            int vertex = q.remove();
            for(int neigh: adj.get(vertex)){
                indegree[neigh]--;
                if(indegree[neigh] == 0)
                    q.add(neigh);
            }
        }
        
        for(int i =0; i < V; i++)
            if(indegree[i] != 0) return true;
        return false;
    }
}