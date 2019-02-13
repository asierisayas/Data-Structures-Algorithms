/*
12. Search a sorted array for first occurrence of k
Write a method that takes a sorted array and returns the index of the first
occurrence of that key in the array. 
*/
public int searchFirst(int[] nums, int target) {
    int lo = 0;
    int hi = nums.length - 1;
    int mid;
    int first;

    while (lo <= hi) {
        mid = (lo + hi) / 2;

        if (nums[mid] == target) {
            first = mid;
            hi = mid - 1;
        } else if (nums[mid] > target) {
            hi = mid - 1;
        } else {
            lo = mid + 1;
        }
    }

    return first;
}

/*
12.2 Search a sorted array for entry equal to its index
*/
public int searchEqual(int[] nums) {
    int lo = 0;
    int hi = nums.length - 1;
    int mid;

    while (lo <= hi) {
        mid = (lo + hi) / 2;

        if (nums[mid] == mid) {
            return mid;
        } else if (mid < nums[mid]) {
            lo = mid + 1;
        } else {
            hi = mid - 1;
        }
    }

    return -1;
}

/*
12.3 Search a cyclically sorted array
*/
public int search(int[] nums, int target) {
    
    //Find pivot index
    int lo = 0;
    int hi = nums.length - 1;
    int mid;
    
    while (lo < hi) {
        mid = (lo + hi) / 2;
        
        if (nums[mid] > nums[hi]) {
            lo = mid + 1;
        } else {
            hi = mid;
        }
    }
    
    int piv = lo;
    lo = 0;
    hi = nums.length - 1;
    int realMid;
    
    while (lo <= hi) {
        mid = (lo + hi) / 2;
        realMid = (mid + piv) % nums.length;
        
        if (nums[realMid] == target) {
            return realMid;
        } else if (nums[realMid] < target) {
            lo = mid + 1;
        } else {
            hi = mid - 1;
        }
    }
    
    return -1;
}

/*
12.6 Search in a 2D Sorted Array
*/
public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0 || matrix[0].length == 0)
        return false;
    
    int row = 0;
    int col = matrix[0].length - 1;
    
    while (row < matrix.length && col >= 0) {
        if (matrix[row][col] == target)
            return true;
        else if (matrix[row][col] < target) {
            row++;
        } else {
            col--;
        }
    }
    
    return false;
}