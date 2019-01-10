/*
14.1 Compute the intersection of two sorted arrays
Write a program which takes as input two sorted arrays, and returns
a new array containing elements that are present in both of the input arrays
[2,3,4,5,5,6,7,7,8,12]
[5,5,6,8,8,9,10,10]
O(m + n)
*/
public List<Integer> intersec(int[] A, int[] B) {
    List<Integer> list = new ArrayList<>();
    int i = 0;
    int j = 0;
    while (i < A.length && j < B.length) {
        if (A[i] == B[i] && (i == 0 || A[i] != A[i - 1])) {
            list.add(A[i]);
            i++;
            j++;
        } else if (A[i] < B[i]) {
            i++;
        } else {
            j++;
        }
    }
    return list;
}

/*
14.2 Merge two sorted arrays
Write a program which takes as input two sorted arrays of integers, 
and updates the first to the combined entries of the two arrays
sorted in order. Assume the first array has enough empty entries
at its end to hold the result
O(n + m)
*/
public static void mergeArr(int[] A, int m, int[] B, int n) {
    int i = m - 1;
    int j = n - 1;
    int k = m + n - 1;
    while (i >= 0 && j >= 0) {
        if (B[j] > A[i]) {
            A[k--] = B[j--];
        } else {
            A[k--] = A[i--];
        }
    }

    while (j >= 0) {
        A[k--] = B[j--];
    }
}

/*
14.5 Merging Intervals
*/
public List<Interval> newList(List<Interval> intervals) {
    intervals.sort((i1,i2) -> Integer.compare(i1.start, i2.start));
    List<Interval> out = new ArrayList<>();

    Interval prev = intervals.get(0);
    for (Interval interval : intervals) {
        if (prev.end < interval.start) { //no overlapping
            out.add(prev);
            prev = interval;
        } else {
            prev.end = Math.max(prev.end, interval.end);
            out.add(prev);
        }
    }

    out.add(prev);
    return out;
}

/*
14.5 Insert intervals
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
*/
public List<Interval> merged(List<Interval> intervals, Interval newInterval) {
    List<Interval> out = new ArrayList<>();
    int i = 0;

    //Add the intervals that dont merge first
    while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
        out.add(intervals.get(i++));
    }

    //Adjust newInterval based on overlapping
    while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
        newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
        newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
        i++;
    }
    out.add(newInterval);

    //Add the rest
    while (i < intervals.size()) {
        out.add(intervals.get(i++));
    }

    return out;
}