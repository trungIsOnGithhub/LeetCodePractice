class Solution {
/* 
    * Time Complexity: O(N)
    * Space Complexity: O(N)
    * Start with an additional array dp to store the minimum price up to a specific day.
    * Use that array to calculate maximum profit we can get from each day, its also the result.
*/
    public int maxProfit(int[] prices) {
        int len = prices.length,
            max_profit = 0;

        int[] dp = new int[len]; // dp[i] means minimum price upto i-th position.
        dp[0] = prices[0]; // minimum price at the beginning.
        
        for(int i=1;i<len;++i){
           dp[i] = Math.min( dp[i-1], price[i] );
        }

        for(int i=1;i<len;++i){
            if( prices[i]-dp[i-1] > max_profit ) // if profit in this day larger than the final result
                { max_profit = prices[i]-dp[i-1]; } // Update final result
        }
        
        return max_profit;
    }
}