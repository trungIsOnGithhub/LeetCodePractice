/*
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * At each stair, the number of way to reach the current stair
 * by the 2-step is the last step
 */
var climbStairs = function(n) {
    if(n < 3) { return n; } // handle some small cases with number of stair < 3

    let numOfWayByStep1 = 1, numOfWayByStep2 = 2;

    for(let i=3;i<=n;++i){
        let temp = numOfWayByStep2;
        numOfWayByStep2 += numOfWayByStep1;
        numOfWayByStep1 = temp;
    }

    return numOfWayByStep2;
};