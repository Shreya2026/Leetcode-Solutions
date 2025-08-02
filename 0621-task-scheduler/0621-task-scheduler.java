class Solution {
    public int leastInterval(char[] tasks, int n) {
         Map<Character, Integer> freqMap = new HashMap<>();
        for (char task : tasks) {
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }

        // Max heap: higher frequency tasks first
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.addAll(freqMap.values());

        int time = 0;
        while(!pq.isEmpty()){
            int cycle = n + 1;
            List<Integer> temp = new ArrayList<>();

            // Try to execute up to n+1 different tasks
            while (cycle > 0 && !pq.isEmpty()) {
                int curr = pq.poll();
                if (curr > 1) {
                    temp.add(curr - 1); // add back if there's more of the task
                }
                time++;
                cycle--;
            }

            for (int t : temp) {
                pq.offer(t);
            }

            // If pq is not empty, we had idle time
            if (!pq.isEmpty()) {
                time += cycle; // Add idle time
            }
        }
        return time;
    }
}