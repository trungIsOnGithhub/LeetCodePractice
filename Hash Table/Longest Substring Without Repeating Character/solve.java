class Solution {
/* Time Complexity: O(N)
 * Space Complexity: O(1) (128)
 * Problem statement here: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * This solution is a variation of Sliding Window Technique with Hash Table,
 * but we can use a boolean array instead to save memory.
 * We have 2 iterators 'front' anf 'rear' for travel through the string
 * update the 'existing' boolean array, which helps indicate alreadyExistOne.
 * Whenever a alreadyExistOne character detects, update the final result as the maximum length
 */
    public int lengthOfLongestSubstring(String s) {
        int front = 0,
            rear = 0,
            len = s.length();
        
        if( len == 0 ){ return 0; }
        
        boolean[] alreadyExistOne = new boolean[128];       
        
        int result = 1;// at first, maximum string length  without repetition will be 1.
        
        while(true) {
            while( rear < len && !alreadyExistOne[(int)s.charAt(rear)] ) {
                alreadyExistOne[(int)s.charAt(rear)] = true;
                ++rear;
            }
            
            result = Math.max(result, rear-front);
            
            if( rear >= len ) { break; }
            
            while( s.charAt(front) != s.charAt(rear) ) {
                alreadyExistOne[(int)s.charAt(front)] = false;
                ++front;
            }
            
            alreadyExistOne[(int)s.charAt(front)] = false;
            ++front;
            
            result = Math.max(result, rear-front);
        }
        
        return result;
    }
}