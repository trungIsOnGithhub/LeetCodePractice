public class Solution {
    /*
    * Time Complexity: O(N)
    * Space Complexity: O(1)
    * Calculate product of each element and record max and min every iteration
    * Swap max and min when encoutered a negative number every iteration
    */
    public int MaxProduct(int[] nums) {
        int currentMax = nums[0],
            currentMin = nums[0],
            result = nums[0];

        for(int i=1; i<nums.Length; ++i) {
            // Console.Write(currentMax + " " + currentMin + "\n");
            int num = nums[i];

            if(num < 0) {
                int currentMaxCached = currentMax;

                currentMax = Math.Max( num, currentMin * num );
                currentMin = Math.Min( num, currentMaxCached * num );
            }
            else {
                currentMax = Math.Max( num, currentMax * num );
                currentMin = Math.Min( num, currentMin * num );
            }

            result = Math.Max(currentMax, result);
        }

        return result;
    }
}