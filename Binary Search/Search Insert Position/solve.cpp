class Solution {
/* 
 * Time Complexity: O(logN)
 * Space Complexity: O(1)
 * Problem statement here: https://leetcode.com/problems/search-insert-position/
 * Do a normal binary search as we find a 'target' in a sorted array,
 * but now after findind the middle position, you have to update the final result:
 * If the middle number is the target, index_middle is the final result.
 * else if middle number < target, result = index_middle + 1
 * else if middle number > target, result = index_middle
 */
public:
    int searchInsert(vector<int>& nums, int target) {
        int len = (int)nums.size(),
            left_pointer = 0, right_pointer = len-1,
            current_result;
        
        // 2 first base cases
        if( target < nums[left_pointer] )
            { return left_pointer; } // insert this target element first place
        if( target > nums[right_pointer] )
            { return right_pointer+1; } // insert at the end

        while( left_pointer <= right_pointer ){
            int mid = left_pointer + (right_pointer-left_pointer)/2;

            if( nums[mid] == target ) // find the same number -> return its current position
                { return mid; }
            else if( nums[mid] < target )
                { left_pointer = mid+1;  current_result = left_pointer; }
            else // if( nums[mid] > target )
                { right_pointer = mid-1;  current_result = mid; }
        }

        return current_result;
    }
};