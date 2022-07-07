class Solution {
/*
 * Time Complexity: O(N+K) N is length of string 's' and 't' respectively.
 * Space Complexity: O(N+K) same with above.
 * Problem statement here: https://leetcode.com/problems/minimum-window-substring/
 * The explaination can also be found on the above URL.
 */
public:
    string minWindow(string s, string t) {
       int freq[256] = {};
        
        int count = t.size();
        for (int i=0; i<t.size(); ++i) {
            ++freq[t[i]];
        }

    int minLen = s.length() + 1;
    int minStart = -1;
    int seen = 0;

    for (int start = 0, end = 0; end < s.size();) {
        if (--freq[s[end++]] >= 0) {
            seen++;
        }  

        if (seen >= count) {
	        while(++freq[s[start++]] <= 0) {};
            seen--;                
            if (minLen > end - start + 1) {
                minLen = end - start + 1;
                minStart = start - 1;
            }
        }
    }

    return minStart >= 0 ? s.substr(minStart, minLen) : "";
    }
};