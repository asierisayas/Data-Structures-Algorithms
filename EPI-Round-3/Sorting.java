/*
14.1 Compute the intersection of two sorted arrays
Write a program which takes as input two sorted arrays, and returns
a new array containing elements that are present in both of the input 
arrays
*/
public List<Integer> intersection(int[] A, int[] B) {
    List<Integer> out = new ArrayList<>();

    int i = 0;
    int j = 0;

    while (i < A.length && j < B.length) {
        if (A[i] == B[i] && (i == 0 || A[i] != A[i - 1])) {
            out.add(A[i]);
            i++;
            j++;
        } else if (A[i] < B[i]) {
            i++;
        } else {
            j++;
        }
    }

    return out;
}

/*
14.2 Merge two sorted arrays
Write a program which takes as input two sorted arrays of integers, 
and updates the first to the combined entries of the two arrays in sorted
order
*/
public void mergeSort(int[] A, int[] B, int m, int n) {
    int i = m - 1;
    int j = (m + n) - 1;
    int k = n - 1;

    while (i >= 0 && k >= 0) {
        if (A[i] > B[k] || A[i] == B[k]) {
            A[j--] = A[i--];
        } else {
            A[j--] = B[k--];
        }
    }

    while (k >= 0) {
        A[j--] = B[k--];
    }
}

/*
14.5 Merging Intervals
Given a collection of intervals, merge all overlapping intervals.
*/
public List<Interval> merge(List<Interval> intervals) {
    
    List<Interval> out = new ArrayList<>();
    
    if (intervals.size() < 2) {
        return intervals;
    }
    
    intervals.sort((i1, i2) -> i1.start - i2.start);
    Interval prev = intervals.get(0);

    for (Interval curr : intervals) {
        //if overlap
        if (curr.start <= prev.end) {
            Interval newInterval = new Interval(Math.min(curr.start, prev.start), Math.max(curr.end, prev.end));
            prev = newInterval;
        } else {
            out.add(prev);
            prev = curr;
        }
    }
    
    out.add(prev);
    return out;
}