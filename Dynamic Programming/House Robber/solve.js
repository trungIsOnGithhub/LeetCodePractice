/* 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * As we weren't able to break into 2 adjacent houses,
 * the problem now is:
 * For each 3 adjacent houses h1 h2 h3,
 * -> should we rob the h1 and h3, or only h2 for the maximum amount of money?
 * If there's only 2 adjacent houses h1 h2,
 * -> should we rob the h1 or h2 for the maximum amount of money??
 * There's only 1 house h1 -> no need to choose.
 * To interpret the above idea in code, we use an dp array(maxMoneyFrom)
 * The first two house we pick up the house with maximum money manually(line 19,20)
 * All the remain houses, run a for loop from 2nd index and perform 3 adjacent house choosing mentioned above
  */
var rob = function(nums) {
    let len = nums.length;

    let maxMoneyFromHouse = new Array(len);
    maxMoneyFromHouse[0] = nums[0];
    maxMoneyFromHouse[1] = (nums[0]>nums[1])? nums[0] : nums[1];
    
    for(let i=2;i<len;++i){
        maxMoneyFromHouse[i] = Math.max(maxMoneyFromHouse[i-1], nums[i]+maxMoneyFromHouse[i-2]);
        //3 houses h1 h2 h3, we choose h1(i-1 index) or h2 and h3(i and i-2 index)??
    }
    
    return maxMoneyFromHouse[len-1];
};