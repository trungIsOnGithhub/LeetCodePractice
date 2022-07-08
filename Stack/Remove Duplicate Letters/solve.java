class Solution {
/*
 * Time Complexity: O(N)
 * Space Complexoty: O(1) (26)
 * Problem statement here: https://leetcode.com/problems/remove-duplicate-letters/submissions/
 */
    public String removeDuplicateLetters(String s) {
        List<Character> newStringList = new ArrayList<>();
        
        boolean[] existOneTime = new boolean[26]; // all false

        for( var c : s.toCharArray() ) {
            if( !existOneTime[(int)c-(int)'a'] ) {
                newStringList.add(c);
                existOneTime[(int)c-(int)'a'] = true;
            }
        }
        
        Collections.sort(newStringList);
        
        // Convert above list to String for final result
        StringBuilder finalResult = new StringBuilder();
        for( var c : newStringList ) { finalResult.append(c); }
        
        return finalResult.toString();
    }
}