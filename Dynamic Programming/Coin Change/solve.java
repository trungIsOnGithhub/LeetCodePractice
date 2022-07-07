class Solution {
/*
 * Time Complexity: O(N*K) (N is the length of input array, K is total amount of money)
 * Space Complexity: O(K)
 * Problem statement here: https://leetcode.com/problems/coin-change/
 * Great explaination that I learned from: https://www.youtube.com/watch?v=jaNZ83Q3QGc
 */
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        
        int[] dp = new int[amount+1];

        for(int i=1;i<=amount;++i){ dp[i] = -1; } // dummy filled just to marked position as not-visited

        for(int curr_amount=0; curr_amount<amount; ++curr_amount) {
            if( dp[curr_amount] != -1 ) {
                for(int i=0;i<len;++i) {
                    if( curr_amount+coins[i] <= amount && curr_amount+coins[i] >= 0 ){
                        if( dp[curr_amount+coins[i]] == -1 ){
                            dp[curr_amount+coins[i]] = dp[curr_amount] + 1; 
                        }
                        else { dp[curr_amount+coins[i]] = Math.min(dp[curr_amount+coins[i]], dp[curr_amount]+1); }
                    }
                }
            }
        }
        
        return dp[amount];
    }
}