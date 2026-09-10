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
    public class Info{
        int sum ;
        int n ;
        int res;
        public Info(int s,int n,int r){
            this.sum = s ;
            this.n = n ;
            this.res = r ;
        }
    }
    private Info solve(TreeNode root){
        if( root == null ) return new Info(0,0,0) ;
        
        Info l = solve(root.left) ;
        Info r = solve(root.right) ;

        int tsum = l.sum+r.sum+root.val ;
        int total = l.n + r.n + 1 ;
        int res = l.res + r.res ;
        if( tsum / total == root.val ) res++ ;

        return new Info(tsum,total,res) ;
    }
    public int averageOfSubtree(TreeNode root) {
        Info I = solve(root) ;
        return I.res ;
    }
}