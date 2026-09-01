/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node
bottomRight) { this.val = val; this.isLeaf = isLeaf; this.topLeft = topLeft; this.topRight =
topRight; this.bottomLeft = bottomLeft; this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    private Node divide(int[][] grid, int sr, int er, int sc, int ec) {
        // base case
        if (er == sr && ec == sc) {
            boolean val = grid[sr][sc] == 1;
            return new Node(val, true); // it is a leaf node
        }

        // 1. divide into 4 subgrid
        int midR = sr + (er - sr) / 2;
        int midC = sc + (ec - sc) / 2;

        // first subgrid
        Node topLeft = divide(grid, sr, midR, sc, midC);
        // second subgrid
        Node topRight = divide(grid, sr, midR, midC + 1, ec);
        // three subgrid
        Node bottomLeft = divide(grid, midR + 1, er, sc, midC);
        // fourth subgrid
        Node bottomRight = divide(grid, midR + 1, er, midC + 1, ec);

        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
            && topLeft.val == topRight.val && topLeft.val == bottomLeft.val
            && topLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true);
        }

        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    public Node construct(int[][] grid) {
        int n = grid.length;

        return divide(grid, 0, n - 1, 0, n - 1);
    }
}