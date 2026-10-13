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

class Solution {
    public boolean isBalanced(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        TreeNode last = null;
        Map<TreeNode, Integer> heights = new IdentityHashMap();
        while(curr != null || !stack.isEmpty()) {
            //traverse left most node
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.peek();
                //right child exists and it hasn't been visited
                if(curr.right != null && curr.right != last ) {
                    curr = curr.right;

                } else {
                    // left and right nodes are done now process the current node
                    curr = stack.pop();
                    int lh = heights.getOrDefault(curr.left, 0);
                    int rh = heights.getOrDefault(curr.right, 0);
                    if(Math.abs(lh - rh) > 1) {
                        return false;
                    }
                    heights.put(curr, 1 + Math.max(lh, rh));
                    last = curr;
                    curr =  null;
                }
            }
        }

        return true;
        
    }
}
