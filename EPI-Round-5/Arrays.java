/**
 * Dutch National Flag 
 */
public void sortColors(int[] nums) {
    int curr = 0;
    int zeroPtr = 0;
    int twoPtr = nums.length - 1;
    
    while (curr <= twoPtr) {
        if (nums[curr] == 0) {
            nums[curr] = nums[zeroPtr];
            nums[zeroPtr++] = 0;
            curr++;
        } else if (nums[curr] == 2) {
            nums[curr] = nums[twoPtr];
            nums[twoPtr--] = 2;
        }  else {
            curr++;
        }
    }
}