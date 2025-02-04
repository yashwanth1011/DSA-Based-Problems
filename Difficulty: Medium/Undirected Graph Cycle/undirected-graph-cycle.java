//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int v = adj.size();
        int[] parent = new int[v];
        boolean[] visited = new boolean[v];
        for(int i =0; i < v; i++){
            if(!visited[i]){
                parent[i] = -1;
                if(bfs(i, visited, parent, v, adj)) return true;
            }
            
            
        }
        
        return false;
    }
    
    public boolean bfs(int source, boolean[] visited, int[] parent, int v, ArrayList<ArrayList<Integer>> adj){
        
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;
        while(!q.isEmpty()){
            int vertex = q.remove();
            for(int neigh: adj.get(vertex)){
                if(!visited[neigh]){
                    q.add(neigh);
                    visited[neigh] = true;
                    parent[neigh]= vertex;
                    
                }
                else if(parent[vertex] != neigh) return true;
            }
        }
        
        return false;
        
    }
}