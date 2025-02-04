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
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] pathVisited = new boolean[v];
        boolean[] visited = new boolean[v];
        
        for(int i =0; i< v; i++){
            if(dfs(adj, i, pathVisited, visited)){
                return true;
            }
        }
        
        return false;
    }
    
    
    private boolean dfs(ArrayList<ArrayList<Integer>> adj, int source,boolean[] pathVisited, boolean[] visited){
        visited[source] = true;
        pathVisited[source] = true;
        for(int neigh : adj.get(source)){
            if(pathVisited[neigh])  
                return true;
            else if(!visited[neigh]){
                if(dfs(adj, neigh, pathVisited, visited)){
                    return true;
                }
            }
        }
        
        pathVisited[source] = false;
        
        return false;
    }
}