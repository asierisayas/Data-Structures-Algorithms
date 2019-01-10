/*
3 Sum 
*/
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    
    for (int i = 0; i < nums.length - 2; i++) {
        if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int currSum = nums[i] + nums[j] + nums[k];

                if (currSum == 0) {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j+1]) j++;
                    while (j < k && nums[k] == nums[k-1]) k--;
                    j++;
                    k--;
                } else if (currSum > 0) {
                    k--;
                } else {
                    j++;
                }
            }                
        }
    }   
    return list;
}

/*
18.7 Compute the maximum water trapped by a pair of vertical lines
Write a program which takes as input an integer array and returns
the pair of entries that trap the maximum amount of water
*/
public int maxArea(int[] height) {
    int maxArea = 0;
    int l = 0;
    int r = height.length - 1;
    
    while (l < r) {
        int h = Math.min(height[l], height[r]);
        maxArea = Math.max(maxArea, h * (r - l));
        if (height[l] < height[r])
            l++;
        else 
            r--;
    }
    
    return maxArea;
}