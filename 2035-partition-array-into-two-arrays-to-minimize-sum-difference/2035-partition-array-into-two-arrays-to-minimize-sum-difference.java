class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int total = 0;
        for (int x : nums) total += x;

        int[] left = Arrays.copyOfRange(nums, 0, n);
        int[] right = Arrays.copyOfRange(nums, n, 2 * n);

        List<Integer>[] leftSums = new ArrayList[n + 1];
        List<Integer>[] rightSums = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            leftSums[i] = new ArrayList<>();
            rightSums[i] = new ArrayList<>();
        }

        // generate subset sums
        genSums(left, 0, 0, 0, leftSums);
        genSums(right, 0, 0, 0, rightSums);

        // sort right sums for binary search
        for (int i = 0; i <= n; i++) {
            Collections.sort(rightSums[i]);
        }

        int ans = Integer.MAX_VALUE;

        for (int k = 0; k <= n; k++) {
            List<Integer> L = leftSums[k];
            List<Integer> R = rightSums[n - k];

            for (int s1 : L) {
                int target = (total / 2) - s1;
                int idx = Collections.binarySearch(R, target);
                if (idx < 0) idx = -idx - 1;

                if (idx < R.size()) {
                    int s2 = R.get(idx);
                    ans = Math.min(ans, Math.abs(total - 2 * (s1 + s2)));
                }
                if (idx > 0) {
                    int s2 = R.get(idx - 1);
                    ans = Math.min(ans, Math.abs(total - 2 * (s1 + s2)));
                }
            }
        }
        return ans;
    }

    private void genSums(int[] arr, int idx, int count, int sum,
                         List<Integer>[] res) {
        if (idx == arr.length) {
            res[count].add(sum);
            return;
        }
        genSums(arr, idx + 1, count, sum, res);
        genSums(arr, idx + 1, count + 1, sum + arr[idx], res);
    }
}


/*
Time Complexity:
O( n * 2^n + 2^n log 2^n )

Space Complexity:
O( 2^n )
*/