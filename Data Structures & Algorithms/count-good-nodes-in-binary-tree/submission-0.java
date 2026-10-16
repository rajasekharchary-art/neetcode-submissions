/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class NodeMax {
    TreeNode node;
    Integer max;
    NodeMax(TreeNode node, Integer max) {
        this.node = node;
        this.max = max;
    }
}
class Solution {
    int goodNodes = 0;
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;

        Stack<NodeMax> stack = new Stack();
        stack.push(new NodeMax(root, root.val));
        while(!stack.isEmpty()) {
            NodeMax nodeMax = stack.pop();
            TreeNode node = nodeMax.node;
            int currMax = nodeMax.max;

            if(node.val >= currMax) {
                goodNodes++;
            }

            if(node.left != null) {
                stack.push(new NodeMax(node.left, currMax > node.left.val ? currMax : node.left.val));
            }

            if(node.right != null) {
                stack.push(new NodeMax(node.right, currMax > node.right.val ? currMax : node.right.val));
            }

        }
        return goodNodes;
    }
}
