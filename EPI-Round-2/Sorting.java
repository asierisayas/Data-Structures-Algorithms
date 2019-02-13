/*
14.1 Compute the intersection of two sorted arrays
Write a program which takes as input two sorted arrays, and returns a new array containng elements that are present in both of the input arrays
*/
public List<Integer> intersection(int[] A, int[] B) {
    List<Integer> output = new ArrayList<>();
    int i = 0;
    int j = 0;
    while (i < A.length && j < B.length) {
        if (A[i] == B[j] && (i == 0 || A[i] != A[i - 1])) {
            output.add(A[i]);
            i++;
            j++;
        } else if (A[i] < A[j]) {
            i++;
        } else {
            j++;
        }
    }

    return output;
}

/*
14.5 Merging Intervals 
Write aprogram which takes as input an array of disjoint closed intervals with integer endpoints, an itnerval to be added, and returns the union of the intervals in the array and the added interval. 
*/
public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> output = new ArrayList<>();
    int i = 0;
    while (i < intervals.size() && newInterval.start > intervals.get(i).end) {
        output.add(intervals.get(i++));
    }
    
    while (i < intervals.size() && newInterval.end >= intervals.get(i).start) {
        newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
        newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
        i++;
    }
    
    output.add(newInterval);
    while (i < intervals.size()) {
        output.add(intervals.get(i));
    }
    
    return output;
}

/*
14.6 Compute the union of intervals
Design an algorithm that takes as input a set of intervals, and outputs their union expressed as a set of disjoint intervals
*/
public List<Interval> merge(List<Interval> intervals) {
    if (intervals.size() <= 1) {
        return intervals;
    }
    
    intervals.sort((i1, i2) -> i1.start - i2.start);
    List<Interval> output = new ArrayList<>();
    Interval prev = intervals.get(0);
    int i = 0;
    while (i < intervals.size()) {
        Interval curr = intervals.get(i);
        if (curr.start <= prev.end) { //overlap
            prev.start = Math.min(prev.start, curr.start);
            prev.end = Math.max(prev.end, curr.end);
        } else {
            output.add(prev);
            prev = curr;
        }
        i++;
    }
    output.add(prev);
    return output;
}