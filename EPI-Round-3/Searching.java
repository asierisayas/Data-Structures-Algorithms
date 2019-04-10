/*
12.1 Search a sorted array for first occurrence of K
*/
public int searchFirst(int[] A, int k) {
    int result = -1;
    int lo = 0;
    int hi = A.length - 1;
    int mid;

    while (lo < hi) {
        midInd = (lo + hi) / 2;

        if (A[midInd] == k) {
            result = midInd;
            hi = midInd - 1;
        } else if (A[midInd] < k) {
            lo = midInd + 1;
        } else {
            hi = midInd - 1;
        }

    }

    return result;
}

/*
12.2 Search a sorted array for entry equal to its index
Design an efficient algorithm that takes a sorted array of distinct integers, 
and returns and index i such tht the element at index i equals i
*/
public int searchEqual(int[] A) {
    int lo = 0;
    int hi = A.length - 1;
    int midInd;

    while (lo <= hi) {
        midInd = (lo + hi) / 2;

        if (A[midInd] == midInd) {
            return midInd;
        } else if (A[midInd] < midInd) {
            lo = midInd + 1;
        } else {
            hi = midInd - 1;
        }
    }

    return -1;
}

/*
12.3 Search a cyclically sorted array
Design an algorithm for finding the positions of smallest element in a 
cyclically sorted array
*/
public int searchSmallest(int[] A) {
    int lo = 0;
    int hi = A.length - 1;
    int midInd;

    while (lo < hi) {
        midInd = (lo + hi) / 2;

        if (A[midInd] > A[hi]) {
            lo = midInd + 1;
        } else {
            hi = midInd;
        }
    }

    return lo;
}

/*
12.6 Search in a 2D sorted array
Design an algorithm that takes a 2D sorted array and a number and 
checks whether that number appears in the array
*/
public boolean exists(int[][] A, int k) {
    int r = A.length - 1;
    int c = 0;

    while (r >= 0 && c < A[0].length) {
        if (A[r][c] == k) {
            return true;
        } else if (A[r][c] < k) {
            c++;
        } else {
            r--;
        }
    }

    return false;
}