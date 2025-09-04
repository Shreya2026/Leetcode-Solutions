//Optimal (Trie + Offline Queries) O((n+q)·32 log n)
//We use a Trie of bits (like 421). The trick is:
//Sort nums.
//Sort queries by mi.
//As we process queries in order of increasing mi, we insert numbers ≤ mi into the Trie.
//Query Trie for best XOR.
//Code (Java Optimal)

/*
Time: O((n + q) · 32) → efficient for n, q ≤ 1e5.
Space: O(32·n) for Trie.
*/

class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }
    
    private void insert(TrieNode root, int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
        }
    }
    
    private int query(TrieNode root, int num) {
        TrieNode node = root;
        if (node.children[0] == null && node.children[1] == null) {
            return -1; // empty Trie
        }
        
        int xor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int opposite = 1 - bit;
            if (node.children[opposite] != null) {
                xor |= (1 << i);
                node = node.children[opposite];
            } else {
                node = node.children[bit];
            }
        }
        return xor;
    }
    
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        
        int q = queries.length;
        int[][] extended = new int[q][3];
        for (int i = 0; i < q; i++) {
            extended[i][0] = queries[i][0]; // xi
            extended[i][1] = queries[i][1]; // mi
            extended[i][2] = i;             // original index
        }
        
        Arrays.sort(extended, (a, b) -> a[1] - b[1]); // sort by mi
        
        TrieNode root = new TrieNode();
        int[] res = new int[q];
        int idx = 0;
        
        for (int[] query : extended) {
            int xi = query[0], mi = query[1], origIdx = query[2];
            
            while (idx < nums.length && nums[idx] <= mi) {
                insert(root, nums[idx]);
                idx++;
            }
            
            res[origIdx] = query(root, xi);
        }
        
        return res;
    }
}


/*
Brute Force (O(n·q))
Check all numbers ≤ mi for each query.
class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int q = queries.length;
        int[] res = new int[q];
        Arrays.sort(nums);

        for (int i = 0; i < q; i++) {
            int xi = queries[i][0], mi = queries[i][1];
            int best = -1;
            for (int num : nums) {
                if (num <= mi) {
                    best = Math.max(best, xi ^ num);
                } else break;
            }
            res[i] = best;
        }
        return res;
    }
}
Time: O(n·q) → TLE for large inputs.
Space: O(1).
*/