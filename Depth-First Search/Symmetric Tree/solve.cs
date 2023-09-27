public class Solution {
    /*
    * Time Complexity: O(V+E)
    * Space Complexity: O(E) - due to stack
    */
    private bool IsSymmetricRecursive(TreeNode left, TreeNode right) {
        if(left is null && right is null) {
            return true;
        }

        if(left is null || right is null) {
            return false;
        }

        if(left.val != right.val) {
            return false;
        }

        return IsSymmetricRecursive(left.left, right.right)
                && IsSymmetricRecursive(left.right, right.left);
    }
    public bool IsSymmetric(TreeNode root) {
        TreeNode leftTraveller = root,
                    rightTraveller = root;

        return IsSymmetricRecursive(leftTraveller, rightTraveller);
    }
}