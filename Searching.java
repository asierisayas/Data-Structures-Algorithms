/*
12.1 Search a sorted array for first occurrence of k
Write a method that takes a sorted array and a key and returns the index
of the first occurrence of that key in the array
*/
public int searchFirst(int[] nums, int targ) {
    int ind = -1;
    int lo = 0;
    int hi = nums.length - 1;
    int mid;
    while (lo < hi) {
        mid = (lo + hi) / 2;
        if (nums[mid] == targ) {
            ind = mid;
            hi = mid - 1;
        } else if (nums[mid] > targ) {
            hi = mid - 1;
        } else { //nums[mid] < targ
            hi = mid + 1;
        }
    }

    return ind;
}

/*
12.3 Search a cyclically sorted array for smallest element
Design an O(logn) algorithm for finding the position of the smallest
element in a cyclically sorted array
[378, 478, 550, 631, 103, 203, 220, 234, 279, 368]
*/
public int searchCyc(int[] nums) {
    int lo = 0;
    int hi = nums.length - 1;

    while (lo < hi) {
        int mid = (lo + hi) / 2;
        if (nums[mid] > nums[hi]) {
            lo = mid + 1;
        } else { //
            hi = mid;
        }
    }

    //Loop ends when left == right
    return lo;
}

/*
12.3b Search a rotated sorted array
[378, 478, 550, 631, 103, 203, 220, 234, 279, 368]
*/
public int searchRot(int[] nums, int targ) {
    //Find pivot
    int lo = 0;
    int hi = nums.length - 1;
    while (lo < hi) {
        int mid = (lo + hi) / 2;
        if (nums[mid] > nums[hi]) {
            lo = mid + 1;
        } else {
            hi = mid;
        }
    }

    int piv = lo;
    lo = 0;
    hi = nums.length - 1;
    while (lo < hi) {
        int mid = (lo + hi) / 2;
        int realMid = (mid + piv) % nums.length;
        if (nums[realMid] == targ) {
            return realMid;
        } else if (nums[realMid] > targ) {
            hi = mid - 1;
        } else {
            lo = mid + 1;
        }
    }

    return -1;
}
