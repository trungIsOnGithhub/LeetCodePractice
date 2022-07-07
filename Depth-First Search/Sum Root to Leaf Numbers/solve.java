class Solution {
/*
 * Time Complexity: O(V) - DFS using recursion
 * Space Complexity: O(V) - create new String for every new node visited
 * Problem statement here: https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * Do the basic DFS, keep a String at every node,
 * we add the value of that node to the String forming number.
 * When reached the leaf node, convert final number from String to Integer and add up to gobal variable.
 */
    private int currentSum;
    final private void dfsum(TreeNode ro, String currentStringNum){
        String newStringNum = currentStringNum.concat( String.valueOf(ro.val) );
        
        if( ro.left==null && ro.right==null ) {
            currentSum += Integer.parseInt(newStringNum);
            return;
        }
        
        if( ro.left != null )
            { dfsum(ro.left, newStringNum); }
        if( ro.right != null )
            { dfsum(ro.right, newStringNum); }
    }
    public int sumNumbers(TreeNode root) {
        this.currentSum=0;

        dfsum(root, "");
        return this.currentSum;
    }
}