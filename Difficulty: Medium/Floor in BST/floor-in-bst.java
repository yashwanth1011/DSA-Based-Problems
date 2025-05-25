// User function Template for Java

class Solution {
    public static int floor(Node root, int x) {
        // Code here
        int floor = -1;
        while(root != null){
            if(root.data == x)
                return x;
            if(root.data > x){
                root = root.left;
            }
            else{
                floor = Math.max(root.data, floor);
                root = root.right;
            }
        }
        return floor;
    }
}

// Less maximum