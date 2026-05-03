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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        boolean leftToRight=true;
        while(!q.isEmpty()){
            int levelSize=q.size();
            Integer[] currentLevel=new Integer[levelSize];
            for(int i=0; i<levelSize;i++){
                TreeNode currentNode=q.poll();
                //find position to fill nodes value
                int index=(leftToRight)?i:(levelSize-1-i);
                currentLevel[index]=currentNode.val;
                if(currentNode.left!=null){
                    q.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    q.add(currentNode.right);
                }
            }
            //after this level
            leftToRight=!leftToRight;
            result.add(Arrays.asList(currentLevel));

        }
        return result;
        

        
    }
}