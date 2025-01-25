//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class LinkedList {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void makeLoop(Node head, Node tail, int x) {
        if (x == 0) return;

        Node curr = head;
        for (int i = 1; i < x; i++) curr = curr.next;

        tail.next = curr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            ArrayList<Integer> arr = new ArrayList<>();
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int k = Integer.parseInt(br.readLine());
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            makeLoop(head, tail, k);
            Solution ob = new Solution();
            Node ans = ob.findFirstNode(head);
            System.out.println(ans == null ? -1 : ans.data);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/* class Node
{
    int data;
    Node next;

    Node(int x)
    {
        data = x;
        next = null;
    }
}*/

// Java program to find starting node 



// Function to detect a loop in the linked list and 
// return the node where the cycle starts using HashSet
class Solution {
    static Node findFirstNode(Node head) {
  
        // HashSet to store visited nodes
        HashSet<Node> st = new HashSet<>(); 
        
        Node currNode = head; 
        
        // Traverse the linked list
        while (currNode != null) {
          
            // If the current node is already in the HashSet,
            // then this is the starting node of the loop
            if (st.contains(currNode)) {
                return currNode;
            }
            
            // If not, add the current node to the HashSet
            st.add(currNode);
            
            // Move to the next node
            currNode = currNode.next;
        }
        
        // If no loop found, return null
        return null;
    }

    public static void main(String[] args) {
      
        // Create a linked list: 10 -> 15 -> 4 -> 20
        Node head = new Node(10);
        head.next = new Node(15);
        head.next.next = new Node(4);
        head.next.next.next = new Node(20);

        head.next.next.next.next = head;

        Node loopNode = findFirstNode(head);

        if (loopNode != null)
            System.out.println(loopNode.data);
        else
            System.out.println(-1);
    }
}