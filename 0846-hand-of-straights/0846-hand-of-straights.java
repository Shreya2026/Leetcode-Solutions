class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int card : hand) {
            freq.put(card, freq.getOrDefault(card, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(freq.keySet());

        while(!minHeap.isEmpty()){
             int first = minHeap.peek();
             for(int i=0;i<groupSize;i++){
                int card=first+i;
                if (!freq.containsKey(card)) return false;

                freq.put(card, freq.get(card) - 1);
                if (freq.get(card) == 0) {
                    freq.remove(card);
                    if (card != minHeap.peek()) minHeap.remove(card);
                    else minHeap.poll(); // only remove from heap if it's top
                }
             }
        }
        return true;
    }
}