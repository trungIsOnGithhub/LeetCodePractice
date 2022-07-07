class Solution {
/* Time Complexity: O(N)
 * Space Complexity: O(1)
 * Problem statement here: https://leetcode.com/problems/majority-element/
 * If we use the Hash Table to solve this problem as the Category name,
 * the Space Complexity will be O(N).
 * But the below solution use the fact that, if a 'Majority Element' appears more than n/2 times
 * the 'count'(number of appearance) will never get to 0, as we +1 with every same element
 * and -1 with every element different from our currently chosen number(candidate).
 */
    public int majorityElement(int[] nums) {
        int candidate = 0, count = 0;
        
        for(int n : nums) {
            if( count == 0 )
                { candidate = n; }
            if( n == candidate )
                { ++count; }
            else
                { --count; }
        }
        
        return candidate;
    }
}