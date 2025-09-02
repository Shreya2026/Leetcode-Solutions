//Time: O(32·n)
//Space: O(32·n)
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

    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        for (int num : nums) {
            insert(root, num);
        }

        int maxXor = 0;
        for (int num : nums) {
            maxXor = Math.max(maxXor, query(root, num));
        }
        return maxXor;
    }
}



/*
Brute Force (O(n²))
Try all pairs and compute XOR.
class Solution {
    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        int maxXor = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                maxXor = Math.max(maxXor, nums[i] ^ nums[j]);
            }
        }
        return maxXor;
    }
}
Time: O(n²)
Space: O(1)
*/

/*
Better (Bitmask + Set, O(32·n))
We try to build the max XOR bit by bit from MSB to LSB.
class Solution {
    public int findMaximumXOR(int[] nums) {
        int maxXor = 0, mask = 0;

        for (int bit = 31; bit >= 0; bit--) {
            mask |= (1 << bit);
            Set<Integer> prefixes = new HashSet<>();

            for (int num : nums) {
                prefixes.add(num & mask);
            }

            int candidate = maxXor | (1 << bit);

            for (int prefix : prefixes) {
                if (prefixes.contains(prefix ^ candidate)) {
                    maxXor = candidate;
                    break;
                }
            }
        }
        return maxXor;
    }
}
Time: O(32·n) ≈ O(n)
Space: O(n)
*/