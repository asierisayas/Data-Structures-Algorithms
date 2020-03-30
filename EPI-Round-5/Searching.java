/**
 * Binary Search
 */
private int search(int[] nums, int target) {
    return search(nums, target, 0, nums.length - 1);
}

private int search(int[] nums, int target, int beg, int end) {
    if (beg > end) {
        return -1;
    }
    
    int midInd = (beg + end) / 2;
    if (nums[midInd] == target) {
        return midInd;
    } else if (target > nums[midInd]) {
        return search(nums, target, midInd + 1, end);
    } else {
        return search(nums, target, beg, midInd - 1);
    }
}

/**
 * Search a sorted array for first occurence of K
 */
public static int searchFirstOfK(List<Integer> A, int k){ 
    int left = ®, right = A.size() - 1» result = -1;
    // A.subList(left , right + 1) is the candidate set.
    while (left <= right){
    int mid=left+((right-left)/2); 
    if (A.get(mid) > k){
    right = mid - 1;
    }else if(A.get(mid)==k){
    result = mid;
    // Nothing to the right of mid can be the first occurrence of k.
    right = mid - 1;
    } else { // A.get(mid) < k
    left = mid + 1;
    } }
    return result; }

/**
 * Search a sorted array for entry equal to its index
 */
public int equalIndex(int[] nums) {
    return equalIndex(nums, 0, nums.length - 1);
}

public int equalIndex(int[] nums, int beg, int end) {
    if (beg > end) {
        return -1;
    }

    int midInd = (beg + end) / 2;
    if (nums[midInd] == midInd) {
        return midInd;
    } else if (nums[midInd] > midInd) {
        return equalIndex(nums, beg, midInd - 1);
    } else {
        return equalIndex(nums, midInd + 1, end);
    }
}

/**
 * Search a 2D sorted matrix
 */
public boolean searchMatrix(int[][] matrix, int target) {
    return searchMatrix(matrix, target, matrix.length - 1, 0);
}

public boolean searchMatrix(int[][] matrix, int target, int x, int y) {
    if (x < 0 || y == matrix[0].length) {
        return false;
    }
    
    if (matrix[x][y] == target) {
        return true;
    } else if (matrix[x][y] > target) {
        return searchMatrix(matrix, target, --x, y);
    } else {
        return searchMatrix(matrix, target, x, ++y);
    }
}