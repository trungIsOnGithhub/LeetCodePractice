class Solution {
/*
 * Time Complexity: O(N) N is length of input array
 * Space Complexity: O(1) same usage of space no matter how big the input is
 * Problem statement here: https://leetcode.com/problems/maximum-sum-circular-subarray/
 * The explaination can also be found on the above URL.
 */
    static int[] maxSubArray(int[] arr,int j) {
        int TotalSum = arr[j];
        int n = arr.length;
        int MaxSum = arr[j];
        int currentSum = arr[j];
        for (int idx = j + 1; idx < n + j; idx++) {
            int k = idx % n;
            int val1 = arr[k];
            TotalSum += val1;
            currentSum = Math.max(currentSum + val1, val1); // from kadane
            MaxSum = Math.max(MaxSum, currentSum);
        }
        int[] resArr = {MaxSum,TotalSum};
        return resArr;
    }
    static int minSubArray(int[] arr,int j) {
        int n = arr.length;
        int MinSum = arr[j];
        int currentSum = arr[j];
        for (int idx = j + 1; idx < n + j; idx++) {
            int k = idx % n;
            int val1 = arr[k];
            currentSum = Math.min(currentSum + val1, val1); // from kadane
            MinSum = Math.min(MinSum, currentSum);
        }
        return MinSum;
    }
    static public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int CircularSum = nums[0];
        int[] resArr = maxSubArray(nums,0);
        int MaxNormaArrSum  = resArr[0];
        int TotalSum = resArr[1];
        int MinSum = minSubArray(nums,0);
        int Onlycircularsum = TotalSum - MinSum;
        if (MaxNormaArrSum<0){
            return MaxNormaArrSum;
        } else {
            return Math.max(Onlycircularsum, MaxNormaArrSum);
        }
    }
}