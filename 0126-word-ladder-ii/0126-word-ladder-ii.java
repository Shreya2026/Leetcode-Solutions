class Solution {
    List<List<String>> result = new ArrayList<>();
    Map<String, List<String>> parentMap = new HashMap<>();
    Set<String> dict;
    String beginWord;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        this.beginWord = beginWord;
        dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return result;

        bfs(beginWord, endWord);
        List<String> path = new ArrayList<>();
        path.add(endWord);
        backtrack(endWord, path);
        return result;
    }

    private void bfs(String begin, String end) {
        Queue<String> q = new LinkedList<>();
        q.offer(begin);

        Set<String> visited = new HashSet<>();
        visited.add(begin);

        boolean found = false;

        while (!q.isEmpty() && !found) {
            int size = q.size();
            Set<String> levelVisited = new HashSet<>();

            for (int i = 0; i < size; i++) {
                String word = q.poll();
                char[] arr = word.toCharArray();

                for (int j = 0; j < arr.length; j++) {
                    char original = arr[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        arr[j] = c;
                        String next = new String(arr);

                        if (dict.contains(next) && !visited.contains(next)) {
                            if (next.equals(end)) found = true;

                            parentMap
                                .computeIfAbsent(next, k -> new ArrayList<>())
                                .add(word);

                            if (!levelVisited.contains(next)) {
                                levelVisited.add(next);
                                q.offer(next);
                            }
                        }
                    }
                    arr[j] = original;
                }
            }
            visited.addAll(levelVisited);
        }
    }

    private void backtrack(String word, List<String> path) {
        if (word.equals(beginWord)) {
            List<String> validPath = new ArrayList<>(path);
            Collections.reverse(validPath);
            result.add(validPath);
            return;
        }

        if (!parentMap.containsKey(word)) return;

        for (String parent : parentMap.get(word)) {
            path.add(parent);
            backtrack(parent, path);
            path.remove(path.size() - 1);
        }
    }
}

/*
Complexity Analysis

Let:

N = number of words

L = length of each word

🔹 Time Complexity

BFS: O(N × L × 26)

Backtracking: depends on number of shortest paths (can be exponential in worst case)

👉 Overall: acceptable & expected

🔹 Space Complexity

O(N × L) for graph + recursion stack
*/