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
    Map<Integer, Integer> map = new HashMap();
    int preInd = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildBST(preorder, 0, preorder.length - 1);
        
    }

    private TreeNode buildBST(int[] preorder, int l, int r) {
        if(l > r) {
            return null;
        }
        int val = preorder[preInd++];
        TreeNode root = new TreeNode(val);
        int i = map.get(val);
        root.left = buildBST(preorder, l, i-1 );
        root.right = buildBST(preorder, i+1, r);
        return root;
    }
}
