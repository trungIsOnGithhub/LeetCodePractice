class Solution {
/*
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * Calculate the maximum distance you can jump at each position,
 * Except you have reached the final position,
 * whenever the maximum distance you calculated above is equal with the current position,
 * that means you cannot go furthers and return false, otherwise return true.
 */
    public boolean canJump(int[] nums) {
        int max_reach = 0, // maximum distance you can jump before starting is 0.
            len = nums.length;

        for(int i=0;i<len;++i){
            max_reach = Math.max( max_reach, nums[i]+i );
            if( i != len-1 && max_reach == i ){ return false; } 
        }

        return true;
    }
}