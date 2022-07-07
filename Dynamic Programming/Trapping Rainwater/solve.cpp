class Solution {
/*
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * The total volume of water trapped in 1 bar will be calculated by:
 *  min(max_height_from_left_side, max_height_from_right_side) - this_bar_height
 * add up the above for all the bars we will have the final result(total_volume)
 * We use 2 arrays(left_max, right_max) and the first 2 for-loops
 * to find and store maximum height from both side.
 */
public:
	int trap(vector<int>& height) {
        int len = height.size();

		if( len <= 2 ) { return 0; }
                
		int current_left_max = -1,
            current_right_max = -1,
            total_volume = 0;
        
		int left_max[len],
            right_max[len];
        
		for(int i=0;i<len;++i){
			if( current_left_max < height[i] ) { current_left_max = height[i]; }
            left_max[i] = current_left_max;
		}

		for(int i=len-1;i>=0;--i){
			if( current_right_max < height[i] ) { current_right_max = height[i]; }
            right_max[i] = current_right_max;
		}
        
		for(int i=0;i<len;++i){
			total_volume +=  min(left_max[i], right_max[i]) - height[i];
		}
        
		return total_volume;
	}
};