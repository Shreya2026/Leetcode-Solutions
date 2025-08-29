class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1; // Not enough cables

        UnionFind uf = new UnionFind(n);

        for (int[] conn : connections) {
            uf.union(conn[0], conn[1]);
        }

        int components = 0;
        for (int i = 0; i < n; i++) {
            if (uf.find(i) == i) { // count roots
                components++;
            }
        }

        return components - 1;
    }
}

class UnionFind {
    int[] parent, rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // path compression
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
}

/*
Complexity

Union-Find (with path compression + union by rank): nearly O(α(n)) ≈ O(1) per operation.

Processing all edges: O(E).

Counting components: O(n).

✅ Total: O(n + E), where E = connections.length.
✅ Space: O(n).
*/