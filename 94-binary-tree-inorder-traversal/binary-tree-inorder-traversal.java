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
    private void inorder(TreeNode node,List<Integer> Result){
        if(node==null) return;
        inorder(node.left, Result);
        Result.add(node.val);
        inorder(node.right, Result);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> Result=new ArrayList<>();
        inorder(root,Result);
        return Result;
        
    }
}