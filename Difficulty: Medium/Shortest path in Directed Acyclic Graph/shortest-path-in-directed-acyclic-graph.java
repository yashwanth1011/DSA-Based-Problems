//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][3];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
                edge[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res[] = obj.shortestPath(n, m, edge);
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Pair{
    int vertex, distance;
    Pair(int vertex, int distance){
        this.vertex = vertex;
        this.distance = distance;
    }
}
// User function Template for Java
class Solution {

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < V; i++)
            graph.add(new ArrayList<>());
        
        
        
        for(int i =0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            
            graph.get(u).add(new int[]{v, wt});
            
        }
        
        
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        distance[0] = 0;
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0);
        while(!q.isEmpty()){
            int vertex = q.remove();
            for(int[] neigh : graph.get(vertex)){
                int node = neigh[0];
                int wt = neigh[1];
                if(distance[vertex] + wt < distance[node]){
                    q.add(node);
                    distance[node] = wt + distance[vertex];
                }
            }
        }
        
        for(int i =0; i < V; i++)
            if(distance[i] == Integer.MAX_VALUE)
                distance[i] = -1;
                
        
        return distance;
        
    }
}