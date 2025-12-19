import java.util.*;

class LFUCache {

    private int capacity;
    private int minFreq;

    private Map<Integer, Integer> keyToVal;
    private Map<Integer, Integer> keyToFreq;
    private Map<Integer, LinkedHashSet<Integer>> freqToKeys;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }

        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);

        freqToKeys.get(freq).remove(key);
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            if (minFreq == freq) {
                minFreq++;
            }
        }

        freqToKeys
            .computeIfAbsent(freq + 1, k -> new LinkedHashSet<>())
            .add(key);

        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            get(key); // update frequency
            return;
        }

        if (keyToVal.size() >= capacity) {
            // Evict LRU from minFreq
            LinkedHashSet<Integer> keys = freqToKeys.get(minFreq);
            int evictKey = keys.iterator().next();
            keys.remove(evictKey);

            if (keys.isEmpty()) {
                freqToKeys.remove(minFreq);
            }

            keyToVal.remove(evictKey);
            keyToFreq.remove(evictKey);
        }

        // Insert new key
        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys
            .computeIfAbsent(1, k -> new LinkedHashSet<>())
            .add(key);
        minFreq = 1;
    }
}
/*
Time Complexity

get() → O(1)

put() → O(1)
(average time using HashMap + LinkedHashSet)

💾 Space Complexity

O(N)
Where N = cache capacity
(Stores keys, frequencies, and frequency buckets)
*/

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */