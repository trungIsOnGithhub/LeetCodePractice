/*
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * Problem statement here: https://leetcode.com/problems/climbing-stairs/
 * At each stair, the number of way to reach the current stair will be:
 * number of way to reach 2 steps before + number of ways to reach 1 step before
 * ->  we can have an dp array to store number of ways for 2 previous position, for adding in the above formula
 * But elaborate a little further, things would be more simple as
 * we can use only two variables to implement, for constant space complexity.
 */
var climbStairs = function(n) {
    if(n < 3) { return n; } // handle some small cases with number of stair < 3

    let numOfWayForOneStepBefore = 1, numOfWayForTwoStepsBefore = 2;

    for(let i=3;i<=n;++i){
        let temporary = numOfWayForTwoStepsBefore;
        numOfWayForTwoStepsBefore += numOfWayForOneStepBefore;
        numOfWayForOneStepBefore = temporary;
    }

    return numOfWayForTwoStepsBefore;
};