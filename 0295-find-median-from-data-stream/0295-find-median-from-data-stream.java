import java.util.PriorityQueue;

class MedianFinder {

    // Max heap for lower half
    private PriorityQueue<Integer> left;
    // Min heap for upper half
    private PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>((a, b) -> b - a);
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        left.offer(num);
        right.offer(left.poll());

        // Balance heaps
        if (right.size() > left.size()) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        }
        return left.peek();
    }
}

/*
Time Complexity

addNum() → O(log N)

findMedian() → O(1)

💾 Space Complexity

O(N) (stores all numbers)
*/

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */