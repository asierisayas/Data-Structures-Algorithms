/**
 * Compute the Intersection of two sorted arrays
 */
public List<Integer> intersection(int[] nums1, int[] nums2) {
    List<Integer> nums = new ArrayList<>();
    while(i < nums1.length && j < nums2.length) {
        if (nums1[i] == nums2[j] && (i == 0 || nums1[i] != nums1[i - 1])) {
            nums.add(nums1[i]);
            i++;
            j++;
        } else if (nums1[i] < nums2[j]) {
            i++;
        } else {
            j++;
        }
    }

    return nums;
}

/**
 * Render a calendar
 */

 /**
  * Merging Intervals
  */
  public int[][] merge(int[][] intervals) {
    if (intervals.length == 0) {
        return new int[0][0];
    }
    
    List<int[]> outputList = new ArrayList<>();
    Collections.sort(Arrays.asList(intervals),(i1, i2) -> (i1[0] - i2[0]));
    int[] prevInterval = intervals[0];
    for (int i = 1; i < intervals.length; i++) {
        int[] currInterval = intervals[i];
        
        //Check for overlap
        if (currInterval[0] <= prevInterval[1]) {
            prevInterval[0] = Math.min(prevInterval[0], currInterval[0]);
            prevInterval[1] = Math.max(prevInterval[1], currInterval[1]);
        } else {
            outputList.add(prevInterval);
            prevInterval = currInterval;
        }
        
    }
    
    outputList.add(prevInterval);
    
    int[][] output = new int[outputList.size()][2];
    for (int i = 0; i < output.length; i++) {
        int[] currInterval = outputList.get(i);
        output[i][0] = currInterval[0];
        output[i][1] = currInterval[1];
    }
    
    return output;
}