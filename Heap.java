/*
11.1 Merge Sorted Files
Write a program that takes as input a set of sorted
sequences and computes the union of these sequences as a sorted sequence.

[3,5,7], [0,6], [0, 6, 28] -> [0,0,3,5,6,6,7,28]
*/
public List<Integer> mergeNums(List<List<Integer>> sets) {

    List<Integer> list = new ArrayList<>();

    PriorityQueue<Integer> pq = new PriorityQueue<>(
        (num1, num2) -> Double.compare(num1, num2)
    )

    for (List<Integer> list : sets) {
        for (int num : list) {
            pq.offer(num);
        }
    }

    while(pq.peek() != null) {
        list.add(pq.poll());
    }

    return list;
}

/*
11.5 Computer the median of online data
Design an algorithm for computing the running median of as sequence
*/
class MedianFinder {
    PriorityQueue<Integer> lo;
    PriorityQueue<Integer> hi;

    public MedianFinder() {
        lo = new PriorityQueue<>(Collections.reverseOrder());
        hi = new PriorityQueue<>();
    }

    public void addNum(int num) {
        lo.offer(num);
        if (lo.size() > hi.size()) {
            hi.offer(lo.poll());
            if (hi.size() > lo.size()) {
                lo.offer(hi.poll());
            }
        }
    }

    public double findMedian() {
        return lo.size() != hi.size() ? (double) lo.peek() : (lo.peek() + hi.peek()) * 0.5;
    }
}