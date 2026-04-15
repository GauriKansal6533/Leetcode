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
    private void postorder(TreeNode node,List<Integer> Result){
        if(node==null) return;
        postorder(node.left, Result);
        postorder(node.right, Result);
        Result.add(node.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> Result=new ArrayList<>();
        postorder(root,Result);
        return Result;
        
    }
}