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

    int calcDeep(TreeNode cur, int height){
        if(cur == null){
            return height;
        }
        return Math.max(calcDeep(cur.left, height + 1), calcDeep(cur.right, height + 1));
    }

    int calcSum(TreeNode cur, int height, int mxheight){
        if(cur == null){
            return 0;
        }
        if(height == mxheight){
            return cur.val;
        }
        return calcSum(cur.left, height + 1, mxheight) + calcSum(cur.right, height + 1, mxheight);
    }
    public int deepestLeavesSum(TreeNode root) {
        return calcSum(root, 0, calcDeep(root, 0) - 1);
    }
}